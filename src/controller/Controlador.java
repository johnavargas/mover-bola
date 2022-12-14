package controller;

import model.Cliente;
import model.Despachador;
import model.Jugador;
import view.VentanaPrincipal;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;

public class Controlador implements KeyListener, WindowListener
{
    VentanaPrincipal vista;
    public HashMap<String, Jugador> jugadores = new HashMap<>();
    public String jugadorPresente = "";
    public Despachador despachador;

    public Controlador(VentanaPrincipal v)
    {
        vista = v;
        vista.getLienzo().setJugadores( jugadores );
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) { }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                jugadores.get(jugadorPresente).moverY(-2);
                break;
            case KeyEvent.VK_RIGHT:
                jugadores.get(jugadorPresente).moverX(2);
                break;
            case KeyEvent.VK_DOWN:
                jugadores.get(jugadorPresente).moverY(2);
                break;
            case KeyEvent.VK_LEFT:
                jugadores.get(jugadorPresente).moverX(-2);
                break;
        }

        int _x = jugadores.get(jugadorPresente).getX();
        int _y = jugadores.get(jugadorPresente).getY();
        despachador.send("mover:"+jugadorPresente+","+_x+","+_y );
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }

    private void ingresar(){
        String color = JOptionPane.showInputDialog(vista, "Color: ");
        despachador.send("login:"+color);
        jugadorPresente = color;

        vista.setTitle(vista.getTitle() + " - " + color);
    }

    /**
     * Conectar un cliente a la red del programa
     */
    public void conectar()
    {
        Cliente conexion = new Cliente("localhost", 1234);
        try {
            despachador = conexion.conectar(vista);

            if (despachador != null) {
                ingresar();
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error: " + e.getMessage());
        }
    }


    @Override
    public void windowOpened(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {

    }

    @Override
    public void windowClosed(WindowEvent windowEvent) {
        despachador.send("logout:"+jugadorPresente);
    }

    @Override
    public void windowIconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) {

    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {

    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {

    }
}
