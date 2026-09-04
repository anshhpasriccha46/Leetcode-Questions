-- # Write your MySQL query statement below
-- select product_id , new_price as price from products p join (select a.product_id, a.new_price , max(a.change_date) from (select b.* from products b where change_date<='2019-08-16') a group by a.product_id) where change_date<='2019-08-16';
-- -- union
-- -- select from products where change_date<='2019-08-16';
select a.product_id , a.new_price as price from products a join (select b.product_id as product_id ,  max(b.change_date) as max_date from products b where b.change_date<='2019-08-16' group by b.product_id) c on a.product_id = c.product_id and a.change_date = c.max_date
union
select product_id , 10 as price from products where product_id not in (select p.product_id from products p where change_date<='2019-08-16');