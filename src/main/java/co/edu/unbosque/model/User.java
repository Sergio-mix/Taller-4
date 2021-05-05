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
    private String image;

    /**
     * builder
     * @param user
     * @param date
     * @param description
     * @param image
     */
    public User(String user, String date, String description, String image) {
        this.user = user;
        this.date = date;
        this.description = description;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
