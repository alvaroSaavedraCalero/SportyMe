package models;

import java.util.Objects;

public class User {

    // propiedades de clase
    private String username;
    private String password;
    private Pedido pedidoActual;

    // constructores
    public User(String username, String password, Pedido pedidoActual) {
        this.username = username;
        this.password = password;
        this.pedidoActual=pedidoActual;
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

    public Pedido getPedidoActual(){return pedidoActual;}

    public void setPedidoActual(Pedido pedidoActual){this.pedidoActual=pedidoActual;}

    // equals, hashcode y toString

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
