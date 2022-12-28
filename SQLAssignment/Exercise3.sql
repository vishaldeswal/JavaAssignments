USE [AdventureWorks2008R2]
GO
/*Exercise 3. Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with
AdventureWorks.*/

SELECT sub.AccountNumber, sub.OrderDate FROM 
(  SELECT soh.*,
   AccountTotal = SUM(sod.LineTotal) OVER (PARTITION BY soh.AccountNumber),
   recent = ROW_NUMBER() OVER (PARTITION BY soh.AccountNumber ORDER BY soh.OrderDate DESC)
   /*partition sales table by account no.*/
   FROM Sales.SalesOrderHeader soh
   JOIN Sales.SalesOrderDetail sod 
   ON soh.SalesOrderID = sod.SalesOrderID
) sub
   WHERE sub.AccountTotal > 70000
   AND sub.recent <= 5;

 