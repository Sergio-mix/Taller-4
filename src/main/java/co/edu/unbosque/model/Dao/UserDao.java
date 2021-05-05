package co.edu.unbosque.model.Dao;

import co.edu.unbosque.model.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> ListUser;

    /**
     * builder
     */
    public UserDao() {
        ListUser = new ArrayList<>();
    }

    /**
     * Method of creating a user object and saving it to a list
     * @param user_Name
     * @param date
     * @param description
     * @param image
     */
    public void add(String user_Name, String date, String description, String image) {
        User user = new User(user_Name, date, description, image);
        ListUser.add(user);
    }

    public List<User> getListUser() {
        return ListUser;
    }

    public void setListUser(List<User> listUser) {
        ListUser = listUser;
    }
}
