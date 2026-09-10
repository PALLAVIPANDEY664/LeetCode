# Write your MySQL query statement below
SELECT c.name AS Customers
FROM Customers as c
LEFT JOIN Orders o 
ON c.id = o.customerId
WHERE o.customerId IS NULL;