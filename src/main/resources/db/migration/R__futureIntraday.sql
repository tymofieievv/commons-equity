CREATE OR REPLACE VIEW future_intraday AS
    SELECT *
    FROM ref0_kafka_future
    WHERE ref_date = CURRENT_DATE