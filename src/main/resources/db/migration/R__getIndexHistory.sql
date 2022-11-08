/**
    function getIndexHistory.
        input:
            time_frame          --> time window used to group index data
            instrument_id_input --> target instrument_id
        output:
            table containing history index data with instrument_id <%instrument_id_input%>
            grouped according to a time window <%time_frame%>.
*/
CREATE OR REPLACE FUNCTION getIndexHistory (time_frame integer, instrument_id_input varchar)
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
		, indexHistory as (
			select *
			from ref0_kafka_index i
			where i.ref_date < CURRENT_DATE and i.instrument_id = instrument_id_input
		)
		, datasource as (
			select
				  i.ref_date
				, t.start_time
				, t.end_time
				, max(i.id) as max_id
			from indexHistory i left join time_interval t
				on i."time" > t.start_time and i."time" <= t.end_time
			group by i.ref_date, t.start_time, t.end_time
		)
		select
			  i.ref_date
			, i.instrument_id
			, i.security_description
			, d.end_time
			, i.price
		from indexHistory i join datasource d on i.id = d.max_id
		order by i.ref_date, d.start_time
	;
END; $$

LANGUAGE 'plpgsql';