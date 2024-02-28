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
import java.util.ArrayList;
import java.util.Collections;



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

                        ! Ejemplos
                        var:double:: b <- 5 end;
                        var:double:: a <- 3 end;
                        var:double:: numero <- 2.5 end;
                        var:double:: variable <- 7 end;
                        var:char[]:: cadena <- "cadena" end;
                        var:double:: copia <- numero end; ! copia tiene el valor 2.5

                        ! Operaciones
                        var:double:: suma <- SUM(5, 2) end;
                        var:double:: resta <- RES(3, 2) end;
                        var:double:: multi <- MUL(4, numero) end; ! Funciona con variables
                        var:double:: division <- DIV(1, variable) end;
                        var:double:: modulo <- MOD(5, 4) end;

                        var:double:: suma2 <- MUL( SUM(7,multi) , RES(7, DIV(25,5) )) end;

                        arr:double::@darray <- [1, 2, 3, 4, 5] end; 
                        arr:double::@carray <- [numero, copia, 7] end;

                        arr:double::@test2 <- [ SUM(7,3), DIV(25,5)] end; 
                        var:double:: med1 <- Media([1, 2, SUM(3, b), 4, a]) end;
                        var:double:: med2 <- Media( @darray ) end;

                        arr:double::@arreglo <- [Media([1, 2, SUM(3, b), 4, a]), Media(@darray)] end;
                        var:double:: mitad <- DIV( SUM(Media(@arreglo), Media(@darray) ), 2) end;

                        var:double:: max1 <- Max( @darray ) end;
                        var:double:: min1 <- Min( @darray ) end;
                        
                        var:double:: min2 <- Min([33,-6,2,45,3,6,8,2,0,4,-5,2,6]) end;
                        var:double:: max2 <- Max([33,-6,2,45,3,6,8,2,0,4,-5,2,6]) end;
                        var:double:: mediana1 <- Mediana([33,-6,2,45,3,6,8,2,0,4,-5,2,6]) end;
                        var:double:: mediana2 <- Mediana([55,6,8,2,555,4,-5,2]) end;
                       
                        var:double:: testMedia <- Media([33,-6,2,45,3,6,8,2,0,4,-5,2,6]) end;    
                        var:double:: testModa <- Moda([33,-6,2,45,3,6,8,2,0,4,1,1,-5,2,6]) end;  
                        var:double:: Varianzaaassss <- Varianza([33,-6,2,45,3,6,8,2,0,4,1,1,-5,2,6]) end;                     
                                                             
                                                                                                    


                        END PROGRAM

                        ! prueba 2
                       
                       """;

        Analizadores.Sintactico parser;
        try {
            parser = new Analizadores.Sintactico(new Analizadores.Lexico(new BufferedReader(new StringReader(Texto))));
            parser.parse(); 
            
            Funciones.reporteTokens();
 

            
            
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
        }      
        
        //System.out.println(Sintactico.variablesDeclaradas);
        
        System.out.println("------------------\n");
        Sintactico.variablesDeclaradas.entrySet().forEach(
            entry -> { System.out.println(entry.getKey() + " = " + entry.getValue()); });
  
        //System.out.println(Sintactico.listaDatosTemp);
        
        
        System.out.println(Sintactico.variablesDeclaradas.get("arreglo"));
        
        
    }
      
}
