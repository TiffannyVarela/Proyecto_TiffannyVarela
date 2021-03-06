/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez_tiffannyvarela;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author tiffa
 */
public class Gui extends JFrame{

    private tablero t;
    private JPanel panelTablero;

    private JPanel panelConfiguracionJugadores;
    
    private JPanel panelStatus;
    private JTextField setNombreUsuario1, setNombreUsuario2;
    private JLabel lblNombreUsuario1, lblNombreUsuario2;
    private JButton iniciarJuego;
    private JButton b[][];
    private posicion pIni;
    
    private JButton turno;
    private JLabel lblTurno;
    
    private JButton reiniciar;
    private JLabel j1, j2;
    private JLabel juegosGanadosJ1, juegosGanadosJ2;
    
    public Gui(){
        t = new tablero("", "");
        this.setTitle("Ajedrez");
        this.setLayout(null);
        this.setSize(800, 600);
        this.setVisible(true);
        this.getPanelJugadores();
        panelConfiguracionJugadores.setVisible(true);
        panelTablero = new JPanel();
        panelTablero.setLayout(new GridLayout(8,8));
        panelTablero.setBounds(0,0, 600, 600);
        this.addButtons();
        this.add(panelTablero);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getPanelStatus();
        actualizarPiezas();
        panelTablero.setVisible(false);
        panelStatus.setVisible(false);
    }
    
