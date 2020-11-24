
package Cliente;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alex12
 */
public class Cliente {
    private final String nombres;
    private final String apellidos;
    private final int dni;
    private final int celular;
    private final String correo;
    private final String direccion;
    
    Conexion conn ;
    
    public Cliente(String nombres, String apellidos, int dni, int celular, String correo, String direccion){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
        
        conn = new Conexion();
    }
    
    public void Guardar(){
        String sql = "INSERT INTO cliente(idCliente, nombres, apellidos, dni, celular, correo, direccion) VALUES (0,'"+nombres+"','"+apellidos+"','"+dni+"','"+celular+"','"+correo+"','"+direccion+"')";
        
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            pstm.executeUpdate();
            conn.Desconectar();
        } catch (SQLException e) {
            System.out.println("Error save: " + e);
        }
    }
    
    public void Actualizar(int id){
        String sql = "UPDATE cliente SET nombres='"+nombres+"', apellidos='"+apellidos+"', dni='"+dni+"', celular='"+celular+"', correo='"+correo+"', direccion='"+direccion+"' WHERE idCliente='"+id+"'";
        
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            pstm.executeUpdate();
            conn.Desconectar();
        } catch (SQLException e) {
            System.out.println("Error save: " + e);
        }
    }
    
    public void Eliminar(int id){
        String sql = "DELETE FROM cliente WHERE idCliente='"+id+"'";
        
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            pstm.executeUpdate();
            conn.Desconectar();
        } catch (SQLException e) {
            System.out.println("Error save: " + e);
        }
    }
    
    public Object[][] getData(){
        
        Object[][] obj = new Object[100][100];
        
        String sql = "Select * from cliente";

        
        try {
            PreparedStatement pstm = conn.getConnection().prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            int c = 0;
            while(res.next()){
                obj[c][0] = res.getInt("idCliente");
                obj[c][1] = res.getString("nombres");
                obj[c][2] = res.getString("apellidos");
                obj[c][3] = res.getInt("dni");
                obj[c][4] = res.getInt("celular");
                obj[c][5] = res.getString("correo");
                obj[c][6] = res.getString("direccion");
                c++;
            }                
            conn.Desconectar();
        } catch (SQLException e) {
            System.out.println("Error save: " + e);
        }
        
     return obj;
    }
}
