package models;



import java.io.Serializable;


public class Producto implements Serializable {

    private String idFoto;
    private String nombreProducto;
    private String descripcion;
    private double precio;
    private String categoria;
    private String tallaEscogida;
    private int cantidad;

    public Producto(String idFoto, String nombreProducto, String descripcion, double precio,String categoria) {
        this.idFoto=idFoto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria=categoria;
    }

    //-------HE CREADO ESTE CONSTRUCTOR NUEVO PA PASAR SOLO EL ID DE LA FOTO-----//

    public Producto(String idFoto){
        this.idFoto=idFoto;
    }

    //------------------------------------------------------------------------//

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTallaEscogida() {
        return tallaEscogida;
    }

    public void setTallaEscogida(String tallaEscogida) {
        this.tallaEscogida = tallaEscogida;
    }

    public String getIdFoto() {return idFoto;}

    public void setIdFoto(String idFoto) {this.idFoto = idFoto;}

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


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


}
