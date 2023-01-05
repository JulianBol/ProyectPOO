/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_poo_v1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author bolys
 */
public class Alumno extends Usuario implements AlumnoData{
    
    private int numCuenta, edad, semestre; 
    private int numInscripcion;
    private int[][] calificaciones; 
    private float promedio; 
    private float velocidad, escolaridad, indEscolar;
    private String nombre; 
    private String carrera;
    private String direccion; 
    
    /**
     * CONSTRUCOR DE CLASE QUE INICIALIZA TODOS LOS ATRIBUTOS DE LA CLASE CON DATOS ALEATORIOS.
     */
    public Alumno() {
        this.nombre = generadorNombre(); 
        this.edad = generadorEdad();
        this.numCuenta = generadorNumCuenta();
        this.direccion = generadorDireccion();
        this.semestre = generadorSemestre();
        this.calificaciones = generadorCalifMaterias();
        this.numInscripcion = 0;
        this.carrera = "INGENIERIA EN COMPUTACION";
        
        // --- Datos de Acceso ---
        setUsername(generadorUser());
        setPassword(generadorPassword());
    }

    /**
     * CONSTRUCTOR.
     * @param numCuenta
     * @param edad
     * @param semestre
     * @param numInscripcion
     * @param calificaciones
     * @param promedio
     * @param velocidad
     * @param escolaridad
     * @param indEscolar
     * @param nombre
     * @param carrera
     * @param direccion 
     */
    public Alumno(int numCuenta, int edad, int semestre, int numInscripcion, int[][] calificaciones, float promedio, float velocidad, float escolaridad, float indEscolar, String nombre, String carrera, String direccion) {
        this.numCuenta = numCuenta;
        this.edad = edad;
        this.semestre = semestre;
        this.numInscripcion = numInscripcion;
        this.calificaciones = calificaciones;
        this.promedio = promedio;
        this.velocidad = velocidad;
        this.escolaridad = escolaridad;
        this.indEscolar = indEscolar;
        this.nombre = nombre;
        this.carrera = carrera;
        this.direccion = direccion;
    }
    
    // ----------------------------- MÉTODOS GENERADORES DE DATA -----------------------------
    
    /**
     * MÉTODO GENERARDOR DE NOMBRES ALEATORIOS (un nombre y dos apellidos), RETORNA UN STRING CON EL NOMBRE GENERADO.
     * @return nombreAleatorio STRING
     */
    private String generadorNombre() {
		String nombresAleatorios;

		String[] nombres = { "Andrea", "David", "Santiago", "Julian", "Diego", "Juan", "Melanie", "Gaelle", "Gael", "Frida"
                , "Pablo", "Simon", "Martin", "Natalia", "Blanca", "Daniel", "Rogelio", "Isaac", "Vanessa", "Yaretzi", "Yareli", "Tania"
                , "Patricio", "Rodrigo", "Brenda", "Alejandro", "Monica", "Gabriel", "Tania", "Daniela", "Karen", "Kaori", "Cassandra"
                , "Miguel", "Cynthia", "Octavio", "Fernando", "Jose", "Omar", "Sebastian", "Manuel", "Axel", "Julieta", "Karla", "Sara"
                , "Carolina", "Jessica", "Maximiliano", "Alicia", "Fernanda", "Maria", "Diana", "Aurora", "Flor", "Alberto", "Rebecca"
                , "Leonardo", "Dara", "Sergio", "Gustavo", "Yannin", "Paola", "Luis", "Jorge", "Alonso", "Sofia", "Abril", "Yara"};
		
                String[] apellidos = { "Gomez", "Arellano", "Orihuela", "Riveroll", "Villegas", "Garcia", "Isaza", "Villamil", "Campos"
                , "Olmos", "Sotelo", "Rodriguez", "Peralta", "Lemuss", "Bolaños", "Garduño", "Pacheco", "Perez", "Orihuela", "Zarco"
                , "Calzontli", "Sandoval", "Reyes", "Ortiz", "Rivas", "Rosas", "Bedolla", "Coronel", "Ortega", "Belmont", "Sosa", "Bazan"
                , "Frias", "Palacios", "Patiño", "Espinoza", "Dominguez", "Hernandez", "Laguna", "Cervantes", "Contreras", "Rosas", "Goncen"
                , "Sandoval", "Villalobos", "Rico", "Guzman", "Paz", "Del Monte", "Diaz", "Tellez", "Salas", "Ordaz", "Tavani", "Mejia"
                , "Oviedo", "Pichardo", "Ontiveros", "Peña", "Acuña", "Marcial", "Angeles", "Cruz", "Chavez", "Maya", "Olea", "Barranco"
                , "Flores", "Rojas", "Mendoza", "Saucedo", "Castillo", "Soriano", "Valdes", "Escudero", "Galvan", "Medina"};
                
                String[] apellidos2 = { "Gomez", "Arellano", "Orihuela", "Riveroll", "Villegas", "Garcia", "Isaza", "Villamil", "Campos"
                , "Olmos", "Sotelo", "Rodriguez", "Peralta", "Lemuss", "Bolaños", "Garduño", "Pacheco", "Perez", "Orihuela", "Zarco"
                , "Calzontli", "Sandoval", "Reyes", "Ortiz", "Rivas", "Rosas", "Bedolla", "Coronel", "Ortega", "Belmont", "Sosa", "Bazan"
                , "Frias", "Palacios", "Patiño", "Espinoza", "Dominguez", "Hernandez", "Laguna", "Cervantes", "Contreras", "Rosas", "Goncen"
                , "Sandoval", "Villalobos", "Rico", "Guzman", "Paz", "Del Monte", "Diaz", "Tellez", "Salas", "Ordaz", "Tavani", "Mejia"
                , "Oviedo", "Pichardo", "Ontiveros", "Peña", "Acuña", "Marcial", "Angeles", "Cruz", "Chavez", "Maya", "Olea", "Barranco"
                , "Flores", "Rojas", "Mendoza", "Saucedo", "Castillo", "Soriano", "Valdes", "Escudero", "Galvan", "Medina" };

			
                nombresAleatorios = nombres[(int) (Math.floor(Math.random() * ((nombres.length - 1) - 0 + 1) + 0))] + " "
					+ apellidos[(int) (Math.floor(Math.random() * ((apellidos.length - 1) - 0 + 1) + 0))] + " "  
                                        + apellidos2[(int) (Math.floor(Math.random() * ((apellidos2.length - 1) - 0 + 1) + 0))];
                
                
		return nombresAleatorios.toUpperCase();
    }
    
