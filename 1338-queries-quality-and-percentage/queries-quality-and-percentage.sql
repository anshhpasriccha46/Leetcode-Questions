# Write your MySQL query statement below
select query_name  , round(avg(rating / position) , 2) as quality , round( 
    (
        count(
            if (rating<3 , rating , null)
        )
 /  
 count(rating) )*100 
 ,2
        ) 
 as poor_query_percentage from queries  group by query_name;
