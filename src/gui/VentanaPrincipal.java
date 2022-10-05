package gui;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame
{
    Container panel;
    Tablero lienzo;
    Timer reloj;

    public VentanaPrincipal() {
        super("Ejemplo de animacion");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel = getContentPane();
        panel.setLayout(new FlowLayout());

        JButton btnIniciar = new JButton("Iniciar");
        panel.add(btnIniciar);

        JButton btnDetener = new JButton("Detener");
        panel.add(btnDetener);

        reloj = new Timer(20, actionEvent -> {
            lienzo.mover();
            lienzo.repaint();
        });

        lienzo = new Tablero(reloj);
        panel.add(lienzo);

        btnIniciar.addActionListener(actionEvent -> {
            reloj.start();
        });

        btnDetener.addActionListener(actionEvent -> {
            reloj.stop();
        });
    }
}