    /**
     * MÉTODO QUE RECUPERA DIRECCIONES REALES DE LA BASE DE DATOS (archivos del tipo .csv) Y RETORNA UN ARREGLO STRING[] CON 1000 DIRECCIONES.
     * @return direcciones STRING[]
     */
    private String[] getDirecciones(){
        int numDirecciones = 0, count = 0;
        String direccionFile = "";
        String[] direcciones = new String[1000];
        
        try{           
            // Aquí usamos Tokenizer para Tokenizar los Elementos Leidos del Archivo
            BufferedReader br = new BufferedReader(new FileReader("DATA/datosDirecciones_1.csv"));
            String dataRead = br.readLine();
            StringTokenizer cadParticion = new StringTokenizer(dataRead, ",");
            
            numDirecciones = 0;
            while (numDirecciones < 1000){
                while (cadParticion.hasMoreElements()){
                    if(count == 2){
                        direccionFile += "NÚM. " + cadParticion.nextElement().toString() + " ";
                    }
                    else if(count == 6){
                        direccionFile += cadParticion.nextElement().toString() + " ALCALDIA ";
                    }
                    else if(count != 5){
                        direccionFile += cadParticion.nextElement().toString() + " ";
                    }
                    else{
                        direccionFile += "C.P. " + cadParticion.nextElement().toString() + " ";
                    }
    
                    count += 1;
                }
                count = 0;
                direcciones[numDirecciones] = direccionFile;
                direccionFile = "";
                numDirecciones += 1;
                dataRead = br.readLine();
                cadParticion = new StringTokenizer(dataRead, ",");
            }
            
            br.close();
        }catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return direcciones;
    }
    
    /**
     * MÉTODO QUE RETORNA UNA DIRECCION ALEATORIA DE ENTRE 1000 EXISTENTES.
     * @return direccion STRING
     */
    private String generadorDireccion(){
        String[] direcciones = getDirecciones();
        return direcciones[(int)(Math.random() * ((999 - 1) + 1)) + 1];
    }
    
    /**
     * MÉTODO QUE RETORNA UNA EDAD AL AZAR, ENTRE UN RANGO DE 18 A 27, RETORNA UN INT.
     * @return edad INT
     */
    private int generadorEdad(){
        return (int)(Math.random() * ((27 - 18) + 1)) + 18;
    }
    
