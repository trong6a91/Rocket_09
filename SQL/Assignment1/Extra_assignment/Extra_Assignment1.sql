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
ALTER TABLE Trainee ADD COLUMN VTI_Account VARCHAR(60) NOT NULL UNIQUE;