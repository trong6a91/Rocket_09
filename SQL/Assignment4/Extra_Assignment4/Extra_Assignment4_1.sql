DROP DATABASE IF EXISTS Assignment_4;
CREATE DATABASE Assignment_4;
USE Assignment_4;
CREATE TABLE Employee
(
	EmployeeID int primary key,
    EmployeeLastName varchar(50),
    EmployeeFirstName varchar(50),
    EmployeeHireDate datetime,
    EmployeeStatus tinyint,
    SupervisorID int ,
    SocialSecurityNumber int
);
drop table if exists Projects;
create table Projects
(
	ProjectID int primary key,
    managerID int,
    ProjectName varchar(100),
    ProjectStartDate datetime,
    ProjectDescription varchar(255),
    ProjectDetailt varchar(255),
    ProjectCompletedOn datetime
);

drop table if exists Project_Modules;
create table Project_Modules
(
	ModuleID int  primary key,
    ProjectID int,
    ProjectModulesDate datetime,
    ProjectModulesCompledOn datetime,
    ProjectModulesDescription varchar(255),
    constraint foreign key(ProjectID)
    references Projects(ProjectID) ON DELETE CASCADE
);

drop table if exists Work_Done;
create table Work_Done
(
	WorkDoneID int primary key,
    EmployeeID int,
    ModuleID int,
    WorkDoneDate datetime,
    WorkDoneDescription varchar(255),
    WorkDoneStatus tinyint,
    constraint foreign key(EmployeeID)
    references Employee(EmployeeID) ON DELETE CASCADE,
    constraint foreign key(ModuleID)
    references Project_Modules(ModuleID) ON DELETE CASCADE
);


INSERT INTO employee 
VALUES 	(1,'Thành','Nguyễn Huy','2019-01-03 00:00:00',1,null,21494),
		(2,'Đông','Công Phương','2019-01-03 00:00:00',1,1,215462),
		(3,'Trang','Đặng Nguyễn Phương','2019-01-03 00:00:00',1,1,null),
		(4,'Thủy','Thạch Thanh','2019-01-05 00:00:00',1,null,236454),
		(5,'Hiệp','Hoàng Mạnh','2019-01-06 00:00:00',1,1,null),
		(6,'Hằng','Hồ Thị','2019-02-01 00:00:00','1',4,365446),
		(7,'Anh','Nguyễn Tú','2019-03-05 00:00:00',1,4,null),
		(8,'Giang','Trần Thị Thu','2019-03-06 00:00:00',1,4,332546),
		(9,'Dũng','Bùi Ngọc','2019-06-03 00:00:00',1,10,123654),
		(10,'Đạt','Giang Tiến','2019-03-08 00:00:00',1,null, null),
        (11,'Kiên','Lại Trung','2019-04-09 00:00:00', 1, null, 512983),
        (12,'Anh','Vũ Tuấn', '2019-05-01 00:00:00',1, null, null),
        (13,'Thảo','Ngọc Nguyễn','2019-05-01 00:00:00',1,12,412123),
        (14,'An', 'Lê Ngọc','2019-06-09 00:00:00',1,12,135123),
        (15,'Việt','Nguyễn Việt','2019-04-09 00:00:00', 1,2,123141),
        (16,'Hiếu','Đỗ Duy', '2019-04-08 00:00:00',1,2,1231445);

INSERT INTO Projects
VALUES 	(1,1,'Web_MyGo','2020-03-01 00:00:00','Web for customer','Just a web','2020-07-15 00:00:00'),
		(2,1,'Android_MyGo','2020-03-05 00:00:00','Android App for customer','Just a app','2020-08-29 00:00:00'),
		(3,1,'IOS_MyGo','2020-03-05 00:00:00','IOS App for customer','Just a app',null),
		(4,1,'BackEnd_MyGo','2020-03-01 00:00:00','BE for MyGo application','Big BE',null),
		(5,4,'Test_MyGo','2020-04-01 00:00:00','Test','Automation','2020-11-01 00:00:00');

