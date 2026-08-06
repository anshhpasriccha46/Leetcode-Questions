# Write your MySQL query statement below
select a.product_id , a.new_price as price from products a where a.change_date <= '2019-08-16' and change_date = (select max(change_date) from products where product_id = a.product_id and change_date <= '2019-08-16' ) 
union
select product_id , 10 as price  from products where product_id not in( select product_id from products where change_date<='2019-08-16')
order by product_id asc;