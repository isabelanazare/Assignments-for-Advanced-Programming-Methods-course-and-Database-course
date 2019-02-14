use firstdatabase;

DELETE FROM ProductDetails;
DELETE FROM Orderdetail;
DELETE FROM Customers;
DELETE FROM Countries;
DELETE FROM Orders;
DELETE FROM Employees;
DELETE FROM Products;
DELETE FROM DiscountCoupons;
DELETE FROM Designers;
DELETE FROM Categories;
DELETE FROM Collections;

INSERT INTO Countries
VALUES(1,'USA','ShippingCompany1',100);
INSERT INTO Countries
VALUES(2,'Romania','ShippingCompany2',200);
INSERT INTO Countries
VALUES(3,'France','ShippingCompany3',140);
INSERT INTO Countries
VALUES(4,'Germany','ShippingCompany4',40);
INSERT INTO Countries
VALUES(5,'Poland','ShippingCompany5',44);
INSERT INTO Countries
VALUES(6,'Greece','ShippingCompany6',66);

INSERT INTO Employees(id,firstname,lastname,salary,countryid,age)
VALUES(1,'Andres','Garcia',2000,2,28);
INSERT INTO Employees(id,firstname,lastname,salary,countryid,age)
VALUES(2,'Paula','Toma',2300,3,21);
INSERT INTO Employees(id,firstname,lastname,salary,countryid,age)
VALUES(3,'Caroline','Deval',2300,2,31);
INSERT INTO Employees(id,firstname,lastname,salary,countryid,age)
VALUES(4,'Jack','Black',2300,3,28);
INSERT INTO Employees(id,firstname,lastname,salary,countryid,age)
VALUES(5,'Maria','Popa',2500,2,20);

/*this statement violates referential integrity constraints*/
/*DELETE FROM Countries WHERE countryid=2;*/


INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(1,'1ianuarie2018',1,1);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(2,'2mai2018',2,2);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(3,'3iunie2018',3,3);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(4,'13iulie2018',4,1);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(5,'23martie2018',5,2);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(6,'1octombrie2017',6,3);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(7,'11noiembrie2017',7,2);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(8,'14octombrie2018',8,3);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(9,'16noiembrie2018',9,1);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(10,'20decembrie2018',10,1);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(11,'4ian2018',11,2);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(12,'22august2018',12,3);
INSERT INTO Orders(orderid, orderdate, customerid, employeeid)
VALUES(13,'13iulie2017',13,2);

INSERT INTO DiscountCoupons(discountid,cdescription,xpercent)
VALUES (0,'No discount',0);
INSERT INTO DiscountCoupons(discountid,cdescription,xpercent)
VALUES (1,'Description1',30);
INSERT INTO DiscountCoupons(discountid,cdescription,xpercent)
VALUES (2,'Description2',50);
INSERT INTO DiscountCoupons(discountid,cdescription,xpercent)
VALUES (3,'Description3',70);

INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid,shippingaddress)
VALUES (1, 'Jessica', 'Jones', 25,1,1,'Address1');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (2, 'Maria', 'Moldovan', 28,2,2,'Address2');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (3, 'Chloé', 'Renard', 31,3,3,'Address3');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (4, 'Ania', 'Babinski', 25,4,4,'Address4');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (5, 'Charlotte', 'Ritter', 20,5,5,'Address5');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (6, 'Amelie', 'Renoir', 17,3,6,'Address6');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (7, 'Ana', 'Popescu', 21,2,7,'Address7');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (8, 'Sarah', 'Parker', 34,1,8,'Address8');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (9, 'Caro', 'Miller', 40,4,9,'Address9');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (10, 'Helga', 'Ritter', 41,4,10,'Address10');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (11, 'Anna', 'Dobrev', 43,5,11,'Address11');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (12, 'Ioana', 'Ciobanu', 16,2,12,'Address12');
INSERT INTO Customers (personid, firstname, lastname, age, countryid, orderid, shippingaddress)
VALUES (13, 'Mara', 'Rotaru', 18,2,13,'Address13');

