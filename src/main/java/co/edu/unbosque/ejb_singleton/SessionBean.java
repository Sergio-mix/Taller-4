package co.edu.unbosque.ejb_singleton;

import javax.ejb.Singleton;
import java.util.ArrayList;

@Singleton
public class SessionBean implements SessionBeanLocal {
    ArrayList listphotos = new ArrayList();

    @Override
    public void agregar(String elemento) {
        listphotos.add(elemento);
    }


    @Override
    public String mostrar() {

        return listphotos.toString();
    }
}
