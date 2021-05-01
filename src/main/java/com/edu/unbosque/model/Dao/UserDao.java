package com.edu.unbosque.model.Dao;

import com.edu.unbosque.model.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserDao {
    private List<User> ListUser;

    public UserDao() {
        ListUser = new ArrayList<>();
    }

    public void add(String usuario, String fecha, String descripcion, String ruta) {
        User user = new User(usuario, fecha, descripcion, ruta);
        ListUser.add(user);
    }

    public String date() {
        String fecha;
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fecha = dateFormat.format(date);
        return fecha;
    }

    public String SecuenciaALFA() {
        Long.toHexString(Double.doubleToLongBits(Math.random()));
        UUID.randomUUID().toString();
        return RandomStringUtils.randomAlphanumeric(12);
    }

    public List<User> getListUser() {
        return ListUser;
    }

    public void setListUser(List<User> listUser) {
        ListUser = listUser;
    }
}
