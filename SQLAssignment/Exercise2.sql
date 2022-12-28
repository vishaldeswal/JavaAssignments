USE [AdventureWorks2008R2]
GO
/* Exercise 2. Write separate queries using a join, a subquery, a CTE, and then an EXISTS 
   To list all AdventureWorks customers
   who have not placed an order.*/

/*1. Using Left Outer Join*/

SELECT*
FROM Sales.Customer cus
LEFT OUTER JOIN 
Sales.SalesOrderHeader soh
ON
cus.CustomerID = soh.SalesOrderID
WHERE soh.SalesOrderID IS NULL
ORDER BY cus.CustomerID

/*2. Using a Subquery*/

SELECT*
FROM Sales.Customer cus
WHERE cus.CustomerID 
NOT IN
(SELECT soh.SalesOrderID
FROM Sales.SalesOrderHeader soh
WHERE soh.SalesOrderID IS NULL)
ORDER BY cus.CustomerID

/*3. USING CTE(Common Table Expression)*/

WITH soh AS
(   SELECT SalesOrderID
    FROM Sales.SalesOrderHeader
)
SELECT *
FROM Sales.Customer cus
LEFT OUTER JOIN soh ON cus.customerID = soh.SalesOrderID
WHERE soh.SalesOrderID IS NULL

/*4. USING EXISTS*/

SELECT*
FROM Sales.Customer cus
WHERE NOT EXISTS (SELECT*
FROM Sales.SalesOrderHeader soh
WHERE soh.SalesOrderID IS NULL
AND cus.customerID = soh.customerID);





 





