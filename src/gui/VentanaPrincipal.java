package gui;

import net.*;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame
{
    Container panel;
    public Tablero lienzo;
    public Despachador despachador;

    public VentanaPrincipal() {
        super("Ejemplo de juego en linea");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = getContentPane();
        panel.setLayout(new FlowLayout());

        lienzo = new Tablero();
        panel.add(lienzo);

        Cliente c = new Cliente();
        c.conectar(this, lienzo); // se conecta al servidor

        conectar();  // conecta el usuario con el juego en linea
    }

    public void conectar(){
        String color = JOptionPane.showInputDialog(this, "Color: ");
        despachador.send("login:"+color);
        lienzo.jugadorPresente = color;
    }
}











