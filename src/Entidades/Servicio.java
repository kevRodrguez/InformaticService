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
public class Servicio {
    private int idServicio;
    private int idUsuario;
    private Date fechaInicio;
    private String estado;
    private String descripcion;
    private double totalPagar;

    public Servicio() {
    }

    public Servicio(int idServicio, int idUsuario, Date fechaInicio, String estado, String descripcion, double totalPagar) {
        this.idServicio = idServicio;
        this.idUsuario = idUsuario;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
        this.descripcion = descripcion;
        this.totalPagar = totalPagar;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }
    
    
}
