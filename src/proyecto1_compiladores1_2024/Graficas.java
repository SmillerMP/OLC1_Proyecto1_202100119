/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_compiladores1_2024;


import Analizadores.Sintactico;
import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author samuel
 */
public class Graficas {
    
    public static void graficaPie(){
                  
        String tituloGrafica = Sintactico.datosGraficas.get("titulo").toString();
        // Elimina las comillas dobles presentes en los textos
        tituloGrafica = tituloGrafica.replaceAll("\"", "");
        
        ArrayList<Object> ListaDoubles = (ArrayList<Object>) Sintactico.datosGraficas.get("values");
        ArrayList<Object> ListaChars = (ArrayList<Object>) Sintactico.datosGraficas.get("label");

        //System.out.println(ListaValues.size() + " " + ListaLabel.size());
        if (ListaDoubles.size() != ListaChars.size()){
            System.err.println("Existe un error en las listas de valores, Grafica de Pie");        
        } else {
            
            DefaultPieDataset datos = new DefaultPieDataset();
            
            int indice = 0;
            while (indice < ListaDoubles.size()) {
                // Convierte en String cada uno de los texto para la grafica
                String labelString = ListaChars.get(indice).toString();
                labelString = labelString.replaceAll("\"", "");
                
                // Convierte en Double cada uno de los valores numericos para la grafica
                Double valorNumerico = Double.parseDouble( ListaDoubles.get(indice).toString());
                
                // Agrega los datos
                datos.setValue(labelString, valorNumerico);
                
                indice++;
            }
            
            // Quita las comillas 
            
            JFreeChart grafica_circular = ChartFactory.createPieChart(
                tituloGrafica,
                datos, 
                true,
                true,
                false
            );
            
                    // Guardar la gráfica como un archivo PNG
            int width = 800;   /* Anchura de la imagen */
            int height = 600;  /* Altura de la imagen */
            File pieChartFile = new File("pie_chart.png");
            try {
                ChartUtilities.saveChartAsPNG(pieChartFile, grafica_circular, width, height);
                System.out.println("¡Gráfica guardada como 'pie_chart.png'!");
            } catch (IOException e) {
                System.err.println("Error al guardar la gráfica: " + e.getMessage());
            }
        }
    }
    
    
    public static void graficaBarras(){
               
        // Recuperacion variable titulo para la grafica
        String tituloGrafica = Sintactico.datosGraficas.get("titulo").toString();
        tituloGrafica = tituloGrafica.replaceAll("\"", "");
        
        // Recuperacion Variable TituloX
        String tituloX = Sintactico.datosGraficas.get("tituloX").toString();
        tituloX = tituloX.replaceAll("\"", "");
        
        // Recuperacion variable TituloY
        String tituloY = Sintactico.datosGraficas.get("tituloY").toString();
        tituloY = tituloY.replaceAll("\"", "");
        
        ArrayList<Object> ListaDoubles = (ArrayList<Object>) Sintactico.datosGraficas.get("ejeY");
        ArrayList<Object> ListaChars = (ArrayList<Object>) Sintactico.datosGraficas.get("ejeX");

        //System.out.println(ListaDoubles.size() + " " + ListaChars.size());
        if (ListaDoubles.size() != ListaChars.size()){
            System.err.println("Existe un error en las listas de valores, Grafica de Pie");        
        } else {
            
            DefaultCategoryDataset datos = new DefaultCategoryDataset();
            
            int indice = 0;
            while (indice < ListaDoubles.size()) {
                // Convierte en String cada uno de los texto para la grafica
                String labelString = ListaChars.get(indice).toString();
                labelString = labelString.replaceAll("\"", "");
                
                // Convierte en Double cada uno de los valores numericos para la grafica
                Double valorNumerico = Double.parseDouble( ListaDoubles.get(indice).toString());
                
                // Agrega los datos
                datos.setValue(valorNumerico, labelString, "");
                
                indice++;
            }
            
            
            JFreeChart grafica_barras = ChartFactory.createBarChart3D(
                tituloGrafica,
                tituloX,
                tituloY,
                datos,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
            );
            
                    // Guardar la gráfica como un archivo PNG
            int width = 800;   /* Anchura de la imagen */
            int height = 600;  /* Altura de la imagen */
            File pieChartFile = new File("bar_chart.png");
            try {
                ChartUtilities.saveChartAsPNG(pieChartFile, grafica_barras, width, height);
                System.out.println("¡Gráfica guardada como 'bar_chart.png'!");
            } catch (IOException e) {
                System.err.println("Error al guardar la gráfica: " + e.getMessage());
            }
        }
    }
}
