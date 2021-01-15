package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Utils.ScannerUtils;
import backend.presentation.UserController;
import entity.User;

public class Function {
	UserController userController;
	public Function() throws ClassNotFoundException, IOException, SQLException {
		userController = new UserController();
	}
    public void getInforById() throws IOException, SQLException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ProjectID: ");
        int id = scanner.nextInt();
        userController = new UserController();
        List<User> users = userController.getListUsersByProjectId(id);
        System.out.printf("%-15s %-25s %-25s %-25s %-25s \n", "ID", "Fullname", "Email", "Password","Pos");
        for (User user : users) {
            System.out.printf("%-15s %-25s %-25s %-25s %-25s \n", user.getId(), user.getFullName(),user.getEmail(),user.getPassWord(),user.getPos());
        }
    }
    public void getManager() throws SQLException, ClassNotFoundException {
        List<User> users = userController.getListManager();
        System.out.println("Information of current Project managers: ");
        System.out.printf("%-15s %-25s %-25s %-25s %-25s \n", "ID", "Fullname", "Email", "Password","Pos");
        for (User user : users) {
            System.out.printf("%-15s %-25s %-25s %-25s %-25s \n", user.getId(), user.getFullName(),user.getEmail(),user.getPassWord(),user.getPos());
        }
    }


	

	public User login() throws ClassNotFoundException, SQLException {
		while (true) {
			System.out.print("Enter email: ");
			String email = ScannerUtils.inputEmail("Wrong email format!");

			System.out.print("Enter password: ");
			String password = ScannerUtils.inputPassword("Password need to be between 6 and 12 character and have at least 1 uppercase character");
			try {
				return userController.login(email, password);

			} catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
			}
		}
	}
}
