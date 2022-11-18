/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import model.DTO.VisitaDTO;
import model.Empleado;
import model.Paciente;
import model.Visita;

/**
 *
 * @author Pablo
 */
public class GestorDB {
    
    private Connection con;
    private String CONN = "jdbc:sqlserver://DESKTOP-EVURPOV\\SQLEXPRESS:1433;databaseName=Visitas;trustServerCertificate=true";
    private String USER= "sa";
    private String PASS= "123cambiar";
    
    public  void conectarDB(){
        
    try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(CONN, USER, PASS);
        } 
    catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    private void cerrarDB() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    public ArrayList<Paciente> getAllPacientes(){
        ArrayList<Paciente> lstPacientes = new ArrayList<>();
        
        try {
            conectarDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Pacientes");
            
            while(rs.next()){
                int idPaciente = rs.getInt("idPaciente");
                String nombre = rs.getString("nombre");
              
                Paciente paciente = new Paciente(idPaciente, nombre);
                lstPacientes.add(paciente);
            }
            rs.close();
            st.close();
            
        } 
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally{
            cerrarDB();
        }
        return lstPacientes;
    }
   
    public ArrayList<Empleado> getAllEmpleados(){
        ArrayList<Empleado> lstEmpleados = new ArrayList<>();
        
        try {
            conectarDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Empleados");
            
            while(rs.next()){
                int legajo = rs.getInt("legajo");
                String nombre = rs.getString("nombre");
              
                Empleado empleado = new Empleado(legajo, nombre);
                lstEmpleados.add(empleado);
            }
            rs.close();
            st.close();
            
        } 
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally{
            cerrarDB();
        }
        return lstEmpleados;
    }
    
    public ArrayList<VisitaDTO> getAllVisitas(){
        ArrayList<VisitaDTO> lstVisitas = new ArrayList<>();
        
        try {
            conectarDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT p.Nombre 'Paciente',v.Nombre 'Visitante',v.Duracion 'Duracion visita',e.Nombre 'Recepcionista'\n" +
                    "FROM Visitas.dbo.Visitas v\n" +
                    "LEFT JOIN Pacientes p ON v.IdPaciente = p.IdPaciente\n" +
                    "LEFT JOIN Empleados e ON v.LegajoRecepcionista = e.Legajo\n" +
                    "ORDER BY p.Nombre");
            
            while(rs.next()){
                String nombrePaciente = rs.getString("Paciente");
                String nombreVisitante = rs.getString("Visitante");
                String nombreRecepcionista = rs.getString("Recepcionista");
                int duracionVisita = rs.getInt("Duracion visita");
                
                VisitaDTO visitaDTO = new VisitaDTO(nombrePaciente, nombreRecepcionista,nombreVisitante, duracionVisita);
                lstVisitas.add(visitaDTO);
            }
            rs.close();
            st.close();
            
        } 
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally{
            cerrarDB();
        }
        return lstVisitas;
    }
    
    public ArrayList<VisitaDTO> getCantidadVisitasPaciente(){
        ArrayList<VisitaDTO> lstVisitas = new ArrayList<>();
        
        try {
            conectarDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT p.Nombre 'Paciente', COUNT(v.IdVisita) 'Cantidad Visitas'\n" +
                "FROM Visitas.dbo.Visitas v\n" +
                "LEFT JOIN Pacientes p ON v.IdPaciente = p.IdPaciente\n" +
                "GROUP BY p.nombre\n" +
                "ORDER BY p.Nombre");
            
            while(rs.next()){
                String nombrePaciente = rs.getString("Paciente");
                int cantidadVisitas = rs.getInt("Cantidad Visitas");
                
                VisitaDTO visitaDTO = new VisitaDTO();
                visitaDTO.setNombrePaciente(nombrePaciente);
                visitaDTO.setCantidadVisitas(cantidadVisitas);
                lstVisitas.add(visitaDTO);
            }
            rs.close();
            st.close();
            
        } 
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally{
            cerrarDB();
        }
        return lstVisitas;
    }
    
    public void addVisita(Visita visita){
    
        try {
            conectarDB();
            String query = "INSERT INTO Visitas VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, visita.getPaciente().getId());
            ps.setInt(2, visita.getEmpleado().getLegajo());
            ps.setString(3, visita.getNombre());
            ps.setInt(4, visita.getDuracion());
            ps.execute();
            ps.close();
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally{
            cerrarDB();
        }
    }
    
    //Promedio duracion de visitas mayores a 10 minutos
    public float promedioDuracionVisitas(){
        float promedio = 0;
        try {
            conectarDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT AVG(Duracion) 'promedio'\n" +
                "FROM Visitas.dbo.Visitas\n" +
                "WHERE Duracion > 10");
            while(rs.next()){    
                promedio = rs.getFloat("promedio"); 
            }
            rs.close();
            st.close(); 
        } 
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally{
            cerrarDB();
        }
        return promedio;
    }
    
}
