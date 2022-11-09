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
          ref_date             DATE
        , instrument_id        VARCHAR(50)
        , security_description VARCHAR(100)
        , "time"               INTERVAL
        , price                DOUBLE PRECISION
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
			where i.ref_date = CURRENT_DATE and i.instrument_id = instrument_id_input
		)
		, datasource as (
			select
				  t.start_time
				, t.end_time
				, max(i.id) as max_id
			from indexIntraday i left join time_interval t
				on i."time" > t.start_time and i."time" <= t.end_time
			group by t.start_time, t.end_time
		)
		select
			  i.ref_date
			, i.instrument_id
			, i.security_description
			, d.end_time
			, i.price
		from indexIntraday i join datasource d on i.id = d.max_id
		where d.end_time < (LOCALTIME + interval '1 hour') -- 1 hour is added to refer to CEST timezone
		order by d.end_time
	;
END; $$

LANGUAGE 'plpgsql';