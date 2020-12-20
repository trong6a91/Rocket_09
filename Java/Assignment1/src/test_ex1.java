import java.security.acl.Group;
		import java.time.LocalDate;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
public class test_ex1 {
	public static void main(String[] args) {
		// Department
		Department department1 = new Department();
		department1.departmentId =11;
		department1.departmentName="Sale";
		
		Department department2 = new Department();
		department2.departmentId =12;
		department2.departmentName="Maketing";
		
		Department department3 = new Department();
		department3.departmentId =13;
		department3.departmentName="Support";
		
		// Position
		Position position1 = new Position();
		position1.positionId=21;
		position1.positionName="Dev";
		
		Position position2 = new Position();
		position2.positionId=22;
		position2.positionName="Test";
		
		Position position3 = new Position();
		position3.positionId=23;
		position3.positionName="PM";
		// Group
		
		Grooup group1 = new Grooup();
		group1.groupId=31;
		group1.groupName="group quan tri";
		group1.createId=99;
		group1.createDate=LocalDate.of(2020,11,20);
	
		
		Grooup group2 = new Grooup();
		group2.groupId=32;
		group2.groupName="group kinh doanh";
		group2.createId=95;
		group2.createDate=LocalDate.of(2020,12,15);
		
		Grooup group3 = new Grooup();
		group3.groupId=33;
		group3.groupName="group lap trinh";
		group3.createId=96;
		group3.createDate=LocalDate.of(2020,12,26);
		
		Grooup group4 = new Grooup();
		group4.groupId=34;
		group4.groupName="group ke toan";
		group4.createId=98;
		group4.createDate=LocalDate.of(2020,02,15);
		
		//Account
		Account account1= new Account();
		account1.AccountId=41;
		account1.email="nkhoang@gmail.com";
		account1.userName="nkhoang";
		account1.fullName="Nguyen Khanh Hoang";
		account1.department = department1;
		account1.position = position2;
		account1.createDate=LocalDate.of(2020,12,14);
		account1.joinDate=LocalDate.of(2020,06,07);
		account1.groups = new Grooup[] {group1};
		
		Account account2= new Account();
		account2.AccountId=42;
		account2.email="nnt@gmail.com";
		account2.userName="nnt";
		account2.fullName="Nguyen Nhu Trong";
		account2.department = department1;
		account2.position = position1;
		account2.createDate=LocalDate.of(2020,12,14);
		account2.joinDate=LocalDate.of(2020,06,07);
		account2.groups = new Grooup[] {group1,group2,group3};
		
		Account account3= new Account();
		account3.AccountId=43;
		account3.email="ptat@gmail.com";
		account3.userName="ptat";
		account3.fullName="Pham Thao Anh Thu";
		account3.department = department3;
		account3.position = position1;
		account3.createDate=LocalDate.of(2020,12,14);
		account3.joinDate=LocalDate.of(2020,06,07);
		account3.groups = new Grooup[] {};
		
		Account account4= new Account();
		account4.AccountId=44;
		account4.email="nkhoang@gmail.com";
		account4.userName="ntlan";
		account4.fullName="Nguyen Thi Lan Anh";
		account4.department = department3;
		account4.position = position3;
		account4.createDate=LocalDate.of(2020,12,14);
		account4.joinDate=LocalDate.of(2020,06,07);
		account4.groups = new Grooup[] {group3};
		
		Account account5= new Account();
		account5.AccountId=54;
		account5.email="ntu@gmail.com";
		account5.userName="ntu";
		account5.fullName="Nguyen Thi Uyen";
		account5.department = department2;
		account5.position = position1;
		account5.createDate=LocalDate.of(2020,12,14);
		account5.joinDate=LocalDate.of(2020,06,07);
		account5.groups = new Grooup[] {group3,group4};
		
		//add accout
				group1.account = new Account[] {account1,account2};
				group2.account=new Account[] {account2};
				group3.account=new Account[] {account2,account4,account5};
				group4.account=new Account[] {account5};
		
		//TypeQuestion
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.typeId=51;
		typeQuestion1.typeName="Multi-choice";
		
		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.typeId=52;
		typeQuestion2.typeName="Essay";
		
		TypeQuestion typeQuestion5 = new TypeQuestion();
		typeQuestion5.typeId=53;
		typeQuestion5.typeName="Essay";
		
		TypeQuestion typeQuestion3 = new TypeQuestion();
		typeQuestion3.typeId=54;
		typeQuestion3.typeName="Multti-choice";
		
		TypeQuestion typeQuestion4 = new TypeQuestion();
		typeQuestion4.typeId=55;
		typeQuestion4.typeName="Essay";
		
		//Category
		CategoryQuestion categoryQuestion1 = new CategoryQuestion();
		categoryQuestion1.categoryId=61;
		categoryQuestion1.categoryName="Java";
		
		CategoryQuestion categoryQuestion2 = new CategoryQuestion();
		categoryQuestion2.categoryId=62;
		categoryQuestion2.categoryName="SQL";
		
		CategoryQuestion categoryQuestion3 = new CategoryQuestion();
		categoryQuestion3.categoryId=63;
		categoryQuestion3.categoryName="HTML";
		
		CategoryQuestion categoryQuestion4 = new CategoryQuestion();
		categoryQuestion4.categoryId=64;
		categoryQuestion4.categoryName="CSS";
		
		//Question 
		Question question1 = new Question();
		question1.questionId=71;
		question1.content="How r u?";
		question1.categoryQuestion = categoryQuestion2;
		question1.typeQuestion = typeQuestion1;
		question1.creatorId = 88;
		question1.createDate = LocalDate.of(2020, 4, 12);
		
		Question question2 = new Question();
		question2.questionId=72;
		question2.content="How old r u?";
		question2.categoryQuestion = categoryQuestion1;
		question2.typeQuestion = typeQuestion2;
		question2.creatorId = 87;
		question2.createDate = LocalDate.of(2020, 5, 12);
		
		Question question3 = new Question();
		question3.questionId=73;
		question3.content="How the f r u?";
		question3.categoryQuestion = categoryQuestion3;
		question3.typeQuestion = typeQuestion1;
		question3.creatorId = 86;
		question3.createDate = LocalDate.of(2020, 7, 12);
		
		Question question4 = new Question();
		question4.questionId=74;
		question4.content="What ur name?";
		question4.categoryQuestion = categoryQuestion2;
		question4.typeQuestion = typeQuestion3;
		question4.creatorId = 80;
		question4.createDate = LocalDate.of(2020, 8, 12);
		
		Question question5= new Question();
		question5.questionId=75;
		question5.content="Do you love me?";
		question5.categoryQuestion = categoryQuestion4;
		question5.typeQuestion = typeQuestion2;
		question5.creatorId = 83;
		question5.createDate = LocalDate.of(2020, 8, 12);
		
		Question question6 = new Question();
		question6.questionId=76;
		question6.content="How lol r u?";
		question6.categoryQuestion = categoryQuestion3;
		question6.typeQuestion = typeQuestion3;
		question6.creatorId = 84;
		question6.createDate = LocalDate.of(2020, 5, 12);
		
		
		//Answer
		Answer answer1 = new Answer();
		answer1.answerId=81;
		answer1.conten="This is    ";
		answer1.isCorrect=true;
		answer1.question = question1;
		
		Answer answer2 = new Answer();
		answer2.answerId=82;
		answer2.conten="This is a    ";
		answer2.isCorrect=false;
		answer2.question = question2;
		
		Answer answer3 = new Answer();
		answer3.answerId=83;
		answer3.conten="This is c    ";
		answer3.isCorrect=true;
		answer3.question = question3;
		
		Answer answer4 = new Answer();
		answer4.answerId=84;
		answer4.conten="This is d    ";
		answer4.isCorrect=true;
		answer4.question = question4;
		
		Answer answer5 = new Answer();
		answer5.answerId=85;
		answer5.conten="This is g   ";
		answer5.isCorrect=false;
		answer5.question = question5;
		
		Answer answer6= new Answer();
		answer6.answerId=86;
		answer6.conten="This is f   ";
		answer6.isCorrect=true;
		answer6.question = question6;
		
		//Exam
		Exam exam1 = new Exam();
		exam1.examId=91;
		exam1.code=111;
		exam1.title="Day la de thi 1";
		exam1.categoryId = 19;
		exam1.duration = 90;
		exam1.creatorId=345;
		exam1.createDate = LocalDate.of(2020, 3, 23);
		exam1.question = new Question[] {question1,question2,question4,question5};
		
		Exam exam2 = new Exam();
		exam2.examId=92;
		exam2.code=222;
		exam2.title="Day la de thi 2";
		exam2.categoryId = 29;
		exam2.duration = 60;
		exam2.creatorId=385;
		exam2.createDate = LocalDate.of(2020, 3, 27);
		exam2.question = new Question[] {question1,question6,question4,question5};
		
		Exam exam3 = new Exam();
		exam3.examId=93;
		exam3.code=333;
		exam3.title="Day la de thi 3";
		exam3.categoryId = 49;
		exam3.duration = 90;
		exam3.creatorId=305;
		exam3.createDate = LocalDate.of(2020, 3, 23);
		exam3.question = new Question[] {question6,question2,question4,question5};
		
		Exam exam4 = new Exam();
		exam4.examId=94;
		exam4.code=444;
		exam4.title="Day la de thi 4";
		exam4.categoryId = 49;
		exam4.duration = 90;
		exam4.creatorId=335;
		exam4.createDate = LocalDate.of(2020, 3, 23);
		exam4.question = new Question[] {question1,question4,question5};
		

				
		// Question1		
//			if(account2.department==null)
//			{
//				System.out.print("This account has no department");
//			}
//			System.out.print("This account in department named "+account2.department.departmentName);
			
		//Question2
//			if(account2.groups.length==0)
//			{
//				System.out.print("This account has no group");
//			}
//			else if(account2.groups.length==1||account2.groups.length==2)
//			{
//				System.out.print("This account's group are Fresher,C# Fresher");
//				
//			}
//			else if(account2.groups.length==3)
//			{
//				System.out.print("This account is an important person , joined many group");
//			}
//			else if(account2.groups.length>4) {
//				System.out.print("This account is a fking man,joined all group");
//				
//			}
		//Question3
//			System.out.prinln(account2.department==null ? "This account has no departmen t" : "This account in department named ");
		
		//Question4
//		System.out.print(account1.position.positionName=="Dev" ? "This is Developer" : "This is not Developer");
		
		//Question5
//		int x = group1.account.length;
//		switch (x) {
//		case 1:
//			System.out.print("This group has only one account");
//			break;
//		case 2:
//			System.out.print("This group has two accounts");
//			break;
//		case 3:
//			System.out.print("This group has three accounts");
//		default:
//			System.out.print("This group has many accounts");
//			break;
//		}
		
		//Question6
//		int x=account2.groups.length;
//		switch (x) {
//		case 0:
//			System.out.print("This account has no group");
//			break;
//		case 1:
//			System.out.print("This account's group are Fresher,C# Fresher");
//			break;
//		case 2:
//			System.out.print("This account's group are Fresher,C# Fresher");
//			break;
//		case 3:
//			System.out.print("This account is an important person , joined many group");
//			break;
//		default:
//			System.out.print("This account is a fking man,joined all group");
//			break;
//		}
		
		//Question7
//		switch (account1.position.positionName) {
//		case "Dev":
//			System.out.print("This is Developer");
//			break;
//
//		default:
//			System.out.print("This is not Developer");
//			break;
//		}
		
//		//Question8
//		Account[] accounts = {account1,account2,account3,account4,account5};
//		for (Account account : accounts) {
//			System.out.println("Email: " + account.email);
//			System.out.println("FullName: " + account.fullName);
//			System.out.println("Name Department: " + account.department.departmentName);
			
		//Question 9
//		Department[] departments = {department1,department2,department3};
//		for(Department department : departments) {
//			System.out.println("Department ID :"+ department.departmentId);
//			System.out.println("Department Name :"+ department.departmentName);
//		}
		
		//Question 10
//		Account[] accounts = {account1,account2,account3,account4,account5};
//		for(int i = 0; i < accounts.length;i++) {
//			System.out.println("Thong tin account thu " + (i+1) + " la :");
//			System.out.println("Email :"+ accounts[i].email);
//			System.out.println("Full name :" + accounts[i].fullName);
//			System.out.println("Department :"+accounts[i].department.departmentName);
//		}
//		
//		//Question 11
//		Department[] departments = {department1,department2,department3};
//		for(int i = 0 ; i < departments.length;i++)
//		{
//			System.out.println("Thong tin cua department thu " + (i+1) + "la :");
//			System.out.println("Id :"+ departments[i].departmentId);
//			System.out.println("Name : "+ departments[i].departmentName);
//		}
//		//Question 12
//		Department[] departments = {department1,department2,department3};
//		for(int i = 0 ; i < 2;i++)
//		{
//			System.out.println("Thong tin cua department thu " + (i+1) + "la :");
//			System.out.println("Id :"+ departments[i].departmentId);
//			System.out.println("Name : "+ departments[i].departmentName);
//		}
//		
//		//Question 13
//		Account[] accounts = {account1,account2,account3,account4,account5};
//		for(int i = 0; i < accounts.length ;i++) {
//			if(i != 1)
//			{System.out.println("Thong tin account thu " + (i+1) + " la :");
//			System.out.println("Email :"+ accounts[i].email);
//			System.out.println("Full name :" + accounts[i].fullName);
//			System.out.println("Department :"+accounts[i].department.departmentName);}
//		}
		// Question 14
//		Account[] accounts = {account1,account2,account3,account4,account5};
//		for(int i = 0; i < accounts.length ;i++) {
//			if(accounts[i].AccountId<4)
//			{
//			System.out.println("Email :"+ accounts[i].email);
//			System.out.println("Full name :" + accounts[i].fullName);
//			System.out.println("Department :"+accounts[i].department.departmentName);
//			}
//		}
		//Question 15 
		for(int i = 0; i < 20 ; i ++ )
		{
			if(i%2==0)
			{
				System.out.println(i);
			}
		}
		
		//Question 16 
		//Question 17
	
}
}