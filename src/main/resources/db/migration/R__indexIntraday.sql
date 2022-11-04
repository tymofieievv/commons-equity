CREATE OR REPLACE VIEW index_history AS
    SELECT *
    FROM index
    WHERE ref_date = CURRENT_DATE