    /**
     * MÉTODO QUE RETORNA UN NÚMERO DE CUENTA DE FORMA ALEATORIA DE 9 DIGITOS, RETORNA UN INT.
     * @return numCuenta INT
     */
    private int generadorNumCuenta(){
        return (int)(Math.random() * ((400000000 - 200000000) + 1)) + 200000000;
    }
    
    /**
     * MÉTODO QUE GENERA Y RETORNA UN USUARIO DE ACCESO, RETORNA UN STRING.
     * @return usuario STRING
     */
    private String generadorUser(){
        return Integer.toString(numCuenta);
    }
    
    /**
     * MÉTODO QUE GENEREA Y RETORNA UNA CONTRASEÑA NUMERICA DE 6 DIGITOS, RETORNA UN INT.
     * @return contraseña INT
     */
    private String generadorPassword(){
        return Integer.toString((int)(Math.random() * ((600000 - 100000) + 1)) + 100000);
    }
    
    /**
     * MÉTODO QUE GENERA EL NUMERO DE SEMESTRE SEGUN LA EDAD DE UN ALUMNO, RETORNA UN INT.
     * @return semestre INT
     */
    private int generadorSemestre(){
        int[] semestres = {1,2,3,4,5,6,7,8,9,10};
  
        if(edad == 18){
            return semestres[0];
        }
        else if(edad == 19){
            return semestres[(int)(Math.random() * ((2 - 1) + 1)) + 1];
        }
        else if(edad == 20){
            return semestres[(int)(Math.random() * ((4 - 3) + 1)) + 3];
        }
        else if(edad == 21){
            return semestres[(int)(Math.random() * ((6 - 5) + 1)) + 5];
        }
        else if(edad == 22){
            return semestres[(int)(Math.random() * ((8 - 7) + 1)) + 7];
        }
        else if(edad == 23){
            return semestres[9];
        }
        else if(edad > 23 && edad < 28){
            return semestres[(int)(Math.random() * ((9 - 7) + 1)) + 7];
        }
        return 0;
    }
    
    /**
     * GENERA CALIFICACIONES DE TIPO INT ALEATORIAMENTE, EL NUMERO DE CALIFICACIONES DEPENDERA DEL SEMESTRE EN EL QUE EL ALUMNO SE ENCUENTRE, DEPENDE DEL ATRIBUTO 'semestre'.
     * @return newCalificaciones INT[][]
     */
    private int[][] generadorCalifMaterias(){
        
        int newCalificaciones[][] = new int[semestre][5];
        for (int i = 0; i < semestre; i++) {
            for (int j = 0; j < 5; j++) {
                newCalificaciones[i][j] = ((int)(Math.random() * ((10 - 5) + 1)) + 5);
            } 
        }      
        return newCalificaciones;
    }
    
    /**
     * MÉTODO QUE GENERA EL PROMEDIO MEDIANTE EL ATRIBUTO 'semestre' Y 'calificaciones', RETORNA UN FLOAT.
     * @return promedio FLOAT
     */
    private float generadorPromedio(){
        
        float numerador = 0, contador=0;
        for (int i = 0; i < semestre; i++) {
            for (int j = 0; j < 5; j++) {
                numerador = numerador + calificaciones[i][j];
                contador++;
            } 
        }
        return numerador/contador;        
    }
    
    /**
     * MÉTODO QUE GENERA LA ESCOLARIDAD 'escolaridad'  MEDIANTE EL ATRIBUTO 'semestre' Y 'calificaciones', RETORNA UN FLOAT.
     * @return escolaridad FLOAT
     */
    private float generadorEscolaridad(){
        float esco;
        float aprobadas = 0;
        float inscritas;
        inscritas = semestre * 5;
        for (int i = 0; i < semestre; i++) {
            for (int j = 0; j < 5; j++) {
                if (calificaciones[i][j] != 5)
                    aprobadas++;
            } 
        }  
        esco = (aprobadas / inscritas)*100;
        return esco;                             
    }
    
    /**
     * MÉTODO QUE GENERA LA VELOCIDAD 'velocidad' MEDIANTE EL ATRIBUTO 'semestre' Y 'calificaciones' Y LA VARIABLE 'CREDITOS' DE LA INTERFAZ 'AlumnoData', RETORNA UN FLOAT.
     * @return velocidad FLOAT
     */
    private float generadorVelocidad(){
        float credAlu = 0;
        float totCred = 0;
        for (int i = 0; i < semestre; i++) {
            for (int j = 0; j < 5; j++) {
                if (calificaciones[i][j] != 5)
                    credAlu = credAlu + CREDITOS[i][j];
            } 
        } 
        for (int i = 0; i < semestre; i++) {
            for (int j = 0; j < 5; j++) {
                 totCred = totCred + CREDITOS[i][j];
            } 
        } 
        
        return (credAlu/totCred)*100;
    }
    
