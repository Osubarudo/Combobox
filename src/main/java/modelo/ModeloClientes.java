/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author osval
 */
public class ModeloClientes {
    
    public ArrayList<Cliente> getClientes(){
        Conexion conx = Conexion.getInstance();
        Connection con = (Connection) conx.conectar();
        Statement stmt;
        ResultSet rs;
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM clientes");
            
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id"));
                cli.setClave(rs.getString("clave"));
                cli.setNombre(rs.getString("nombre"));
                cli.setTelefono(rs.getString("telefono"));
                listaClientes.add(cli);
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ModeloClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }
    
    
}
