package backend.datalayer;

import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    List<User> getListUsersByProjectId(int id)throws SQLException, ClassNotFoundException;
    List<User> getListManager()throws SQLException, ClassNotFoundException;
    User login(String email, String password) throws Exception;
}
