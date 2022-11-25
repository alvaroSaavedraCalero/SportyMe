package models;

import java.io.Serializable;

public class Direccion implements Serializable {

    private String calle;
    private String CP;
    private String provincia;
    private String localidad;

    public Direccion(String calle, String CP, String provincia, String localidad) {
        this.calle = calle;
        this.CP = CP;
        this.provincia = provincia;
        this.localidad = localidad;
    }

    public Direccion() {
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCP() {
        return CP;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
