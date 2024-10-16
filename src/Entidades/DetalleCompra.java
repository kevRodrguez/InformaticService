/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author andre
 */
public class DetalleCompra {
    private int idCompra;
    private int idProducto;
    private int cantidad;
    private double precioCompra;
    private double preciounitario;
    private double precioMayore;

    public DetalleCompra() {
    }

    public DetalleCompra(int idCompra, int idProducto, int cantidad, double precioCompra, double preciounitario, double precioMayore) {
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.preciounitario = preciounitario;
        this.precioMayore = precioMayore;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public double getPrecioMayore() {
        return precioMayore;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPreciounitario(double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public void setPrecioMayore(double precioMayore) {
        this.precioMayore = precioMayore;
    }
    
    
}
