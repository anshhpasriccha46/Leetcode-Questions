# Write your MySQL query statement below
select distinct num as ConsecutiveNums from logs a where num = (select num from logs where id = a.id + 1) and 
num = (select num from logs where id = a.id + 2) ;