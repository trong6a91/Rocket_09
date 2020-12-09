DROP DATABASE IF EXISTS ThucTap ;
CREATE DATABASE ThucTap;
USE ThucTap ;

DROP TABLE IF EXISTS Country;
CREATE TABLE Country(
country_id INT AUTO_INCREMENT PRIMARY KEY,
country_name VARCHAR(40)

);

DROP TABLE IF EXISTS  Location;
CREATE TABLE Location(
location_id INT AUTO_INCREMENT PRIMARY KEY,
street_address VARCHAR(40),
postal_code INT,
country_id INT NOT NULL,
FOREIGN KEY (country_id) REFERENCES Country(country_id)
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
employee_id INT AUTO_INCREMENT PRIMARY KEY,
full_name VARCHAR(40),
email VARCHAR(40),
location_id INT NOT NULL,
FOREIGN KEY (location_id) REFERENCES Location(location_id)
);



INSERT INTO Country
VALUES (1,'Viet Nam'),
		(2,'Trung Quốc'),
        (3,'Hoa Kì'),
        (4,'Anh'),
        (5,'Lao');

INSERT INTO Location
VALUES (10,'Nguyen Trai',123,1),
(6,'Mátryee',535,4),
(7,'Great Wall',432,2),
(8,'Nguyen Xien',137,1),
(9,'Center Resion',362,3);

INSERT INTO Employee
VALUES (11,'Nguyen Thai','nguyenthai@gmail.com',7),
(12,'Nguyen Nhu','nn03@gmail.com',6),
(13,'Hoang Uyen','hu34@gmail.com',7),
(14,'Nguyen Hai','haig@gmail.com',9),
(15,'Van Luc','vanluc@gmail.com',8);

-- 2a : Lấy tất cả nhân viên thuộc Viêt Nam
SELECT *
FROM employee
WHERE location_id IN (SELECT location_id
					FROM Location
                    WHERE country_id = 1 );
                    
-- 2b : Lấy ra tên quốc gia của employee có email là nn03@gmail.com
SELECT country_name
FROM Country
WHERE country_id = (SELECT country_id
					FROM Location
                    WHERE location_id = (SELECT location_id
											FROM Employee
											WHERE email = 'nn03@gmail.com'));

-- 2c : Thống kê mỗi country,location có bao nhiêu employee đang làm việc

SELECT e.location_id,count(e.location_id) as num_activer_location,c.country_id,count(c.country_id) as num_activer_country
FROM Employee e JOIN Location l ON e.location_id = l.location_id JOIN Country c ON c.country_id = l.country_id
GROUP BY e.location_id,c.country_id;

-- 3 Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
DROP TRIGGER IF EXISTS insert_max_10_employees_in_country;
DELIMITER $$
CREATE TRIGGER insert_max_10_employees_in_country
BEFORE INSERT ON Emloyee 
FOR EACH ROW
BEGIN
IF (SELECT COUNT(1)
	FROM Employee e JOIN Location l ON e.location_id = l.location_id JOIN Country c ON c.country_id = l.country_id
	GROUP BY c.country_id) > 10
    THEN 
    SIGNAL SQLSTATE '12345'
    SET MESSAGE_TEXT ='No more than 10 employees';
    END IF;
END$$
DELIMITER ;

-- 4 Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở location đó sẽ có location_id = null


DROP TRIGGER IF EXISTS deleted_location;
DELIMITER $$
CREATE TRIGGER delete_location
BEFORE DELETE ON Location
FOR EACH ROW
BEGIN
		UPDATE Employee
        SET location_id = null
        WHERE location_id = OLD.location_id;
END$$
DELIMITER ;


