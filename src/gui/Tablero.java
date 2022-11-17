package gui;

import net.Despachador;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Tablero extends Canvas implements KeyListener {

    public HashMap<String, Jugador> jugadores = new HashMap<>();
    public String jugadorPresente = "";
    public Despachador despachador;

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
/*
    public void mover(String[] datosJugador){
        jugadores.get(datosJugador[0]).x = Integer.parseInt(datosJugador[1]);
        jugadores.get(datosJugador[0]).y = Integer.parseInt(datosJugador[2]);
        repaint();
    }

    public void adicionarJugador(String login){
        Color c = Color.black;
        System.out.println("login: " + login);
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
*/
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

        int _x = jugadores.get(jugadorPresente).x;
        int _y = jugadores.get(jugadorPresente).y;
        despachador.send("mover:"+jugadorPresente+","+_x+","+_y );
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }
}
