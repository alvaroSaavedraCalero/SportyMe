package models;

import java.util.ArrayList;

public class Pedido {

    private ArrayList<ItemPedido> itemsPedido;
    private double subtotal;
    private double gastosDeEnvio;
    private double total;

    public Pedido(){
        this.itemsPedido=new ArrayList<ItemPedido>();
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

    public void setGastosDeEnvio(double gastosDeEnvio) {
        this.gastosDeEnvio = gastosDeEnvio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double calcularSubTotal(){

        double _subtotal=0;

        for(ItemPedido item: itemsPedido){

           _subtotal+=(item.getProductoPedido().getPrecio()*item.getCantidadPedido());
        }

        return _subtotal;

    }

}
