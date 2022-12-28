USE [AdventureWorks2008R2]
GO
/*EXERCISE 5. Write a Procedure supplying name information from the Person. 
Person table and accepting a filter for the first name. 
Alter the above Store Procedure to supply Default Values if user does not enter any value.( Use AdventureWorks) */

CREATE PROCEDURE spGetPersonDetails(@name nvarchar(20) = 'Kendra') /*altering the stored procdure by giving default firstname as 'Kendra' if user does not enter any value*/
AS
BEGIN
      SELECT FirstName, MiddleName, LastName 
	  FROM Person.Person
	  WHERE FirstName LIKE @name+'%'      /*FILTER*/
END

/*Altering the stored procdure by giving default firstname as 'Kendra' if user does not enter any value*/

ALTER PROCEDURE spGetPersonDetails(@name nvarchar(20) = 'Kendra') 
AS
BEGIN
      SELECT FirstName, MiddleName, LastName 
	  FROM Person.Person
	  WHERE FirstName LIKE @name+'%'      /*FILTER*/
END

/*Executing the above defined stored procedure*/
EXEC spGetPersonDetails 'Rob'        /*this will take FirstName as 'Rob'*/
EXEC spGetPersonDetails              /*this will take defualt FirstName as mentioned in above stored procedure*/