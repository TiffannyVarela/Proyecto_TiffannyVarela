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
public class caballo extends pieza{

    public caballo() {
    }

    public caballo(posicion pos, String color, String nombre) {
        super(pos, color, nombre);
    }
    

    public caballo(int x, int y, String color) {
        super(new posicion(x, y), color, "caballo");
    }
    
    public boolean val (tablero tablero, posicion p){
    return super.val(this.posibles(tablero), p);
    }

    @Override
    public ArrayList posibles(tablero t){
        ArrayList<posicion> posiciones = new ArrayList();
        for(int i =super.getPX()-2; i<= super.getPX()+2; i=i+4){
            if(i >= 0 && i < 8){
                for(int j=super.getPY()-1; j<= super.getPY()+1; j=j+2){
                    if(j > 0 && j < 8){
                        if(!(t.Bloqueada(this, i, j))){
                            posiciones.add(new posicion(i, j));
                        }
                    }
                }
            }
        }
        for(int i =super.getPY()-2; i<= super.getPY()+2; i=i+4){
            if(i >= 0 && i < 8){
                for(int j=super.getPX()-1; j<= super.getPX()+1; j=j+2){
                    if(j > 0 && j < 8){
                        if(!(t.Bloqueada(this, j, i))){
                            posiciones.add(new posicion(j, i));
                        }
                    }
                }
            }
        }
        return posiciones;
    }
}
