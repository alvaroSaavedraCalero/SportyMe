package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Almacen implements Serializable {

    private static ArrayList<User> almacenUsuarios = new ArrayList<>();

    public Almacen() {


        Direccion direccionPepe = new Direccion("calle geranios nº1", "28845", "Torredolones", "Madrid");
        User usuarioPepe = new User("pepe01", "1234pepe", "Pepe", "Contretas Cava", "pepe01@mail.com", direccionPepe);

        Direccion direccionAna = new Direccion("calle Alamos nº2", "25487", "Camarma", "Madrid");
        User usuarioAna = new User("ana02", "1234ana", "Ana", "Caballete Perez", "ana02@mail.com", direccionAna);

        Direccion direccionJose = new Direccion("calle marina nº3", "26895", "Rivas", "Madrid");
        User usuarioJose = new User("jose03", "1234jose", "Jose", "Martinez Lopez", "jose03@mail.com", direccionJose);

        almacenUsuarios.add(usuarioPepe);
        almacenUsuarios.add(usuarioAna);
        almacenUsuarios.add(usuarioJose);

    }


    public static ArrayList<User> getAlmacenUsuarios() {
        return almacenUsuarios;
    }

    public static void setAlmacenUsuarios(ArrayList<User> almacenUsuarios) {
        Almacen.almacenUsuarios = almacenUsuarios;
    }

    public static User comprobarCredencialesLogin(String user, String pass) {
        boolean continuar = true;
        User retorno = null;
        int i = 0;

        while (i < almacenUsuarios.size() && continuar) {
           if (almacenUsuarios.get(i).getUsername().equals(user) &&
           almacenUsuarios.get(i).getPassword().equals(pass)) {
               retorno = almacenUsuarios.get(i);
               continuar = false;
           } else {
               i++;
           }
        }
        return retorno;
    }
}
