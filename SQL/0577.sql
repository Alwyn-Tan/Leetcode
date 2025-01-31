SELECT Employee.name, Bonus.bonus FROM Employee LEFT JOIN Bonus using(empId)
WHERE bonus < 1000 OR bonus IS NULL