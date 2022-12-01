package model;

import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Servidor
{
    public Servidor()
    {
        int portNumber = 1234;
        ArrayList<Despachador> escritores = new ArrayList<>();
        HashMap<String, Jugador> jugadores = new HashMap<>();

        try {
                ServerSocket serverSocket = new ServerSocket(portNumber);
                while (true)
                {
                    Socket clientSocket = serverSocket.accept();

                    Despachador lector = new Despachador(clientSocket);
                    escritores.add(lector);
                    lector.escritores = escritores;
                    lector.jugadores = jugadores;
                    lector.start();

                    //clientSocket.close();
                }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
