CREATE FUNCTION XXIM_GENERATE_INV_NUM(INV_TYPE    VARCHAR(50),
                                      DATED       VARCHAR(20))
   RETURNS LONG
   DETERMINISTIC
BEGIN
   DECLARE V_VALUE   LONG;

   SELECT CONCAT(
             CASE INV_TYPE
                WHEN 'PO' THEN '10'
                WHEN 'PURCHASE' THEN '11'
                WHEN 'PURCHASE RETURN' THEN '12'
                WHEN 'SALE' THEN '21'
                WHEN 'SALE RETURN' THEN '22'
                ELSE '50'
             END,
             DATE_FORMAT(DATED, '%Y%m%d'),
             LPAD(COALESCE(MAX(SUBSTR(INV_NUM, LENGTH(INV_NUM) - 2)), 0) + 1,
                  3,
                  '0'))
             VALUE
     INTO V_VALUE
     FROM XXIM_INVOICE_MAIN
    WHERE     DATE(INV_DATE) = STR_TO_DATE(DATED, '%Y%m%d')
          AND INV_TYPE = INV_TYPE;

   RETURN V_VALUE;
END;