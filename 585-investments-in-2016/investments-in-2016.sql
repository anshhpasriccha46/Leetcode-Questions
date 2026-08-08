# Write your MySQL query statement below
-- select sum(
--     if(a.tiv_2015 in (select tiv_2015 from insurance where pid!=a.pid and tiv_2015 = a.tiv_2015 and (lat!=a.lat or lon!=a.lon)) , a.tiv_2016 , null)
-- ) as tiv_2016 from insurance a ;
-- select a.* from insurance a where a.tiv_2015 in (select tiv_2015 from insurance b where b.pid!=a.pid and b.tiv_2015 = a.tiv_2015 and (b.lat , b.lon) not in(select lat, lon from insurance c where c.pid!=b.pid))
select round(sum(b.tiv_2016) , 2) as tiv_2016 from insurance b where (b.lat , b.lon) not in(select lat, lon from insurance c where c.pid!=b.pid) and b.tiv_2015 in (select tiv_2015 from insurance c where c.pid!=b.pid);