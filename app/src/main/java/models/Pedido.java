package models;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {

    private ArrayList<ItemPedido> itemsPedido = new ArrayList<>();
    private String usuario;
    private double subtotal;
    private double gastosDeEnvio = 0;
    private double total;

    public Pedido(String username) {
        this.usuario = username;

    }

    public ArrayList<ItemPedido> getItemsPedido() {
        return itemsPedido;
    }

    public void setItemsPedido(ArrayList<ItemPedido> itemsPedido) {
        this.itemsPedido = itemsPedido;
    }

    public double getSubtotal() {
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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setGastosDeEnvio(double gastosDeEnvio) {
        this.gastosDeEnvio = gastosDeEnvio;
    }

    public double getTotal() {
        return this.subtotal + this.gastosDeEnvio;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public double calcularSubTotal() {

        double _subtotal = 0;

        for (ItemPedido item : itemsPedido) {

            _subtotal += (item.getProductoPedido().getPrecio() * item.getCantidadPedido());
        }

        return _subtotal;

    }



}
