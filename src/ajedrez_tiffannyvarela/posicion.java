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
public class posicion {
    private int x;
    private int y;

    public posicion() {
    }

    public posicion(int x, int y) {
        this.setPX(x);
        this.setPY(y);
    }

    public int getPX() {
        return x;
    }

    public void setPX(int x) {
        this.x = x;
    }

    public int getPY() {
        return y;
    }

    public void setPY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        String l = "abcdefgh";
        return l.substring(this.getPX(), this.getPY()+1)+(this.getPY()+1);
    }
    
    
    
    public posicion(String pos) throws Exception {
        this.setPosi(pos);
    }
    
    public void setPosi (String pos) throws Exception{
        this.setPX(this.ti(pos.substring(0, 1)));
        this.setPY(Integer.parseInt(pos.substring(1, 2))-1);
        System.out.print(this.toString());
    }
    
    public int ti (String l) throws Exception{
        String ls="abcdefgh";
        for (int i = 0; ls.length() < 10; i++) {
            if (ls.subSequence(i, i+1).equals(l)) {
                return i;
            }
        }
        throw new Exception(l);
    }
    
    public boolean equals(posicion pos){
        if (this.getPX()==pos.getPX() && this.getPY()==pos.getPY()) {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
