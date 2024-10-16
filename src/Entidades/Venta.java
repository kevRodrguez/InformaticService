/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.util.Date;
/**
 *
 * @author andre
 */
public class Venta {
    private int idventa;
    private int idUsuario;
    private String comprador;
    private Date fechaVenta;
    private double subTotal;
    private double totalPago;

    public Venta() {
    }

    public Venta(int idventa, int idUsuario, String comprador, Date fechaVenta, double subTotal, double totalPago) {
        this.idventa = idventa;
        this.idUsuario = idUsuario;
        this.comprador = comprador;
        this.fechaVenta = fechaVenta;
        this.subTotal = subTotal;
        this.totalPago = totalPago;
    }

    public int getIdventa() {
        return idventa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getComprador() {
        return comprador;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }
}
