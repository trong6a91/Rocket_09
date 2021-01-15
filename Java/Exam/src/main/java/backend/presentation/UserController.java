package backend.presentation;

import backend.bussinesslayer.IUserService;
import backend.bussinesslayer.UserService;
import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    private IUserService userService;

    public UserController() throws IOException, SQLException, ClassNotFoundException {
        userService = new UserService();
    }
    public List<User> getListUsersByProjectId(int id) throws SQLException, ClassNotFoundException {
        return userService.getListUsersByProjectId(id);
    }

    public List<User> getListManager() throws SQLException, ClassNotFoundException {
        return userService.getListManager();
        
    }
    public User login(String email, String password) throws Exception {
		return userService.login(email, password);}
}
