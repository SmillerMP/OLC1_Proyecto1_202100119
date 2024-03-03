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
        
        GUI gui = new GUI();
        gui.setVisible(true);
        
//        
//        String Texto = """
//                        PROGRAM
//                        	! Variables
//                        	var:double:: notaAprobar <- 61 end;
//                        	var:char[]:: labelAprobar <- "Nota Minima" end;
//                        	
//                        	! Arreglos
//                        	arr:double:: @notas <- [notaAprobar, MUL(75, 0.45), DIV(SUM(80,20), RES(75,25))] end;
//                        	arr:char[]:: @labels <- [labelAprobar, "P1", "P2"] end;
//                        	
//                        	!Prints
//                        	var:char[]:: titulo1 <- "Titulo histograma" end;
//                        	console::column = "test" -> [10, 15.5, 61.1] end;
//                        	console::column = "Notas" -> @notas end;
//                        	console::column = titulo1 -> @labels end;
//                        	
//                        	console::print = "Media", "Mediana", "Moda", "Varianza", "Max", "Min" end;
//                        	console::print = Media(@notas), Mediana(@notas), Moda(@notas), Varianza(@notas), Max(@notas), Min(@notas) end;
//                        	console::print = "Hola Mundo", MOD(10, 9), notaAprobar, labelAprobar end;
//                        	
//                        	<! FELICIDADES
//                        		Lo de arriba ya es medio proyecto
//                        		Tu puedes !>
//                        	
//                        	var:double:: gb1 <- 61 end;
//                        	var:char[]:: gbt <- "Datos" end;
//                        	graphBar(
//                        		!grafica 1
//                        		tituloX::char[] = "Actividades" end;
//                        		tituloY::char[] = gbt end;
//                        		titulo::char[] = "Estudiantes" end;
//                        		ejeX::char[] = ["1 Parcial", "2 parcial", "Final"] end;
//                        		ejeY::double = [gb1, 30, 70] end;
//                        		EXEC graphBar end;
//                        	) end;
//                        	
//                        	graphPie(
//                        		<! FELICIDADES
//                        		La de pie es facil !>
//                        	
//                        		label::char[] = ["Uno", "Dos", "Tres"] end;
//                        		titulo::char[] = "Ejemplo Gráfica de Pie" end;
//                        		values::double = [50, 30, 20] end;
//                        		EXEC graphPie end;
//                        	) end;
//                        	
//                        	
//                        	graphLine(
//                        	!testing de variables en graficas
//                        		titulo::char[] = "Gráfica de Línea" end;
//                        		ejeX::char[] = @labels end;
//                        		ejeY::double = @notas end;
//                        		tituloX::char[] = "Actividades" end;
//                        		tituloY::char[] = "Notas" end;
//                        		EXEC graphLine end;
//                        	) end;
//                        	
//                        	Histogram(
//                        		titulo::char[] = titulo1 end;
//                        		values::char[] = [2,2,2,5,5,7,8] end;
//                        		EXEC Histogram end;
//                        	) end;
//                        	
//                        <! En las graficas los datos se declaran directamente o por medio de variables
//                        Buena suerte
//                        Deben generar todas las graficas en una ejecucion
//                         !>
//                        
//                        END PROGRAM
//                       
//                       """;
//
//        
//        //System.out.println(Sintactico.variablesDeclaradas);
//        
//        System.out.println("------------------\n");
////        Sintactico.variablesDeclaradas.entrySet().forEach(
////            entry -> { System.out.println(entry.getKey() + " = " + entry.getValue()); });
//  
//        //System.out.println(Sintactico.listaDatosTemp);
             
        
    }   
}