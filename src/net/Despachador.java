package net;

import gui.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Despachador extends Thread {
    private PrintWriter out;
    private BufferedReader in;
    private String tipo = "lector";
    private Socket socket;
    public VentanaPrincipal gui = null;
    public ArrayList<Despachador> escritores = new ArrayList<>();
    public HashMap<String, Jugador> jugadores = new HashMap<>();

    public Despachador(Socket socket, String tipo) {
        try {
            this.in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
            this.socket = socket;
            this.tipo = tipo;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void run(){
        try {
            leer();
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void leer() throws IOException  {
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Recibido: " + inputLine);


            if (gui != null) {  // Cliente
                String[] datosJugadores = inputLine.split("#");
                for (String jugador: datosJugadores) {
                    System.out.println("leyendo jugador: " + jugador);
                    String[] data = jugador.split(",");
                    Color c = Color.black;
                    switch (data[0]){
                        case "rojo": c = Color.RED;
                            break;
                        case "verde": c = Color.GREEN;
                            break;
                        case "azul": c = Color.BLUE;
                            break;
                    }
                    gui.lienzo.jugadores.put(data[0] , new Jugador(data[0], c, Integer.parseInt(data[1]), Integer.parseInt(data[2])));

                }
                gui.lienzo.repaint();
            }

            if (gui == null) {  // Servidor
                String[] datos = inputLine.split(":");
                if (datos[0].equals("login")) {
                    Color c = Color.black;
                    switch (datos[1]){
                        case "rojo": c = Color.RED;
                            break;
                        case "verde": c = Color.GREEN;
                            break;
                        case "azul": c = Color.BLUE;
                            break;
                    }
                    jugadores.put(datos[1] , new Jugador(datos[1], c, 10, 10));
                } else if (datos[0].equals("mover")) {
                    String[] datosJugador = datos[1].split(",");
                    jugadores.get(datosJugador[0]).x = Integer.parseInt(datosJugador[1]);
                    jugadores.get(datosJugador[0]).y = Integer.parseInt(datosJugador[2]);
                }

                String[] lista = new String[jugadores.size()];
                int index = 0;
                for (Jugador e: jugadores.values()) {
                    lista[index++] = e.nickname + "," + e.x + "," + e.y;
                }

                for (Despachador e: escritores) {
                    e.send(String.join("#", lista));
                }
            }
        }
    }

    public void send(String inputLine)
    {
        try {
            System.out.println("Enviando: " + inputLine);
            out.println(inputLine);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}