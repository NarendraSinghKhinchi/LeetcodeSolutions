/* Write your PL/SQL query statement below */
SELECT c.name as Customers
FROM Customers c 
WHERE id NOT IN (SELECT customerID FROM Orders);
