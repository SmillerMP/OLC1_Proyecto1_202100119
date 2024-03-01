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



import org.jfree.chart.JFreeChart;
import org.jfree.JCommon;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartUtilities;




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
                        ! Variables
                        var:double:: notaAprobar <- 61 end;
                        var:char[]:: labelAprobar <- "Nota Minima" end;

                        ! Arreglos
                        arr:double:: @notas <- [notaAprobar, MUL(75, 0.45), DIV(SUM(80,20), RES(75,25))] end;
                        arr:char[]:: @labels <- [labelAprobar, "P1", "P2"] end;

                        !Prints
                        var:char[]:: titulo1 <- "Titulo histograma" end;

                        <! FELICIDADES
                                Lo de arriba ya es medio proyecto
                                Tu puedes !>

                        var:double:: gb1 <- 61 end;
                        var:char[]:: gbt <- "Datos" end;
                        graphBar(
                                !grafica 1
                                tituloX::char[] = "Actividades" end;
                                tituloY::char[] = gbt end;
                                titulo::char[] = "Estudiantes" end;
                                ejeX::char[] = ["1 Parcial", "2 parcial", "Final"] end;
                                ejeY::double = [gb1, 30, 70] end;
                                EXEC graphBar end;
                        ) end;                        
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
//        Sintactico.variablesDeclaradas.entrySet().forEach(
//            entry -> { System.out.println(entry.getKey() + " = " + entry.getValue()); });
  
        //System.out.println(Sintactico.listaDatosTemp);
             
        
    }   
}