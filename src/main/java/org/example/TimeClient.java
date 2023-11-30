package org.example;

import java.io.*;
import java.net.*;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TimeClient {
    public static void main(String[] args) throws IOException {
        // Crear un socket para conectarse al servidor en el puerto 6789
        Socket socket = new Socket("localhost", 6789);

        // Crear un PrintWriter para enviar mensajes al servidor
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // Crear un BufferedReader para leer mensajes del servidor
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // Crear un Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese 'time' para obtener la hora actual del servidor:");

        // Leer la entrada del usuario
        String userInput = scanner.nextLine();

        // Verificar si el usuario ingresó "time"
        if ("time".equals(userInput)) {
            // Enviar mensaje "time" al servidor
            out.println(userInput);

            // Leer y mostrar la respuesta del servidor
            String response = in.readLine();
            System.out.println("Server time: " + response);
        } else {
            System.out.println("Comando no reconocido.");
        }

        // Cerrar recursos
        scanner.close();
        out.close();
        in.close();
        socket.close();
    }
}


