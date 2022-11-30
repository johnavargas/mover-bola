package model;

import view.Tablero;
import view.VentanaPrincipal;

import java.net.*;

public class Cliente {
    public Despachador conectar(VentanaPrincipal gui, Tablero tablero) {
        String hostName = "localhost";
        int portNumber = 1234;//Integer.parseInt(args[1]);

        try {
            Socket kkSocket = new Socket(hostName, portNumber);

            Despachador lector = new Despachador(kkSocket);
            lector.gui = gui;
            lector.start();

            return lector;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}