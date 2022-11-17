package net;

import java.net.*;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        int portNumber = 1234;
        ArrayList<Despachador> escritores = new ArrayList<>();

        try {
                ServerSocket serverSocket = new ServerSocket(portNumber);
                while (true) {
                    Socket clientSocket = serverSocket.accept();

                    Despachador lector = new Despachador(clientSocket, "lector");
                    lector.start();
                    lector.escritores = escritores;

                    Despachador escritor = new Despachador(clientSocket, "escritor");
                    escritores.add(escritor);
                    escritor.start();

                    //clientSocket.close();
                }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
