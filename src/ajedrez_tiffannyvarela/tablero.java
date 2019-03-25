/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez_tiffannyvarela;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author tiffa
 */
public class tablero {
    private jugadores j1;
    private jugadores j2;
    private pieza[] piezas;
    private boolean turno;
    private boolean activo;

    public tablero() {
    }

    public tablero(jugadores j1, jugadores j2, pieza[] piezas, boolean turno, boolean activo) {
        this.j1 = j1;
        this.j2 = j2;
        this.piezas = piezas;
        this.turno = turno;
        this.activo = activo;
    }
    
    public tablero(String ju1, String ju2) {
        this.setJ1(new jugadores(ju1, "blanco"));
        this.setJ2(new jugadores(ju2, "negro"));
        
    }

    public jugadores getJ1() {
        return j1;
    }

    public void setJ1(jugadores j1) {
        this.j1 = j1;
    }

    public jugadores getJ2() {
        return j2;
    }

    public void setJ2(jugadores j2) {
        this.j2 = j2;
    }

    public pieza[] getpiezas() {
        return piezas;
    }

    public void setpiezas(pieza[] piezas) {
        this.piezas = piezas;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public boolean isSelec() {
        return activo;
    }

    public void isSelec(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString(){
        String e = "|", res = "";
        int ancho = 0;

        for (int i = 7; i >=0 ; i--){
            res += (i + 1) + " " + e +" ";
            for (int j = 0; j < 8; j++){
                if(this.getpiezapos(j, i) != -1) {
                    res += piezas[this.getpiezapos(j, i)].getNombre().subSequence(0, 2) + "" + piezas[this.getpiezapos(j, i)].getColor().subSequence(0, 1) + " " + e + " ";
                }else {
                    res += "    " + e + " ";
                }
            }
            res += "\n";
            if (i == 7) {
                ancho = res.length();
                res = "\n" + res;
                for (int h = 0; h < ancho ; h++) {
                    res = "-"+res;
                }
            }
            for (int h = 0; h < ancho ; h++) {
                res += "-";
            }
            res += "\n";
        }
        res = "    a     b     c     d     e     f     g     h \t\n" + res;
        return res;
    }
    
    public void iniciar (){
        String color;
        int c=0;
        for (int i = 0; i < 8; i++) {
            if(i== 0 || i == 1){
                color = j1.getColor();
            }else{
                color = j2.getColor();
            }
            for(int j=0; j<8; j++){ //columnas (x)
                if(i == 0 || i==7){
                    if(j== 0 || j == 7){
                        piezas[c] = new torre(j, i, color);
                    }else if(j == 1 || j == 6){
                        piezas[c] = new alfil(j, i, color);
                    }else if(j == 2 || j == 5){
                        piezas[c] = new caballo(j, i, color);
                    }else if(j == 3){
                        piezas[c] = new rey(j, i, color);
                    }else if(j == 4){
                        piezas[c] = new reina(j, i, color);
                    }
                    c++;
                }else if(i == 1 || i == 6){
                    piezas[c] = new peon(j, i, color);
                    c++;
                }
            }
        }
    }
    
    public jugadores getTurno() {
        if (this.isTurno()) {
            return this.getJ2();
        }
        else{
            return this.getJ1();
        }
    }
    
    public boolean mover(posicion posInicio, posicion posFinal){
        boolean result= false;
        if(this.getpiezapos(posInicio) != -1){
            if(this.getTurno().getColor().equals(this.piezas[this.getpiezapos(posInicio)].getColor())){
                if(this.getpiezas()[this.getpiezapos(posInicio)].val(this, posFinal)){
                    if(this.getpiezapos(posFinal) != -1){
                        if(this.getTurno().getColor().equals(this.piezas[this.getpiezapos(posInicio)].getColor())){
                            this.comer(posFinal);
                        }
                    }
                    this.piezas[this.getpiezapos(posInicio)].mov(posFinal);
                    result = true;
                    if(this.isTurno()){
                        this.setTurno(false);
                    }else{
                        this.setTurno(true);
                    }  
                }
            }
        }
        return result;
    }
    
        public void comer(posicion p){
        if(this.getpieza(p).getNombre().equals("Rey")){
            this.isSelec(false);
            if(this.isTurno()){
                this.j1.addGanadados();
            }else{
                this.j2.addGanadados();
            }
        }
        this.piezas[this.getpiezapos(p)].setSelec(false);
    }

    public boolean mover(String movimiento){
        movimiento = movimiento.toUpperCase();
        String pos[];
        pos = movimiento.split("-");
        if(movimiento.replace("-", "").length() == 4){
            try{
                return this.mover(new posicion(pos[0]), new posicion(pos[1]));
            }catch(Exception e){
                return false;
            }
        }else{
            return false;
        }
        
    }

    public boolean Bloqueada(pieza p, int posX, int posY){
        if(this.getpiezapos(posX, posY) != -1){
            if(!(this.getpieza(posX, posY).getColor().equals(p.getColor()))){
                return false;
            }
            return true;
        }else{
            return false;
        }
    }

    public int getpiezapos(posicion p){
        int index=-1;
        for(int i=0; i<piezas.length; i++){
            if(piezas[i].getPX() == p.getPX() && piezas[i].getPY() == p.getPY()){
                if(piezas[i].isSelec()){
                    index = i;
                }
            }
        }
        return index;
    }

    public int getpiezapos(int posX, int posY){
        return this.getpiezapos(new posicion(posX, posY));
    }
    
    public pieza getpieza(int posX, int posY){
        return this.getpieza(new posicion(posX, posY));
    }

    public pieza getpieza(posicion p){
        if(this.getpiezapos(p) != -1){
            return this.getpiezas()[this.getpiezapos(p)];
        }else{
            return null;
        }
    }

    public void nuevoJuego(){
        this.iniciar();
        this.setTurno(true);
        this.isSelec(true);
    }
    
    public boolean Contraria(pieza p, int posX, int posY) throws Exception{
        if(p.getPX() != posX || p.getPY() != posY){
            if(posX >= 0 && posX < 8 && posX >= 0 && posX < 8){
                if(!(this.getpieza(posX, posY).getColor().equals(p.getColor()))){
                    return true;
                }else{
                    return false;
                }
            }
        }
        throw new Exception();
    }
    
    
}
