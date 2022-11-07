/**
    function get_indexIntraday.
        input:
            time_frame          --> time window used to group index data
            instrument_id_input --> target instrument_id
        output:
            table containing index data with instrument_id <%instrument_id_input%>
            grouped according to a time window <%time_frame%>.
*/
CREATE OR REPLACE FUNCTION get_indexIntraday (time_frame integer, instrument_id_input varchar)
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
		from indexIntraday i join datasource d
			on i.id = d.max_id
		where d.end_time < (LOCALTIME + interval '1 hour')
		order by i.ref_date, d.start_time
	;
END; $$

LANGUAGE 'plpgsql';