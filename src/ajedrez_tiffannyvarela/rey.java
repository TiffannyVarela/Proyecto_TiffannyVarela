/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez_tiffannyvarela;

import java.util.ArrayList;

/**
 *
 * @author tiffa
 */
public class rey extends pieza{
    public rey(int x, int y, String color ){
        super(new posicion(x,  y),  color, "Rey");
    }

    public boolean val(tablero tablero , posicion p){
this.posibles(tablero);
        return super.val(this.posibles(tablero), p);
    }

    @Override
    public ArrayList posibles(tablero tablero){
        ArrayList<posicion> posiciones = new ArrayList();
        for(int i=super.getPX()-1; i<=super.getPX()+1; i++){
            for(int j=super.getPY()-1; j<=super.getPY()+1; j++){
                if(i != super.getPX() || j != super.getPY()){
                    try{
                        if(!(tablero.getpiezas()[tablero.getpiezapos(i, j)].getColor().equals(super.getColor()))){
                            posiciones.add(new posicion(i, j)); 
                        }
                    }catch(Exception e){
                        posiciones.add(new posicion(i, j));
                    }
                }
            }
        }
        return posiciones;
    }
}
