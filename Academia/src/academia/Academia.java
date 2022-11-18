/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academia;

import academia.controller.GestorDB;

/**
 *
 * @author Pablo
 */
public class Academia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorDB gestorDB = new GestorDB();
        System.out.println(gestorDB.getAllCursos());
    }
    
}
