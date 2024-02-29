/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_compiladores1_2024;

import Clases.Tokens;
import Clases.Errores;
import Analizadores.Sintactico;
        
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author samuel
 */
public class Funciones {
    
    public static void ImprimirColumnaArreglo(ArrayList arreglo, Object nombre) {
        ArrayList<Double> listaTemp = new ArrayList<>(); 
        for (Object numero : arreglo) {
            listaTemp.add(Double.parseDouble(numero.toString()));
        }
        
        String TextoSalida = "";
        
        TextoSalida += "---------------- \n" + nombre.toString() + "\n---------------- \n";
        
        for (Object dato : listaTemp) {
            TextoSalida += dato.toString() + "\n";
        }
        
        TextoSalida += "\n";
        System.out.println(TextoSalida);
    }
    
    public static void ImprimirColumna(Object nombre) {
        ArrayList<Object> copiaListaDatosTemp = new ArrayList<>(Sintactico.listaDatosTemp); 
        Sintactico.listaDatosTemp.clear();
        String TextoSalida = "";
        
        TextoSalida += "---------------- \n" + nombre.toString() + "\n---------------- \n";
        
        for (Object dato : copiaListaDatosTemp) {
            TextoSalida += dato.toString() + "\n";
        }
        
        TextoSalida += "\n";
        System.out.println(TextoSalida);
    }
    
    public static void ImprimirConsola(){
        ArrayList<Object> copiaListaDatosTemp = new ArrayList<>(Sintactico.listaDatosTemp); 
        Sintactico.listaDatosTemp.clear();
        String TextoSalida = "";
        
        TextoSalida += "! Salida: ";
        
        for (int i =0; i < copiaListaDatosTemp.size(); i++){
            if (i == copiaListaDatosTemp.size() - 1) {
                TextoSalida += copiaListaDatosTemp.get(i).toString();
            } else {
                TextoSalida += (copiaListaDatosTemp.get(i).toString() + ", ");
            }
        }
        
        TextoSalida += "\n";
        System.out.println(TextoSalida);

    }
    
    // Busca en el hashmap la lista correspondiente a la clave
    public static ArrayList busquedaLista(Object key) {
        return (ArrayList<Object>) Sintactico.variablesDeclaradas.get(key);
    }

    // Funcion para copiar el ArrayList original
    public static ArrayList copiaLista(){
        
        ArrayList<Object> copiaListaDatosTemp = new ArrayList<>(Sintactico.listaDatosTemp); 
        Sintactico.listaDatosTemp.clear();
        return copiaListaDatosTemp;
    }
    
