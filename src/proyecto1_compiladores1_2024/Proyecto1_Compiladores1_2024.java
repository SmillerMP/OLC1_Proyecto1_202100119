/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1_compiladores1_2024;

/**
 *
 * @author samuel
 */


import java.io.*;



import Analizadores.Sintactico;
import Analizadores.Lexico;
import Clases.Errores;


import java.io.BufferedReader;
import java.io.StringReader;


public class Proyecto1_Compiladores1_2024 {
    /**
     * @param args the command line arguments
     * 
     * 
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String Texto = """
                       <! hola es es un comentario !>
                       
                       !prueba 1
                       
                       PROGRAM
                       
                       var:double:: numero <- 2.5 end;

                                    
                       END PROGRAM
                       
                       ! prueba 2
                       
                       """;

        Analizadores.Sintactico parser;
        try {
            parser = new Analizadores.Sintactico(new Analizadores.Lexico(new BufferedReader(new StringReader(Texto))));
            parser.parse(); 
            
            System.out.println("Hola");
            Funciones.reporteTokens();
 

            
            
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
        }      
       
        System.out.println(Sintactico.variablesDeclaradas);

        
        
        
        
    }
      
}
