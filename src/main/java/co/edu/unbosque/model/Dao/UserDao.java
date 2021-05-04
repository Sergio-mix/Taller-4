package co.edu.unbosque.model.Dao;

import co.edu.unbosque.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> ListUser;

    public UserDao() {
        ListUser = new ArrayList<>();
    }

    public void add(String user_Name, String date, String description, String route) {
        User user = new User(user_Name, date, description, route);
        ListUser.add(user);
    }

    public List<User> getListUser() {
        return ListUser;
    }

    public void setListUser(List<User> listUser) {
        ListUser = listUser;
    }
}