    /**
     * MÉTODO QUE ESTABLECE LOS ATRIBUTOS 'velocidad, escolaridad e indEscolar', ES IMPORTANTE HABER GENERADO LOS ATRIBUTOS 'semestre, calificaiones' CON ANTELACION.
     */
    public void defineData(){

        this.promedio = generadorPromedio();
        this.velocidad = generadorVelocidad();
        this.escolaridad = generadorEscolaridad();
        this.indEscolar = promedio*velocidad*escolaridad; 
    }
    
    /**
     * IMPRIME LOS DATOS PERSONALES DE UN ALUMNO EN LA TERMINAL.
     */
    private void printDataAlumno_Personal(){
        System.out.println("=======================================================================================================");
        System.out.println("\t\t\t\t\tDATOS PERSONALES\n");
        System.out.println("NOMBRE: " + nombre + "\t\t\t" + "NUM. CUENTA: " + numCuenta);
        System.out.println("EDAD: " + edad + " AÑOS");
        System.out.println("CARRERA: " + carrera + "\t\tSEMESTRE: " + semestre + "°");
        System.out.println("DIRECCIÓN: " + direccion);
        System.out.println("=======================================================================================================");       
    }
    
    /**
     * IMPRIME LOS DATOS ACADEMICOS DE UN ALUMNO EN LA TERMINAL.
     */
    private void printDataAlumno_Academico(){
        System.out.println("\t\t\t\t\tHISTORIAL ACADEMICO\n");
        System.out.println(nombre + " \t\tPROMEDIO: " + promedio + "\nNUM. CUENTA: " + numCuenta + "\t\t NUM. INSCRIPCION: " + numInscripcion + "\n------------------------");
        
        for (int i = 0; i < semestre; i++) {
            System.out.print("\n\tSEMESTRE " + (i+1) + "°|\n");
            for (int j = 0; j < 5; j++) {
                System.out.println("\t\t" + MATERIAS[i][j] + " -- " + calificaciones[i][j]);
            }
        }
    }
    
    /**
     * MÉTODO QUE IMPRIME LOS DATOS PERSONALES Y ACADEMICOS DE UN ALUMNO EN LA TERMINAL.
     */
    public void printDataAlumno(){
        printDataAlumno_Personal();
        printDataAlumno_Academico();
    }
    
    // --------------------- MÉTODOS QUE ENVIAN DATA A ARCHIVO (.csv) ------------------
    
    /**
     * MÉTODO QUE ENVIA LA INFORMACION PERSONAL DE UN ALUMNO A LA BASE DE DATOS (archivo de tipo .csv).
     */
    private void sendData_Personal(){
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(URL_ALU + Integer.toString(numCuenta) +"\\" + Integer.toString(numCuenta) + "_Personal.csv"));
            BufferedWriter bwG = new BufferedWriter(new FileWriter(URL_GEN + "registrosGenerales.csv", true));
            PrintWriter salida = new PrintWriter(bw);
            PrintWriter salidaG = new PrintWriter(bwG);
            
            String data = nombre + "," + Integer.toString(numCuenta) + "," + carrera
                          + "," + Integer.toString(edad) + "," + Integer.toString(semestre) 
                          + "," + Float.toString(promedio) + "," + Integer.toString(numInscripcion) 
                          + "," + Float.toString(velocidad) + "," + Float.toString(escolaridad)
                          + "," + Float.toString(indEscolar) + "," + getUsername() 
                          + "," + getPassword() + "," + direccion;
            
