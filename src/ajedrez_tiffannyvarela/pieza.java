/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez_tiffannyvarela;

import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.ImageIcon;

/**
 *
 * @author tiffa
 */
public class pieza {
    private String nombre;
    private posicion pos;
    private String color;
    private boolean selec;

    public pieza() {
    }

    public pieza(posicion pos, String color,String nombre) {
        this.setPos(pos);
        this.setColor(color);
        this.setSelec(true);
        this.setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public posicion getPos() {
        return pos;
    }

    public void setPos(posicion pos) {
        this.pos = pos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isSelec() {
        return selec;
    }

    public void setSelec(boolean selec) {
        this.selec = selec;
    }

    public void setPX(int posicion){
        this.pos.setPX(posicion);
    }
    
    public int getPX(){
        return this.getPos().getPX();
    }
           
    public void setPY(int posicion){
        this.pos.setPY(posicion);
    }
    
    public int getPY(){
        return this.getPos().getPY();
    }
    
    public void mov(posicion p){
        this.setPos(p);
    }
       
    
    public boolean val(ArrayList<posicion> posiciones, posicion pd){
        for (int i = 0; i < posiciones.size(); i++) {
            if (posiciones.get(i).getPX()==pd.getPX() && posiciones.get(i).getPY()==pd.getPY()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean val(tablero tablero , posicion p){
        return false;
    }
    
    
    public ArrayList posibles(tablero t){
        return null;
    }
    
    public ImageIcon getIcon(){
        if(!nombre.equals("") && !color.equals("")){
                return new ImageIcon(getClass().getResource("/Pieza/"+nombre+color+".png"));
        }else{
            return new ImageIcon("alfilBlanco.png");
        }
    }
    
}
