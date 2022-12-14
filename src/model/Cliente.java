package model;

import view.Tablero;
import view.VentanaPrincipal;

import java.net.*;

public class Cliente {
    private String hostName;
    private int portNumber;

    public Cliente(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    public Despachador conectar(VentanaPrincipal gui) throws Exception
    {
        Socket kkSocket = new Socket(hostName, portNumber);

        Despachador lector = new Despachador(kkSocket);
        lector.gui = gui;
        lector.start();

        return lector;
    }
}