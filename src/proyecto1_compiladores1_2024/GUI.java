/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyecto1_compiladores1_2024;

import Clases.Simbolos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author samuel
 */
public class GUI extends javax.swing.JFrame {
    
    public static String texto_consola = "";
    public static boolean graficaPresente = false;
    public static String texto_inicio = "";
    
    HashMap<String, String> rutasCompArchivos = new HashMap<>();
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        Entrada_datos.setTabSize(3); // Puedes ajustar el tamaño según tus necesidades      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Consola_salida = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        Seleccionar_grafica = new javax.swing.JComboBox<>();
        menuTabs = new javax.swing.JTabbedPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        Entrada_datos = new javax.swing.JTextArea();
        grafica_salida = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        Archivo = new javax.swing.JMenu();
        Nuevo_archivo = new javax.swing.JMenuItem();
        Abrir_archivo = new javax.swing.JMenuItem();
        Guardar = new javax.swing.JMenuItem();
        Guardar_como = new javax.swing.JMenuItem();
        Eliminar_tab = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Ejecutar_programa = new javax.swing.JMenuItem();
        limpiar_consola = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        PanelPrincipal.setBackground(new java.awt.Color(44, 51, 51));
        PanelPrincipal.setForeground(new java.awt.Color(165, 201, 202));
        PanelPrincipal.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(165, 201, 202));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Entrada");

        Consola_salida.setEditable(false);
        Consola_salida.setBackground(new java.awt.Color(57, 91, 100));
        Consola_salida.setColumns(20);
        Consola_salida.setFont(new java.awt.Font("Hack Nerd Font", 1, 12)); // NOI18N
        Consola_salida.setForeground(new java.awt.Color(231, 246, 242));
        Consola_salida.setRows(5);
        Consola_salida.setSelectionColor(new java.awt.Color(165, 201, 202));
        jScrollPane2.setViewportView(Consola_salida);

        jLabel2.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(165, 201, 202));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consola");

        Seleccionar_grafica.setBackground(new java.awt.Color(60, 63, 65));
        Seleccionar_grafica.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 1, 14)); // NOI18N
        Seleccionar_grafica.setForeground(new java.awt.Color(165, 201, 202));
        Seleccionar_grafica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seleccionar_graficaActionPerformed(evt);
            }
        });

        menuTabs.setBackground(new java.awt.Color(165, 201, 202));
        menuTabs.setForeground(new java.awt.Color(44, 51, 51));
        menuTabs.setAutoscrolls(true);
        menuTabs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuTabs.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 1, 14)); // NOI18N

        Entrada_datos.setBackground(new java.awt.Color(57, 91, 100));
        Entrada_datos.setColumns(20);
        Entrada_datos.setFont(new java.awt.Font("Hack Nerd Font Propo", 0, 12)); // NOI18N
        Entrada_datos.setForeground(new java.awt.Color(231, 246, 242));
        Entrada_datos.setRows(5);
        Entrada_datos.setSelectionColor(new java.awt.Color(165, 201, 202));
        jScrollPane4.setViewportView(Entrada_datos);

        menuTabs.addTab("Nueva Pestaña", jScrollPane4);

        grafica_salida.setBackground(new java.awt.Color(44, 51, 51));
        grafica_salida.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Graficas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu Nerd Font Propo Med", 1, 14), new java.awt.Color(165, 201, 202))); // NOI18N
        grafica_salida.setForeground(new java.awt.Color(165, 201, 202));

        javax.swing.GroupLayout grafica_salidaLayout = new javax.swing.GroupLayout(grafica_salida);
        grafica_salida.setLayout(grafica_salidaLayout);
        grafica_salidaLayout.setHorizontalGroup(
            grafica_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );
        grafica_salidaLayout.setVerticalGroup(
            grafica_salidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuTabs, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grafica_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 582, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Seleccionar_grafica, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(menuTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelPrincipalLayout.createSequentialGroup()
                        .addComponent(Seleccionar_grafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grafica_salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        menuTabs.getAccessibleContext().setAccessibleName("Nuevo\n");
        menuTabs.getAccessibleContext().setAccessibleDescription("");

        jMenuBar1.setBackground(new java.awt.Color(165, 201, 202));
        jMenuBar1.setBorder(null);
        jMenuBar1.setForeground(new java.awt.Color(165, 201, 202));
        jMenuBar1.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 1, 14)); // NOI18N

        Archivo.setForeground(new java.awt.Color(48, 50, 52));
        Archivo.setText("Archivo");
        Archivo.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 15)); // NOI18N

        Nuevo_archivo.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        Nuevo_archivo.setText("Nuevo Archivo");
        Nuevo_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nuevo_archivoActionPerformed(evt);
            }
        });
        Archivo.add(Nuevo_archivo);

        Abrir_archivo.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        Abrir_archivo.setText("Abrir Archivo");
        Abrir_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abrir_archivoActionPerformed(evt);
            }
        });
        Archivo.add(Abrir_archivo);

        Guardar.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        Archivo.add(Guardar);

        Guardar_como.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        Guardar_como.setText("Guardar Como");
        Guardar_como.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar_comoActionPerformed(evt);
            }
        });
        Archivo.add(Guardar_como);

        Eliminar_tab.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        Eliminar_tab.setText("Eliminar Pestaña");
        Eliminar_tab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_tabActionPerformed(evt);
            }
        });
        Archivo.add(Eliminar_tab);

        jMenuBar1.add(Archivo);

        jMenu2.setText("Programa");
        jMenu2.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 15)); // NOI18N

        Ejecutar_programa.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        Ejecutar_programa.setText("Ejecutar");
        Ejecutar_programa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ejecutar_programaActionPerformed(evt);
            }
        });
        jMenu2.add(Ejecutar_programa);

        limpiar_consola.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        limpiar_consola.setText("Limpiar Consolar");
        limpiar_consola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar_consolaActionPerformed(evt);
            }
        });
        jMenu2.add(limpiar_consola);

        jMenuItem5.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        jMenuItem5.setText("Borrar Documentos (!)");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Reportes");
        jMenu3.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 15)); // NOI18N

        jMenuItem9.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        jMenuItem9.setText("Reporte de Tokens");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem7.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        jMenuItem7.setText("Reporte de Errores");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem11.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        jMenuItem11.setText("Tabla de Simbolos");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenuItem10.setFont(new java.awt.Font("Ubuntu Nerd Font Propo Med", 0, 14)); // NOI18N
        jMenuItem10.setText("Mostrar Documentacion");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Nuevo_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nuevo_archivoActionPerformed
        // TODO add your handling code here:
        JTextArea textArea = new JTextArea();
        textArea.setTabSize(3); // Puedes ajustar el tamaño según tus necesidades      
        textArea.setBackground(new Color(57,91,100));
        textArea.setForeground(new Color(231,246,242));

        // Crear un JScrollPane y agregar el JTextArea a él
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        menuTabs.insertTab("Nueva Pestaña", null, scrollPane, null, 0); 
    }//GEN-LAST:event_Nuevo_archivoActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void Guardar_comoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar_comoActionPerformed
        // TODO add your handling code here:
        
        // Funcion para guardar como
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            // El usuario seleccionó un archivo y hizo clic en "Guardar"
            String rutaSeleccionada = fileChooser.getSelectedFile().getAbsolutePath();
            String nombreArchivo = fileChooser.getSelectedFile().getName();
            
            File archivo = new File(rutaSeleccionada);
        
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                // Escribir el texto en el archivo
                
                int selectedIndex = menuTabs.getSelectedIndex();
                Component selectedComponent = menuTabs.getComponentAt(selectedIndex);
                
                // Verificar si el componente asociado es un JScrollPane
                if (selectedComponent instanceof JScrollPane) {
                    JScrollPane scrollPane = (JScrollPane) selectedComponent;
                    JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
                    writer.write(textArea.getText());
                    rutasCompArchivos.put(nombreArchivo, rutaSeleccionada);
                    menuTabs.setTitleAt(selectedIndex, nombreArchivo);
                    JOptionPane.showMessageDialog(null, "Archivo Guardado Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    System.out.println("No se ha seleccionado ningún tab o el componente asociado no es un JTextArea.");
                }
               
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al guardar el texto en el archivo.", "Error",JOptionPane.ERROR_MESSAGE);
            }
            
        } else if (resultado == JFileChooser.CANCEL_OPTION) {
            // El usuario canceló la operación
            JOptionPane.showMessageDialog(null, "Se ha cancelado la carga del archivo", "Accion Interrumpida", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_Guardar_comoActionPerformed

    private void Ejecutar_programaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ejecutar_programaActionPerformed
        // TODO add your handling code here:
               
        String textoAnalizar = "";
        int selectedIndex = menuTabs.getSelectedIndex();
        // Obtener el componente asociado con el tab seleccionado
        Component selectedComponent = menuTabs.getComponentAt(selectedIndex);
        
        // Verificar si el componente asociado es un JScrollPane
        if (selectedComponent instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) selectedComponent;
            JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
            textoAnalizar = textArea.getText();
        } else {
            System.out.println("No se ha seleccionado ningún tab o el componente asociado no es un JTextArea.");
        }
        
        //System.out.println(Entrada_datos.getText()); 
        
        texto_consola = "";
        graficaPresente = false;
        Graficas.GraficasAlmacenadas.clear();
        Seleccionar_grafica.removeAllItems();
        
        
        Analizadores.Sintactico parser;
        try {
            parser = new Analizadores.Sintactico(new Analizadores.Lexico(new BufferedReader(new StringReader(textoAnalizar))));
            parser.parse();        
            Funciones.reporteTokens();            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, no se ha podido compilar", "Error", JOptionPane.ERROR_MESSAGE);

        }    
        
        Consola_salida.append(texto_consola);
        Consola_salida.append("\n\n //////////////////######## EJECUCION TERMINADA ########/////////////////// \n\n");
        
        Graficas.GraficasAlmacenadas.entrySet().forEach(
            entry -> { //System.out.println(entry.getKey() + " = " + entry.getValue()); 
                Seleccionar_grafica.addItem(entry.getKey());         
            });
        
        Seleccionar_grafica.setSelectedItem(texto_inicio);
        
        Funciones.reporteErrores();
        Funciones.reporteTokens();
        Funciones.reporteSimbolos();
        
        
        Analizadores.Lexico.listaErrores.clear();
        Analizadores.Lexico.listaTokens.clear();
        Analizadores.Sintactico.listaSimbolos.clear();
        
        
    }//GEN-LAST:event_Ejecutar_programaActionPerformed

    private void limpiar_consolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar_consolaActionPerformed
        // TODO add your handling code here:
        
        Consola_salida.removeAll();
        Consola_salida.setText("");
    }//GEN-LAST:event_limpiar_consolaActionPerformed

    private void Seleccionar_graficaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seleccionar_graficaActionPerformed
        // TODO add your handling code here:

        try {
            String opcionSeleccionada = Seleccionar_grafica.getSelectedItem().toString();
            ChartPanel panel = new ChartPanel(Graficas.GraficasAlmacenadas.get(opcionSeleccionada));
            panel.setMouseWheelEnabled(true);
            panel.setPreferredSize(new Dimension(563,272));

            grafica_salida.removeAll();
            grafica_salida.setLayout(new BorderLayout());
            grafica_salida.add(panel, BorderLayout.CENTER);
            grafica_salida.revalidate();
            grafica_salida.repaint();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_Seleccionar_graficaActionPerformed

    private void Abrir_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abrir_archivoActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo df", "df");
        fileChooser.setFileFilter(filter); 

        int returnVal = fileChooser.showSaveDialog(null);
        
        if(returnVal == JFileChooser.APPROVE_OPTION){
            File file = fileChooser.getSelectedFile();
            String archivoRuta = file.getPath();
            if (!archivoRuta.toLowerCase().endsWith(".df")) {
                file = new File(archivoRuta + ".df");
            }
            
            // Verifica si el nombre del archivo ya existe como un tab
            if (rutasCompArchivos.containsKey(file.getName())) {
                  JOptionPane.showMessageDialog(null, "El archivo ya está abierto en otro tab.", "Archivo Duplicado", JOptionPane.ERROR_MESSAGE);
                return; // Sale del método ya que no se puede abrir el archivo duplicado
            }
            
            
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;
                StringBuilder contenido = new StringBuilder();
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                br.close();
                
//                jTextArea1.setText(contenido.toString());               
//                ruta = archivoSeleccionado.getAbsolutePath();
//                nombreArchivo = archivoSeleccionado.getName();
                
                JTextArea textArea = new JTextArea();
                textArea.setText(contenido.toString()); // Establece el contenido en el JTextArea
                textArea.setTabSize(3); // Puedes ajustar el tamaño según tus necesidades      
                textArea.setBackground(new Color(57,91,100));
                textArea.setForeground(new Color(231,246,242));
                textArea.setFont(new Font("Hack Nerd Font Propo", Font.PLAIN, 12));
                
                        
                JScrollPane scrollPane = new JScrollPane(textArea);

                // Agrega el JScrollPane al nuevo tab con el nombre del archivo
                menuTabs.addTab(file.getName(), scrollPane);
                
                int index = menuTabs.indexOfComponent(scrollPane);
             
                menuTabs.setSelectedIndex(index);
                  
                // Añade la ruta completa a un hashmap
                rutasCompArchivos.put(file.getName(), file.getAbsolutePath());
                        
                
                                                      
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error, hubo un problema al cargar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Se ha cancelado la carga del archivo", "Accion Interrumpida", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Abrir_archivoActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
        
        int selectedIndex = menuTabs.getSelectedIndex();
        String nombreTab = menuTabs.getTitleAt(selectedIndex);
        // Obtener el componente asociado con el tab seleccionado
        Component selectedComponent = menuTabs.getComponentAt(selectedIndex);
        
        // Verificar si el componente asociado es un JScrollPane
        if (selectedComponent instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) selectedComponent;
            JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
        
            String ruta = rutasCompArchivos.get(nombreTab);
            
            if (ruta != null) {
                int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de guardar? \nLa ruta es: " + ruta, "Cuidado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);       

                if (resp == 0) {
                    File archivo = new File(ruta);

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                        // Escribir el texto en el archivo
                        writer.write(textArea.getText());
                        JOptionPane.showMessageDialog(null, "Archivo Guardado Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error al guardar el texto en el archivo. Revise la ruta", "Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aun no existe un ruta asociada a esta pestaña \nSeleccione Guardar Como", "Error",JOptionPane.ERROR_MESSAGE);
            }
        
        } else {
            System.out.println("No se ha seleccionado ningún tab o el componente asociado no es un JTextArea.");
        }      
    }//GEN-LAST:event_GuardarActionPerformed

    private void Eliminar_tabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_tabActionPerformed
        // TODO 
        
        int selectedIndex = menuTabs.getSelectedIndex();
        String nombreTab = menuTabs.getTitleAt(selectedIndex);
        
        if (selectedIndex != -1) { // Asegurarse de que haya un tab seleccionado
            // Remover el tab seleccionado
            
            int resp = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar \nPestaña: " + nombreTab,  "Cuidado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);       
            if (resp == 0) {
                
                menuTabs.removeTabAt(selectedIndex);               
                try {
                    rutasCompArchivos.remove(nombreTab);                  
                    JOptionPane.showMessageDialog(null, "Pestaña eliminada correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                }
                

            } else {
                JOptionPane.showMessageDialog(null, "Operacion cancelada", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } else {
            System.out.println("No hay ningún tab seleccionado para eliminar.");
        }
    }//GEN-LAST:event_Eliminar_tabActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que desea eliminar los datos? \nse eliminaran las graficas, reportes y el historial de consola", "Cuidado", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);       
        
        if (resp == 0) {
            try {
                File carpeta = new File("./Graficas");
                if (carpeta.exists() && carpeta.isDirectory()) {
                    File[] archivos = carpeta.listFiles();
                    if (archivos != null) {
                        for (File archivo : archivos) {
                            archivo.delete();
                        }
                    }                          
                    //System.out.println("Archivos eliminados correctamente.");
                } else {
                    //System.out.println("La carpeta Graficas no existe o no es un directorio.");
                }
            } catch (Exception ex) {
                //System.err.println("Error al eliminar archivos: " + ex.getMessage());
            }
            
            // Elimina los reportes
            try {
                File carpeta = new File("./Reportes");
                if (carpeta.exists() && carpeta.isDirectory()) {
                    File[] archivos = carpeta.listFiles();
                    if (archivos != null) {
                        for (File archivo : archivos) {
                            archivo.delete();
                        }
                    }                          
                    //System.out.println("Archivos eliminados correctamente.");
                } else {
                    //System.out.println("La carpeta Graficas no existe o no es un directorio.");
                }
            } catch (Exception ex) {
                //System.err.println("Error al eliminar archivos: " + ex.getMessage());
            }

            grafica_salida.removeAll();
            grafica_salida.revalidate();
            grafica_salida.repaint();
            grafica_salida.setPreferredSize(new Dimension(582, 293)); 

            Consola_salida.removeAll();
            Consola_salida.setText("");

            Seleccionar_grafica.removeAllItems();
           
            JOptionPane.showMessageDialog(null, "Datos eliminados correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Operacion cancelada", "Información", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        String comando1 = "xdg-open ./Reportes/Tokens.html"; // Abre el administrador de archivos en el directorio actual
        // Concatena los comandos separados por un punto y coma
        String comando = comando1 ;
        // Crea una instancia de ProcessBuilder
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Establece el comando a ejecutar con el shell
        processBuilder.command("bash", "-c", comando);

        try {
            // Inicia el proceso
            Process proceso = processBuilder.start();

            // Espera a que el proceso termine
            int exitCode = proceso.waitFor();

            // Imprime el código de salida
            //System.out.println("Código de salida: " + exitCode);
        } catch (IOException | InterruptedException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se ha podido abrir los reportes", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        String comando1 = "xdg-open ./Reportes/Errores.html"; 
        String comando = comando1 ;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", comando);

        try {
            // Inicia el proceso
            Process proceso = processBuilder.start();
            int exitCode = proceso.waitFor();       
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido abrir los reportes", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        String comando1 = "xdg-open ./Reportes/TablaSimbolos.html"; 
        String comando = comando1 ;
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", comando);

        try {
            // Inicia el proceso
            Process proceso = processBuilder.start();
            int exitCode = proceso.waitFor();       
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido abrir los reportes", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Abrir_archivo;
    private javax.swing.JMenu Archivo;
    public static javax.swing.JTextArea Consola_salida;
    private javax.swing.JMenuItem Ejecutar_programa;
    private javax.swing.JMenuItem Eliminar_tab;
    private javax.swing.JTextArea Entrada_datos;
    private javax.swing.JMenuItem Guardar;
    private javax.swing.JMenuItem Guardar_como;
    private javax.swing.JMenuItem Nuevo_archivo;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JComboBox<String> Seleccionar_grafica;
    public static javax.swing.JPanel grafica_salida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenuItem limpiar_consola;
    private javax.swing.JTabbedPane menuTabs;
    // End of variables declaration//GEN-END:variables
}
