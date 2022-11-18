/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DTO;

/**
 *
 * @author Pablo
 */
public class VisitaDTO {
  
    private String nombrePaciente;
    private String nombreRecepcionista;
    private String nombreVisita;
    private int duracionVisita;
    private int cantidadVisitas;
    
    public VisitaDTO(){}

    public VisitaDTO(String nombrePaciente, String nombreRecepcionista, String nombreVisita, int duracionVisita) {
        this.nombrePaciente = nombrePaciente;
        this.nombreRecepcionista = nombreRecepcionista;
        this.nombreVisita = nombreVisita;
        this.duracionVisita = duracionVisita;
    }
   
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreRecepcionista() {
        return nombreRecepcionista;
    }

    public void setNombreRecepcionista(String nombreRecepcionista) {
        this.nombreRecepcionista = nombreRecepcionista;
    }

    public String getNombreVisita() {
        return nombreVisita;
    }

    public void setNombreVisita(String nombreVisita) {
        this.nombreVisita = nombreVisita;
    }

    public int getDuracionVisita() {
        return duracionVisita;
    }

    public void setDuracionVisita(int duracionVisita) {
        this.duracionVisita = duracionVisita;
    }

    public int getCantidadVisitas() {
        return cantidadVisitas;
    }

    public void setCantidadVisitas(int cantidadVisitas) {
        this.cantidadVisitas = cantidadVisitas;
    }

    @Override
    public String toString() {
        return "VisitaDTO{" + "nombrePaciente=" + nombrePaciente + ", nombreRecepcionista=" + nombreRecepcionista + ", nombreVisita=" + nombreVisita + ", duracionVisita=" + duracionVisita + '}';
    }
     
}
