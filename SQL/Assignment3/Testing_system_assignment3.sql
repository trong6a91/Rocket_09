USE DepartmentIF;
-- Tạo view chứa các nhân viên thuộc phòng ban Sales
CREATE VIEW DSNV_Sales 
AS
SELECT *
FROM `Account`
WHERE DepartmentID = ( SELECT DepartmentID
						FROM Department
                        WHERE DepartmentName = 'Sales');

 --  Tạo view có chứa thông tin các account tham gia vào nhiều group nhất                       
CREATE VIEW AC_Group
AS
SELECT *
FROM `Account`
WHERE AccountID = (SELECT AccountID
					FROM GroupAccount
                    GROUP BY AccountID
                    HAVING COUNT(AccountID) = (SELECT MAX(ds)
												FROM ( SELECT COUNT(1) AS ds
														FROM GroupAccount
                                                        GROUP BY AccountID) AS bang));

SELECT *
FROM `Account`
WHERE AccountID = (SELECT AccountID
					FROM GroupAccount
                    GROUP BY AccountID
                    HAVING COUNT(*) = (SELECT COUNT(*)
										FROM GroupAccount
                                        GROUP BY AccountID
                                        ORDER BY COUNT(*) DESC LIMIT 1));

-- Tạo view có chứa câu hỏi có những content quá dài (content quá 300 ki tu được coi là quá dài) và xóa nó điv
CREATE VIEW Q_tren_300tu
AS
SELECT *
FROM Question
WHERE CHAR_LENGTH(Content) > 300 ;

-- Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE VIEW DE_MAX_ACC
AS
SELECT *
FROM department
WHERE DepartmentID = (SELECT DepartmentID 
						FROM `Account`
                        GROUP BY DepartmentID
                        HAVING COUNT(DepartmentID) = (SELECT MAX(dem)
														FROM (SELECT COUNT(1) AS dem
																FROM `Account`
                                                                GROUP BY DepartmentID) AS bang));
                                                                



