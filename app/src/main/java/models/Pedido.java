package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {

    private ArrayList<ItemPedido> itemsPedido = new ArrayList<>();
    private String usuario;
    private double subtotal;
    private double gastosDeEnvio = 0;


    public Pedido(String username) {
        this.usuario = username;

    }
    public Pedido() {

    }

    public ArrayList<ItemPedido> getItemsPedido() {
        return itemsPedido;
    }

    public void setItemsPedido(ArrayList<ItemPedido> itemsPedido) {
        this.itemsPedido = itemsPedido;
    }

    public double getSubtotal() {
        this.subtotal = calcularSubTotal();
        return calcularSubTotal();
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getGastosDeEnvio() {
        return gastosDeEnvio;
    }

    public String getUsuario() {
        return usuario;
    }

    public double getTotal() {
        return subtotal + gastosDeEnvio;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setGastosDeEnvio(double gastosDeEnvio) {
        this.gastosDeEnvio = gastosDeEnvio;
    }








    public double calcularSubTotal() {

        double _subtotal = 0;

        for (ItemPedido item : itemsPedido) {

            _subtotal += (item.getProductoPedido().getPrecio() * item.getCantidadPedido());
        }

        return _subtotal;

    }



}
