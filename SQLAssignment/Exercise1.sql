USE [AdventureWorks2008R2]
GO
/* 1.Display the number of records in the [SalesPerson] table. 
(Schema(s) involved: Sales) */

SELECT COUNT(BusinessEntityID) As NumberOfRecords
FROM Sales.SalesPerson

/* 2.Select both the FirstName and LastName of records from the Person table where the FirstName begins with the letter ‘B’. 
(Schema(s) involved: Person) */

SELECT FirstName, LastName 
FROM Person.Person
WHERE FirstName LIKE 'B%'

/* 3. Select a list of FirstName and LastName for employees where Title is one of Design Engineer, Tool Designer or Marketing
Assistant. (Schema(s) involved: HumanResources, Person) */

SELECT p.FirstName, p.LastName, e.JobTitle
FROM Person.Person p JOIN HumanResources.Employee e
ON p.BusinessEntityID = e.BusinessEntityID
WHERE e.JobTitle IN('Design Engineer', 'Tool Designer', 'Marketing Assistant')

/* 4. Display the Name and Color of the Product with the maximum weight. (Schema(s) involved: Production) */

SELECT Name, Color, Weight     
FROM Production.Product 
WHERE Weight = (SELECT MAX(WEIGHT) FROM Production.Product) 

/* 5. Display Description and MaxQty fields from the SpecialOffer table. Some of the MaxQty values are NULL, in this case display
the value 0.00 instead. (Schema(s) involved: Sales)  */

SELECT Description, ISNULL(MaxQty, 0.0) AS MaxQTY
FROM Sales.SpecialOffer

/* 6. Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005
i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined as
'Average exchange rate for the day.' (Schema(s) involved: Sales) */

SELECT AVG(AverageRate) As OverallAverage
FROM Sales.CurrencyRate
WHERE FromCurrencyCode = 'USD' 
and ToCurrencyCode = 'GBP' 
and DATEPART(YEAR,CurrencyRateDate) = 2005

/* 7. Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’.
Display an additional column with sequential numbers for each row returned beginning at integer 1. 
(Schema(s) involved: Person)*/

SELECT ROW_NUMBER() over (order by FirstName) As SequentialNumber, FirstName, LastName
FROM Person.Person
WHERE FirstName LIKE '%ss%'

/*8. Sales people receive various commission rates that belong to 1 of 4 bands. (Schema(s) involved: Sales)
Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the appropriate band as above*/

Select BusinessEntityID As SalesPersonID, CommissionPct,
Case When CommissionPct = 0 Then 'Band 0'
When CommissionPct > 0 and CommissionPct <= 0.01 Then 'Band 1'
When CommissionPct > 0.01 and CommissionPct <= 0.015 Then 'Band 2'
When CommissionPct > 0.015 Then 'Band 3'
End As CommissionBand
From Sales.SalesPerson
Order By CommissionPct

/* 9. Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez. Hint: use
[uspGetEmployeeManagers] (Schema(s) involved: [Person], [HumanResources]) */

uspGetEmployeeManagers @BusinessEntityID = 48

/* 10. Display the ProductId of the product with the largest stock level. Hint: Use the Scalar-valued function [dbo]. [UfnGetStock].
(Schema(s) involved: Production)*/

SELECT ProductID, MAX(dbo.ufnGetStock(Quantity)) As LargestStockQuantity
FROM Production.ProductInventory
GROUP BY ProductID