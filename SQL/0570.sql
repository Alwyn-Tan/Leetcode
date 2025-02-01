SELECT Manager.name
FROM Employee AS Manager JOIN Employee AS Temp 
ON Manager.id = Temp.managerId
GROUP BY Manager.id
HAVING count(Manager.id) >= 5