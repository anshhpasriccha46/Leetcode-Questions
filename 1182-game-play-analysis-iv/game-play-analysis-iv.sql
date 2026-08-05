# Write your MySQL query statement below
select round(count(if(DATEDIFF(event_date ,
 (select min(event_date) from activity where player_id = a.player_id)
 )=1 , 1, null))/ (select count(distinct player_id) from activity) , 2) as fraction from activity a;