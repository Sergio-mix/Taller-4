package co.edu.unbosque.model.singleton;

import co.edu.unbosque.model.Dao.UserDao;
import co.edu.unbosque.model.User;

import javax.ejb.Singleton;
import java.util.List;

/**
 * CLass SingletonBean
 */
@Singleton
public class SessionBean implements SessionBeanLocal {

    UserDao userDao = new UserDao();

    /**
     * Metodos para almacenar los datos en tipo EJB Singleton
     * @param user_Name
     * @param date
     * @param description
     * @param image
     */
    @Override
    public void agregar(String user_Name, String date, String description, String image) {
        userDao.add(user_Name, date, description, image);
    }

    @Override
    public List<User> mostrar() {
        return userDao.getListUser();
    }
}
