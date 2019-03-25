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
public class reina extends pieza{
    public reina(int x, int y, String color ){
        super(new posicion(x, y),  color, "Reina");
    }
    
    public boolean val(tablero t, posicion p){
        return super.val(this.posibles(t), p);
    }
    @Override
    public ArrayList posibles(tablero t){
        ArrayList<posicion> posiciones = new ArrayList();
        for(int i=super.getPX()+1; i<8; i++){ 
            try{
                if(t.Bloqueada(this, i, super.getPY())){
                    if(t.Contraria(this, i, super.getPY())){
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
                if(t.Bloqueada(this, i, super.getPY())){
                    if(t.Contraria(this, i, super.getPY())){
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
                if((t.Bloqueada(this, super.getPX(), i))){
                    if((t.Contraria(this, super.getPX(), i))){
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
                if((t.Bloqueada(this, super.getPX(), i))){
                    if((t.Contraria(this, super.getPX(), i))){
                        posiciones.add(new posicion(super.getPX(), i));
                    }
                    break;
                }else {
                    posiciones.add(new posicion(super.getPX(), i));
                }
            }catch(Exception e){}
        }
        for (int i=1; i<8; i++){
            if(super.getPX()+i <8 && super.getPX()+i >=0 && super.getPY()+i <8 && super.getPY()+i >=0 ){
                try{
                    if(t.Bloqueada(this, super.getPX() + i, super.getPY() + i)){
                        if(t.Contraria(this, super.getPX() + i, super.getPY() + i)){
                            posiciones.add(new posicion(super.getPX() + i, super.getPY() + i));
                        }
                        break;
                    }else {
                        posiciones.add(new posicion(super.getPX() + i, super.getPY() + i));
                    }
                }catch(Exception e){}
            }
        }
        for (int i=1; i<8; i++){
            if(super.getPX()-i <8 && super.getPX()-i >=0 && super.getPY()+i <8 && super.getPY()+i >=0 ){
                try{
                    if(t.Bloqueada(this, super.getPX() - i, super.getPY() + i)){
                        if(t.Contraria(this, super.getPX() - i, super.getPY() + i)){
                            posiciones.add(new posicion(super.getPX() - i, super.getPY() + i));
                        }
                        break;
                    }else {
                        posiciones.add(new posicion(super.getPX() - i, super.getPY() + i));
                    }
                }catch(Exception e){}
            }
        }
        for (int i=1; i<8; i++){
            if(super.getPX()+i <8 && super.getPX()+i >=0 && super.getPY()-i <8 && super.getPY()-i >=0 ){
                try{
                    if(t.Bloqueada(this, super.getPX() + i, super.getPY() - i)){
                        if(t.Contraria(this, super.getPX() + i, super.getPY() - i)){
                            posiciones.add(new posicion(super.getPX() + i, super.getPY() - i));
                        }
                        break;
                    }else {
                        posiciones.add(new posicion(super.getPX() + i, super.getPY() - i));
                    }
                }catch(Exception e){}
            }
        }
        for (int i=1; i<8; i++){
            if(super.getPX()-i <8 && super.getPX()-i >=0 && super.getPY()-i <8 && super.getPY()-i >=0 ){
                try{
                    if(t.Bloqueada(this, super.getPX() - i, super.getPY() - i)){
                        if(t.Contraria(this, super.getPX() - i, super.getPY() - i)){
                            posiciones.add(new posicion(super.getPX() - i, super.getPY() - i));
                        }
                        break;
                    }else {
                        posiciones.add(new posicion(super.getPX() - i, super.getPY() - i));
                    }
                }catch(Exception e){}
            }
        }
        return posiciones;
    }
    
}