    public static double estadisticas(ArrayList arreglo, String funcion){
        ArrayList<Double> listaTemp = new ArrayList<>(); 
        for (Object numero : arreglo) {
            listaTemp.add(Double.parseDouble(numero.toString()));
        }
        
        if (funcion.equals("MEDIA")) {
            double suma = 0;
            for (double numero : listaTemp) {
                suma += numero;
            }
            
            double media = (double) suma / listaTemp.size();
            return media;
           
        } else if (funcion.equals("MEDIANA")){
            double resultado = 0;
            
            Collections.sort(listaTemp);
            //System.err.println(listaTemp);
            //System.err.println(listaTemp.size());
            int tamanoLista = listaTemp.size();
            
            if ((tamanoLista % 2) == 0) {
                // Realiza la operacion para cuando el arreglo es par
                double operar = ((listaTemp.get((tamanoLista/2)-1)) + (listaTemp.get(tamanoLista/2) )) / 2;
                //System.err.println(operar);
                resultado = operar;
            } else {
                //System.err.println(listaTemp.get(tamanoLista/2));
                resultado = listaTemp.get(tamanoLista/2);
            }
            
            return resultado;
            
        // Funcion para la Moda
        } else if (funcion.equals("MODA")){
            int repeticion = 0;
            int cantidadRepeticon = 0;
            double queDato = 0;
            double datoEtregar = 0;
            
            Collections.sort(listaTemp);
            
            for (double numero : listaTemp) {
                if (numero == queDato){                   
                    repeticion++;
                } else {
                    repeticion = 1;
                    queDato = numero;
                }
                
                if(repeticion > cantidadRepeticon) {
                    cantidadRepeticon = repeticion;
                    datoEtregar = numero;
                }          
            }
            return datoEtregar;
        
        } else if (funcion.equals("VARIANZA")) {
            double suma = 0;
            double resultado = 0;
            for (double numero : listaTemp) {
                suma += numero;
            }
            double media = (double) suma / listaTemp.size();
            
            //System.err.println("media--> "+ media);
            //System.err.println("tamano--> "+ listaTemp.size());
            
            for (double numero : listaTemp) {
                
                double operacion = Math.pow((numero - media),2);
                //System.out.println(operacion);
                resultado += operacion;
            } 
            
            return resultado/(listaTemp.size() - 1);
            
        // Funcion para numero mayor    
        } else if (funcion.equals("MAX")){
            double resultado = 0;
            boolean primero = true;
            for (double numero : listaTemp){
                if (numero > resultado || primero == true)
                    resultado = numero;
                    primero = false;
            }
            
            return resultado;
        } else if (funcion.equals("MIN")){
            double resultado = 0;
            boolean primero = true;
            for (double numero : listaTemp){
                if (numero < resultado || primero == true)
                    resultado = numero;
                    primero = false;
            }
            
            return resultado;
        } 
        return 0;
    }
    
    
    public static double operaciones(Object valor1, Object valor2, String operacion) {
        
        //System.err.println(valor1 + " | " + valor2);
        
        try {
            double val1 = Double.parseDouble(valor1.toString());
            double val2 = Double.parseDouble(valor2.toString());
            
            if (operacion.equals("SUM")) {
                return val1 + val2;
            } else if (operacion.equals("RES")) {
                return val1 - val2;
            } else if (operacion.equals("MUL")) {
                return val1 * val2;
            } else if (operacion.equals("DIV")) {
                return val1 / val2;
            } else if (operacion.equals("MOD")) {
                return val1 % val2;
            } else {
                throw new IllegalArgumentException("Operación no válida: " + operacion);
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Error al sumar los valores");
        }
        
    }
    
    
    public static void reporteTokens() {
        File carpeta = new File("./Reportes");
        if (!carpeta.exists()) {
            carpeta.mkdirs(); // Crea la carpeta y sus subcarpetas si no existen
        }

        File archivo = new File("./Reportes/Tokens.html");

        FileWriter Escribir;
        PrintWriter NuevaLinea;
        archivo.delete();
        if (!archivo.exists()) {

            try {

                archivo.createNewFile();
                Escribir = new FileWriter(archivo, true);

                NuevaLinea = new PrintWriter(Escribir);
                NuevaLinea.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "    <meta charset='utf-8'>\n"
                        + "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n"
                        + "    <title>Tokens</title>\n"
                        + "    <meta name='viewport' content='width=device-width, initial-scale=1'>\n"
                        + "    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>\n"
                        + "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Arial\">\n"
                        + "    <script src='main.js'></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body style=\"background-color: rgb( 90, 24, 47); font-family: 'Arial', sans-serif;\">");

                NuevaLinea.println("<center><h1>Reporte de Tokens</h1></center>\n");

                NuevaLinea.println("<center>");
                NuevaLinea.println("<style type=\"text/css\">\n"
                        + "            .tg  {border-collapse:collapse;border-spacing:0;}\n"
                        + "            .tg  {background-color: #f75120;}\n"
                        + "            .tg td{border-color:rgb(0, 0, 0);border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n"
                        + "              overflow:hidden;padding:10px 5px;word-break:normal;}\n"
                        + "            .tg th{border-color:rgb(0, 0, 0);border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n"
                        + "              font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}\n"
                        + "            .tg .tg-0pky{border-color:inherit;text-align:center;vertical-align:top;font-weight:bold;font-weight:800}\n"
                        + "            .tg .tg-0lax{text-align:center;vertical-align:top}\n"
                        + "            </style>\n"
                        + "            <table class=\"tg\">\n"
                        + "            <thead>\n"
                        + "              <tr>\n"
                        + "                <b> \n"
                        + "                    <th class=\"tg-0pky\">#</th>\n"
                        + "                    <th class=\"tg-0pky\">Lexema</th>\n"
                        + "                    <th class=\"tg-0pky\">Token<br></th>\n"
                        + "                    <th class=\"tg-0pky\">Linea</th>\n"
                        + "                    <th class=\"tg-0pky\">Columna<br></th>\n"
                        + "                </b>\n"
                        + "              </tr>\n"
                        + "            </thead>");
                NuevaLinea.println("<tbody>");
                
                int indice = 0;
                while (indice < Analizadores.Lexico.listaTokens.size()) {
                    Tokens tokens = Analizadores.Lexico.listaTokens.get(indice);
                    if (tokens != null) {
                        NuevaLinea.println("<tr>");
                        
                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(indice + 1);
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(tokens.getToken());
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(tokens.getLexema());
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(tokens.getLinea());
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(tokens.getColumna());
                        NuevaLinea.println("</th>");

                        NuevaLinea.println("</tr>");
                        
                        indice++;
                    }
                }

                NuevaLinea.println("</tbody>");
                NuevaLinea.println("</table>");
                NuevaLinea.println("</center>");
                NuevaLinea.println("<br>\n"
                        + "  <br>\n"
                        + "  <br>");
               

                NuevaLinea.println("</body>\n"
                        + "</html>");

                Escribir.close();
                //JOptionPane.showMessageDialog(null, "El Reporte se creo Satisfactoriamente", "Creacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
            }    
        }
    }
    
    
    
