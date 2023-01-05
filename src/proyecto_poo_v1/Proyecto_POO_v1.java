/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_poo_v1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bolys   
 */
public class Proyecto_POO_v1 implements AlumnoData{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList <Alumno> alumnos = new ArrayList <>();
        
        //INICIALIZACIÓN DE ALUMNOS 
        for (int i = 0; i < 10; i++) {
            alumnos.add(new Alumno());
            alumnos.get(i).defineData();
            alumnos.get(i).sendData();
        }
        
        
        String username = login();
        if (detectarUser(username)) {
            Alumno alumno = busquedaAlumno(username);
            int op=0;
            do{
                
                System.out.println("\t\t\tBIENVENIDO " + alumno.getNombre());
                System.out.println("\n\tSELECCIONA UNA OPCION");
                System.out.println("\tVER HISTORIAL ACADEMICO --------------- (1)");
                System.out.println("\tVER NUMERO DE INSCRIPCION ------------- (2)");
                System.out.println("\tCERRAR SESION ----------------------------(3)");
                System.out.print("\tOPCION: ");
                try {
                    op = new Scanner(System.in).nextInt();
                }
                catch(Exception InputMismatchException) {
                  System.out.println("Opcion incorrecta. Vuelva a intentar");
                }
                
                if (op == 1) {
                    alumno.printDataAlumno();
                    System.out.println("\n\t\t\t << PRESIONA 'e' PARA REGRESAR >>");
                    new Scanner(System.in).nextLine();
                }
                else if (op == 2) {
                    if (alumno.getSemestre() < 10) {
                        System.out.println("\tESTIMADO " + alumno.getNombre()
                        + " SU NUMERO DE INSCRIPCION AL SEMESTRE " + (alumno.getSemestre() + 1)
                        + " ES: " + alumno.getNumInscripcion());
                    }
                    else if (alumno.getSemestre() == 10) {
                        System.out.println("\tESTIMADO " + alumno.getNombre() 
                        + " USTED A CONCLUIDO LA CARRERA DE INGENIERIA EN COMPUTACION CON UN PROMEDIO DE "
                        + alumno.getPromedio());
                    }
                    
                    System.out.println("\n\t\t\t << PRESIONA 'e' PARA REGRESAR >>");
                    new Scanner(System.in).nextLine();
                }
                
            }while(op != 3);
        }
        else{
            Administrador administrador = busquedaAdministrador(username);
            int op=0;
            
            do{
                System.out.println("\nINGRESO UN ADMINISTRADOR, BIENVENIDO " + administrador.getNombre());
                ArrayList <Alumno> alumnos_ = new ArrayList <>();
                String[] alums = new File(URL_ALU).list();

                for (String alum : alums) {
                    alumnos_.add(busquedaAlumno(alum));
                }

                System.out.println("\n\t\tSELECCIONA UNA OPCION");
                System.out.println("\t\tCREAR NUEVO ALUMNO -------------- (1)");
                System.out.println("\t\tACTUALIZAR ALUMNO --------------- (2)");
                System.out.println("\t\tVER ALUMNOS --------------------- (3)");
                System.out.println("\t\tBORRAR ALUMNO ------------------- (4)");
                System.out.println("\t\tGENERAR NUMEROS DE INSCRIPCION -- (5)");
                System.out.println("\t\tSALIR ----------------------------(6)");
                System.out.print("\t\tOPCION: ");
                try {
                    op = new Scanner(System.in).nextInt();
                }
                catch(Exception InputMismatchException) {
                  System.out.println("Opcion incorrecta. Vuelva a intentar");
                }
                if (op == 1) {
                    System.out.print("INGRESA NOMBRE: ");
                    String nombre = new Scanner(System.in).nextLine();
                    
                    int numCuenta;
                    numCuenta=asignarNumCuenta();
                    
                    int edad=0;
                    while(edad<18 || edad>27){
                        System.out.print("INGRESA EDAD: ");
                        try {
                            edad = new Scanner(System.in).nextInt();
                        }
                        catch(Exception e) {
                            System.out.println("Conflicto de tipos. Vuelva a intentar");
                        }
                        
                    }

               
                    int semestre=0;
                    while(semestre<1 || semestre>10){
                        System.out.print("INGRESA SEMESTRE: ");
                        try {
                            semestre = new Scanner(System.in).nextInt();
                        }
                        catch(Exception e) {
                            System.out.println("Conflicto de tipos. Vuelva a intentar");
                        }
                    }
                    
                    System.out.println("INGRESA CALIFICACIONES....\n");
                    int[][] calificaciones = new int[semestre][5];
                    for (int i = 0; i < semestre; i++) {
                        for (int j = 0; j < 5; j++) {
                            calificaciones[i][j]=0;
                            while(calificaciones[i][j]<5 || calificaciones[i][j]>10){
                                System.out.print("INGRESA CALIFICAION SEMESTRE " + (i+1) + " -- " + MATERIAS[i][j] + ": ");
                                try {
                                    calificaciones[i][j] = new Scanner(System.in).nextInt();
                                }
                                catch(Exception e) {
                                    System.out.println("Conflicto de tipos. Vuelva a intentar");
                                }
                            }
                        }
                    }
                    
                    System.out.print("INGRESA DIRECCION: ");
                    String direccion = new Scanner(System.in).nextLine();
                    
                    administrador.createAlumno(nombre, numCuenta, edad, semestre, calificaciones, direccion);
                    numerosInscripcion(alumnos_);
                    for(Alumno alu: alumnos_){
                        administrador.setAlumno(alu);
                        administrador.updateAlumno();
                    }
                    
                    System.out.println("<< ALUMNO CREADO CON EXITO, PRESIONA 'e' PARA REGRESAR >>");
                    new Scanner(System.in).nextLine();
                }
                
                else if (op == 2) {
                    ArrayList <Integer> atributosUpdate = new ArrayList <>();
                    System.out.println("\t\t\tALUMNOS EN EXISTENCIA\n");
                    for (int i = 0; i < alumnos_.size(); i++) {
                        System.out.println((i+1) + " - " + alumnos_.get(i).getNombre() + "\t" + "NUM. CUENTA: " + alumnos_.get(i).getNumCuenta());
                    }
                
                    int id=-1;
                    while(id<0 || id>alumnos_.size()-1){
                        System.out.print("\tINGRESA ID DE ALUMNO A MODIFICAR: ");
                        try {
                            id = new Scanner(System.in).nextInt() - 1;
                            administrador.setAlumno(alumnos_.get(id));
                        }
                        catch(Exception e) {
                            System.out.println("Vuelva a intentar");
                        }
                    }
                    
                    
                    System.out.println("\tPUEDES MODIFICAR LOS SIGUIENTES DATOS DE " + alumnos_.get(id).getNombre());
                    System.out.print("\n\t(1) - NOMBRE\n\t(2) - EDAD\n\t(3) - SEMESTRE\n\t(4) - CALIFICACIONES\n\t(5) - DIRECCION");
                    
                    do {
                        op = 10;
                        while(op<0 || op>6){
                            System.out.print("\n\tINGRESA ATRIBUTO A ACTUALIZAR: ");
                            try {
                                op = new Scanner(System.in).nextInt();
                            }
                            catch(Exception InputMismatchException) {
                              System.out.println("Opcion incorrecta. Vuelva a intentar");
                            }
                        }
                        atributosUpdate.add(op);
                        
                        System.out.print("\t\t<< PRESIONA 'e' PARA DEJAR DE SELECCIONAR 'c' PARA CONTINUAR >>");
                    } while (!(new Scanner(System.in).nextLine().equals("e")));
                    for (int i = 0; i < atributosUpdate.size(); i++) {
                        switch (atributosUpdate.get(i)) {
                            case 1 -> {
                                System.out.print("\n\tINGRESA NUEVO NOMBRE: ");
                                administrador.editNombre(new Scanner(System.in).nextLine());
                            }

                            case 2 -> {
                                int edad=0;
                                while(edad<18 || edad>27){
                                    System.out.print("\n\tINGRESA NUEVA EDAD: ");
                                    try {
                                        edad = new Scanner(System.in).nextInt();
                                        administrador.editEdad(edad);
                                    }
                                    catch(Exception e) {
                                        System.out.println("Conflicto de tipos. Vuelva a intentar");
                                    }

                                }
                            }
                            case 3 -> {
                                int semestre=0;
                                while(semestre<1 || semestre>10){
                                    System.out.print("\n\tINGRESA NUEVO SEMESTRE: ");
                                    try {
                                        semestre = new Scanner(System.in).nextInt();
                                        administrador.editSemestre(semestre);
                                    }
                                    catch(Exception e) {
                                        System.out.println("Conflicto de tipos. Vuelva a intentar");
                                    }
                                }
                                
                                /** SI ACTUALIZAMOS EL SEMESTRE, LA CANTIDAD DE CALIIFICACIONES CAMBIA,
                                 *  POR ELLO TAMBIEN DE DEBEN MODIFICAR LAS CALIFICAIONES.
                                 */
                                
                                int[][] newCalificaciones = new int[alumnos_.get(id).getSemestre()][5];
                                System.out.print("\n\tINGRESA NUEVAS CALIFICACIONES\n ");
                                for (int j = 0; j < alumnos_.get(id).getSemestre(); j++) {
                                    for (int k = 0; k < 5; k++) {
                                        newCalificaciones[j][k]=0;
                                        while(newCalificaciones[j][k]<5 || newCalificaciones[j][k]>10){
                                            System.out.print("INGRESA CALIFICAION SEMESTRE " + (j+1) + " -- " + MATERIAS[j][k] + ": ");
                                            try {
                                                newCalificaciones[j][k] = new Scanner(System.in).nextInt();
                                            }
                                            catch(Exception e) {
                                                System.out.println("Conflicto de tipos. Vuelva a intentar");
                                            }
                                        }
                                    }
                                }
                                administrador.editCalificaciones(newCalificaciones);
                            }
                            case 4 -> {
                                int[][] newCalificaciones = new int[alumnos_.get(id).getSemestre()][5];
                                System.out.print("\n\tINGRESA NUEVAS CALIFICACIONES\n ");
                                for (int j = 0; j < alumnos_.get(id).getSemestre(); j++) {
                                    for (int k = 0; k < 5; k++) {
                                        newCalificaciones[j][k]=0;
                                        while(newCalificaciones[j][k]<5 || newCalificaciones[j][k]>10){
                                            System.out.print("INGRESA CALIFICAION SEMESTRE " + (j+1) + " -- " + MATERIAS[j][k] + ": ");
                                            try {
                                                newCalificaciones[j][k] = new Scanner(System.in).nextInt();
                                            }
                                            catch(Exception e) {
                                                System.out.println("Conflicto de tipos. Vuelva a intentar");
                                            }
                                        }
                                    }
                                }
                                administrador.editCalificaciones(newCalificaciones);
                            }
                            case 5 -> {
                                System.out.print("\n\tINGRESA NUEVA DIRECCION: ");
                                administrador.editDireccion(new Scanner(System.in).nextLine());
                            }
                            default -> throw new AssertionError();
                        }
                    }
                    
                    administrador.updateAlumno();
                    
                    System.out.println("<< ALUMNO ACTUALIZADO CON EXITO, PRESIONA 'e' PARA REGRESAR >>");
                    new Scanner(System.in).nextLine();
                }
                else if (op == 3) {
                    System.out.println("\t\t\tALUMNOS EN EXISTENCIA\n");
                    for (int i = 0; i < alumnos_.size(); i++) {
                        System.out.println((i+1) + " - " + alumnos_.get(i).getNombre() + "\t" + "NUM. CUENTA: " + alumnos_.get(i).getNumCuenta());
                    }
                    
                    int id=-1;
                    while(id<0 || id>alumnos_.size()-1){
                        System.out.print("\tINGRESA ID DE ALUMNO: ");
                        try {
                            id = new Scanner(System.in).nextInt() - 1;
                            administrador.setAlumno(alumnos_.get(id));
                        }
                        catch(Exception e) {
                            System.out.println("Vuelva a intentar");
                        }
                    }
                    alumnos_.get(id).printDataAlumno();
                }
                else if (op == 4) {
                    System.out.println("\t\t\tALUMNOS EN EXISTENCIA\n");
                    for (int i = 0; i < alumnos_.size(); i++) {
                        System.out.println((i+1) + " - " + alumnos_.get(i).getNombre() + "\t" + "NUM. CUENTA: " + alumnos_.get(i).getNumCuenta());
                    }
                    int id=-1;
                    while(id<0 || id>alumnos_.size()-1){
                        System.out.print("\tINGRESA ID DE ALUMNO A ELIMINAR: ");
                        try {
                            id = new Scanner(System.in).nextInt() - 1;
                            administrador.setAlumno(alumnos_.get(id));
                        }
                        catch(Exception e) {
                            System.out.println("Vuelva a intentar");
                        }
                    }
                    deleteAlumno(new File(URL_ALU + Integer.toString(alumnos_.get(id).getNumCuenta())));
                    alumnos_.remove(id);
                    
                    numerosInscripcion(alumnos_);
                    for(Alumno alu: alumnos_){
                        administrador.setAlumno(alu);
                        administrador.updateAlumno();
                    }
                    
                    System.out.println("<< ALUMNO ELIMINADO CON EXITO, PRESIONA 'e' PARA REGRESAR >>");
                    new Scanner(System.in).nextLine();
                }
                else if (op == 5) {
                    numerosInscripcion(alumnos_);
                    
                    for(Alumno alu: alumnos_){
                        administrador.setAlumno(alu);
                        administrador.updateAlumno();
                    }
                    
                    
                }
                
            }while(op != 6);
        }
       
    }
    
    /**
     * MÉTODO ENCARGADO DE AUTENTICAR A LOS USUARIOS, SOLICITA UN USUARIO Y UNA CONTRASEÑA AMBOS DEL TIPO STRING. REVISA QUE LOS DATOS
     * EXISTAN EN LA BASE DE DATOS, Y DE EXISTIR Y SER CORRECTOS, DA ACCESO AL SISTEMA, SINO TE SOLICITA LOS DATOS HASTA SER CORRECTOS,
     * FINALMENTE RETORNA EL NOMBRE DE USUARIO DE QUIEN ACCEDIO.
     * @return usernam String
     */
    public static String login(){

        String user, password;
 
        do{
            System.out.println("\t\t\tLOGIN");
            System.out.print("\tINGRESA USUARIO: ");
            user = new Scanner(System.in).nextLine();
            System.out.print("\tINGRESA CONTRASEÑA: ");
            password = new Scanner(System.in).nextLine();

            if (detectarUser(user)) { // TRUE = ALUMNO
                if (new File(URL_ALU + user).exists()) {
                    if (password.equals(getPassword(user, detectarUser(user)))) {
                        return user;
                    }
                }
                else{
                    System.out.println("USUARIO O PASSWORD INCORRECTOS, INTENTE NUEVAMENTE...");
                }
            }
            else{
                if (new File(URL_ADM + user + ".csv").exists()) {
                    if (password.equals(getPassword(user, detectarUser(user)))) {
                        return user;
                    }
                }
                else{
                    System.out.println("USUARIO O PASSWORD INCORRECTOS, INTENTE NUEVAMENTE...");
                }
            }         
        }while (true); 
    }
    
    /**
     * MÉTODO QUE RECUPERA LA CONTRASEÑA DE UN USUARIO DE LA BASE DE DATOS. 
     * RECIBE COMO PARAMETROS EL NOMBRE DE USUARIO QUE QUIERE ACCEDER Y EL TIPO DE USUARIO (ALUMNO O ADMINISTRADOR COMO BOOLEAN: TRUE = ALUMNO) PARA PODER BUSCAR EN LA BASE DE DATOS 
     * LA CONTRASEÑA CORRESPONDIENTE Y RETORNARLA PARA REALIZAR LA AUTENTICAION CON login().
     * @param user STRING
     * @param typeUser BOOLEAN
     * @return password STRING
     */
    public static String getPassword(String user, boolean typeUser){
        ArrayList <String> data = new ArrayList <>();
        
        if (typeUser) { // TRUE = ALUMNO

            try{           
                BufferedReader br = new BufferedReader(new FileReader(URL_ALU + user + "\\" + user + "_Personal.csv"));
                String dataRead = br.readLine();
                StringTokenizer cadParticion = new StringTokenizer(dataRead, ",");

                while (cadParticion.hasMoreElements()) {
                        data.add(cadParticion.nextElement().toString());
                    }

                br.close();

            }catch (FileNotFoundException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }

            return data.get(11);
        }
        else{
            try{           
                BufferedReader br = new BufferedReader(new FileReader(URL_ADM + user + ".csv"));
                String dataRead = br.readLine();
                StringTokenizer cadParticion = new StringTokenizer(dataRead, ",");

                while (cadParticion.hasMoreElements()) {
                        data.add(cadParticion.nextElement().toString());
                    }

                br.close();

            }catch (FileNotFoundException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
            }

            return data.get(2);
        }
    }
    
    /**
     * MÉTODO QUE RECUPERA LAS CALIFICACIONES DEL ALUMNO DE LA BASE DE DATOS.
     * REQUIERE COMO PARAMETROS EL NOMBRE DE USUARIO (STRING) Y SEMESTRE (INT), RETORNA UN ARREGLO INT[][] CON LAS CALIFICACIONES.
     * @param user String
     * @param semestre int
     * @return calificaciones INT[][]
     */
   public static int[][] getCalificaciones(String user, int semestre){
        ArrayList <String> data = new ArrayList <>();
        int[][] calificaciones = new int[semestre][5];
        int cont = 0;
        
        try{           
            BufferedReader br = new BufferedReader(new FileReader(URL_ALU + user + "\\" + user + "_Academico.csv"));
            String dataRead = br.readLine();
            
            
            while (cont < semestre) {
                StringTokenizer cadParticion = new StringTokenizer(dataRead, ",");
                
                while (cadParticion.hasMoreElements()) {
                    data.add(cadParticion.nextElement().toString());
                }
                
                for (int i = 0; i < data.size() - 1; i++) {
                    calificaciones[cont][i] = Integer.parseInt(data.get(i+1));
                }
                data.clear();
                dataRead = br.readLine();
                cont += 1;
                
            }
            br.close();
            
            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return calificaciones;
   }
    
   /**
    * MÉTODO QUE QUE RECUPERA TODOS LOS DATOS DE UN ALUMNO.
    * REQUIERE UN NOMBRE DE USUARIO DEL ALUMNO, UNA VEZ CON ESTO, BUSCA LOS DATOS EN LA BASE DE DATOS E INICIALIZA UN OBJETO ALUMNO
    * CON LOS DATOS RECUPERADOS DE LA BASE DE DATOS, FINALMENTE RETORNA ESTE OBJETO INICIALIZADO DE TIPO 'Alumno'.
    * @param user
    * @return alumno Alumno
    */
    public static Alumno busquedaAlumno(String user){
        ArrayList <String> data = new ArrayList <>();
        Alumno alumno = new Alumno();
        
        try{           
            BufferedReader br = new BufferedReader(new FileReader(URL_ALU + user + "\\" + user + "_Personal.csv"));
            String dataRead = br.readLine();
            StringTokenizer cadParticion = new StringTokenizer(dataRead, ",");
            
            while (cadParticion.hasMoreElements()) {
                data.add(cadParticion.nextElement().toString());
            }
            

            br.close();
            
            alumno.setNombre(data.get(0));
            alumno.setNumCuenta(Integer.parseInt(data.get(1)));
            alumno.setCarrera("INGENIERIA EN COMPUTACION");
            alumno.setEdad(Integer.parseInt(data.get(3)));
            alumno.setSemestre(Integer.parseInt(data.get(4)));
            alumno.setPromedio(Float.parseFloat(data.get(5)));
            alumno.setNumInscripcion(Integer.parseInt(data.get(6)));
            alumno.setVelocidad(Float.parseFloat(data.get(7)));
            alumno.setEscolaridad(Float.parseFloat(data.get(8)));
            alumno.setIndEscolar(Float.parseFloat(data.get(9)));
            alumno.setUsername(data.get(10));
            alumno.setPassword(data.get(11));
            alumno.setDireccion(data.get(12));
            alumno.setCalificaciones(getCalificaciones(data.get(1), Integer.parseInt(data.get(4))));
            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return alumno;
    }
    
    /**
     * MÉTODO QUE QUE RECUPERA TODOS LOS DATOS DE UN AMINISTRADOR.
     * REQUIERE UN NOMBRE DE USUARIO DEL ADMINISTRADOR, UNA VEZ CON ESTO, BUSCA LOS DATOS EN LA BASE DE DATOS E INICIALIZA UN OBJETO ADMINISTRADOR
     * CON LOS DATOS RECUPERADOS DE LA BASE DE DATOS, FINALMENTE RETORNA ESTE OBJETO INICIALIZADO DE TIPO 'Administrador'.
     * @param user
     * @return administrador Administrador
     */
     public static Administrador busquedaAdministrador(String user){
        ArrayList <String> data = new ArrayList <>();
        Administrador administrador = new Administrador();
        
        try{           
            BufferedReader br = new BufferedReader(new FileReader(URL_ADM + user + ".csv"));
            String dataRead = br.readLine();
            StringTokenizer cadParticion = new StringTokenizer(dataRead, ",");
            
            while (cadParticion.hasMoreElements()) {
                data.add(cadParticion.nextElement().toString());
            }
            

            br.close();
            
            administrador.setNombre(data.get(0));
            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return administrador;
    }
     
     /**
      * MÉTODO QUE DETECTA EL TIPO DE USUARIO QUE DESEA ACCEDER.
      * REQUIERE UN NOMBRE DE USUARIO (STRING), CON BASE EN EL HACE UNA BUSQUEDA EN LAS BASES DE DATOS Y RETORNA TRUE SI EL USUARIO ES ENCONTRADO EN 
      * LA BASE DE DATOS DE ALUMNOS, O FALSE SI SE ENCUENTRA EN ADMINISTRADOR.
      * @param user
      * @return boolean
      */
    public static boolean detectarUser(String user){
        String[] alums = new File(URL_ALU).list();
        String[] adms = new File(URL_ADM).list();
        
        for (String alum : alums) {
            if (user.equals(alum)) {
                return true;
            }
        }
        
        for (String admn : adms) {
            if (user.equals(admn)) {
                return false;
            }
        }
        return false;
    }
    
    public static void deleteAlumno(File file){
        if (file.isDirectory()) {
            for(File f: file.listFiles()){
                deleteAlumno(f);
            }
        }
        
        file.delete();
    }
    
    /**
     * MÉTODO QUE GENERA EL NUMERO DE INSCRIPCION.
     * REQUIERE UN ARRAYLIST DE ALUMNOS, EL MÉTODO GENERARÁ UN NUMERO DE INSCRIPCION A CADA ALUMNO EN EL ARRAY. EL MÉTODO IMPLEMENTA EL 
     * ALGORITMO DE LA FACULTAD DE INGENIERIA.
     * @param alumnos 
     */
    public static void numerosInscripcion (ArrayList alumnos){
        
        alumnos=sort(alumnos);

        for (int i = 0; i < alumnos.size(); i++) {
            
            Alumno temp = (Alumno) alumnos.get(i);
            temp.setNumInscripcion(alumnos.size()-i); 
        }

        try{
            Thread.sleep(1000);
        } catch (Exception e){
            System.out.println("error");
        }   
    }
    
    public static ArrayList<Alumno> sort(ArrayList<Alumno> a){
        if(a.size()<=0)
           return a;
        ArrayList<Alumno> smaller = new ArrayList<>();
        ArrayList<Alumno> greater = new ArrayList<>();
        Alumno pivot = a.get(0);
        for(int i=1; i<a.size(); i++)
           {
            Alumno n=a.get(i);
            if(n.getIndEscolar() < pivot.getIndEscolar())
               smaller.add(n);
            else
               greater.add(n);
           }
        smaller=sort(smaller);
        greater=sort(greater);
        smaller.add(pivot);
        smaller.addAll(greater);
        return smaller;
    }

    public static int asignarNumCuenta() {
        System.out.print("INGRESA NUM. DE CUENTA: ");
        int numCuenta = 0;
        try {
            numCuenta = new Scanner(System.in).nextInt();
        }
        catch(Exception e) {
            System.out.println("Conflicto de tipos. Vuelva a intentar");
            numCuenta=asignarNumCuenta();
        }
        return numCuenta;
    }
}
