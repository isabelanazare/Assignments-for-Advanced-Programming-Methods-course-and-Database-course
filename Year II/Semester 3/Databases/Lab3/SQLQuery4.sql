ALTER PROCEDURE up1
AS 
BEGIN
	ALTER TABLE Employees
	ALTER COLUMN firstname VARCHAR(255)
END
GO

ALTER PROCEDURE down1
AS 
BEGIN
	ALTER TABLE Employees
	ALTER COLUMN firstname VARCHAR(50)
END
GO

ALTER PROCEDURE up2
AS 
BEGIN
	ALTER TABLE Employees
	ADD favHobby varchar(50)
END
GO

ALTER PROCEDURE down2
AS 
BEGIN
	ALTER TABLE Employees
	DROP COLUMN favHobby 
END
GO

ALTER PROCEDURE up3
AS 
BEGIN
	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'NameConstraint')
	ALTER TABLE Influencers
	ADD CONSTRAINT NameConstraint
	DEFAULT 'Username' FOR InstagramUserName
END
GO

ALTER PROCEDURE down3
AS 
BEGIN
	IF EXISTS (SELECT * FROM sysobjects WHERE name = 'NameConstraint')
	ALTER TABLE Influencers
	DROP CONSTRAINT NameConstraint
END
GO

ALTER PROCEDURE up4
AS
BEGIN
	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'PK_Influencers')
	ALTER TABLE Influencers
	ADD CONSTRAINT PK_Influencers PRIMARY KEY CLUSTERED (id);
END
GO

ALTER PROCEDURE down4
AS
BEGIN
	IF EXISTS (SELECT * FROM sysobjects WHERE name = 'PK_Influencers')
	ALTER TABLE Influencers
	DROP CONSTRAINT PK_Influencers;
END
GO

ALTER PROCEDURE up5
AS
BEGIN
	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'Influencers_Constraint')
	ALTER TABLE Influencers
	ADD CONSTRAINT Influencers_Constraint 
	UNIQUE (InstagramUserName)
END
GO

ALTER PROCEDURE down5
AS
BEGIN
	IF EXISTS (SELECT * FROM sysobjects WHERE name = 'Influencers_Constraint')
	ALTER TABLE Influencers
	DROP CONSTRAINT Influencers_Constraint 
END
GO

ALTER PROCEDURE up6
AS
BEGIN
	IF NOT EXISTS (SELECT * FROM sysobjects WHERE name = 'productIDFKK')
	ALTER TABLE Influencers
	ADD CONSTRAINT productIDFKK FOREIGN KEY(productid) REFERENCES Products(productid)
END
GO

ALTER PROCEDURE down6
AS
BEGIN
	IF EXISTS (SELECT * FROM sysobjects WHERE name = 'productIDFKK')
	ALTER TABLE Influencers
	DROP CONSTRAINT productIDFKK
END
GO

ALTER PROCEDURE up7
AS
BEGIN
	CREATE TABLE Stores
	(id CHAR(10) PRIMARY KEY,
	StoreLocation VARCHAR(255))
END
GO

ALTER PROCEDURE down7
AS 
BEGIN
	DROP TABLE IF EXISTS Stores
END
GO