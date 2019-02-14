USE firstdatabase;

DROP TABLE IF EXISTS CurrentVersion

CREATE TABLE CurrentVersion(currVers INT);

Insert INTO CurrentVersion VALUES (0);

IF EXISTS ( select * from sys.procedures where name='main')
 BEGIN 
   DROP PROC main
END 


go
CREATE PROCEDURE [dbo].[main] @vers INT
AS
BEGIN
	DECLARE @currVers INT
		DECLARE @proc VARCHAR(50)

		SELECT @currVers = currVers
		FROM CurrentVersion

		IF @currVers = @vers
		BEGIN
			PRINT 'Already this version'
		END

		WHILE @currVers < @vers
		BEGIN
			SET @currVers = @currVers + 1
			SET @proc = 'up' + cast(@currVers AS VARCHAR(50))
			PRINT @proc
			EXEC @proc
		END

		WHILE @currVers > @vers
		BEGIN
			SET @proc = 'down' + cast(@currVers AS VARCHAR(50))
			PRINT @proc
			EXEC @proc
			SET @currVers = @currVers - 1
		END
	UPDATE CurrentVersion
	SET currVers = @vers
END

EXEC main 2

EXEC up1;
EXEC up2;
EXEC up3;
EXEC up4;
EXEC up5;
EXEC up6;
EXEC up7;

EXEC down1;
EXEC down2;
EXEC down3;
EXEC down4;
EXEC down5;
EXEC down6;
EXEC down7;
/*
sp_helpindex Employees
select * from Employees

CREATE clustered index numeindex on Influencers(id)
select * from Influencers 
Where id=1

*/