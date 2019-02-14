USE firstdatabase;

/*h. 4 queries with the GROUP BY clause, 3 of which also contain the HAVING clause; 
2 of the latter will also have a subquery in the HAVING clause; use the aggregation operators: COUNT, SUM, AVG, MIN, MAX;*/
/*AVG*/ /*GROUP BY*/
SELECT AVG(x) as AverageAgeofEmployees
  FROM (SELECT SUM(age) AS x
        FROM Employees GROUP BY age) AS AgeofEmployees;
--this query returns all the customers by their first name who are at least 18 and at most 30
/*HAVING*/ /*MIN*/ /*MAX*/
SELECT age,firstname
FROM Customers
GROUP BY age,firstname
HAVING MIN(age) > 18 AND MAX(age)<30
 /*COUNT*//*subquery in the HAVING clause*/
/*lists the number of current customers who come from countries which have had so far more than 100 clients*/
SELECT COUNT(personid) as NumberOfCurrentCustomersWhoComeFromCountriesWhichHaveHadSoFarMoreThan100Clients, countryid
FROM Customers
GROUP BY countryid
HAVING countryid=ANY(SELECT countryid FROM Countries WHERE nrofcustomers>=100)

/*subquery in the HAVING clause */
/*lists the number of current customers who have ordered the product with id 2*/
SELECT COUNT(personid) as NrOfPeopleWhoHaveOrderedProductWithId2, orderid 
FROM Customers
GROUP BY orderid
HAVING orderid=ANY(SELECT orderid FROM Orderdetail WHERE productid=2)


/*i. 4 queries using ANY and ALL to introduce a subquery in the WHERE clause; 
2 of them should be rewritten with aggregation operators, while the other 2 should also be expressed with [NOT] IN.*/

--Returns the first names of the clients who have purchased at least two products
SELECT firstname as FirstNameOfClientsWhoHavePurchasedAtLeastTwoProducts,orderid
FROM Customers
WHERE orderid = ANY
(SELECT orderid FROM Orderdetail WHERE quantity>=2);
--Returns the ids of orders with quantity >=2
SELECT	orderid as OrderswithQuantitybiggerthan2
FROM Customers
WHERE orderid = ANY (SELECT orderid FROM Orderdetail WHERE quantity>=2);
/*
the following statement returns TRUE and lists the customers and the orderids if ALL the orders in the orderDetail table have quantity >=2:
*/
SELECT firstname as FIRSTNAME,orderid
FROM Customers
WHERE orderid = ALL (SELECT orderid FROM OrderDetail WHERE quantity>=2);

/*the following statement returns TRUE and lists the customers ids if ALL the records in the orderDetail table have price >=200:
 */
SELECT orderid AS ORDERID
FROM Orderdetail
WHERE orderid = ALL (SELECT orderid FROM OrderDetail WHERE price>=100);

/*rewritten with AGGREGATION OPERATOR*/
SELECT COUNT(personid) as NrOfClientsWhoHavePurchasedAtLeastTwoProducts
FROM Customers
WHERE orderid = ANY
(SELECT orderid FROM Orderdetail WHERE quantity>=2);
/*rewritten with AGGREGATION OPERATOR*/
--Returns the number of orders with quantity >=2
SELECT COUNT(orderid) as NumberofOrderswithQuantitybiggerthan2
FROM Customers
WHERE orderid = ANY (SELECT orderid FROM Orderdetail WHERE quantity>=2);

/*[NOT] IN*/ 

/*
the following statement returns TRUE and lists the customers and the orderids if ALL the orders in the orderDetail table have quantity >=2:
*/
SELECT firstname,orderid
FROM Customers
WHERE orderid IN (SELECT orderid FROM OrderDetail WHERE quantity>=2);
/*[NOT] IN*/
/*the following statement returns TRUE and lists the customers ids if ALL the records in the orderDetail table have price >=200:
 */
SELECT orderid
FROM Orderdetail
WHERE orderid IN (SELECT orderid FROM OrderDetail WHERE price>=100);