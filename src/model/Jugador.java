package model;

import java.awt.*;

public class Jugador {
    private Color login;
    private String nickname;
    private int x;
    private int y;

    public Jugador(String n, Color l, int x, int y)
    {
        nickname = n;
        login = l;
        this.x = x;
        this.y = y;
    }

    public void moverX(int h)
    {
        x += h;
    }

    public void moverY(int h)
    {
        y += h;
    }

    public Color getLogin() {
        return login;
    }

    public void setLogin(Color login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
