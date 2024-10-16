/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author andre
 */
public class DetalleVenta {
    private int idDetalleVenta;
    private int idVenta;
    private int idCompra;
    private int cantidad;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVenta, int idVenta, int idCompra, int cantidad) {
        this.idDetalleVenta = idDetalleVenta;
        this.idVenta = idVenta;
        this.idCompra = idCompra;
        this.cantidad = cantidad;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
