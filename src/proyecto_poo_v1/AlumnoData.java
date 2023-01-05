/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyecto_poo_v1;

/**
 *
 * @author bolys
 */
public interface AlumnoData {
        /**
         * VARIABLE DEL TIPO STRING[][] QUE ALMACENA EL NOMBRE DE LAS MATERIAS EXISTENTES EN LA CARRERA.
         */
        String MATERIAS[][] = { 
        {"ALGEBRA","PROGRAMACION","CyGA","FISICA","QUIMICA"},
        {"ALGEBRA II","CALCULO II","MECANICA","RETI","EDA I"},
        {"EC. DIFERENCIALES","POO","EDA II","CALCULO II","PROBABILIDAD"},
        {"ESTADISTICA","ELECTRICIDAD","A. NÚMERICO","MATEMATICAS A.","ESTRUCTURAS D."},
        {"EyPC","DISPOSITIVOS E.","LENGUAJES FORMALES","SEÑALES","SOFTWARE"},
        {"SISTEMAS OP","DDM","BASES DE DATOS","CIRCUITOS","ADMINISTRACION DE PROYECTOS"},
        {"FINANZAS","DD VLSI","IA","COMPILADORES","SISTEMAS C."},
        {"OPTATIVA CSyH","MICROCOMPUTADORAS","COMPUTACION GRAFICA","ETICA","REDES DE DATOS"},
        {"ARQ COMPUTADORAS","SISTEMAS EMBEBIDOS","SISTEMAS DISTRIBUIDOS","OPTATIVA","RECURSOS MEXICO"},
        {"OPTATIVA I","OPTATIVA II","OPTATIVA III","OPTATIVA IV","OPTATIVA V"}};
        
        /**
         * VARIABLE DEL TIPO INT[][] QUE ALMACENA LOS CREDITOS DE CADA MATERIA EN LA CARRERA.
         */
        int CREDITOS[][] = {{2,8,3,12,4},{4,2,6,4,8},{6,8,3,6,5},{2,4,6,6,4},{10,2,2,2,4},
                                    {4,3,4,2,8},{8,6,9,2,2},{7,6,4,2,8},{8,8,4,4,6},{8,6,4,3,2}};
        
        
        /**
         * DIRECCION DE ARCHIVOS DONDE SE ALMACENARAN LOS ARCHIVOS GENERADOS POR EL PROGRAMA.
         */
        String URL_GEN = "C:\\Users\\bolys\\Desktop\\FI - 3er Semestre\\POO\\PROYECTO\\Proyecto_POO_v1\\DATA\\";
        
        /**
         * DIRECCION DE ARCHIVOS DONDE SE ALMACENARAN LOS ARCHIVOS DE ALUMNO GENERADOS POR EL PROGRAMA.
         */
        String URL_ALU = "C:\\Users\\bolys\\Desktop\\FI - 3er Semestre\\POO\\PROYECTO\\Proyecto_POO_v1\\DATA\\ALUMNO\\";
        
        /**
         * DIRECCION DE ARCHIVOS DONDE SE ALMACENARAN LOS ARCHIVOS DE ADMINISTRADOR.
         */
        String URL_ADM = "C:\\Users\\bolys\\Desktop\\FI - 3er Semestre\\POO\\PROYECTO\\Proyecto_POO_v1\\DATA\\ADMINISTRADOR\\";
        
}
