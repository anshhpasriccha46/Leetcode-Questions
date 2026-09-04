select d.name as Department , t.employee , t.salary from 
(select departmentId, name as employee , salary , 
    DENSE_RANK() OVER (partition by departmentId  order by salary desc) as seq
from employee ) t
inner join department d on t.departmentId = d.Id
where seq in (1  ,2 , 3);