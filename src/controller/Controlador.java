package controller;

import model.Despachador;
import view.Jugador;
import view.VentanaPrincipal;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class Controlador implements KeyListener
{
    VentanaPrincipal vista;
    public HashMap<String, Jugador> jugadores = new HashMap<>();
    public String jugadorPresente = "";
    public Despachador despachador;

    public Controlador(VentanaPrincipal v)
    {
        vista = v;
        jugadores = vista.lienzo.jugadores;
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

        int _x = jugadores.get(jugadorPresente).x;
        int _y = jugadores.get(jugadorPresente).y;
        despachador.send("mover:"+jugadorPresente+","+_x+","+_y );
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }

    public void conectar(){
        String color = JOptionPane.showInputDialog(vista, "Color: ");
        despachador.send("login:"+color);
        jugadorPresente = color;
    }
}
