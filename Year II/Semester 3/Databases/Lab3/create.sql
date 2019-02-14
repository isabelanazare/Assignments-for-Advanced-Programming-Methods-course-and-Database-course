USE firstdatabase;

DROP TABLE IF EXISTS ProductDetails
DROP TABLE IF EXISTS Orderdetail
DROP TABLE IF EXISTS Customers
DROP TABLE IF EXISTS Countries
DROP TABLE IF EXISTS Orders
DROP TABLE IF EXISTS Employees
DROP TABLE IF EXISTS Products
DROP TABLE IF EXISTS DiscountCoupons
DROP TABLE IF EXISTS Designers
DROP TABLE IF EXISTS Categories
DROP TABLE IF EXISTS Collections
DROP TABLE IF EXISTS Influencers
DROP TABLE IF EXISTS Stores

CREATE TABLE Countries(
	countryid int,
	name varchar(255),
	shippingcompany varchar(50),
	nrofcustomers int,
	PRIMARY KEY (countryid)
)
CREATE TABLE Employees(
	id int,
	PRIMARY KEY (id),
	firstname varchar(50),
    lastname varchar(50),
	salary int,
	countryid int,
	age int
		)
CREATE TABLE Orders(
	orderid int,
	PRIMARY KEY (orderid),
	orderdate varchar(50),
	customerid int,
	employeeid int,
	FOREIGN KEY (employeeid) REFERENCES Employees(id)
)
CREATE TABLE Influencers(
id int NOT NULL,
name varchar(255),
InstagramUserName VARCHAR(255),
productid int
 /*CONSTRAINT PK_Influencers PRIMARY KEY (id),
InstagramUserName varchar(50),
UNIQUE (InstagramUserName)*/
)
CREATE TABLE Categories(
	categoryid int,
	name varchar(255),
    PRIMARY KEY (categoryid)
)
CREATE TABLE Designers(
	designerid int,
	name varchar(255),
    PRIMARY KEY (designerid)
)
CREATE TABLE Collections(
	collectionid int,
	name varchar(255),
    PRIMARY KEY (collectionid)
)

CREATE TABLE Products(
	productid int,
	title varchar(255),
	designerid int,
	collectionid int,
    PRIMARY KEY (productid),
	FOREIGN KEY (designerid) REFERENCES Designers(designerid),
	FOREIGN KEY (collectionid) REFERENCES Collections(collectionid),
)
CREATE TABLE ProductDetails(
		productdetailsid int,
		productid int,
		categoryid int,
		PRIMARY KEY (productdetailsid),
		FOREIGN KEY (productid) REFERENCES Products(productid),
		FOREIGN KEY (categoryid) REFERENCES Categories(categoryid)
		)

CREATE TABLE DiscountCoupons(
	discountid int,
	PRIMARY KEY (discountid),
	cdescription varchar(50),
	xpercent int
)
CREATE TABLE Orderdetail(
	id int,
	PRIMARY KEY (id),
	orderid int,
	productid int,
	quantity int,
	discountid int,
	price int,
	FOREIGN KEY (orderid) REFERENCES Orders(orderid),
	FOREIGN KEY (productid) REFERENCES Products(productid),
	FOREIGN KEY (discountid) REFERENCES DiscountCoupons(discountid)
)
CREATE TABLE Customers(
	personid int,
	firstname varchar(255),
    lastname varchar(255),
	age int,
	countryid int,
	orderid int,
	shippingaddress varchar(255),
    PRIMARY KEY (personid),
	FOREIGN KEY (countryid) REFERENCES Countries(countryid),
	FOREIGN KEY (orderid) REFERENCES Orders(orderid)
)
