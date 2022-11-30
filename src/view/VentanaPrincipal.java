package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame
{
    Container panel;
    public Tablero lienzo;

    public VentanaPrincipal() {
        super("Ejemplo de juego en linea");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = getContentPane();
        panel.setLayout(new FlowLayout());

        lienzo = new Tablero();
        panel.add(lienzo);// se conecta al servidor
    }
}











