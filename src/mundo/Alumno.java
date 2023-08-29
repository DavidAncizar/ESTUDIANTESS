/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author usuario
 */

public class Alumno {
    private String nombre;
    private String apellido;
    private String semestre;
    private String correo;
    private String celular;
    private String cedula;

    public Alumno() {
    }
    
    public Alumno(String nombre, String apellido, String semestre, String correo, String celular, String cedula) {
        this.nombre = nombre; 
        this.apellido = apellido;
        this.semestre = semestre;
        this.correo = correo;
        this.celular = celular;
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCelular() {
        return celular;
    }

    public String getCedula() {
        return cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
    
}

