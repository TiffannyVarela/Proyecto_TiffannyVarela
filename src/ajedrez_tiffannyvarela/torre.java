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
public class torre extends pieza{
    
    public torre(int x, int y, String color ){
        super(new posicion(x, y), color, "torre");
    }
    public boolean val(tablero tablero , posicion p){
this.posibles(tablero);
        return super.val(this.posibles(tablero), p);
    }

    @Override
    public ArrayList posibles(tablero tablero){
        ArrayList<posicion> posiciones = new ArrayList();
        for(int i=super.getPX()+1; i<8; i++){ 
            try{
                if(tablero.Bloqueada(this, i, super.getPY())){
                    if(tablero.Contraria(this, i, super.getPY())){
                        posiciones.add(new posicion(i, super.getPY()));
                    }
                    break;
                }else {
                    posiciones.add(new posicion(i, super.getPY()));
                }
            }catch(Exception e){}
        }
        for(int i=super.getPX()-1; i>=0 ; i--){ 
            try{
                if(tablero.Bloqueada(this, i, super.getPY())){
                    if(tablero.Contraria(this, i, super.getPY())){
                        posiciones.add(new posicion(i, super.getPY()));
                    }
                    break;
                }else {
                    posiciones.add(new posicion(i, super.getPY()));
                }
            }catch(Exception e){}
        }
        for(int i=super.getPY()+1; i<8; i++){ 
            try{
                if((tablero.Bloqueada(this, super.getPX(), i))){
                    if((tablero.Contraria(this, super.getPX(), i))){
                        posiciones.add(new posicion(super.getPX(), i));
                    }
                    break;
                }else {
                    posiciones.add(new posicion(super.getPX(), i));
                }
            }catch(Exception e){}
        }
        for(int i=super.getPY()-1; i>=0; i--){ 
            try{
                if((tablero.Bloqueada(this, super.getPX(), i))){
                    if((tablero.Contraria(this, super.getPX(), i))){
                        posiciones.add(new posicion(super.getPX(), i));
                    }
                    break;
                }else {
                    posiciones.add(new posicion(super.getPX(), i));
                }
            }catch(Exception e){}
        }        return posiciones;
    }
}
