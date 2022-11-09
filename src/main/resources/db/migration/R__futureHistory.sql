CREATE OR REPLACE VIEW future_history AS
    SELECT *
    FROM ref0_kafka_future
    WHERE ref_date < CURRENT_DATE