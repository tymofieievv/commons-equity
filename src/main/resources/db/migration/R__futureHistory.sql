CREATE OR REPLACE VIEW future_history AS
    SELECT *
    FROM future
    WHERE ref_date < CURRENT_DATE