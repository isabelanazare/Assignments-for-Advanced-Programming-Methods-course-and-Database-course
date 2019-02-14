USE firstdatabase;
/*d. 4 queries with INNER JOIN, LEFT JOIN, RIGHT JOIN, and FULL JOIN; 
one query will join at least 3 tables, while another one will join at least two many-to-many relationships;*/

---LEFT JOIN

--the following statement will select all customers, and any orders they might have
SELECT Customers.firstname, Orders.orderid
FROM Customers
LEFT JOIN Orders ON Customers.personid = Orders.customerid
ORDER BY Customers.firstname;

---RIGHT JOIN

--the following statement will return all employees, and any orders they might have placed
SELECT Orders.orderid, Employees.firstname, Employees.lastname
FROM Orders
RIGHT JOIN Employees ON Orders.employeeid = Employees.id
WHERE Orders.orderid IS NOT NULL
ORDER BY Orders.orderid;

---INNER JOIN
--the following statement will return all customers who come from the same country as the employee responsible for their order, this query joins 3 tables

SELECT DISTINCT c.firstname as CustomerFirstName,
	c.lastname as CustomerLastName
    , c.countryid as CountryOfCustomerID
    , emp.countryid as CountryOfEmployeeID
FROM Customers c
INNER JOIN Employees emp
    on c.countryid = emp.countryid
INNER JOIN Orders o
    on o.employeeid = emp.countryid

---FULL JOIN

--the following statement selects the orderid, the orderdetailid,ordered productsid and multiple orderproduct categories
SELECT o.orderid as ORDERID, od.orderid as OrderDetailID,p.productid as OrderedPRODUCTID,pd.categoryid as PRODUCTCATEGORY
FROM Customers c
FULL JOIN Orders o ON c.personid=o.customerid
FULL JOIN Orderdetail od ON od.orderid=o.orderid
FULL JOIN Products p ON p.productid=od.productid
FULL JOIN ProductDetails pd ON pd.productid=od.productid
