/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_poo_v1;

/**
 *
 * @author bolys
 */
public class Usuario {
    private String username, password;

    public Usuario() {
    }

    /**
     * CONSTRUCTOR.
     * @param username
     * @param password 
     */
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * RETORNA EL USERNAME DE UN ALUMNO O ADMINISTRADOR SEGUN SEA EL CASO.
     * @return usernam STRING
     */
    public String getUsername() {
        return username;
    }

    /**
     * ESTABLECE EL USERNAME DE UN ALUMNO O ADMINISTRADOR SEGUN SEA EL CASO.
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * RETORNA EL PASSWORD DE UN ALUMNO O ADMINISTRADOR SEGUN SEA EL CASO.
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * ESTABLECE EL PASSWORD DE UN ALUMNO O ADMINISTRADOR SEGUN SEA EL CASO.
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