INSERT INTO Project_Modules
VALUES 	(1,1,'2020-03-01 00:00:00','2020-05-01 00:00:00','web customer'),
        (2,1,'2020-03-01 00:00:00','2020-05-29 00:00:00','web profile'),
        (3,1,'2020-03-01 00:00:00','2020-08-29 00:00:00','web_report'),
        (4,2,'2020-03-05 00:00:00','2020-09-15 00:00:00','app driver'),
		(5,2,'2020-03-05 00:00:00','2020-10-14 00:00:00','app customer'),
        (6,3,'2020-03-05 00:00:00',null					,'web driver'),
        (7,3,'2020-03-10 00:00:00',null					,'web customer'),
        (8,4,'2020-03-01 00:00:00',null					,'backend web'),
        (9,4,'2020-03-01 00:00:00','2020-09-09 00:00:00','backend database'),
        (10,5,'2020-04-01 00:00:00','2020-09-01 00:00:00','manual'),
        (11,5,'2020-04-01 00:00:00','2020-11-14 00:00:00','automation');
        

INSERT INTO Work_Done
VALUES 	(1,5,1,	'2020-05-01 00:00:00',	'design',1),
		(2,5,1,	'2020-05-01 00:00:00',	'core js',1),
		(3,5,2,	'2020-05-29 00:00:00',	'html,css',1),
		(4,11,2,'2020-05-29 00:00:00',	'javascript and vue',1),
		(5,14,3,'2020-08-29 00:00:00',	'make data',1),
		(6,13,3,'2020-08-29 00:00:00',	'vue design',1),
		(7,2,4,	'2020-09-15 00:00:00',	'app driver-design',1),
		(8,15,4,'2020-09-15 00:00:00',	'app driver-api done',1),
		(9,16,5,'2020-10-14 00:00:00',	'app customer-design',1),
		(10,2,5,'2020-10-14 00:00:00',	'app customer-api done',1),
		(11,9,6,null,					'ios design',1),
		(12,10,7,null,					'ios design + api work',1),
		(13,11,8,null,					'backend core',1),
		(14,12,8,null,					'backend system',1),
		(15,4,8,null,					'backend api',1),
		(16,1,9,'2020-09-09 00:00:00','backend data config ',1),
		(17,16,5,'2020-09-09 00:00:00','backend data create',1),
		(18,6,10,'2020-09-01 00:00:00','write test case',1),
		(19,8,10,'2020-09-01 00:00:00','sumary test case',1),
		(20,7,11,'2020-11-14 00:00:00','write code done',1);

-- Question 2
DELIMITER $$
CREATE PROCEDURE delete_project (OUT times INT)
BEGIN
	SELECT count(*) INTO times
	FROM projects
	WHERE ProjectCompletedOn < (SELECT SUBDATE(NOW(), INTERVAL 3 MONTH));
    
    DELETE 
    FROM projects 
	WHERE ProjectCompletedOn < (SELECT SUBDATE(NOW(),INTERVAL 3 MONTH));
END$$
DELIMITER ;
set @num=0;
CALL delete_project (@num);
select @num;

-- Question 3
DROP PROCEDURE IF EXISTS project_modules_dang_lam;
DELIMITER $$
CREATE PROCEDURE project_modules_dang_lam (IN projectID INT , IN employeeID INT )
	BEGIN
		SELECT *
        FROM Project_Modules
        WHERE ProjectModulesCompledOn IS NULL AND (ProjectID = projectID OR EmployeeID = employeeID);
    END$$
DELIMITER ;

SET @a = 0, @b = 0;
CALL project_modules_dang_lam(@a, @b);
select @a, @b;

-- Question 4
DELIMITER $$
CREATE PROCEDURE NV_lam_viec_ko_giao (IN project_ID INT)
	BEGIN
		SELECT EmployeeLastName, EmployeeFirstName
        FROM Employee a LEFT JOIN Work_Done b ON a.EmployeeID = b.EmployeeID LEFT JOIN Project_Modules c ON b.ModuleID = c.ModuleID
        WHERE  SupervisorID IS NULL AND ProjectID = project_ID;
    END$$
DELIMITER ;

 


