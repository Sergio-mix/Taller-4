package co.edu.unbosque.model;

import javax.swing.*;
import java.io.File;

/**
 * Class User
 */
public class User {
    private String user;
    private String date;
    private String description;
    private String route;

    /**
     * constructor
     * @param user
     * @param date
     * @param description
     * @param route
     */
    public User(String user, String date, String description, String route) {
        this.user = user;
        this.date = date;
        this.description = description;
        this.route = route;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}
