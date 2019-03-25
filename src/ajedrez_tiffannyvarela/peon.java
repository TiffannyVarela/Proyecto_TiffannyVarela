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
public class peon extends pieza{
    private boolean primero;
    private posicion posIn;

    public peon(int x, int y, String color ){
        super(new posicion(x, y),  color,  "peon");
        this.setPosInicial(new posicion(x, y));
        this.setPrimero(true);
    }

    public boolean isPrimero() {
        return primero;
    }

    public void setPrimero(boolean primero) {
        this.primero = primero;
    }

    public posicion getPosInicial() {
        return posIn;
    }

    public void setPosInicial(posicion pos) {
        this.posIn = pos;
    }

    public boolean val(tablero tablero , posicion p){
        return  super.val(this.posibles(tablero), p);
    }

    public void mover(posicion p){
        super.mov(p);
        this.setPrimero(false);
    }

    @Override
    public ArrayList posibles(tablero t){
        ArrayList<posicion> posiciones = new ArrayList();
        try{
            if(this.getPosInicial().getPY() == 6){
                for(int i=super.getPX()-1; i<= super.getPX()+1; i++){
                    if(i>= 0 && i<8){
                        if(t.getpiezapos(i, super.getPY()-1) == -1){
                            if(super.getPX() == i){
                                posiciones.add(new posicion(i, super.getPY()-1));
                            }
                        }else if(i != super.getPX() && !(t.getpieza(i, super.getPY()-1).getColor().equals(super.getColor()))){
                            posiciones.add(new posicion(i, super.getPY()-1));
                        }
                    }
                }
                if(this.isPrimero() == true && t.getpiezapos(super.getPX(), super.getPY()-2) == -1){
                    posiciones.add(new posicion(super.getPX(), super.getPY()-2));
                }
            }else{
                for(int i=super.getPX()-1; i<= super.getPX()+1; i++){
                    if(i>= 0 && i<8){
                        if(t.getpiezapos(i, super.getPY()+1) == -1){
                            if(super.getPX() == i){
                                posiciones.add(new posicion(i, super.getPY()+1));
                            }
                        }else if(i != super.getPX() && !(t.getpieza(i, super.getPY()+1).getColor().equals(super.getColor()))){
                            posiciones.add(new posicion(i, super.getPY()+1));
                        }
                    }
                }
                if(this.isPrimero() == true && t.getpiezapos(super.getPX(), super.getPY()+2) == -1){
                    posiciones.add(new posicion(super.getPX(), super.getPY()+2));
                }
            }
        }catch(Exception e){
            
        }
        return posiciones;
    }
}
