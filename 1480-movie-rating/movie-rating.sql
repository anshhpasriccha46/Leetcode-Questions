# Write your MySQL query statement below
select name as results from (select a.name from users a inner join movierating b on a.user_id = b.user_id group by b.user_id order by count(*) desc , a.name asc limit 1 ) d
union all
select title as results from (select a.title from movies a join movierating b on a.movie_id = b.movie_id where month(b.created_at) = 2 and year(b.created_at) = 2020 group by b.movie_id order by  avg(b.rating) desc ,  a.title asc limit 1 ) c;