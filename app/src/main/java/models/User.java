package models;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    // propiedades de clase
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private Pedido pedidoActual;
    private Direccion direccionEnvio;

    // constructores


    public User(String username, String password, String nombre, String apellidos, String correo, Direccion direccionEnvio) {
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.pedidoActual = new Pedido();
        this.direccionEnvio = new Direccion(direccionEnvio.getCalle(), direccionEnvio.getCP(), direccionEnvio.getProvincia(),
                direccionEnvio.getLocalidad());
    }

    public User(String username) {
        this.username = username;
    }

    public User() {}

    // getter y setter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Pedido getPedidoActual(){ return pedidoActual;}

    public void setPedidoActual(Pedido pedidoActual){this.pedidoActual=pedidoActual;}

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }

    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) { this.correo = correo; }

    public Direccion getDireccionEnvio() { return direccionEnvio; }

    public void setDireccionEnvio(Direccion direccionEnvio) { this.direccionEnvio =
            new Direccion(direccionEnvio.getCalle(), direccionEnvio.getCP(), direccionEnvio.getProvincia(),
                    direccionEnvio.getLocalidad()); }


}
