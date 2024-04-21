package com.main.Interview_Question.X05NetWork.x01socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: qxd
 * @date: 2024/4/16
 * @description:
 */
public class Server {
    private static final int PORT = 5555;
    private static Set<PrintWriter> clientWriters = new HashSet<>();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running...");
            while (true) {
                // 等待客户端连接
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                // 为每个客户端连接创建一个新线程
                Thread clientThread = new Thread(() -> {
                    try {
                        // 获取客户端的输入流和输出流
                        BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                        // 将客户端的输出流加入到客户端写入集合中
                        synchronized (clientWriters) {
                            clientWriters.add(writer);
                        }

                        // 读取客户端发送的消息并广播给所有客户端
                        String message;
                        while ((message = reader.readLine()) != null) {
                            System.out.println("Received from client: " + message);
                            broadcast(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        // 客户端断开连接时，将其输出流从客户端写入集合中移除，并关闭套接字
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 广播消息给所有连接的客户端
    private static void broadcast(String message) {
        synchronized (clientWriters) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }
}
