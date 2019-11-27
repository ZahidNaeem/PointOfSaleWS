DROP PROCEDURE IF EXISTS xxim.XXIM_RECORD_EXISTS;
CREATE PROCEDURE xxim.`XXIM_RECORD_EXISTS`(IN  p_table          VARCHAR(30),
                                    IN  p_column         VARCHAR(30),
                                    IN  p_column_value   VARCHAR(30),
                                    OUT p_result         INT)
BEGIN
   SET @v_result = '''';
   SET @query =
          concat(''SELECT COUNT(1) INTO @v_result FROM '',
                 p_table,
                 '' WHERE '',
                 p_column,
                 '' = '',
                 p_column_value);

   PREPARE stmt FROM @query;

   EXECUTE stmt;
   DEALLOCATE PREPARE stmt;
   SET p_result = @v_result;
END;
