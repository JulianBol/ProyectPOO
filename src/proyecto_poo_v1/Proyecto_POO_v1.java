/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_poo_v1;

/**
 *
 * @author bolys
 */
public class Proyecto_POO_v1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        AlumnoData prue = new AlumnoData();
        System.out.println(prue.generarNombresAleatorios());
        System.out.println(prue.generadorEdad());
        System.out.println(prue.generadorDireccion());
        System.out.println(prue.generadorNumCuenta());
        System.out.println(prue.generadorSemestre(24));
        
        
    }
    
}
