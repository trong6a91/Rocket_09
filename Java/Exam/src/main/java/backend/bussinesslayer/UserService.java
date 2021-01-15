package backend.bussinesslayer;

import backend.datalayer.IUserRepository;
import backend.datalayer.UserRepository;
import entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService implements  IUserService {
    private  IUserRepository userRepository;

    public UserService() throws IOException, SQLException, ClassNotFoundException {
        userRepository = new UserRepository();
    }


    public List<User> getListUsersByProjectId(int id) throws SQLException, ClassNotFoundException {
        return userRepository.getListUsersByProjectId(id);
    }

    public List<User> getListManager() throws SQLException, ClassNotFoundException {
        return userRepository.getListManager();
    }
    public User login(String email, String password) throws Exception {
        return userRepository.login(email,password);
    }
}
