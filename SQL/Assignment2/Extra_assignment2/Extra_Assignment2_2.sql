DROP DATABASE IF EXISTS ex2;
CREATE DATABASE IF NOT EXISTS ex2;
USE ex2;

DROP TABLE IF EXISTS Department;
CREATE TABLE Department
(
	Department_Number INT NOT NULL PRIMARY KEY,
	Department_Name VARCHAR(100)
);

DROP TABLE IF EXISTS Employee_Table;
CREATE TABLE Employee_Table
(
	Employee_Number INT PRIMARY KEY,
	Employee_Name VARCHAR(100),
	Department_Number INT,
	CONSTRAINT FOREIGN KEY(Department_Number) REFERENCES Department(Department_Number)
);

DROP TABLE IF EXISTS Employee_Skill_Table;
CREATE TABLE Employee_Skill_Table
(
	Employee_Number INT PRIMARY KEY,
	Skill_Code VARCHAR(100),
	Date_Registered DATE,
	CONSTRAINT FOREIGN KEY(Employee_Number) REFERENCES Employee_Table(Employee_Number)
);

INSERT INTO Department VALUES 
	(1, 	'SAMSUNG'	),
	(2, 	'SONY'		),
	(3, 	'LG'		),
	(4, 	'CANON'		);

INSERT INTO Employee_Table VALUES 
(1, 'Soobin Hoang Son',	 	2),
(2, 'Tran Thanh MC', 		2),
(3, 'Truong Giang MC', 		1),
(4, 'Quan AP',	 			4),
(5, 'My Tam', 				1),
(6, 'Dam Vinh Hung', 		2),
(7, 'Binz', 				2),
(8, 'SuBoi', 				1),
(9, 'Wowy', 				2),
(10, 'Karik', 				3),
(11, 'Duc Phuc',			4),
(12, 'Harry Won', 			2);

INSERT INTO Employee_Skill_Table VALUES 
(1, 	'JAVA', 		'2020-11-28'),
(2, 	'PYTHON', 		'2020-11-28'),
(3, 	'HTML', 		'2020-11-28'),
(4, 	'CSS', 			'2020-11-28'),
(5, 	'JAVA', 		'2020-11-28'),
(6, 	'C#', 			'2020-11-28'),
(7, 	'SQL', 			'2020-11-28'),
(8,	 	'PHOTOSHOP', 	'2020-11-28'),
(9, 	'JAVA', 		'2020-11-28'),
(10, 	'JAVA', 		'2020-11-28'),
(11, 	'HTML', 		'2020-11-28'),
(12, 	'C#', 			'2020-11-28');

SELECT Employee_Table.Employee_Name
FROM Employee_Table JOIN Employee_Skill_Table ON Employee_Table.Employee_Number=Employee_Skill_Table.Employee_Number
WHERE Employee_Skill_Table.Skill_Code='Java';

SELECT Department_Name
FROM Department JOIN Employee_Table ON Department.Department_Number = Employee_Table.Department_Number
GROUP BY Employee_Table.Department_Number
HAVING COUNT(1)>3;

SELECT Department_Number,COUNT(Employee_Number) as So_NV,GROUP_CONCAT(Employee_Number)
FROM Employee_Table
GROUP BY Department_Number;

SELECT Employee_Table.Employee_Number,Employee_Table.Employee_Name
FROM Employee_Table JOIN Employee_Skill_Table ON Employee_Table.Employee_Number=Employee_Skill_Table.Employee_Number
GROUP BY Employee_Skill_Table.Employee_Number
HAVING COUNT(Skill_Code)>1;