    public void actualizarPiezas(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                pieza p = t.getpieza(j, i);
                if(p != null){
                    b[i][j].setIcon(p.getIcon());
                }else{
                    b[i][j].setIcon(null);
                }
            }
        }
        if(t.getTurno().getColor().equals("Blanco")){
            turno.setBackground(Color.white);
        }else{
            turno.setBackground(Color.black);
        }
        j1.setText("J1: "+t.getJ1().getNombre());
        juegosGanadosJ1.setText(Integer.toString(t.getJ1().getGanados())+ " juegos ganados. Color:" + t.getJ1().getColor());
        j2.setText("J2: "+t.getJ2().getNombre());
        juegosGanadosJ2.setText(Integer.toString(t.getJ2().getGanados())+ " juegos ganados. Color:" + t.getJ2().getColor());
        
    }
    
    public void addButtons(){
        b = new JButton[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                b[i][j] = new JButton();
                pieza p = t.getpieza(j, i);
                if(p != null){
                    b[i][j].setIcon(p.getIcon());
                }
                
                if(i%2 == 0 && j%2 == 0){
                    b[i][j].setBackground(new Color(209, 139, 71));
                }else if(i%2 != 0 && j%2 != 0){
                    b[i][j].setBackground(new Color(209, 139, 71));
                }else{
                    b[i][j].setBackground(new Color(255, 206, 158));
                }
                
                b[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        JButton b = (JButton) e.getSource();

                        int x = b.getX() / b.getWidth();
                        int y = b.getY() / b.getHeight();

                        
                        if(pIni == null){
                            if(t.getpieza(new posicion(x,y)) != null){
                                if(t.getTurno().getColor().equals(t.getpieza(new posicion(x, y)).getColor())){
                                    pIni = new posicion(x,y);
                                }else{
                                    JOptionPane.showMessageDialog(rootPane,"El turno es del jugador "+t.getTurno().getNombre()+"("+t.getTurno().getColor()+")");
                                }
                            }
                        }else{
                            boolean r = t.mover(pIni, new posicion(x, y));
                            if(!r){
                                JOptionPane.showMessageDialog(rootPane,"Movimiento invalido!");
                            } else if(!t.isSelec()){
                                JOptionPane.showMessageDialog(rootPane,"Juego Finalizado, ha ganado "+t.getJ1().getNombre());
                                finalizarJuego();
                            }
                            pIni = null;
                        }

                        actualizarPiezas();
                        
                        
                    }
                });
                
                panelTablero.add(b[i][j]);
            }
        }
    }
    public void finalizarJuego(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                b[i][j].setEnabled(false);
            }
        }
    }
    
    public void getPanelJugadores (){
        panelConfiguracionJugadores = new JPanel();
        panelConfiguracionJugadores.setLayout(null);

        lblNombreUsuario1 = new JLabel("Nombre Jugador 1");
        lblNombreUsuario1.setBounds(50, 50, 250, 50);
        lblNombreUsuario1.setFont(new Font("Arial", 0, 25));
        panelConfiguracionJugadores.add(lblNombreUsuario1);
        
        setNombreUsuario1 = new JTextField();
        setNombreUsuario1.setBounds(290, 50, 450, 50);
        setNombreUsuario1.setFont(new Font("Arial", 0, 20));
        setNombreUsuario1.setMargin(new Insets(0, 10, 0, 10));
        panelConfiguracionJugadores.add(setNombreUsuario1);
        

        lblNombreUsuario2 = new JLabel("Nombre Jugador 2");
        lblNombreUsuario2.setBounds(50, 120, 250, 50);
        lblNombreUsuario2.setFont(new Font("Arial", 0, 25));
        panelConfiguracionJugadores.add(lblNombreUsuario2);
        
        setNombreUsuario2 = new JTextField();
        setNombreUsuario2.setBounds(290, 120, 450, 50);
        setNombreUsuario2.setFont(new Font("Arial", 0, 20));
        setNombreUsuario2.setMargin(new Insets(0, 10, 0, 10));
        panelConfiguracionJugadores.add(setNombreUsuario2);
        
        iniciarJuego = new JButton("Iniciar Juego");
        iniciarJuego.setBounds(290,190,450,50);
        iniciarJuego.setFont(new Font("Arial", 0, 20));

        iniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!setNombreUsuario1.getText().equals("") && !setNombreUsuario2.getText().equals("")){
                    t = new tablero(setNombreUsuario1.getText(), setNombreUsuario2.getText());
                    panelTablero.setVisible(true);
                    panelStatus.setVisible(true);
                    panelConfiguracionJugadores.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(rootPane, "Debe Ingresar los nombres de los Jugadores");
                }
            }
        });
        panelConfiguracionJugadores.add(iniciarJuego);
        ImageIcon imagen = new ImageIcon("./src/Pieza/907874.jpg");
        
        JLabel background = new JLabel();
        
        background.setBounds(0, 0, 800, 600);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_DEFAULT));
        background.setIcon(icono);
        panelConfiguracionJugadores.add(background);
        
        panelConfiguracionJugadores.setBounds(0, 0, 900, 600);
        this.add(panelConfiguracionJugadores);
    }
    
    public void getPanelStatus(){
        panelStatus = new JPanel();
        panelStatus.setBounds(600,0, 200, 600);
        panelStatus.setLayout(null);
        lblTurno = new JLabel("Turno");
        lblTurno.setBounds(10,10, 180, 20);
        lblTurno.setHorizontalAlignment(2);
        panelStatus.add(lblTurno);
        
        turno = new JButton();
        turno.setBackground(Color.gray);
        turno.setBounds(10, 30, 180, 100);
        panelStatus.add(turno);
        this.add(panelStatus);
        
        j1 = new JLabel();
        j1.setBounds(10, 165, 180, 25);
        j1.setFont(new Font("Arial", 0, 20));
        panelStatus.add(j1);
        juegosGanadosJ1 = new JLabel();
        juegosGanadosJ1.setBounds(20, 185, 170, 20);
        juegosGanadosJ1.setFont(new Font("Arial", 0 , 12));
        panelStatus.add(juegosGanadosJ1);
        
        j2 = new JLabel();
        j2.setBounds(10, 210, 180, 25);
        j2.setFont(new Font("Arial", 0, 18));
        panelStatus.add(j2);
        juegosGanadosJ2 = new JLabel();
        juegosGanadosJ2.setBounds(20, 230, 170, 20);
        juegosGanadosJ2.setFont(new Font("Arial", 0 , 12));
        panelStatus.add(juegosGanadosJ2);
        
        
        
        
        reiniciar = new JButton("Reiniciar");
        reiniciar.setBounds(10, 135, 180, 25);
        reiniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                reiniciar();
            }
        });
        
        panelStatus.add(reiniciar);
    }
    
    public void reiniciar(){
        t.nuevoJuego();
        actualizarPiezas();
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                b[i][j].setEnabled(true);
            }
        }
    }
}
