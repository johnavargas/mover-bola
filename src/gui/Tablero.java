package gui;

import java.awt.*;

public class Tablero extends Canvas {
    int x = 10, y = 10;

    public Tablero()
    {
        super();
        setBackground(Color.white);
        setSize(390, 400);
    }

    public void paint(Graphics g) {
        g.fillOval(x, y, 50, 50);
    }

    public void mover(){
        x += 2;
    }
}
