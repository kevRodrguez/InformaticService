/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EntidadesDAO;

import Entidades.Empleado;
import db.cn;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bryan
 */
public class EmpleadoDAO {
    private PreparedStatement ps;
    private Connection con;
    private cn CN;
    private ResultSet rs;

    public EmpleadoDAO() {
        this.CN= new cn();
    }
    public ArrayList<Jugador> ConsultarJugadores(cnBKB conexion){
        ArrayList<Jugador> listadoJugadores = new ArrayList<Jugador>();
        Jugador jugadorTemporal;
        // Consulta SQL con parámetros
        String sSQL = "Call  consultar_jugadores()";
            
        try {

            // Usar PreparedStatement para consultas parametrizadas
            CallableStatement cs = conexion.getConexion().prepareCall(sSQL);

            // Ejecutar la consulta
            ResultSet rs = cs.executeQuery();

            // Procesar los resultados
            while (rs.next()) {
                jugadorTemporal = new Jugador(
                        rs.getInt("id_jugador"),
                        rs.getString("nombre"),
                        rs.getString("nombre_equipo"),
                        rs.getInt("dorsal"),
                        rs.getDouble("estatura"),
                        rs.getString("posicion")
                );

                listadoJugadores.add(jugadorTemporal);
            }

            // Cerrar el ResultSet y el CallableStatement
            rs.close();
            cs.close();

            return listadoJugadores;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR consulta!!", JOptionPane.ERROR_MESSAGE);
        }

        return listadoJugadores;
    }
    
    public ArrayList<Empleado> ConsultarUsuarios(){
        ArrayList<Empleado> usuarios = new ArrayList<Empleado>();
        String sSQL = "{call sp_mostrar_usuarios};";
            
        try {

            CallableStatement cs =this.CN.getConexion().prepareCall(sSQL);

             rs = cs.executeQuery();

            // Procesar los resultados
            while (rs.next()) {
                Empleado usuario = new Empleado();
                usuario.setIdEmpleado(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.set
                );

                listadoJugadores.add(jugadorTemporal);
            }

            // Cerrar el ResultSet y el PreparedStatement
            rs.close();
            cs.close();

            return listadoJugadores;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR xd!!", JOptionPane.ERROR_MESSAGE);
        }

        return listadoJugadores;
    }
    
}
