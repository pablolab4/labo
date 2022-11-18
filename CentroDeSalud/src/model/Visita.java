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
public class Visita {
    private int idVisita;
    private Paciente paciente;
    private Empleado empleado;
    private String nombre;
    private int duracion;

    public Visita() {
    }

    public Visita(int idVisita, Paciente paciente, Empleado empleado, String nombre, int duracion) {
        this.idVisita = idVisita;
        this.paciente = paciente;
        this.empleado = empleado;
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    
}
