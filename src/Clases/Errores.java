/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author samuel
 */
public class Errores {
    String Tipo;
    String Descripcion;
    String Linea;
    String Columna;

    public Errores(String Tipo, String Descripcion, String Linea, String Columna) {
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
        this.Linea = Linea;
        this.Columna = Columna;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public String getLinea() {
        return Linea;
    }

    public String getColumna() {
        return Columna;
    }
    
    
}
