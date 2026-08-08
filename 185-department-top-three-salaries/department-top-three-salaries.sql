# Write your MySQL query statement below
select  department.name as Department , a.name as Employee, a.salary as Salary  from employee a inner join department on a.departmentId = department.id
 where salary  in (
    select salary from(
    select distinct salary from employee where departmentId  = a.departmentId order by salary desc limit 3) b
    ) ;