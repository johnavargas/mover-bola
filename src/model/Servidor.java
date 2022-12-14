package model;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Servidor
{
    private int portNumber;
    private int max_num_jugadores;
    private ArrayList<Despachador> escritores = new ArrayList<>();
    private HashMap<String, Jugador> jugadores = null;

    public Servidor(int portNumber, int max_num_jugadores) {
        this.portNumber = portNumber;
        this.max_num_jugadores = max_num_jugadores;
        jugadores = Almacen.leer();
    }

    public void conectar() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(portNumber);
        while (true)
        {
            Socket clientSocket = serverSocket.accept();

            Despachador lector = new Despachador(clientSocket);
            escritores.add(lector);
            lector.escritores = escritores;
            lector.jugadores = jugadores;
            lector.start();
        }

        //serverSocket.close();
    }
}