            salida.println(data);
            salidaG.println(data);
            salida.close();
            salidaG.close();
        } catch (IOException ex){
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    /**
     * MÉTODO QUE ENVIA LA INFORMACION ACADEMICA DE UN ALUMNO A LA BASE DE DATOS (archivo de tipo .csv).
     */
    private void sendData_Academico(){
        
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(URL_ALU + Integer.toString(numCuenta) +"\\" + Integer.toString(numCuenta) + "_Academico.csv"));
            PrintWriter salida = new PrintWriter(bw);

            for (int i = 0; i < semestre; i++) {
                String data = "Semestre " + (i+1)
                              + "," + calificaciones[i][0] + "," + calificaciones[i][1]
                              + "," + calificaciones[i][2] + "," + calificaciones[i][3]
                              + "," + calificaciones[i][4];
                salida.println(data);
            }
            
            salida.close();            
        } catch (IOException ex){
            java.util.logging.Logger.getLogger(Alumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    /**
     * MÉTODO PUBLICO QUE INVOCA A sendData_Personal() Y sendData_Academico() PARA ENVIAR A LA BASE DE DATOS LA INFORMACION DEL ALUMNO.
     */
    public void sendData(){
        if (new File(URL_ALU + Integer.toString(numCuenta)).exists()) {
            sendData_Personal();
            sendData_Academico();
        }
        else{
            new File(URL_ALU + Integer.toString(numCuenta)).mkdir();
            sendData_Personal();
            sendData_Academico();
        }
    }
    
    // ----------------------------- GETTERS y SETTERS -----------------------
    /**
     * ESTABLECE EL NOMBRE DE UN ALUMNO.
     * @param nombre 
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * RETORNA EL NOMBRE DE UN ALUMNO.
     * @return nombre STRING (Nombre de un Alumno)
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * ESTABLECE EL NUMERO DE CUENTA DE UN ALUMNO
     * @param numCuenta 
     */
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    /**
     * RETORNA EL NUMERO DE CUENTA DE UN ALUMNO.
     * @return numCuenta INT
     */
    public int getNumCuenta() {
        return numCuenta;
    }

    /**
     * ESTABLECE LA EDAD DE UN ALUMNO.
     * @param edad 
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    /**
     * ESTABLECE EL SEMESTRE DE UN ALUMNO.
     * @param semestre 
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * ESTABLECE EL NUMERO DE INSCRIPCION DE UN ALUMNO.
     * @param numInscripcion 
     */
    public void setNumInscripcion(int numInscripcion) {
        this.numInscripcion = numInscripcion;
    }
    
    /**
     * RETORNA EL SEMESTRE DEL ALUMNO.
     * @return semestre INT
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * RETORNA EL NUMERO DE INSCRIPCION DEL ALUMNO.
     * @return numInscripcion INT
     */
    public int getNumInscripcion() {
        return numInscripcion;
    }

    /**
     * RETORNA UN ARREGLO INT[][] CON LAS CALIFICACIONES DE UN ALUMNO.
     * @return calificaciones INT[][]
     */
    public int[][] getCalificaciones() {
        return calificaciones;
    }

    /**
     * ESTABLECE LAS CALIFICACIONES DE UN ALUMNO, NO LAS  GENERA SINO QUE REASIGNA LA VARIABLE CON UNA NUEVA REFERENCIA A UN NUEVO ARREGLO.
     * @param calificaciones 
     */
    public void setCalificaciones(int[][] calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * RETORNA EL PROMEDIO DE UN ALUMNO.
     * @return promedio FLOAT
     */
    public float getPromedio() {
        return promedio;
    }

    /**
     * ESTABLECE EL PROMEDIO DE UN ALUMNO.
     * @param promedio 
     */
    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }


    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public float getEscolaridad() {
        return escolaridad;
    }

    public void setEscolaridad(float escolaridad) {
        this.escolaridad = escolaridad;
    }

    public float getIndEscolar() {
        return indEscolar;
    }

    public void setIndEscolar(float indEscolar) {
        this.indEscolar = indEscolar;
    }

    /**
     * RETORNA LA CARRERA QUE CURSA EL ALUMNO.
     * @return carrera STRING
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * ESTABLECE LA CARRERA QUE CURSA UN ALUMNO.
     * @param carrera STRING
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    /**
     * ESTABLECE LA DIRECCION DE UN ALUMNO.
     * @param direccion STRING
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * RETORNA UN ARREGLO INT[][] CON LAS MATERIAS DE UN ALUMNO.
     * @return MATERIAS STRING [][]
     */
    public String[][] getMaterias() {
        return MATERIAS;
    }

    @Override
    public String toString() {
        return "Alumno{" + "numCuenta=" + numCuenta + ", edad=" + edad + ", semestre=" + semestre + ", numInscripcion=" + numInscripcion + ", calificaciones=" + calificaciones + ", creditosMaterias=" + CREDITOS + ", promedio=" + promedio + ", velocidad=" + velocidad + ", escolaridad=" + escolaridad + ", indEscolar=" + indEscolar + ", nombre=" + nombre + ", carrera=" + carrera + ", direccion=" + direccion + '}';
    }    
}
