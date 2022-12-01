package view;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame
{
    private Container panel;
    private Tablero lienzo;

    public VentanaPrincipal() {
        super("Ejemplo de juego en linea");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = getContentPane();
        panel.setLayout(new FlowLayout());

        lienzo = new Tablero();
        panel.add(lienzo);// se conecta al servidor
    }

    public Tablero getLienzo() {
        return lienzo;
    }
}











