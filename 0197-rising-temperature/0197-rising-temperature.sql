# Write your MySQL query statement below
-- select w1.id from weather w1 join weather w2 on datediff(w1.recorddate,w2.recorddate) = 1 where w1.temperature > w2.temperature ; 
select w2.id from Weather w1 join Weather w2 on w1.recordDate=date_sub(w2.recordDate,interval 1 day) 
where w2.temperature>w1.temperature;