/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_compiladores1_2024;

import Clases.Tokens;
import Analizadores.Sintactico;
        
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author samuel
 */
public class Funciones {
    
    
    
    public static int operaciones(String valor1, String valor2, String operacion) {
        try {
            int val1 = Integer.parseInt(valor1);
            int val2 = Integer.parseInt(valor2);
            
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
    
    public static String convertToString(Object valor) {
        try {
            String texto = String.valueOf(valor);
            return texto;
        } catch (Exception e) {
            return null; 
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
                };

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
