/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_poo_v1;

/**
 *
 * @author bolys
 */
public class Alumno extends AlumnoData{
    private int numCuenta, edad, semestre;
    private int numInscripcion;
    private int numMateriasCursadas; // Aprobadas en toda la Carrera
    private int numMateriasCursadasesteSemestre; // Aprobadas en el Semestre
    private int numMateriasInscritas; // Por Semestre
    private float promedio; // Promedio general de Carrera
    private String nombre;
    private String carrera;
    private String direccion;

    public Alumno() {
    }

    
    public Alumno(int numCuenta, int edad, int semestre, int numInscripcion, int numMateriasCursadas, int numMateriasCursadasesteSemestre, int numMateriasInscritas, float promedio, String nombre, String carrera, String direccion) {
        this.numCuenta = numCuenta;
        this.edad = edad;
        this.semestre = semestre;
        this.numInscripcion = numInscripcion;
        this.numMateriasCursadas = numMateriasCursadas;
        this.numMateriasCursadasesteSemestre = numMateriasCursadasesteSemestre;
        this.numMateriasInscritas = numMateriasInscritas;
        this.promedio = promedio;
        this.nombre = nombre;
        this.carrera = carrera;
        this.direccion = direccion;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getNumInscripcion() {
        return numInscripcion;
    }

    public void setNumInscripcion(int numInscripcion) {
        this.numInscripcion = numInscripcion;
    }

    public int getNumMateriasCursadas() {
        return numMateriasCursadas;
    }

    public void setNumMateriasCursadas(int numMateriasCursadas) {
        this.numMateriasCursadas = numMateriasCursadas;
    }

    public int getNumMateriasCursadasesteSemestre() {
        return numMateriasCursadasesteSemestre;
    }

    public void setNumMateriasCursadasesteSemestre(int numMateriasCursadasesteSemestre) {
        this.numMateriasCursadasesteSemestre = numMateriasCursadasesteSemestre;
    }

    public int getNumMateriasInscritas() {
        return numMateriasInscritas;
    }

    public void setNumMateriasInscritas(int numMateriasInscritas) {
        this.numMateriasInscritas = numMateriasInscritas;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
}
