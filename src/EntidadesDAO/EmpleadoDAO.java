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
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        String sSQL = "{call sp_mostrar_usuarios};";
        
        try {
            
            CallableStatement cs =this.CN.getConexion().prepareCall(sSQL);
            
            rs = cs.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido(rs.getString(3));
                emp.setUsuario(rs.getString(4));
                emp.setContraseña(rs.getString(5));
                empleados.add(emp);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR xd!!", JOptionPane.ERROR_MESSAGE);
        }
        
        return empleados;
    }
    public boolean InsertarEmpleado(Empleado emp)
    {
        String sql ="{call sp_insertar_empleado(?,?,?,?,?)}";
        try {
            CallableStatement cs= this.CN.getConexion().prepareCall(sql);
            cs.setString(1, emp.getNombre());
            cs.setString(2, emp.getApellido());
            cs.setString(3, emp.getUsuario());
            cs.setString(4, emp.getContraseña());
            cs.setString(5, emp.getRol());
            int filas=cs.executeUpdate();
            if (filas>0) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public boolean ActualizarEmpleado(Empleado emp)
    {
        String sql = "{CALL sp_actualizar_empleado(?,?,?,?,?,?)}";
        
        try  {
            CallableStatement cs = this.CN.getConexion().prepareCall(sql);
            cs.setInt(1, emp.getIdEmpleado());
            cs.setString(2, emp.getNombre());
            cs.setString(3, emp.getApellido());
            cs.setString(4, emp.getUsuario());
            cs.setString(5, emp.getContraseña());
            cs.setString(6, emp.getRol());
            int filas=cs.executeUpdate();
            if (filas>0) {
                return true;
            }
            System.out.println("Equipo actualizado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar el equipo: " + e.getMessage());
        }
        return false;
    }
    public boolean EliminarJugador(int idEmpleado) {
        String sql = "CALL eliminar_jugador(?)";
        
        try {
            CallableStatement cs = CN.getConexion().prepareCall(sql) ;
            cs.setInt(1, idEmpleado);
            int filas=cs.executeUpdate();
            if (filas>0) {
                return true;
            }
            System.out.println("Equipo eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar el equipo: " + e.getMessage());
        }
        return false;
    }
}
