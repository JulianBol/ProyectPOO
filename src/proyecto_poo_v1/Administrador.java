/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_poo_v1;

/**
 *
 * @author bolys
 */
public class Administrador extends Usuario{

    private Alumno alumno;
    private String nombre;

    public Administrador(){
        
    }
    
    /**
     * CONSTRUCTOR.
     * @param alumno
     * @param nombre 
     */
    public Administrador(Alumno alumno, String nombre) {
        this.alumno = alumno;
        this.nombre = nombre;
    }

    // ---------------- GETTERS Y SETTERS -------------------
    /**
     * MÉTODO QUE RETORNA UN OBJETO DE TIPO ALUMNO.
     * @return alumno (Objeto de la Clase Alumno).
     */
    public Alumno getAlumno() {
        return alumno;
    }
    
    /**
     * MÉTODO QUE ESTABLECE EL ATRIBUTO 'alumno' CON LA REFERENCIA HACIA UN ALUMNO EN EXISTENCIA.
     * @param alumno 
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    /**
     * MÉTODO QUE RETORNA UN STRING.
     * @return nombre (Nombre de Administrador).
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * MÉTODO QUE ESTABLECE EL ATRIBUTO 'nombre' CON UN STRING.
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    // --------------- MÉTODOS DE CRUD ---------------------
    
    /**
     * MÉTODO QUE CREA Y RETORNA UN NUEVO OBJETO DEL TIPO 'Alumno' RECIBIENDO COMO PARAMETROS SUS ATRIBUTOS ESCENCIALES.
     * @param nombre STRING
     * @param numCuenta INT
     * @param edad INT
     * @param semestre INT
     * @param calificaciones INT[][]
     * @param direccion STRING
     * @return alumno (Objeto de la Clase Alumno).
     */
    public Alumno createAlumno(String nombre, int numCuenta, int edad, int semestre, int[][] calificaciones, String direccion){
        alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setNumCuenta(numCuenta);
        alumno.setEdad(edad);
        alumno.setSemestre(semestre);
        alumno.setCalificaciones(calificaciones);
        alumno.setDireccion(direccion);
        alumno.setCarrera("INGENIERIA EN COMPUTACION");
        alumno.defineData();
        alumno.sendData();
        
        return alumno;
    }
    
    /**
     * MÉTODO QUE ACTUALIZA EL ATRIBUTO 'nombre' DE UN OBJETO DE TIPO 'Alumno', REQUIERE COMO PARAMETRO UN STRING.
     * @param name STRING
     */
    public void editNombre(String name){
        alumno.setNombre(name);
    } 
    
    /**
     * MÉTODO QUE ACTUALIZA EL ATRIBUTO 'numCuenta' DE UN OBJETO DE TIPO 'Alumno', REQUIERE COMO PARAMETRO UN INT.
     * @param numCuenta INT
     */
    public void editNumCuenta(int numCuenta){
        alumno.setNumCuenta(numCuenta);
    }
    
    /**
     * MÉTODO QUE ACTUALIZA EL ATRIBUTO 'edad' DE UN OBJETO DE TIPO 'Alumno', REQUIERE COMO PARAMETRO UN INT.
     * @param age INT
     */
    public void editEdad(int age){
        alumno.setEdad(age);
    }
    
    /**
     * MÉTODO QUE ACTUALIZA EL ATRIBUTO 'semestre' DE UN OBJETO DE TIPO 'Alumno', REQUIERE COMO PARAMETRO UN INT.
     * @param semestre INT
     */
    public void editSemestre(int semestre){
        alumno.setSemestre(semestre);
    }
    
    /**
     * MÉTODO QUE ACTUALIZA EL ATRIBUTO 'calificaciones' DE UN OBJETO DE TIPO 'Alumno', REQUIERE COMO PARAMETRO UN INT[][].
     * @param calificaciones INT [][]
     */
    public void editCalificaciones(int[][] calificaciones){
        alumno.setCalificaciones(calificaciones);
    }
    
    /**
     * MÉTODO QUE ACTUALIZA EL ATRIBUTO 'direccion' DE UN OBJETO DE TIPO 'Alumno', REQUIERE COMO PARAMETRO UN STRING.
     * @param address STRING
     */
    public void editDireccion(String address){
        alumno.setDireccion(address);
    }
    
    /**
     * MÉTODO QUE ACTUALIZA Y DEFINE LOS REGISTROS ACADEMICOS DE UN ALUMNO Y ENVIA TODA LA INFORMACION DEL ALUMNO A LA BASE DE DATOS.
     */
    public void updateAlumno(){
        alumno.defineData();
        alumno.sendData();
    }
}
