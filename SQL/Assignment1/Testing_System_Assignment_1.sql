DROP DATABASE IF EXISTS DepartmentIF;
CREATE DATABASE DepartmentIF;
USE DepartmentIF;

CREATE TABLE Department (
		DepartmentID 	INT AUTO_INCREMENT PRIMARY KEY,
		DepartmentName 	VARCHAR(50) NOT NULL
 );
 
 CREATE TABLE `Position`(
		PositionID 		INT AUTO_INCREMENT PRIMARY KEY,
        PositionName 	ENUM('Dev','Test','Scrum Master','PM')
);

CREATE TABLE `Account`(
		AccountID 		INT AUTO_INCREMENT PRIMARY KEY,
        Email 			VARCHAR(60) UNIQUE,
        Username 		VARCHAR(20) UNIQUE,
        Fullname 		VARCHAR(60) NOT NULL,
        DepartmentID 	INT,
        FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
        PositionID 		INT,
        FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID),
        CeateDate 		DATE
        
);

CREATE TABLE `Group`(
		GroupID 		INT AUTO_INCREMENT PRIMARY KEY,
        Groupname 		VARCHAR(30) NOT NULL,
        CreatorID 		INT,
        CreateDate 		DATE
	
);

CREATE TABLE GroupAccount(
		GroupID 		INT NOT NULL,
        AccountID 		INT NOT NULL,
        CONSTRAINT PRIMARY KEY(GroupID,AccountID),
        CONSTRAINT FOREIGN KEY(GroupID) REFERENCES `Group`(GroupID),
        CONSTRAINT FOREIGN KEY(AccountID) REFERENCES `Account`(AccountID),
        JoinDate 		DATE
        
);
        
 CREATE TABLE TypeQuestion(
		TypeID 			INT AUTO_INCREMENT PRIMARY KEY,
        TypeName 		ENUM('Essay','Multiple-choice')
 );
 
 CREATE TABLE CategoryQuestion(
		CategoryID 		INT AUTO_INCREMENT PRIMARY KEY,
        CategoryName 	VARCHAR(40)
 );
 
 CREATE TABLE Question(
		QuestionID 		INT AUTO_INCREMENT PRIMARY KEY,
        Content 		VARCHAR(80),
        CategoryID 		INT NOT NULL,
        FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
        TypeID 			INT NOT NULL ,
        FOREIGN KEY (TypeID) REFERENCES TypeQuestion(TypeID),
        CreatorID 		INT NOT NULL,
        CreateDate 		DATE
);

CREATE TABLE Answer(
		AnswerID 		INT AUTO_INCREMENT PRIMARY KEY,
        Content 		VARCHAR(80) NOT NULL,
        QuestionID 		INT NOT NULL,
        FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID),
        isCorrect ENUM('True','False')
);

CREATE TABLE  Exam(
		ExamID 			INT AUTO_INCREMENT PRIMARY KEY,
        `Code` 			INT UNIQUE,
        Title 			VARCHAR(60),
        CategoryID 		INT NOT NULL,
        Duration 		VARCHAR(10),
        CreatorID 		INT NOT NULL,
        CreateDate 		DATE
);

CREATE TABLE ExamQuestion(
		ExamID 			INT NOT NULL,
        QuestionID 		INT NOT NULL,
        CONSTRAINT PRIMARY KEY(ExamID,QuestionID),
        CONSTRAINT FOREIGN KEY (ExamID) REFERENCES Exam(ExamID),
        CONSTRAINT FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);
INSERT INTO Department
VALUES	(11,			'Maketing'	),
		(21,			'Sales'		),
		(31,			'Securitiy'	),
        (41,			'Technicial'	),
        (51,			'HK'			);
        
INSERT INTO `Position`
VALUES 	(12,			'Dev'			),
		(22,			'Scrum Master'		),
		(32,			'Test'			),
        (42,			'PM'				),
        (52,			'Test'			);

INSERT INTO `Account`
VALUES	
(13,		'abcd@gmail.com',		'abcd',		'nguynvana',		31,	22,		'2020-06-07'),
(23,		'efgh@gmail.com',		'efgh',		'phamthie',			21,	42,		'2020-06-07'),
(33,		'tuyj@gmail.com',		'tuyj',		'phamvantuy',		11,	22,		'2020-06-07'),
(43,		'huong@gmail.com',		'huong',	'nguyenthihuong',	41, 12,		'2020-06-07'),
(53,		'uyen@gmail.com',		'uyen',		'nguyenthiuyen',	21,	22,		'2020-06-07');

INSERT INTO `Group`
VALUE 	(14,			'Maketing',			323,		'2020-06-07'),
		(24,			'Sales',			453,		'2020-06-07'),
		(34,			'Securitiy',		757,		'2020-06-07'),
        (44,			'Technicial',		783,		'2020-06-07'),
        (54,			'HK',				587,		'2020-06-07');
        
INSERT INTO GroupAccount
VALUES 	(14,			43,		'2020-06-07'),
		(24,			13,		'2020-06-07'),
		(34,			43,		'2020-06-07'),
        (44,			23,		'2020-06-07'),
        (54,			53,		'2020-06-07');

INSERT INTO TypeQuestion
VALUES 	(16,			'Essay'				),
		(26,			'Multiple-choice'	),
		(36,			'Multiple-choice'	),
        (46,			'Essay'				),
        (56,			'Essay'				);

INSERT INTO CategoryQuestion
VALUES 	(17,			'Java'		),
		(27,			'NET'		),
		(37,			'Ruby'		),
        (47,			'Python'	),
        (57,			'JS'		);
        
INSERT INTO Question
VALUES 	(18,			'Q1',	17,		16,		17654,		'2020-06-07'),
		(28,			'Q2',	27,		26,		17382,		'2020-06-07'),
		(38,			'Q3',	37,		36,		37582,		'2020-06-07'),
        (48,			'Q4',	47,		46,		45321,		'2020-06-07'),
        (58,			'Q5',	57,		56,		33535,		'2020-06-07');
        
INSERT INTO Answer
VALUES 	(19,			'A1',	18,		'True'	),
		(29,			'A2',	28,		'True'	),
		(39,			'A3',	38,		'False'	),
        (49,			'A4',	48,		'False'	),
        (59,			'A5',	58,		'True'	);

INSERT INTO Exam
VALUES 	(110,		165,	'Title1',		91,		90,		12344,		'2020-03-04'),
		(210,		175,	'Title2',		92,		90,		12345,		'2020-07-06'),
		(310,		195,	'Title3',		93,		120,	12346,		'2020-07-06'),
        (410,		302,	'Title4',		94,		120,	12347,		'2020-07-06'),
        (510,		456,	'Title5',		95,		120,	12348,		'2020-07-06');
        
INSERT INTO ExamQuestion
VALUES 	(110,			18),
		(210,			28),
		(310,			38),
        (410,			48),
        (510,			58);		
