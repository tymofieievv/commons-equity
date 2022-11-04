CREATE OR REPLACE VIEW index_intraday AS
    SELECT *
    FROM index
    WHERE ref_date = CURRENT_DATE
