package com.lineadirecta.certificacion.models;

public class RealizarCompraModel {

    private String categoria;
    private String opcion;
    private String prenda;
    private String talla = null;
    private String cantidad = null;

    public String getCategoria() {
        return categoria;
    }

    public String getOpcion() {
        return opcion;
    }

    public String getPrenda() {
        return prenda;
    }

    public String getTalla() {
        return talla;
    }

    public String getCantidad() {
        return cantidad;
    }
}
