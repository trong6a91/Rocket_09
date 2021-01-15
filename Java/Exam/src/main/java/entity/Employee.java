package entity;

public class Employee extends User{
	
	
	
	public Employee(int id, String fullName, String email, String passWord, int projectId, String proSkill) {
		super(id, fullName, email, passWord,Pos.EMPLOYEE);
		this.projectId = projectId;
		this.proSkill = proSkill;
	}
	private int projectId;
	private String proSkill;

}
