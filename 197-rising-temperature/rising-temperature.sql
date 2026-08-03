# Write your MySQL query statement below
select id from weather a where temperature > (select temperature from weather b where DATEDIFF(a.recordDate , b.recordDate)=1);