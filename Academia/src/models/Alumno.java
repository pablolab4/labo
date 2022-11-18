
package models;

public class Alumno {
    
    private int idAlumno;
    private String nombre;
    private int cuotasPagas;
    private int nota;
    private Curso curso;

    public Alumno() {
    }

    public Alumno(int idAlumno, String nombre, int cuotasPagas, int nota, Curso curso) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.cuotasPagas = cuotasPagas;
        this.nota = nota;
        this.curso = curso;
    }


    @Override
    public String toString() {
        return "Alumno{" + "id_alumno=" + idAlumno + ", nombre=" + nombre + ", cuotasPagas=" + cuotasPagas + ", nota=" + nota + '}';
    }
    

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCuotasPagas() {
        return cuotasPagas;
    }

    public void setCuotasPagas(int cuotasPagas) {
        this.cuotasPagas = cuotasPagas;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
    
}
