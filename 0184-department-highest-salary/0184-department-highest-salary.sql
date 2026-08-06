-- # Write your MySQL query statement below
-- SELECT
--     d.name AS Department,
--     e.name AS Employee,
--     e.salary AS Salary
-- FROM Employee e
-- JOIN Department d
-- ON e.departmentId = d.id
-- WHERE (e.departmentId, e.salary) IN (
--     SELECT departmentId, MAX(salary)
--     FROM Employee
--     GROUP BY departmentId
-- );


select d.name as Department , 
        e.name  as Employee ,
        e.salary as Salary 
from employee e 
join department d 
on e.departmentid = d.id 
where (e.departmentid , e.salary) in    
(
    select departmentid ,max(salary) from employee group by departmentid 
);