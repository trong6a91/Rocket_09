CREATE DATABASE Ex3;
USE Ex3;

CREATE TABLE ABX (
		ID INT AUTO_INCREMENT PRIMARY KEY,
        `Name` VARCHAR(60),
        BirthDate DATE,
        Gender ENUM('0','1','NULL'),
        IsDeleteFlag ENUM('0','1')
);