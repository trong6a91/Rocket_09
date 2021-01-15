package entity;

public class Manager extends User{

	

	public Manager(int id, String fullName, String email, String passWord, int explnYear) {
		super(id, fullName, email, passWord,Pos.MANAGER);
		this.explnYear = explnYear;
	}

	private int explnYear;

}
