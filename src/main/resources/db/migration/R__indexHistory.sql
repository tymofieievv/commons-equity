CREATE OR REPLACE VIEW index_history AS
    SELECT *
    FROM ref0_kafka_index
    WHERE ref_date < CURRENT_DATE
