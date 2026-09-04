SELECT ROUND(SUM(i.tiv_2016), 2) AS tiv_2016
FROM Insurance i
WHERE i.pid IN (
    SELECT DISTINCT a.pid
    FROM Insurance a
    JOIN Insurance b
        ON a.pid <> b.pid
        AND a.tiv_2015 = b.tiv_2015
    WHERE (a.lat, a.lon) NOT IN (
        SELECT lat, lon
        FROM Insurance l
        where l.pid != a.pid
    )
);