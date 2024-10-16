/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author andre
 */
public class Compra {
    private int idCompra;
    private int idUsuario;
    private String estado;

    public Compra() {
    }

    public Compra(int idCompra, int idUsuario, String estado) {
        this.idCompra = idCompra;
        this.idUsuario = idUsuario;
        this.estado = estado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
