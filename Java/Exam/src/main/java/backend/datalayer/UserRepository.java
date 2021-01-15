package backend.datalayer;

import entity.Pos;
import entity.User;
import Utils.JDBC;

import java.awt.Choice;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private Connection connection;
    private JDBC jdbc;
    public UserRepository() throws IOException, SQLException, ClassNotFoundException {
        jdbc = new JDBC();
    }
    public List<User> getListUsersByProjectId(int id) throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<User>();
        try
        {
            connection = jdbc.connect();
            Statement statement = connection.createStatement();
            String sql ="SELECT UserID,FullName,Email,`Password`,Pos" + 
            		"            		FROM `User`LEFT JOIN Project " + 
            		"                           ON `User`.UserID = Project.IdEmployee" + 
            		"                    WHERE ProjectId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int UserId = resultSet.getInt("UserID");
                String fullName = resultSet.getString("FullName");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                Pos pos = Pos.valueOf(resultSet.getString("Pos")); 
                User user = new User(UserId, fullName, email, password,pos);
                
                users.add(user);
            }
            return users;
        }
        finally {
            connection.close();
        }

    }

    public List<User> getListManager() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<User>();
        try
        {
            connection = jdbc.connect();
            Statement statement = connection.createStatement();
            String sql = "SELECT DISTINCT UserID,FullName,Email,`Password`,Pos" + 
            		"                    FROM `User`" + 
            		"                    RIGHT JOIN" + 
            		"                    PROJECT" + 
            		"                    ON" + 
            		"                    `User`.UserID = Project.IdManager;";

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int UserId = resultSet.getInt("UserID");
                String fullName = resultSet.getString("FullName");
                String email = resultSet.getString("Email");
                String password = resultSet.getString("Password");
                Pos pos = Pos.valueOf(resultSet.getString("Pos"));
                User user = new User(UserId, fullName, email, password,pos);
                users.add(user);
            }
            return users;
        }
        finally {
            connection.close();
        }
    }

    public User login(String email, String password) throws Exception {
        try {
            connection = jdbc.connect();

            String sql = "SELECT * \r\n" + 
            		"FROM `User`\r\n" + 
            		"WHERE Email=? AND `password`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int UserId = resultSet.getInt("UserId");
                String fullName = resultSet.getString("FullName");
                email = resultSet.getString("Email");
                password = resultSet.getString("Password");
                Pos pos = Pos.valueOf(resultSet.getNString("Pos"));

                User user = new User(UserId, fullName, email, password,pos);
                return user;
            } else {
                throw new Exception("Getting wrong!");
            }

        } finally {
            connection.close();
        }
    }
}
