package gui;

import java.awt.*;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class Jugador {
    public Color login;
    public int x;
    public int y;

    public Jugador(Color l, int x, int y)
    {
        login = l;
        this.x = x;
        this.y = y;
    }
}
