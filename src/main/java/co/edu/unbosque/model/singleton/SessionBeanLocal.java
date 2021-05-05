package co.edu.unbosque.model.singleton;
import co.edu.unbosque.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface SessionBeanLocal {
    void agregar(String user_Name, String date, String description, String image);

    List<User> mostrar();
}
