USE [AdventureWorks2008R2]
GO
/*Exercise 4. Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date, 
and returns a table of all the SalesOrderDetail rows for that Sales Order including Quantity, ProductID, UnitPrice,
and the unit price converted to the target currency based on the end of day rate for the date provided.
Exchange rates can be found in the Sales.CurrencyRate table. (Use AdventureWorks)*/

CREATE FUNCTION dbo.udfGetCurrencyOrderDetail (
   @SalesOrderID int,
   @TargetCurrencyCode nchar(3), 
   @CurrencyRateDate datetime )
RETURNS  @QueryTable TABLE (
    SalesOrderDetailID int,
	OrderQty int,
	ProductID int,
	UnitPrice Money,
	UnitPriceConverted Money)
AS
BEGIN
       DECLARE @EndOfDayRate Money;
	   SELECT @EndOfDayRate = EndOfDayRate
	   FROM Sales.CurrencyRate
	   WHERE CurrencyRateDate = @CurrencyRateDate
	   AND ToCurrencyCode = @TargetCurrencyCode;
	   INSERT @QueryTable
	   SELECT SalesOrderDetailID,
	   OrderQty,ProductID,UnitPrice,UnitPrice*@EndOfDayRate
	   FROM Sales.SalesOrderDetail
	   WHERE SalesOrderID = @SalesOrderID
	   RETURN;
END
GO





