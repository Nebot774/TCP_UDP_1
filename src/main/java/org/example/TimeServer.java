package org.example;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeServer {
    public static void main(String[] args) throws IOException {

    //creamos un socket de servidor en el puerto 6789
        ServerSocket serverSocket = new ServerSocket(6789);

        while (true){
            //esperamos conexiones de clientes
            Socket clientSocket=serverSocket.accept();

            //creamos un buffer para leer mensajes del cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //creamos un PrinWriter para enviar mensajes al cliente
            PrintWriter out=new PrintWriter(clientSocket.getOutputStream(), true);

            //leemos el mensaje del cliente
            String request=in.readLine();

            //si el cliente introduze time enviamos la hora actual
            if ("time".equals(request)) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                out.println(now.format(formatter));
            }


            //cerramos conexiones
            in.close();
            out.close();
            clientSocket.close();


        }





    }
}