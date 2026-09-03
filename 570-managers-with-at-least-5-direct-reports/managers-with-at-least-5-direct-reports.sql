SELECT
    mng.name
FROM employee mng
LEFT JOIN employee emp
    ON mng.id = emp.managerId
GROUP BY mng.id
HAVING COUNT(emp.id) >= 5;