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
import java.util.Collections;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import java.awt.Color;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author samuel
 */
public class Graficas {
    
    public static void histrograma(){
                  
        String tituloGrafica = Sintactico.datosGraficas.get("titulo").toString();
        // Elimina las comillas dobles presentes en los textos
        tituloGrafica = tituloGrafica.replaceAll("\"", "");
        
        ArrayList<Object> listaValoresObjetos = (ArrayList<Object>) Sintactico.datosGraficas.get("values");
        
        // se crea un nuevo arraylista para almacenar los valores pero en double (se puede castear directamente pero no se por que no los ordena bien)
        ArrayList<Double> listaValores = new ArrayList<>();
        for (Object dato : listaValoresObjetos) {
            listaValores.add(Double.valueOf(dato.toString()));
        }
        
        // Creacion de Arraylist para almacenar los datos de la tabla
        ArrayList<Double> HistrogramaValores = new ArrayList<>();
        ArrayList<Integer> HistrogramaFrecuencia = new ArrayList<>();
        ArrayList<Integer> HistrogramaFrAcumulada = new ArrayList<>();
        ArrayList<Double> HistrogramaFrRelativa = new ArrayList<>();

        int repeticion = 0;
        double queDato = 0;
        boolean inicio = true;

        // Ordena los valores de la lista de menor a mayor
        Collections.sort(listaValores);
       
        int indice = 0;
        while (indice < listaValores.size()){
            double numero = listaValores.get(indice);
            
            if (indice == 0) {
                queDato = numero;
            }
            
            if (numero == queDato){                   
                repeticion++;
            } else {
                HistrogramaValores.add(queDato);
                HistrogramaFrecuencia.add(repeticion);
                repeticion = 1;
                queDato = numero;
            }
            
            if (indice == listaValores.size() - 1){
                HistrogramaValores.add(numero);
                HistrogramaFrecuencia.add(repeticion);
            }
            
            indice++;
        }

        
        indice = 0;
        inicio = true;
        while (indice < HistrogramaFrecuencia.size()) {
            if (inicio) {
                HistrogramaFrAcumulada.add(HistrogramaFrecuencia.get(indice));
                inicio = false;
            } else {
                int suma = HistrogramaFrAcumulada.get(indice-1) + HistrogramaFrecuencia.get(indice);
                HistrogramaFrAcumulada.add(suma);
            }
            indice ++;
        }
        
        for (Integer numero : HistrogramaFrecuencia) {
            double operacion = (Double.valueOf(numero.toString()) * 100)/ listaValores.size();
            operacion = (Math.round(operacion * 100.0 ) / 100.0);
            HistrogramaFrRelativa.add(operacion);     
        }
        
//        System.out.println(HistrogramaValores);
//        System.out.println(HistrogramaFrecuencia);
//        System.out.println(HistrogramaFrAcumulada);
//        System.out.println(HistrogramaFrRelativa);
             
        String textoConsola = "";
        indice = 0;
        textoConsola += "------------------------\n";
        textoConsola += "| Valor | Fb | Fa | Fr |\n";
        textoConsola += "------------------------\n";
        
        DefaultCategoryDataset datos = new DefaultCategoryDataset();

        while (indice < HistrogramaFrecuencia.size()) {
            textoConsola += HistrogramaValores.get(indice) + " | " + HistrogramaFrecuencia.get(indice) + " | " + 
                    HistrogramaFrAcumulada.get(indice)+ " | " + HistrogramaFrRelativa.get(indice) +"%\n";
            
            datos.setValue(HistrogramaFrecuencia.get(indice), "Frecuencia",HistrogramaValores.get(indice) );
            indice ++;
        }
        
        int finalLista = HistrogramaValores.size() - 1;
        
        textoConsola += "Tota: " + HistrogramaFrecuencia.get(finalLista) + " | " + HistrogramaFrAcumulada.get(finalLista) + " | " 
                + "100.00%\n";
        
        textoConsola += "----------------------\n";        
        
        System.out.println(textoConsola);
        
        JFreeChart grafica_barras = ChartFactory.createBarChart3D(
            tituloGrafica,
            "Valores",
            "Frecuencia",
            datos,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        // Obtener el plot (área de trazado) del gráfico
        CategoryPlot plot = (CategoryPlot) grafica_barras.getPlot();

        // Obtener el renderer de las barras
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Cambiar el color de las barras
        renderer.setSeriesPaint(0, Color.BLUE); // Cambiar el color de la primera serie a azul

        // Guardar la gráfica como un archivo PNG
        int width = 800;   /* Anchura de la imagen */
        int height = 600;  /* Altura de la imagen */
        try {
            File carpeta = new File("./Graficas");
            if (!carpeta.exists()) {
                carpeta.mkdirs(); // Crea la carpeta y sus subcarpetas si no existen
            }

            File grafica = new File("./Graficas/histograma_chart.png");

            grafica.delete();
            if (!grafica.exists()) {
                ChartUtilities.saveChartAsPNG(grafica, grafica_barras, width, height);
                System.out.println("¡Gráfica guardada en './Graficas/' como 'histograma_chart.png'!");
            }

        } catch (IOException e) {
            System.err.println("Error al guardar la gráfica: " + e.getMessage());
        }
        
        
        
    }
    
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
            
            try {
                File carpeta = new File("./Graficas");
                if (!carpeta.exists()) {
                    carpeta.mkdirs(); // Crea la carpeta y sus subcarpetas si no existen
                }

                File grafica = new File("./Graficas/pie_chart.png");

                grafica.delete();
                if (!grafica.exists()) {
                    ChartUtilities.saveChartAsPNG(grafica, grafica_circular, width, height);
                    System.out.println("¡Gráfica guardada en './Graficas/' como 'pie_chart.png'!");
                }
                
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
                Double valorNumerico = Double.valueOf( ListaDoubles.get(indice).toString());
                
                // Agrega los datos
                datos.setValue(valorNumerico, "",labelString );
                
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
            
            try {
                File carpeta = new File("./Graficas");
                if (!carpeta.exists()) {
                    carpeta.mkdirs(); // Crea la carpeta y sus subcarpetas si no existen
                }

                File grafica = new File("./Graficas/bar_chart.png");

                grafica.delete();
                if (!grafica.exists()) {
                    ChartUtilities.saveChartAsPNG(grafica, grafica_barras, width, height);
                    System.out.println("¡Gráfica guardada en './Graficas/' como 'bar_chart.png'!");
                }
                
            } catch (IOException e) {
                System.err.println("Error al guardar la gráfica: " + e.getMessage());
            }
        }
    }
    
    
    
    public static void graficaLineas(){
               
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
                Double valorNumerico = Double.valueOf( ListaDoubles.get(indice).toString());
                
                // Agrega los datos
                datos.setValue(valorNumerico, "",labelString );
                
                indice++;
            }
            
            
            JFreeChart grafica_barras = ChartFactory.createLineChart(
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
            try {
                File carpeta = new File("./Graficas");
                if (!carpeta.exists()) {
                    carpeta.mkdirs(); // Crea la carpeta y sus subcarpetas si no existen
                }

                File pieChartFile = new File("./Graficas/line_chart.png");

                pieChartFile.delete();
                if (!pieChartFile.exists()) {
                    ChartUtilities.saveChartAsPNG(pieChartFile, grafica_barras, width, height);
                    System.out.println("¡Gráfica guardada en './Graficas/' como 'line_chart.png'!");
                }
                
            } catch (IOException e) {
                System.err.println("Error al guardar la gráfica: " + e.getMessage());
            }
        }
    }
}
