/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package centrodesalud;

import controller.GestorDB;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Pablo
 */
public class CentroDeSalud {
    
    
   

    public static void main(String[] args) {
        GestorDB gestorDB = new GestorDB();
        System.out.println(gestorDB.promedioDuracionVisitas());
    }
    
}
