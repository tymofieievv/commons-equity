/**
    function getIndexIntraday.
        input:
            time_frame          --> time window used to group index data
            instrument_id_input --> target instrument_id
        output:
            table containing intraday index data with instrument_id <%instrument_id_input%>
            grouped according to a time window <%time_frame%>.

        Note that if a time window contains LOCALTIME then it is ignored
*/
CREATE OR REPLACE FUNCTION getIndexIntraday (time_frame integer, instrument_id_input varchar)
    RETURNS TABLE (
          id            INTEGER
        , "timestamp"   TIMESTAMP
        , instrument_id VARCHAR(50)
        , price_close   DOUBLE PRECISION
        , price_open    DOUBLE PRECISION
        , price_low     DOUBLE PRECISION
        , price_high    DOUBLE PRECISION
)
AS $$
BEGIN
    RETURN QUERY
		WITH time_interval as (
		    /*
		     * time_interval view contains a record for each time window from midnight to midnight.
		     * The length of the time window is determined by input variable <%time_frame%>
		     */
			select
				  ( n               || ' minutes')::interval as start_time
				, ((n + time_frame) || ' minutes')::interval as end_time
			from generate_series(0, (24*60), time_frame) n
		)
		, indexIntraday as (
			select *
			from ref0_kafka_index i
			where i."timestamp"::date = CURRENT_DATE and i.instrument_id = instrument_id_input
		)
		, datasource as (
			select
				  t.start_time
				, t.end_time
				, i."timestamp"::date as ref_date
				, max(i.id)         as max_id -- for price_close
				, min(i.id)         as min_id -- for price_open
                , min(i.price_low)  as min_price_low
                , max(i.price_high) as max_price_high
			from indexIntraday i left join time_interval t
				on i."timestamp"::time > t.start_time and i."timestamp"::time <= t.end_time
			group by i."timestamp"::date, t.start_time, t.end_time
		)
		select
		      i1.id
			, (d.ref_date || ' ' || d.end_time)::timestamp as "timestamp"
			, i1.instrument_id
			, i2.price_close
			, i1.price_open
			, d.min_price_low  as price_low
			, d.max_price_high as price_high
		from datasource d
		    left join indexIntraday i1 on i1.id = d.min_id
		    left join indexIntraday i2 on i2.id = d.max_id
		where d.end_time < (LOCALTIME + interval '1 hour') -- 1 hour is added to refer to CEST timezone
		order by d.end_time
	;
END; $$

LANGUAGE 'plpgsql';