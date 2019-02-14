use firstdatabase;
DROP TABLE IF EXISTS C
DROP TABLE IF EXISTS AdPictureB

CREATE TABLE AdPictureB(
bid int,
b2productid int
CONSTRAINT p1 PRIMARY KEY (bid),
code varchar(50),
mentions varchar(100)  --10, 9.8 - 0.5, 8, 10, 1 
)
CREATE TABLE C(
cid int,
aid int,
bid int,
PRIMARY KEY (cid),
FOREIGN KEY (aid) REFERENCES Influencers(aid),
CONSTRAINT Constraint1 FOREIGN KEY (bid) REFERENCES AdPictureB(bid)
)

DELETE FROM Influencers;
DELETE FROM AdPictureB;

INSERT INTO Influencers
VALUES(1,1,'Tania');
INSERT INTO Influencers
VALUES(2,3,'Ana210');
INSERT INTO Influencers
VALUES(3,2,'MariaC');

INSERT INTO AdPictureB
VALUES(1,1,'ww','2ed');
INSERT INTO AdPictureB
VALUES(2,4,'ww','2ed');
INSERT INTO AdPictureB
VALUES(3,2,'ww','2ed');
INSERT INTO AdPictureB
VALUES(4,1,'ww','2ed');
INSERT INTO AdPictureB
VALUES(5,1,'ww','2ed');

--sp_helpindex Influencers
/*a. Write queries on Ta such that their corresponding execution plans contain the following operators:

clustered index scan;*/

--select * from Influencers

/*clustered index seek;*/

/*
select * from Influencers 
Where aid=1*/

/*nonclustered index scan;*/
/*select a2rank from Influencers */

/*nonclustered index seek;*/
/*
select * from Influencers
where a2rank=2
*/
/*key lookup*/

--CREATE nonclustered index [idx] on Influencers (a2rank)

--select * from Influencers with (index=idx) where a2rank>1;

/*b. Write a query on table Tb with a WHERE clause of the form WHERE b2 = value and analyze its execution plan. 
Create a nonclustered index that can speed up the query. Recheck the query’s execution plan (operators, SELECT’s estimated subtree cost).*/

CREATE nonclustered index [index2] on AdPictureB (b2productid)
--Initial Subtree Cost: 0.0032875 
--Subtree Cost: 0.0032853
SELECT * FROM AdPictureB
WHERE b2productid>1

--sp_helpindex AdPictureB

--DROP INDEX index2 on AdPictureB
/*c. Create a view that joins at least 2 tables. 
Check whether existing indexes are helpful;
 if not, reassess existing indexes / examine the cardinality of the tables.*/
--cost with no index : 0.0067414
--cost with index: 0.0067404

ALTER VIEW VIEW1 AS
SELECT AdPictureB.bid,  AdPictureB.b2productid,Products.productid
FROM AdPictureB
INNER JOIN Products ON AdPictureB.b2productid = Products.productid
WHERE AdPictureB.b2productid>1
sp_helpindex AdPictureB

CREATE nonclustered index [index4] on AdPictureB (code)
CREATE nonclustered index [index5] on AdPictureB (mentions)

DROP INDEX index4 on AdPictureB

ALTER TABLE C
DROP CONSTRAINT Constraint1
GO

ALTER TABLE AdPictureB
DROP CONSTRAINT p1
GO

DROP index p1 ON AdPictureB

SELECT * FROM VIEW1