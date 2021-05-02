package co.edu.unbosque.ejb_singleton;
import javax.ejb.Local;

@Local
public interface SessionBeanLocal {
    void agregar(String elemento);

    String mostrar();
}
