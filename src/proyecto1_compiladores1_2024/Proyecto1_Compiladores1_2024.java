/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1_compiladores1_2024;

/**
 *
 * @author samuel
 */

import javax.swing.ImageIcon;

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
        
        ImageIcon icon = new ImageIcon("./Bash_Logo_Colored.png");
        gui.setIconImage(icon.getImage());
        gui.setVisible(true);
    }   
}