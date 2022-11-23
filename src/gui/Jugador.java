package gui;

import java.awt.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Jugador {
    public Color login;
    public String nickname;
    public int x;
    public int y;

    public Jugador(String n, Color l, int x, int y)
    {
        nickname = n;
        login = l;
        this.x = x;
        this.y = y;
    }
}
