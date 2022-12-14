package controller;

import model.Cliente;
import model.Despachador;
import model.Jugador;
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
    }

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


}
