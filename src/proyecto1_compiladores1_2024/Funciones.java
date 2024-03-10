/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_compiladores1_2024;

import Clases.Tokens;
import Clases.Errores;
import Clases.Simbolos;
import Analizadores.Sintactico;
import proyecto1_compiladores1_2024.GUI;
        
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
    
    public static String textoArrelgo = "";
    
    public static String nombreVariable(Object nombre) {
        String nombreLower = "";
        try {
            nombreLower = nombre.toString().toLowerCase();
        } catch (Exception e) {
        }
        
        return nombreLower;
    }
    
    public static void ImprimirColumnaArreglo(ArrayList arreglo, Object nombre) {        
        String TextoSalida = "";
        
        TextoSalida += "---------------- \n" + nombre.toString() + "\n---------------- \n";
        
        for (Object dato : arreglo) {
            TextoSalida += dato.toString() + "\n";
        }
        
        //System.out.println(TextoSalida);
        
        GUI.texto_consola += TextoSalida;
        GUI.texto_consola += "\n";
    }
    
    public static void ImprimirColumna(Object nombre) {
        ArrayList<Object> copiaListaDatosTemp = new ArrayList<>(Sintactico.listaDatosTemp); 
        Sintactico.listaDatosTemp.clear();
        String TextoSalida = "";
        
        TextoSalida += "---------------- \n" + nombre.toString() + "\n---------------- \n";
        
        for (Object dato : copiaListaDatosTemp) {
            TextoSalida += dato.toString() + "\n";
        }
        
        //System.out.println(TextoSalida);
        GUI.texto_consola += TextoSalida;
        GUI.texto_consola += "\n";
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
        //System.out.println(TextoSalida);
        GUI.texto_consola += TextoSalida;
        GUI.texto_consola += "\n";

    }
    
    // Busca en el hashmap la lista correspondiente a la clave
    public static ArrayList busquedaLista(Object key) {
        return (ArrayList<Object>) Sintactico.variablesDeclaradas.get(key);
    }

    // Funcion para copiar el ArrayList original
    public static ArrayList copiaLista(){
        textoArrelgo = "[";
        ArrayList<Object> copiaListaDatosTemp = new ArrayList<>();
        try {
            copiaListaDatosTemp = new ArrayList<>(Sintactico.listaDatosTemp);           
            int indice = 0;
            while (indice < copiaListaDatosTemp.size()){      
                if (indice == copiaListaDatosTemp.size() - 1) {
                    textoArrelgo += copiaListaDatosTemp.get(indice).toString() + "]";

                } else {
                    textoArrelgo += copiaListaDatosTemp.get(indice).toString() + ", ";
                }            
                indice++;
            }

            Sintactico.listaDatosTemp.clear();
        } catch (Exception e) {
            //System.err.println(e);
            copiaListaDatosTemp.clear();
        }  
  
        return copiaListaDatosTemp;
    }
    
    public static double estadisticas(ArrayList arreglo, String funcion){
        ArrayList<Double> listaTemp = new ArrayList<>(); 
        for (Object numero : arreglo) {
            try {
                listaTemp.add(Double.valueOf(numero.toString()));
            } catch (NumberFormatException e) {
                System.err.println(e);
            }          
        }
        
        
        try {
            switch (funcion) {
                case "MEDIA" -> {
                    double suma = 0;
                    for (double numero : listaTemp) {
                        suma += numero;
                    }

                    double media = (double) suma / listaTemp.size();
                    return media;                
                }

                case "MEDIANA" -> {
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
                }

                case "MODA" -> {
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
                }

                case "VARIANZA" -> {
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
                }

                case "MAX" -> {
                    double resultado = 0;
                    boolean primero = true;
                    for (double numero : listaTemp){
                        if (numero > resultado || primero == true)
                            resultado = numero;
                        primero = false;
                    }

                    return resultado;
                }
                case "MIN" -> {
                    double resultado = 0;
                    boolean primero = true;
                    for (double numero : listaTemp){
                        if (numero < resultado || primero == true)
                            resultado = numero;
                        primero = false;
                    }              
                    return resultado;
                }

                default -> {
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }
    
    
    public static double operaciones(Object valor1, Object valor2, String operacion) {
        
        //System.err.println(valor1 + " | " + valor2);
        
        try {
            double val1 = Double.parseDouble(valor1.toString());
            double val2 = Double.parseDouble(valor2.toString());
            
            switch (operacion) {
                case "SUM" -> {
                    return val1 + val2;
                }
                case "RES" -> {
                    return val1 - val2;
                }
                case "MUL" -> {
                    return val1 * val2;
                }
                case "DIV" -> {
                    return val1 / val2;
                }
                case "MOD" -> {
                    return val1 % val2;
                }
                default -> throw new IllegalArgumentException("Operación no válida: " + operacion);
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
                        + "<body style=\"background-color: rgb(44,51,51); font-family: 'Arial', sans-serif; color: rgb(231,246,242);\">");

                NuevaLinea.println("<center><h1>Reporte de Tokens</h1></center>\n");

                NuevaLinea.println("<center>");
                NuevaLinea.println("<style type=\"text/css\">\n"
                        + "            .tg  {border-collapse:collapse;border-spacing:0;}\n"
                        + "            .tg  {background-color: #395b64;}\n"
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
                        + "<body style=\"background-color: rgb(44,51,51); font-family: 'Arial', sans-serif; color: rgb(231,246,242);\">");

                NuevaLinea.println("<center><h1>Reporte de Errores Lexicos</h1></center>\n");

                NuevaLinea.println("<center>");
                NuevaLinea.println("<style type=\"text/css\">\n"
                        + "            .tg  {border-collapse:collapse;border-spacing:0;}\n"
                        + "            .tg  {background-color: #395b64;}\n"
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
    
    public static void reporteSimbolos() {
        File carpeta = new File("./Reportes");
        if (!carpeta.exists()) {
            carpeta.mkdirs(); // Crea la carpeta y sus subcarpetas si no existen
        }

        File archivo = new File("./Reportes/TablaSimbolos.html");

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
                        + "    <title>Tabla de Simbolos</title>\n"
                        + "    <meta name='viewport' content='width=device-width, initial-scale=1'>\n"
                        + "    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>\n"
                        + "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Arial\">\n"
                        + "    <script src='main.js'></script>\n"
                        + "</head>\n"
                        + "\n"
                        + "<body style=\"background-color: rgb(44,51,51); font-family: 'Arial', sans-serif; color: rgb(231,246,242);\">");

                NuevaLinea.println("<center><h1>Tabla de Simbolos</h1></center>\n");

                NuevaLinea.println("<center>");
                NuevaLinea.println("<style type=\"text/css\">\n"
                        + "            .tg  {border-collapse:collapse;border-spacing:0;}\n"
                        + "            .tg  {background-color: #395b64;}\n"
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
                        + "                    <th class=\"tg-0pky\">Nombre</th>\n"
                        + "                    <th class=\"tg-0pky\">Tipo<br></th>\n"
                        + "                    <th class=\"tg-0pky\">Valor</th>\n"
                        + "                    <th class=\"tg-0pky\">Linea<br></th>\n"
                        + "                    <th class=\"tg-0pky\">Columna</th>\n"
                        + "                </b>\n"
                        + "              </tr>\n"
                        + "            </thead>");
                NuevaLinea.println("<tbody>");
                
                int indice = 0;
                while (indice < Analizadores.Sintactico.listaSimbolos.size()) {
                    Simbolos simbolo = Analizadores.Sintactico.listaSimbolos.get(indice);
                    if (simbolo != null) {
                        NuevaLinea.println("<tr>");
                        
                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(indice + 1);
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(simbolo.getNombre());
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(simbolo.getTipo());
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(simbolo.getValor());
                        NuevaLinea.println("</th>");

                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(simbolo.getLinea());
                        NuevaLinea.println("</th>");
                        
                        NuevaLinea.print("<th class=\"tg-0lax\">");
                        NuevaLinea.print(simbolo.getColumna());
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
