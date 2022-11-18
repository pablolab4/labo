/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pablo
 */
public class Paciente {

    public Paciente(int idPaciente, String nombre) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
    }
    
    private int idPaciente;
    private String nombre;

    public int getId() {
        return idPaciente;
    }

    public void setId(int id) {
        this.idPaciente = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
