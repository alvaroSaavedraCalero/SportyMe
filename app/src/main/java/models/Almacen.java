package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Almacen implements Serializable {

    private static ArrayList<User> almacenUsuarios = new ArrayList<>();
    private static ArrayList<Producto> almacenProductos = new ArrayList<>();


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

        // Añadimos los productos
        String[] tallas1 = {"XS", "S", "M", "L", "XL", "XXL"};
        String[] tallasZapatillas = {"35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46"};

        Producto camiseta1 = new Producto("camiseta1", "Camiseta Boxeo Everlast Lodel Hombre Negro",
                "Camiseta diseñada para recoger el sudor. Consigue el mojor rendimiento con esta camiseta",
                25.99, tallas1, "camiseta");
        almacenProductos.add(camiseta1);

        Producto camiseta2 = new Producto("camiseta2", "Camiseta roja Hombre ",
                "Camiseta para la vestimenta de sport. Comoda para cualquier ocasion",
                20.99, tallas1, "camiseta");
        almacenProductos.add(camiseta2);

        Producto camiseta3 = new Producto("camiseta3","Camiseta Negra y Verde Runner",
                "Camiseta para salir a correr. Diseñada para runners profesionales",
                24.99,tallas1, "camiseta");
        almacenProductos.add(camiseta3);

        Producto pantalon1 = new Producto("pantalon1","Pantalon sport Verde Adidad",
                "Este pantalon lo puedes usar tanto para hacer deporte como para divertirte con tus amigos",
                30.45, tallas1, "pantalon");
        almacenProductos.add(pantalon1);

        Producto pantalon2 = new Producto("pantalon2","Pantalon Azul Oscuro Runner",
                "Pantalon diseñado para runners. Comodidad infinita",
                40.30, tallas1, "pantalon");
        almacenProductos.add(pantalon2);

        Producto pantalon3 = new Producto("pantalon3","Pantalon Corto Marron Clarito",
                "Pantalon perfecto para el verano. Consigue el tuyo",
                15.60, tallas1, "pantalon");
        almacenProductos.add(pantalon3);

        Producto sudadera1 = new Producto("sudadera1","Sudadera Negra Everlast",
                "Sudadera para hombre perfecta para las epocas proximas", 30.25,
                tallas1, "sudadera");
        almacenProductos.add(sudadera1);

        Producto sudadera2 = new Producto("sudadera2","Sudadera Blanca con Imagenes",
                "Sudadera para la epoca navideña, puedes regalarsela a tus hijos.",
                50.00, tallas1, "sudadera");
        almacenProductos.add(sudadera2);

        Producto sudadera3 = new Producto("sudadera3","Sudadera Negra Sport",
                "Sudadera para las personas deportistas. Forro interior",
                43.23, tallas1, "sudadera");
        almacenProductos.add(sudadera3);

        Producto zapatillas1 = new Producto("zapatillas1","Zapatillas Blancas sport",
                "Zapatillas de cuya marca no se ve perfectas para ver si no las manchas",
                70.50, tallasZapatillas, "zapatillas");
        almacenProductos.add(zapatillas1);

        Producto zapatillas2 = new Producto("zapatillas2","Zapatillas basketBall",
                "Zapatillas / Botas de baloncesto con camara de aire",
                90.68, tallasZapatillas, "zapatillas");
        almacenProductos.add(zapatillas2);

        Producto zapatillas3 = new Producto("zapatillas3","Zapatillas negras ",
                "Zapatillas creo que de marca nike negras muy de calle",
                130.20, tallasZapatillas, "zapatillas");
        almacenProductos.add(zapatillas3);
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
