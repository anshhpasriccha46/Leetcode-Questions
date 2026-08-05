# Write your MySQL query statement below
select  reports_to as employee_id, (select  name from employees where employee_id = a.reports_to)  as name,  count(*) as reports_count , round(avg(a.age) , 0 )as average_age from employees a
where reports_to is not null group by reports_to order by reports_to asc ;

