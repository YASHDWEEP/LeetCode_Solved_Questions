# Write your MySQL query statement below
-- Delete p1 from person p1 join person p2 on p1.email = p2.email where p1.id > p2.id ; 
# Write your MySQL query statement below
with cte as (
    select id 
    from (
        select email, min(id) as id from Person group by email
    )t
)

delete from Person where id not in (select * from cte);