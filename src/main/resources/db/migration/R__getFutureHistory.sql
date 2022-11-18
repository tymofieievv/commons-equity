/**
    function getFutureHistory.
        input:
            time_frame          --> time window used to group index data
            instrument_id_input --> target instrument_id
        output:
            table containing history future data with ticker <%isin_input%>
            grouped according to a time window <%time_frame%>.

        Note that if a time window contains LOCALTIME then it is ignored
*/
CREATE OR REPLACE FUNCTION getFutureHistory (time_frame integer, isin_input varchar)
    RETURNS TABLE (
          id                     INTEGER
        , ref_date               DATE
        , isin                   VARCHAR(50)
        , ticker                 VARCHAR(50)
        , "time"                 INTERVAL
        , underlying_id          VARCHAR(50)
        , underlying_description VARCHAR(100)
        , price_close            DOUBLE PRECISION
        , price_open             DOUBLE PRECISION
        , price_low              DOUBLE PRECISION
        , price_high             DOUBLE PRECISION
        , volume                 DOUBLE PRECISION
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
		, futureHistory as (
			select *
			from ref0_kafka_future i
			where i.ref_date < CURRENT_DATE and i.ticker = isin_input
		)
		, datasource as (
			select
				  i.ref_date
				, t.start_time
				, t.end_time
				, max(i.id)         as max_id -- for price_close
				, min(i.id)         as min_id -- for price_open
                , min(i.price_low)  as min_price_low
                , max(i.price_high) as max_price_high
                , sum(i.volume)     as sum_volume
			from futureHistory i left join time_interval t
				on i."time" > t.start_time and i."time" <= t.end_time
			group by i.ref_date, t.start_time, t.end_time
		)
		select
		      f1.id
            , d.ref_date
            , f1.isin
            , f1.ticker
            , d.end_time::TIME
            , f1.underlying_id
            , f1.underlying_description
			, f2.price_close
			, f1.price_open
			, d.min_price_low  as price_low
			, d.max_price_high as price_high
			, d.sum_volume     as volume
		from datasource d
		    left join futureHistory f1 on f1.id = d.min_id
		    left join futureHistory f2 on f2.id = d.max_id
		order by d.ref_date, d.end_time
	;
END; $$

LANGUAGE 'plpgsql';