INSERT INTO Collections
VALUES (1,'Collection1');
INSERT INTO Collections
VALUES (2,'Collection2');
INSERT INTO Collections
VALUES (3,'Collection3');
INSERT INTO Collections
VALUES (4,'Collection4');
INSERT INTO Collections
VALUES (5,'Collection5');

INSERT INTO Categories
VALUES (1,'Dresses');
INSERT INTO Categories
VALUES (2,'Accessories');
INSERT INTO Categories
VALUES (3,'Trousers');
INSERT INTO Categories
VALUES (4,'Blouses');
INSERT INTO Categories
VALUES (5,'Skirts');
INSERT INTO Categories
VALUES (6,NULL);

INSERT INTO Designers
VALUES (1,'Anne Ten');
INSERT INTO Designers
VALUES (2,'Paul Blue');
INSERT INTO Designers
VALUES (3,'Lola Pink');

INSERT INTO Products(productid,title,designerid,collectionid)
VALUES(1,'RedScarf',1,3);
INSERT INTO Products(productid,title,designerid,collectionid)
VALUES(2,'RedDress',3,3);
INSERT INTO Products(productid,title,designerid,collectionid)
VALUES(3,'YellowPants',1,1);
INSERT INTO Products(productid,title,designerid,collectionid)
VALUES(4,'RedBlouse',3,3);
INSERT INTO Products(productid,title,designerid,collectionid)
VALUES(5,'MetalSkirt',2,2);

INSERT INTO Orderdetail(id,orderid,productid,quantity,discountid,price)
VALUES (1,1,1,2,0,200);
INSERT INTO Orderdetail(id,orderid,productid,quantity,discountid,price)
VALUES (2,2,4,4,2,230);
INSERT INTO Orderdetail(id,orderid,productid,quantity,discountid,price)
VALUES (3,3,4,10,1,5000);

INSERT INTO Orderdetail(id,orderid,productid,quantity,discountid,price)
VALUES (4,4,3,2,2,2000);
INSERT INTO Orderdetail(id,orderid,productid,quantity,discountid,price)
VALUES (5,5,2,5,1,100);
INSERT INTO Orderdetail(id,orderid,productid,quantity,discountid,price)
VALUES (6,6,4,4,0,150);
INSERT INTO Orderdetail(id,orderid,productid,quantity,discountid,price)
VALUES (7,7,5,6,0,120);
INSERT INTO Orderdetail(id,orderid,productid,quantity,discountid,price)
VALUES (8,8,3,8,1,1000);

INSERT INTO ProductDetails
VALUES(1,2,2);
INSERT INTO ProductDetails
VALUES(2,3,2);
INSERT INTO ProductDetails
VALUES(3,1,1);
INSERT INTO ProductDetails
VALUES(4,1,2);
INSERT INTO ProductDetails
VALUES(5,1,3);
INSERT INTO ProductDetails
VALUES(6,4,1);
INSERT INTO ProductDetails
VALUES(7,5,2);


/*
insert data – for at least 4 tables; at least one statement should violate referential integrity constraints;
update data – for at least 3 tables;
delete data – for at least 2 tables. 
In the UPDATE / DELETE statements, use at least once: {AND, OR, NOT},  {<,<=,=,>,>=,<> }, IS [NOT] NULL, IN, BETWEEN, LIKE.*/

/*AND*/
UPDATE Customers
SET firstname ='Ariana'
WHERE firstname='Ana' AND lastname='Popescu';
/*OR*/
UPDATE Products
SET title=title+' - New '
WHERE collectionid=3 OR collectionid=2;

UPDATE Products
SET title=title+' - NEW'
WHERE collectionid=3 OR collectionid=2;

--DELETE FROM Products WHERE collectionid=1;

