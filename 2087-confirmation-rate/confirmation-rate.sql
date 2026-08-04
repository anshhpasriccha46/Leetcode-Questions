SELECT
    n.user_id,
    round(n.num / if(d.denomin=0 , 1 , d.denomin) , 2) AS confirmation_rate
FROM
(
    SELECT
        a.user_id,
        COUNT(b.action) AS num
    FROM Signups a
    LEFT JOIN
    (
        SELECT *
        FROM Confirmations
        WHERE action = 'confirmed'
    ) b
    ON a.user_id = b.user_id
    GROUP BY a.user_id
) n
JOIN
(
    SELECT
        a.user_id,
        COUNT(b.action) AS denomin
    FROM Signups a
    LEFT JOIN Confirmations b
        ON a.user_id = b.user_id
    GROUP BY a.user_id
) d
ON n.user_id = d.user_id;