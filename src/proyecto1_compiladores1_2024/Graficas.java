/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1_compiladores1_2024;


import Analizadores.Sintactico;
import java.awt.BorderLayout;
import proyecto1_compiladores1_2024.GUI;
import java.io.File;
import java.io.IOException;


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
import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import java.util.HashMap;


/**
 *
 * @author samuel
 */
public class Graficas {
    
    public static HashMap<String, JFreeChart> GraficasAlmacenadas = new HashMap<>();
    
    public static void histograma(){
                  
        try {
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
            textoConsola += "\n-------------------------------\n";
            textoConsola += "| Valor | Fb | Fa | Fr |\n";
            textoConsola += "-------------------------------\n";

            DefaultCategoryDataset datos = new DefaultCategoryDataset();

            while (indice < HistrogramaFrecuencia.size()) {
                textoConsola += HistrogramaValores.get(indice) + " | " + HistrogramaFrecuencia.get(indice) + " | " + 
                        HistrogramaFrAcumulada.get(indice)+ " | " + HistrogramaFrRelativa.get(indice) +"%\n";

                datos.setValue(HistrogramaFrecuencia.get(indice), "Frecuencia",HistrogramaValores.get(indice) );
                indice ++;
            }

            int finalLista = HistrogramaValores.size() - 1;

            textoConsola += "Total: " + HistrogramaFrAcumulada.get(finalLista) + " | " + HistrogramaFrAcumulada.get(finalLista) + " | " 
                    + "100.00%\n";

            textoConsola += "-------------------------------\n\n";        

            //System.out.println(textoConsola);
            GUI.texto_consola += textoConsola;

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


            if (!GUI.graficaPresente) {
                ChartPanel panel = new ChartPanel(grafica_barras);
                panel.setMouseWheelEnabled(true);

                GUI.grafica_salida.removeAll();
                GUI.grafica_salida.setLayout(new BorderLayout());
                GUI.grafica_salida.add(panel, BorderLayout.CENTER);
                GUI.grafica_salida.revalidate();
                GUI.grafica_salida.repaint();
                GUI.grafica_salida.setPreferredSize(new Dimension(582, 293));
                GUI.graficaPresente = true;
                GUI.texto_inicio = tituloGrafica;
            }

            GraficasAlmacenadas.put(tituloGrafica, grafica_barras);

            //Guardar la grafica como png
            GuardarGrafica(tituloGrafica + ".png", grafica_barras);
            Sintactico.datosGraficas.clear(); 
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    
    // Manejo de grafica de Pie
    public static void graficaPie(){
                  
        try {
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


                JFreeChart grafica_circular = ChartFactory.createPieChart(
                    tituloGrafica,
                    datos, 
                    true,
                    true,
                    false
                );


                if (!GUI.graficaPresente) {
                    ChartPanel panel = new ChartPanel(grafica_circular);
                    panel.setMouseWheelEnabled(true);

                    GUI.grafica_salida.removeAll();
                    GUI.grafica_salida.setLayout(new BorderLayout());
                    GUI.grafica_salida.add(panel, BorderLayout.CENTER);
                    GUI.grafica_salida.revalidate();
                    GUI.grafica_salida.repaint();
                    GUI.grafica_salida.setPreferredSize(new Dimension(582, 293));
                    GUI.graficaPresente = true;
                    GUI.texto_inicio = tituloGrafica;
                }

                // Alamacena los datos en un hashmap para luego usarlos
                GraficasAlmacenadas.put(tituloGrafica, grafica_circular);

                // Guardar la grafica como png      
                GuardarGrafica(tituloGrafica + ".png", grafica_circular);

                Sintactico.datosGraficas.clear();

            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    
    public static void graficaBarras(){
               
        try {
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

                if (!GUI.graficaPresente) {
                    ChartPanel panel = new ChartPanel(grafica_barras);
                    panel.setMouseWheelEnabled(true);

                    GUI.grafica_salida.removeAll();
                    GUI.grafica_salida.setLayout(new BorderLayout());
                    GUI.grafica_salida.add(panel, BorderLayout.CENTER);
                    GUI.grafica_salida.revalidate();
                    GUI.grafica_salida.repaint();
                    GUI.grafica_salida.setPreferredSize(new Dimension(582, 293));
                    GUI.graficaPresente = true;
                    GUI.texto_inicio = tituloGrafica;
                }         

                GraficasAlmacenadas.put(tituloGrafica, grafica_barras);

                // Guardar la grafica como png
                GuardarGrafica(tituloGrafica + ".png", grafica_barras);

                Sintactico.datosGraficas.clear();
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    
    
    public static void graficaLineas(){
               
        try {
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


                JFreeChart grafica_lineas = ChartFactory.createLineChart(
                    tituloGrafica,
                    tituloX,
                    tituloY,
                    datos,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
                );


                if (!GUI.graficaPresente) {
                    ChartPanel panel = new ChartPanel(grafica_lineas);
                    panel.setMouseWheelEnabled(true);

                    GUI.grafica_salida.removeAll();
                    GUI.grafica_salida.setLayout(new BorderLayout());
                    GUI.grafica_salida.add(panel, BorderLayout.CENTER);
                    GUI.grafica_salida.revalidate();
                    GUI.grafica_salida.repaint();
                    GUI.grafica_salida.setPreferredSize(new Dimension(582, 293));
                    GUI.graficaPresente = true;
                    GUI.texto_inicio = tituloGrafica;
                }

                GraficasAlmacenadas.put(tituloGrafica, grafica_lineas);

                GuardarGrafica(tituloGrafica + ".png", grafica_lineas);

                Sintactico.datosGraficas.clear();
            }
        } catch (Exception e) {
        }
    }
    
    
    public static void GuardarGrafica (String nombre, JFreeChart grafica){
        try {
            File carpeta = new File("./Graficas");
            if (!carpeta.exists()) {
                carpeta.mkdirs(); // Crea la carpeta y sus subcarpetas si no existen
            }

            File archivo = new File("./Graficas/" + nombre);

            archivo.delete();
            if (!archivo.exists()) {
                ChartUtilities.saveChartAsPNG(archivo, grafica, 800, 600);
                GUI.texto_consola += "¡Gráfica guardada en './Graficas/' como '"+ nombre + "'!\n";
            }

        } catch (IOException e) {
            System.err.println("Error al guardar la gráfica: " + e.getMessage());
        }
        
    }
}
