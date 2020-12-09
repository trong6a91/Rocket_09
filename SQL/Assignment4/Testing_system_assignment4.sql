USE DepartmentIF;
-- Question 1
DELIMITER $$
-- drop PROCEDURE  if exists get_account;
CREATE PROCEDURE get_account ( IN department_name VARCHAR(50))
BEGIN
	SELECT *
		FROM Department d JOIN `Account` a ON a.DepartmentID = d.DepartmentID
		WHERE DepartmentName = department_name;
END$$
DELIMITER ;
call departmentif.get_account('Sales');

-- Question 2
DELIMITER $$
CREATE PROCEDURE account_number()
BEGIN
	SELECT GroupID,COUNT(1)
	FROM GroupAccount
	GROUP BY GroupID;
END$$
DELIMITER ;

-- Question 3 
DELIMITER $$
CREATE PROCEDURE used_time ()
BEGIN
	SELECT typeID,COUNT(1)
    FROM Question
    GROUP BY TypeID
     HAVING MONTH(CreateDate)=MONTH(NOW()) AND YEAR(CreateDate)=YEAR(NOW());
END$$
DELIMITER ;
UPDATE Question SET TypeID = 36 WHERE QuestionID = 18;
-- Question 4
DROP PROCEDURE IF EXISTS max_used_time;
DELIMITER $$
CREATE PROCEDURE max_used_time(OUT id_tyq_max_used_time INT)
BEGIN
	SELECT TypeID INTO id_tyq_max_used_time
    FROM Question
    GROUP BY TypeID
    HAVING COUNT(1) = (SELECT MAX(ds)
						FROM (SELECT COUNT(1) as ds
								FROM Question
                                GROUP BY TypeID) as bc);
END$$
DELIMITER ;
SET @v = 0;
CALL max_used_time(@v);
SELECT @v;
-- Question 5
SELECT TypeName
FROM TypeQuestion
WHERE TypeID = @v;

-- Question 6
DROP PROCEDURE IF EXISTS get_result;
DELIMITER $$
CREATE PROCEDURE get_result(IN input VARCHAR(40))
BEGIN
		SELECT GroupID
        FROM `Group`
        WHERE GroupName LIKE Concat('%',input,'%') ;
        
        SELECT AccountID
        FROM `Account`
         WHERE Username LIKE Concat('%',input,'%');
END$$

DELIMITER ;
call get_result('bcd');
-- Question 8
UPDATE Question SET Content = " How are you" WHERE QuestionID = 18;
UPDATE Question SET Content = " How old are you" WHERE QuestionID = 28;
UPDATE Question SET Content = " What is your job" WHERE QuestionID = 38;
UPDATE Question SET Content = " What do you wanna do" WHERE QuestionID = 48;
UPDATE Question SET Content = " Are you gonna playing atm" WHERE QuestionID = 58;
DELIMITER $$
CREATE PROCEDURE max_content (IN type_question_name CHAR(20))
BEGIN
	SELECT QuestionID
    FROM Question
    WHERE char_length(Content) = (SELECT MAX(char_length(Content))
									FROM Question
									WHERE TypeID IN (SELECT TypeID 
														FROM TypeQuestion
														WHERE TypeName = type_question_name));
    
END$$
DELIMITER ;

-- Question 9
DELIMITER $$
CREATE PROCEDURE Delete_Exam ( IN ID INT )
BEGIN 
	DELETE FROM Exam
    WHERE ExamID = ID;
END $$
DELIMITER ;

-- Question 10
CALL Delete_Exam( SELECT ExamID
					FROM Exam
                    WHERE YEAR(CreateDate)<SUBDATE(NOW(),INTERVAL 3 YEAR));
                    
-- Question 11
INSERT INTO Department 
VALUES ( 61, 'Waiting room');

DELIMITER $$
CREATE PROCEDURE delete_department(IN name_of_department VARCHAR(40))
BEGIN
		DELETE FROM Department
        WHERE DepartmentName=name_of_department;
        
        UPDATE `Account`
        SET DepartmentID = (SELECT DepartmentID 
							FROM Department
                            WHERE DepartmentName = "Waiting room")
		WHERE DepartmentID = (SELECT DepartmentID 
							FROM Department
                            WHERE DepartmentName = name_of_department);
END$$
DELIMITER ;

-- Question 12







