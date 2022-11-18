package models;

public class Curso {
    private int idCurso;
    private String nombre;
    private int precioCuota;
    private int cantidadCuotas;
    private int activo;

    public Curso(int idCurso, String nombre, int precioCuota, int cantidadCuotas, int activo) {
        this.idCurso = idCurso;
        this.nombre = nombre;
        this.precioCuota = precioCuota;
        this.cantidadCuotas = cantidadCuotas;
        this.activo = activo;
    }

    public Curso() {
    }

    @Override
    public String toString() {
        return nombre;
    }
    
   

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecioCuota() {
        return precioCuota;
    }

    public void setPrecioCuota(int precioCuota) {
        this.precioCuota = precioCuota;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
}
