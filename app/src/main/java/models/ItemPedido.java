package models;

public class ItemPedido {

    private Producto productoPedido;
    private int cantidadPedido;

    public ItemPedido(Producto productoPedido, int cantidadPedido) {
        this.productoPedido = productoPedido;
        this.cantidadPedido = cantidadPedido;
    }

    public ItemPedido() {
    }

    public Producto getProductoPedido() {
        return productoPedido;
    }

    public void setProductoPedido(Producto productoPedido) {
        this.productoPedido = productoPedido;
    }

    public int getCantidadPedido() {
        return cantidadPedido;
    }

    public void setCantidadPedido(int cantidadPedido) {
        this.cantidadPedido = cantidadPedido;
    }
}
