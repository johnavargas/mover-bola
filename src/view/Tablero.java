package view;

import model.Jugador;

import java.awt.*;
import java.util.HashMap;

public class Tablero extends Canvas {

    private HashMap<String, Jugador> jugadores = new HashMap<>();

    public Tablero()
    {
        super();
        setBackground(Color.white);
        setSize(390, 400);
   }

    public void paint(Graphics g) {
        for (Jugador j: jugadores.values()) {
            g.setColor(j.getLogin());
            g.fillOval(j.getX(), j.getY(), 30, 30);
        }
    }

    public void setJugadores(HashMap<String, Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
    }
}
