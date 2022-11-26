package models;

import java.util.ArrayList;

public class Producto {

    private String nombreProducto;
    private String descripcion;
    private double precio;
    private String[] tallaPosible;
    private String categoria;

    public Producto(String nombreProducto, String descripcion, double precio, String[] tallaPosible,String categoria) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tallaPosible = tallaPosible;
        this.categoria=categoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String[] getTallaPosible() {
        return tallaPosible;
    }

    public void setTallaPosible(String[] tallaPosible) {
        this.tallaPosible = tallaPosible;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
