/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import models.Alumno;
import models.Curso;

/**
 *
 * @author Pablo
 */
public class GestorDB {
    
    private Connection con;
    private String CONN = "jdbc:sqlserver://DESKTOP-EVURPOV\\SQLEXPRESS:1433;databaseName=Academia;trustServerCertificate=true";
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
    
    public ArrayList<Alumno> getAllAlumnos(){
        ArrayList<Alumno> lstAlumnos = new ArrayList<>();
        
        try {
            conectarDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_alumno,nombre,CuotasPagas,nota FROM Alumnos");
            
            while(rs.next()){
                int idAlumno = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");
                int cuotasPagas = rs.getInt("CuotasPagas");
                int nota = rs.getInt("nota");
               
              
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(idAlumno);
                alumno.setCuotasPagas(cuotasPagas);
                alumno.setNombre(nombre);
                alumno.setNota(nota);
                lstAlumnos.add(alumno);
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
        return lstAlumnos;
    }
    
    public ArrayList<Curso> getAllCursos(){
        ArrayList<Curso> lstCursos = new ArrayList<>();
        
        try {
            conectarDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_curso,nombre,PrecioCuota,CantidadCuotas,activo FROM Cursos");
            
            while(rs.next()){
                int idCurso = rs.getInt("id_curso");
                String nombre = rs.getString("nombre");
                int precioCuotas = rs.getInt("PrecioCuota");
                int cantidadCuotas = rs.getInt("CantidadCuotas");
                int status = rs.getInt("activo");
               
              
                Curso curso = new Curso();
                curso.setIdCurso(idCurso);
                curso.setNombre(nombre);
                curso.setPrecioCuota(precioCuotas);
                curso.setCantidadCuotas(cantidadCuotas);
                curso.setActivo(status);
                lstCursos.add(curso);
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
        return lstCursos;
    }
    
    public void addAlumno(Alumno alumno){
    
        try {
            conectarDB();
            String query = "INSERT INTO Alumnos VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, alumno.getNombre());
            ps.setInt(2, alumno.getCuotasPagas());
            ps.setInt(3, alumno.getNota());
            ps.setInt(4, alumno.getCurso().getIdCurso());
            ps.execute();
            ps.close();
            
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally{
            cerrarDB();
        }
    }
    
    public int getTotalFacturado(){
        
        int total = 0;
        try {
            conectarDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT SUM(t.totales) as total FROM (SELECT  c.nombre, Count(*) * c.CantidadCuotas * c.PrecioCuota as totales "
                + "FROM Alumnos a LEFT JOIN Cursos c ON a.id_curso = c.id_curso	"
                + "WHERE a.id_curso IS NOT NULL GROUP BY c.nombre, c.CantidadCuotas, c.PrecioCuota) as t");
            
            while(rs.next()){    
                total = rs.getInt("total"); 
            }
            
            rs.close();
            st.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally{
            cerrarDB();
        }
        return total;
    }
    
    public int getCertificados(){
        int certificados = 0;
        try{
           conectarDB();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) as certificados FROM Alumnos a "
                    + "LEFT JOIN Cursos c ON a.id_curso = c.id_curso "
                    + "WHERE a.CuotasPagas = c.CantidadCuotas");
            
            while(rs.next()){    
                certificados = rs.getInt("certificados"); 
            }
            
            rs.close();
            st.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally{
            cerrarDB();
        }
        return certificados;
    }
    
    public int getDeudaByCursoId(int id){
        int deuda = 0;
        try{
           conectarDB();
            String query = "SELECT SUM(t.deuda) deuda "
                    + "FROM (SELECT c.nombre, a.CuotasPagas, c.PrecioCuota, SUM((c.CantidadCuotas - a.CuotasPagas) * c.PrecioCuota) as deuda "
                    + "FROM Alumnos a LEFT JOIN Cursos c ON a.id_curso = c.id_curso WHERE a.CuotasPagas < c.CantidadCuotas and c.id_curso = ? "
                    + "GROUP BY  c.nombre, a.CuotasPagas, c.PrecioCuota) as t";
            PreparedStatement ps = con.prepareStatement(query); 
            ps.setString(1, String.valueOf(id));
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){    
                deuda = rs.getInt("deuda"); 
            }

            rs.close();
            ps.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }finally{
            cerrarDB();
        }
        return deuda;
    
    }
    
    
   
   /* public ArrayList<Empleado> getAllEmpleados(){
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
    }*/    
}