    public static void reporteErrores() {
        File carpeta = new File("./Reportes");
        if (!carpeta.exists()) {
            carpeta.mkdirs(); // Crea la carpeta y sus subcarpetas si no existen
        }

        File archivo = new File("./Reportes/Errores.html");

        FileWriter Escribir;
        PrintWriter NuevaLinea;
        archivo.delete();
        if (!archivo.exists()) {

            try {

                archivo.createNewFile();
                Escribir = new FileWriter(archivo, true);

                NuevaLinea = new PrintWriter(Escribir);
                NuevaLinea.println("<!DOCTYPE html>\n"
                        + "<html>\n"
                        + "<head>\n"
                        + "    <meta charset='utf-8'>\n"
                        + "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>\n"
                        + "    <title>Errores Lexicos</title>\n"
                        + "    <meta name='viewport' content='width=device-width, initial-scale=1'>\n"
                        + "    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>\n"
                        + "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Arial\">\n"
                        + "    <script src='main.js'></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body style=\"background-color: rgb(77, 201, 218); font-family: 'Arial', sans-serif;\">");

                NuevaLinea.println("<center><h1>Reporte de Errores Lexicos</h1></center>\n");

                NuevaLinea.println("<center>");
                NuevaLinea.println("<style type=\"text/css\">\n"
                        + "            .tg  {border-collapse:collapse;border-spacing:0;}\n"
                        + "            .tg  {background-color: #eaf5c3;}\n"
                        + "            .tg td{border-color:rgb(0, 0, 0);border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n"
                        + "              overflow:hidden;padding:10px 5px;word-break:normal;}\n"
                        + "            .tg th{border-color:rgb(0, 0, 0);border-style:solid;border-width:1px;font-family:Arial, sans-serif;font-size:14px;\n"
                        + "              font-weight:normal;overflow:hidden;padding:10px 5px;word-break:normal;}\n"
                        + "            .tg .tg-0pky{border-color:inherit;text-align:center;vertical-align:top;font-weight:bold;font-weight:800}\n"
                        + "            .tg .tg-0lax{text-align:center;vertical-align:top}\n"
                        + "            </style>\n"
                        + "            <table class=\"tg\">\n"
                        + "            <thead>\n"
                        + "              <tr>\n"
                        + "                <b> \n"
                        + "                    <th class=\"tg-0pky\">#</th>\n"
                        + "                    <th class=\"tg-0pky\">Tipo de Error</th>\n"
                        + "                    <th class=\"tg-0pky\">Descripcion<br></th>\n"
                        + "                    <th class=\"tg-0pky\">Linea</th>\n"
                        + "                    <th class=\"tg-0pky\">Columna<br></th>\n"
                        + "                </b>\n"
                        + "              </tr>\n"
                        + "            </thead>");
                NuevaLinea.println("<tbody>");

                int indice = 0;
                while (indice < Analizadores.Lexico.listaErrores.size()) {
                    Errores errorLec = Analizadores.Lexico.listaErrores.get(indice);
                    if (errorLec != null) {
                        NuevaLinea.println("<tr>");
                        
                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(indice + 1);
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(errorLec.getTipo());
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(errorLec.getDescripcion());
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(errorLec.getLinea());
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(errorLec.getColumna());
                        NuevaLinea.println("</th>");

                        NuevaLinea.println("</tr>");
                        
                        indice++;
                    }
                }

                NuevaLinea.println("</tbody>");
                NuevaLinea.println("</table>");
                NuevaLinea.println("</center>");
                NuevaLinea.println("<br>\n"
                        + "  <br>\n"
                        + "  <br>");
               

                NuevaLinea.println("</body>\n"
                        + "</html>");

                Escribir.close();
                //JOptionPane.showMessageDialog(null, "El Reporte se creo Satisfactoriamente", "Creacion Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
            }    
        }
    }
   
    
}
