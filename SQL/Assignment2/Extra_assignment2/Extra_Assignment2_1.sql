DROP DATABASE IF EXISTS Fresher_Trainee_Management;
CREATE DATABASE Fresher_Trainee_Management;
USE Fresher_Trainee_Management;

CREATE TABLE Trainee(
		TraineeID INT AUTO_INCREMENT PRIMARY KEY,
        Full_Name VARCHAR(60),
        Birth_Date DATE,
        Gender ENUM('Male','Female','Unknown'),
        ET_IQ TINYINT UNSIGNED,
        ET_Math TINYINT UNSIGNED,
        ET_English TINYINT UNSIGNED,
        Training_Class VARCHAR(60),
        Evaluation VARCHAR(100)
); 
TRUNCATE TABLE Trainee;

INSERT INTO Trainee
VALUES 	(1, 'Đình Tuấn', '1999-07-23', 'Male', 20, 20, 50, 'A007', 'Perfect'),
		(2, 'Bảo Anh', '1999-10-05', 'Male', 10, 10, 25, 'A007', 'Mischief'),
		(3, 'Thùy Dương', '1999-12-03', 'Female', 14, 16, 45, 'A002', 'Docile'),
		(4, 'Quỳnh Anh', '1999-12-10', 'Female', 10, 20, 15, 'A001', 'Docile'),
		(5, 'Đình Tú', '2002-01-22', 'Male', 9, 10, 36, 'A004', 'Mischief'),
		(6, 'Đậu Hiền', '1999-06-14', 'Female', 3, 10, 50, 'A002', 'Docile'),
		(7, 'Đắc Công', '1999-01-01', 'Male', 10, 10, 16, 'A006', 'Mischief'),
		(8, 'Trà My', '1999-03-05', 'Female', 12, 14, 35, 'A001', 'Docile'),
		(9, 'Phan Ngọc', '1977-06-01', 'Female', 20, 20, 40, 'A003', 'Perfect'),
		(10, 'Nguyễn Ngân', '1999-07-23', 'Female', 15, 12, 25, 'A005', 'Docile'),
		(11, 'Nguyễn Thảo', '1999-11-19', 'Female', 1, 2, 25, 'A003', 'Mischief'),
		(12, 'Phương Hoa', '1999-04-16', 'Female', 5, 2, 29, 'A004', 'Docile'),
		(13, 'Đức Vượng', '1999-07-19', 'Male', 15, 12, 45, 'A005', 'Docile');

SELECT Full_Name, MONTH(Birth_Date) 
FROM Trainee  
WHERE ET_IQ >10
ORDER BY MONTH(Birth_Date) ;

SELECT *
FROM Trainee 
WHERE char_length(Full_Name) = (SELECT MAX(char_length(Full_Name))
							   FROM Trainee 
							);


SELECT Trainee_Id, Full_Name, ET_IQ, ET_Gmath, ET_English
FROM Trainee
WHERE  ET_IQ>=8 and ET_Gmath>=8 and ET_English>=18 and ET_IQ + ET_Gmath>=20 ;


DELETE 
FROM 
	Trainee 
WHERE 
	Trainee_Id=3;


UPDATE
	Trainee 
SET  
	Training_Class = 2 
WHERE Trainee_Id = 5;
