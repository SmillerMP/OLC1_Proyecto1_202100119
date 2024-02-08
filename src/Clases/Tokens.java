/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author samuel
 */
public class Tokens {
    String Token;
    String Lexema;
    String Linea;
    String Columna;

    public Tokens(String Token, String Lexema, String Linea, String Columna) {
        this.Token = Token;
        this.Lexema = Lexema;
        this.Linea = Linea;
        this.Columna = Columna;
    }

    public String getToken() {
        return Token;
    }

    public String getLexema() {
        return Lexema;
    }

    public String getLinea() {
        return Linea;
    }

    public String getColumna() {
        return Columna;
    }
    
}
