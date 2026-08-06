# Write your MySQL query statement below
-- SELECT d.name AS Department,
--        e1.name AS Employee,
--        e1.salary AS Salary
-- FROM Employee e1
-- JOIN Department d
-- ON e1.departmentId = d.id
-- WHERE (
--     SELECT COUNT(DISTINCT e2.salary)
--     FROM Employee e2
--     WHERE e2.departmentId = e1.departmentId
--       AND e2.salary > e1.salary
-- ) < 3;
# Write your MySQL query statement below
SELECT
    d.name AS Department,
    e.name AS Employee,
    e.salary AS Salary
FROM (
    SELECT
        *,
        DENSE_RANK() OVER (
            PARTITION BY departmentId
            ORDER BY salary DESC
        ) AS salary_rank
    FROM Employee
) e
JOIN Department d
ON e.departmentId = d.id
WHERE salary_rank <= 3;
