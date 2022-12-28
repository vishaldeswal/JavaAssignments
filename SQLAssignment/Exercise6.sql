USE [AdventureWorks2008R2]
GO
/*EXERCISE 6. Write a trigger for the Product table to ensure the list price can never be 
  raised more than 15 Percent in a single change. Modify the above trigger to execute its check code 
  only if the ListPrice column is updated (Use AdventureWorks Database)*/


CREATE TRIGGER Production.triggerOnPrice
ON Production.Product
FOR UPDATE
AS
   IF EXISTS
  (
     SELECT* FROM inserted i
     JOIN deleted d
     ON i.ProductID = d.ProductID
     WHERE i.ListPrice > (d.ListPrice * 1.15)
  )
BEGIN
     RAISERROR('Price can never be raised more than 15 Percent in a single change', 16, 1)
     ROLLBACK TRAN
END



ALTER TRIGGER Production.triggerOnPrice
ON Production.Product
FOR UPDATE
AS
   IF UPDATE(ListPrice)
BEGIN
   IF EXISTS
(
   SELECT *
   FROM inserted i
   JOIN deleted d
   ON i.ProductID = d.ProductID
   WHERE i.ListPrice > (d.ListPrice * 1.15)
)
BEGIN 
     RAISERROR('Price can never be raised more than 15 Percent in a single change', 16, 1)
ROLLBACK TRAN
END
END
