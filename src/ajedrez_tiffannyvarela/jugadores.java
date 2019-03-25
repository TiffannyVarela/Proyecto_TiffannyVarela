/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez_tiffannyvarela;

/**
 *
 * @author tiffa
 */
public class jugadores {
    private int ganados;
    private String nombre;
    private String color;

    public jugadores() {
    }

    public jugadores(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public jugadores(int ganados, String nombre, String color) {
        this.ganados = ganados;
        this.nombre = nombre;
        this.color = color;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void addGanadados(){
        this.setGanados(this.getGanados()+1);
    }
    
    
}
