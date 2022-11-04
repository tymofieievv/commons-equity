CREATE OR REPLACE VIEW future_intraday AS
    SELECT *
    FROM future
    WHERE ref_date = CURRENT_DATE