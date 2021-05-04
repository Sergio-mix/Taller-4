package co.edu.unbosque.model.Dao;

import co.edu.unbosque.model.User;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private List<User> ListUser;

    public UserDao() {
        ListUser = new ArrayList<>();
    }

    public void add(String usuario, String fecha, String descripcion, ImageIcon imagen) {
        User user = new User(usuario, fecha, descripcion, imagen);
        ListUser.add(user);
    }

    public List<User> getListUser() {
        return ListUser;
    }

    public void setListUser(List<User> listUser) {
        ListUser = listUser;
    }
}
