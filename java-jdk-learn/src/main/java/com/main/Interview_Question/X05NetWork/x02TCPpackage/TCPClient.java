package com.main.Interview_Question.X05NetWork.x02TCPpackage;

/**
 * @author: qxd
 * @date: 2024/4/16
 * @description:
 */
import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            String message;
            while ((message = reader.readLine()) != null) {
                writer.println(message);

                BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Server response: " + serverReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
