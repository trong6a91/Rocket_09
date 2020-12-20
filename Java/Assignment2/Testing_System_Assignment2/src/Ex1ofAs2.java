public class Ex1ofAs2 {

	public static void main(String[] args) {
		Question1();
		Question2();
		Question3();
		Question4();
		Question5();
		Question6();
		Question7();
		Question8();
		Question9();
		Question10();
		Question11();
		Question12();
		Question13();
		Question14();
		Question15();
		Question16();
}
	public static void Question1() {		
	if(account2.department==null)
	{
		System.out.print("This account has no department");
	}
	System.out.print("This account in department named "+account2.department.departmentName);
	}
public static void Question2() {
	

	if(account2.groups.length==0)
	{
		System.out.print("This account has no group");
	}
	else if(account2.groups.length==1||account2.groups.length==2)
	{
		System.out.print("This account's group are Fresher,C# Fresher");
		
	}
	else if(account2.groups.length==3)
	{
		System.out.print("This account is an important person , joined many group");
	}
	else if(account2.groups.length>4) {
		System.out.print("This account is a fking man,joined all group");
		
	}}
public static void Question3() {
	System.out.prinln(account2.department==null ? "This account has no departmen t" : "This account in department named ");
}
public static void Question4() {
System.out.print(account1.position.positionName=="Dev" ? "This is Developer" : "This is not Developer");
}
public static void Question5() {
int x = group1.account.length;
switch (x) {
case 1:
	System.out.print("This group has only one account");
	break;
case 2:
	System.out.print("This group has two accounts");
	break;
case 3:
	System.out.print("This group has three accounts");
default:
	System.out.print("This group has many accounts");
	break;
}
}

public static void Question6() {
int x=account2.groups.length;
switch (x) {
case 0:
	System.out.print("This account has no group");
	break;
case 1:
	System.out.print("This account's group are Fresher,C# Fresher");
	break;
case 2:
	System.out.print("This account's group are Fresher,C# Fresher");
	break;
case 3:
	System.out.print("This account is an important person , joined many group");
	break;
default:
	System.out.print("This account is a fking man,joined all group");
	break;
}
}

public static void Question7() {
switch (account1.position.positionName) {
case "Dev":
	System.out.print("This is Developer");
	break;

default:
	System.out.print("This is not Developer");
	break;
}
}

public static void Question8() {
Account[] accounts = {account1,account2,account3,account4,account5};
for (Account account : accounts) {
	System.out.println("Email: " + account.email);
	System.out.println("FullName: " + account.fullName);
	System.out.println("Name Department: " + account.department.departmentName);
}
public static void Question9() {
Department[] departments = {department1,department2,department3};
for(Department department : departments) {
	System.out.println("Department ID :"+ department.departmentId);
	System.out.println("Department Name :"+ department.departmentName);
}
}

public static void Question10() {
Account[] accounts = {account1,account2,account3,account4,account5};
for(int i = 0; i < accounts.length;i++) {
	System.out.println("Thong tin account thu " + (i+1) + " la :");
	System.out.println("Email :"+ accounts[i].email);
	System.out.println("Full name :" + accounts[i].fullName);
	System.out.println("Department :"+accounts[i].department.departmentName);
}
}

public static void Question11() {
Department[] departments = {department1,department2,department3};
for(int i = 0 ; i < departments.length;i++)
{
	System.out.println("Thong tin cua department thu " + (i+1) + "la :");
	System.out.println("Id :"+ departments[i].departmentId);
	System.out.println("Name : "+ departments[i].departmentName);
}
}
public static void Question12() {
Department[] departments = {department1,department2,department3};
for(int i = 0 ; i < 2;i++)
{
	System.out.println("Thong tin cua department thu " + (i+1) + "la :");
	System.out.println("Id :"+ departments[i].departmentId);
	System.out.println("Name : "+ departments[i].departmentName);
}
}

public static void Question13() {
Account[] accounts = {account1,account2,account3,account4,account5};
for(int i = 0; i < accounts.length ;i++) {
	if(i != 1)
	{System.out.println("Thong tin account thu " + (i+1) + " la :");
	System.out.println("Email :"+ accounts[i].email);
	System.out.println("Full name :" + accounts[i].fullName);
	System.out.println("Department :"+accounts[i].department.departmentName);}
}
}
public static void  Question14() {
Account[] accounts = {account1,account2,account3,account4,account5};
for(int i = 0; i < accounts.length ;i++) {
	if(accounts[i].AccountId<4)
	{
	System.out.println("Email :"+ accounts[i].email);
	System.out.println("Full name :" + accounts[i].fullName);
	System.out.println("Department :"+accounts[i].department.departmentName);
	}
}
}
public static void Question15() { 
for(int i = 0; i < 20 ; i ++ )
{
	if(i%2==0)
	{
		System.out.println(i);
	}
}
}

public static void Question16() {
	// Dai qua
}
public static void Question17() {
	//Dai qua
}


}
