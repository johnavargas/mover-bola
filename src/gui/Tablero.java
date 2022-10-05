package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tablero extends Canvas implements MouseListener, KeyListener {
    int x = 10, y = 10, x2=50, y2=50;
    int radio = 25;
    Timer reloj;
    Color color = Color.black;

    public Tablero(Timer reloj)
    {
        super();
        setBackground(Color.white);
        setSize(390, 400);
        addMouseListener(this);
        addKeyListener(this);
        this.reloj = reloj;
   }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radio*2, radio*2);

        g.setColor(Color.blue);
        g.fillOval(x2, y2, 30, 30);
    }

    public void mover(){
        if (x < 340 && y == 10)
            x += 2;

        if (x == 340 && y < 350)
            y += 2;

        if (y == 340 && x > 10)
            x -= 2;

        if (x == 10 && y > 10)
            y -= 2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        int p = mouseEvent.getX();
        int q = mouseEvent.getY();

        if (Math.pow(p - x - radio, 2) + Math.pow(q - y - radio, 2) <= radio*radio) {
            reloj.stop();
            color = Color.red;
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_UP:
                y2 -= 2;
                break;
            case KeyEvent.VK_RIGHT:
                x2 += 2;
                break;
            case KeyEvent.VK_DOWN:
                y2 += 2;
                break;
            case KeyEvent.VK_LEFT:
                x2 -= 2;
                break;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
