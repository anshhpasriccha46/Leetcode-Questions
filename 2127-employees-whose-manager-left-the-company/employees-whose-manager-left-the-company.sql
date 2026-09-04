# Write your MySQL query statement below
-- select employee_id from employees where salary<30000 and manager_id not in (select employee_id from employees) order by employee_id asc;

select emp.employee_id from employees emp left join employees mng on emp.manager_id = mng.employee_id where emp.manager_id is not null and  emp.salary < 30000 and mng.employee_id is null order by emp.employee_id asc;