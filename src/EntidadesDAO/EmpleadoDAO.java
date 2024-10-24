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
    
    
    public ArrayList<Empleado> ConsultarEmpleados(){
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        String sSQL = "{call sp_mostrar_empleados()};";
        
        try {
            
            CallableStatement cs =this.CN.getConexion().prepareCall(sSQL);
            
            rs = cs.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setIdEmpleado(rs.getInt(1));
                emp.setNombre(rs.getString(2));
                emp.setApellido(rs.getString(3));
                emp.setUsuario(rs.getString(4));
                emp.setRol(rs.getString(5));
                empleados.add(emp);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR xd!!", JOptionPane.ERROR_MESSAGE);
        }
        
        return empleados;
    }
    public boolean validarPassword(String usuario, String password){
        
        String sSQL = "{call sp_validar_password(?,?)};";
        int filasEncontradas=0;
        try {
            
            CallableStatement cs =this.CN.getConexion().prepareCall(sSQL);
            cs.setString(1, usuario);
            cs.setString(2,password);
            rs = cs.executeQuery();
            while (rs.next()) {
                filasEncontradas=rs.getInt("cantidad_usuarios");
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "¡¡ERROR xd!!", JOptionPane.ERROR_MESSAGE);
        }
        
        if (filasEncontradas>0) {
            return true;
        }
        return false;
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
