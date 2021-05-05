package co.edu.unbosque.model.singleton;
import co.edu.unbosque.model.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Interface SessionBeanLocal
 */
@Local
public interface SessionBeanLocal {
    /**
     * Metodos que se declararon en la clase SessionBean
     * @param user_Name
     * @param date
     * @param description
     * @param image
     */

    void agregar(String user_Name, String date, String description, String image);

    List<User> mostrar();
}
