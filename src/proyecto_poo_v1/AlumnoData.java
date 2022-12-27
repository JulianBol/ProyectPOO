/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_poo_v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bolys
 */
public class AlumnoData {

    public AlumnoData() {
    }
    
    public String generarNombresAleatorios() {
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
                
                
		return nombresAleatorios;
    }
      
    
    private String[] getDirecciones(){
        int numDirecciones = 0, count = 0;
        String direccion = "";
        String[] direcciones = new String[1000];
        
        try{           
            // Aquí usamos Tokenizer para Tokenizar los Elementos Leidos del Archivo
            BufferedReader br = new BufferedReader(new FileReader("datosDirecciones_1.csv"));
            String dataRead = br.readLine();
            StringTokenizer cadParticion = new StringTokenizer(dataRead, ",");
            
            numDirecciones = 0;
            while (numDirecciones < 1000){
                //System.out.println("\n" + dataRead);
                while (cadParticion.hasMoreElements()){
                    if(count == 2){
                        direccion += "NÚM. " + cadParticion.nextElement().toString() + ", ";
                    }
                    else if(count == 6){
                        direccion += cadParticion.nextElement().toString() + ", ALCALDIA ";
                    }
                    else if(count != 5){
                        direccion += cadParticion.nextElement().toString() + " ";
                    }
                    else{
                        direccion += "C.P. " + cadParticion.nextElement().toString() + ", ";
                    }
    
                    count += 1;
                }
                count = 0;
                //System.out.println(direccion);
                direcciones[numDirecciones] = direccion;
                direccion = "";
                numDirecciones += 1;
                dataRead = br.readLine();
                cadParticion = new StringTokenizer(dataRead, ",");
            }
            
            br.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlumnoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return direcciones;
    }
    
    
    public String generadorDireccion(){
        String[] direcciones = getDirecciones();
        return direcciones[(int)(Math.random() * ((1000 - 1) + 1)) + 1];
    }
    
    
    public int generadorEdad(){
        return (int)(Math.random() * ((27 - 18) + 1)) + 18;
    }
    
    
    public int generadorNumCuenta(){
        return (int)(Math.random() * ((400000000 - 200000000) + 1)) + 200000000;
    }
    
    
    public int generadorSemestre(int edad){
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
}
/**
 * RELACION EDAD - SEMESTRE
 * 18 - 1°
 * 19 - 2°, 3°
 * 20 - 4°, 5°
 * 21 - 6°, 7°
 * 22 - 8°, 9°
 * 23 - 10° 
 */