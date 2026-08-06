SELECT person_name
FROM Queue q where (
    SELECT SUM(weight)
    FROM Queue
    WHERE turn <= q.turn
)<=1000 order by turn desc limit 1;

