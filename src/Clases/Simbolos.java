/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author samuel
 */
public class Simbolos {
    String Nombre;
    String Tipo;
    String Valor;
    String Linea;
    String Columna;

    public Simbolos(String Nombre, String Tipo, String Valor, String Linea, String Columna) {
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Valor = Valor;
        this.Linea = Linea;
        this.Columna = Columna;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getValor() {
        return Valor;
    }

    public String getLinea() {
        return Linea;
    }

    public String getColumna() {
        return Columna;
    }
    
}