/*NOT*/
UPDATE DiscountCoupons
SET cdescription=cdescription+' - '+CONVERT(varchar(10), xpercent)+'% off'
WHERE NOT xpercent=0;
/*>=*/
DELETE FROM Collections WHERE collectionid>=4;
DELETE FROM Categories WHERE name IS NULL;
/*IN*/
UPDATE Countries
SET name='EU: '+ name
WHERE name IN('Romania','France','Germany','Poland','Greece');

/*BETWEEN*/
/*extra gift*/
UPDATE Orderdetail
SET quantity=quantity+1
WHERE quantity BETWEEN 4 AND 100;
/*LIKE*/
UPDATE Orders
SET orderdate+=' - July Special Sale'
WHERE orderdate LIKE '%iulie%';
/*<=*/
/*raise salary*/
UPDATE Employees
SET salary+=100
WHERE salary<=2500;
/*On the same database, write the following SELECT queries:*/

/*a. 2 queries with the union operation; use UNION [ALL] and OR;*/
/*OR*/ /*DISTINCT*/
SELECT DISTINCT countryid
FROM Customers
WHERE countryid=2 OR countryid=3;
/*UNION*/ 
/*DISTINCT*/
SELECT DISTINCT countryid FROM Countries
UNION
SELECT DISTINCT countryid FROM Customers;
/*b. 2 queries with the intersection operation; use INTERSECT and IN;*/
/*INTERSECT*/ /*>=*/
SELECT orderid FROM Orderdetail
WHERE orderid>=2
INTERSECT
SELECT orderid FROM Customers;
/*IN*/
SELECT name
FROM Countries
WHERE name IN ('EU: Germany', 'EU: France');

/*c. 2 queries with the difference operation; use EXCEPT and NOT IN;*/
/*EXCEPT*/ /*<=*/
--Returns customers id from Romania whose age is >17
SELECT personid
FROM Customers
WHERE countryid=2
EXCEPT
SELECT personid
FROM Customers
WHERE age<=17;
/*NOT IN*/ /*AND*/ /*>=*/
--Selecting all the customers who are not from Eastern Europe and who are over 30
SELECT firstname 
FROM Customers
WHERE countryid NOT IN ('2','5') AND age>=30;

---h.

/*e. 2 queries using the IN operator to introduce a subquery in the WHERE clause; in at least one query, the subquery should include a subquery in its own WHERE clause;
*/
/*ORDER BY*/
--the following statement selects the first 3 customers that are from the same countries as the employees responsible for their orders(ordered alphabetically by their firstname)
SELECT TOP 4 firstname,lastname,orderid,countryid FROM Customers
WHERE countryid IN(SELECT countryid 
				FROM Employees 
				WHERE orderid IN(SELECT orderid FROM Orders))
ORDER BY firstname;

--selects the first 4 customers who are the same age as some employees
/*TOP*/
SELECT TOP 4 firstname,age FROM Customers
WHERE age IN(SELECT age FROM Employees WHERE Customers.age=Employees.age);

/*f. 2 queries using the EXISTS operator to introduce a subquery in the WHERE clause;*/
/*TOP*/ /*>*/
--if there are employees with salaries bigger than 2500, the first 3 will be selected
SELECT TOP 3 firstname,salary
FROM Employees
WHERE EXISTS (SELECT salary FROM Employees WHERE salary>2500);

--if there are customers from Romania the first 3 will be selected
/*ORDER BY*/
SELECT TOP 3 lastname,firstname,age
FROM Customers
WHERE EXISTS (SELECT countryid FROM Customers WHERE countryid=2)
ORDER BY lastname;

/*g. 2 queries with a subquery in the FROM clause;*/

---This query returns the average age of customers
SELECT AVG(x) as AverageAge
  FROM (SELECT SUM(age) AS x
        FROM Customers GROUP BY age) AS AgeofCustomers;

--Returns the average quantity of products ordered by customers
SELECT AVG(x) as AverageQuantityOrdered
  FROM (SELECT SUM(quantity) AS x
        FROM Orderdetail GROUP BY quantity) AS tb1;