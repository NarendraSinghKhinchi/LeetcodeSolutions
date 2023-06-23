# Write your MySQL query statement below
select product_name,year,price
from product as p
left join sales as s
on p.product_id = s.product_id
where price is not null AND year is not null