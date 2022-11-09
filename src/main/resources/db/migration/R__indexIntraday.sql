CREATE OR REPLACE VIEW index_intraday AS
    SELECT *
    FROM ref0_kafka_index
    WHERE ref_date = CURRENT_DATE
