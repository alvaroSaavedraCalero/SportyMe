package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Almacen implements Serializable {

    private static ArrayList<User> almacenUsuarios = new ArrayList<>();
    private static ArrayList<Producto> almacenProductos = new ArrayList<>();

    public Almacen() {
        // Añadimos 3 usuarios
        Direccion direccionPepe = new Direccion("calle geranios nº1", "28845", "Torredolones", "Madrid");
        User usuarioPepe = new User("pepe01", "1234pepe", "Pepe", "Contretas Cava", "pepe01@mail.com", direccionPepe);

        Direccion direccionAna = new Direccion("calle Alamos nº2", "25487", "Camarma", "Madrid");
        User usuarioAna = new User("ana02", "1234ana", "Ana", "Caballete Perez", "ana02@mail.com", direccionAna);

        Direccion direccionJose = new Direccion("calle marina nº3", "26895", "Rivas", "Madrid");
        User usuarioJose = new User("jose03", "1234jose", "Jose", "Martinez Lopez", "jose03@mail.com", direccionJose);

        almacenUsuarios.add(usuarioPepe);
        almacenUsuarios.add(usuarioAna);
        almacenUsuarios.add(usuarioJose);

        // Añadimos los productos
        String[] tallas = {"XS", "S", "M", "L", "XL", "XXL"};

        Producto camiseta1 = new Producto("Camiseta Boxeo Everlast Lodel Hombre Negro",
                "Camiseta diseñada para recoger el sudor. Consigue el mojor rendimiento con esta camiseta",
                25.99, tallas, "camiseta");

        Producto camiseta2 = new Producto("Camiseta roja Hombre ",
                "Camiseta para la vestimenta de sport. Comoda para cualquier ocasion",
                20.99, tallas, "camiseta");

        Producto camiseta3 = new Producto("Camiseta Negra y Verde Runner",
                "Camiseta para salir a correr. Diseñada para runners profesionales",
                24.99,tallas, "camiseta");

        Producto pantalon1 = new Producto("Pantalon sport Verde Adidad",
                "Este pantalon lo puedes usar tanto para hacer deporte como para divertirte con tus amigos",
                30.45, tallas, "pantalon");

        Producto pantalon2 = new Producto("Pantalon Azul Oscuro Runner",
                "Pantalon diseñado para runners. Comodidad infinita",
                40.30, tallas, "pantalon");

        Producto pantalon3 = new Producto("Pantalon Corto Marron Clarito",
                "Pantalon perfecto para el verano. Consigue el tuyo",
                15.60, tallas, "pantalon");

        Producto sudadera1 = new Producto("Sudadera Negra Everlast",
                "Sudadera para hombre perfecta para las epocas proximas", 30.25,
                tallas, "sudadera");


    }


    public static ArrayList<User> getAlmacenUsuarios() {
        return almacenUsuarios;
    }

    public static void setAlmacenUsuarios(ArrayList<User> almacenUsuarios) {
        Almacen.almacenUsuarios = almacenUsuarios;
    }

    public static ArrayList<Producto> getAlmacenProductos() {
        return almacenProductos;
    }

    public static void setAlmacenProductos(ArrayList<Producto> almacenProductos) {
        Almacen.almacenProductos = almacenProductos;
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
