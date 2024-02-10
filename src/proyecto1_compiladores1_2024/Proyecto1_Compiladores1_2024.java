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
        
        String Texto = "var:double:: suma <- MUL( SUM(7,3) , RES(10, DIV(25,5))) end ;";

        Analizadores.Sintactico parser;
        try {
            parser = new Analizadores.Sintactico(new Analizadores.Lexico(new BufferedReader(new StringReader(Texto))));
            parser.parse(); 
            
            System.out.println("Hola");
            reporteTokens();
            
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
        }      
        
        
        
    }
    
    
    public static void reporteTokens() {
        File archivo = new File("Tokens.html");

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
                        + "<body style=\"background-color: rgb(77, 201, 218); font-family: 'Arial', sans-serif;\">");

                NuevaLinea.println("<center><h1>Reporte de Tokens</h1></center>\n");

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
                        + "                    <th class=\"tg-0pky\">Lexema</th>\n"
                        + "                    <th class=\"tg-0pky\">Token<br></th>\n"
                        + "                    <th class=\"tg-0pky\">Linea</th>\n"
                        + "                    <th class=\"tg-0pky\">Columna<br></th>\n"
                        + "                </b>\n"
                        + "              </tr>\n"
                        + "            </thead>");
                NuevaLinea.println("<tbody>");

                Analizadores.Lexico.listaTokens.forEach((tokens) -> {
                    if (tokens != null) {
                        NuevaLinea.println("<tr>");

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
                    }
                });

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
