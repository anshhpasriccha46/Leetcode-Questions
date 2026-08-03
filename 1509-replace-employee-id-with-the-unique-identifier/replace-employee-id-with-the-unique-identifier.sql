# Write your MySQL query statement below
select a.unique_id , b.name from employees b left join EmployeeUNI a on b.id = a.id;