package gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Tablero extends Canvas implements KeyListener {

    HashMap<String, Jugador> jugadores = new HashMap<>();
    public String jugadorPresente = "";

    public Tablero()
    {
        super();
        setBackground(Color.white);
        setSize(390, 400);
        addKeyListener(this);
   }

    public void paint(Graphics g) {
        for (Jugador j: jugadores.values()) {
            g.setColor(j.login);
            g.fillOval(j.x, j.y, 30, 30);
        }
    }

    public void mover(){
    }

    public void adicionarJugador(String login){
        Color c = Color.black;
        switch (login){
            case "rojo": c = Color.RED;
                break;
            case "verde": c = Color.GREEN;
                break;
            case "azul": c = Color.BLUE;
                break;
        }
        jugadores.put(login , new Jugador(c, 10, 10));
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) { }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                jugadores.get(jugadorPresente).y -= 2;
                break;
            case KeyEvent.VK_RIGHT:
                jugadores.get(jugadorPresente).x  += 2;
                break;
            case KeyEvent.VK_DOWN:
                jugadores.get(jugadorPresente).y  += 2;
                break;
            case KeyEvent.VK_LEFT:
                jugadores.get(jugadorPresente).x -= 2;
                break;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }
}
