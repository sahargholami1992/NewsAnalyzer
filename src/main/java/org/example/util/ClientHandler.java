package org.example.util;

import org.example.entity.NewsItem;
import org.example.newsAnalyzer.NewsAnalyzer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private static final int port = 11111;

    @Override
    public void run() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());
                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                NewsItem receivedNewsItem = (NewsItem) inputStream.readObject();
                NewsAnalyzer.newsItemReceived(receivedNewsItem);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
