# Write your MySQL query statement below
select
 r.contest_id , 
round( 
   ifnull( (nullif(count(r.user_id ) ,0)) / (select count(*) from users) * 100 , 0)
    ,2) as percentage from register r  group by r.contest_id order by percentage desc,r.contest_id asc ;