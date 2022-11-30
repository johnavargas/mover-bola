package view;

import model.Despachador;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Tablero extends Canvas {

    public HashMap<String, Jugador> jugadores = new HashMap<>();

    public Tablero()
    {
        super();
        setBackground(Color.white);
        setSize(390, 400);
   }

    public void paint(Graphics g) {
        for (Jugador j: jugadores.values()) {
            g.setColor(j.login);
            g.fillOval(j.x, j.y, 30, 30);
        }
    }


}
