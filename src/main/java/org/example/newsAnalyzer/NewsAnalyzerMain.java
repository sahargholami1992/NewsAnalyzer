package org.example.newsAnalyzer;

import org.example.util.ClientHandler;
import org.example.util.ReportTask;
import java.util.Timer;

public class NewsAnalyzerMain {
    public static void main(String[] args) {
        Thread clientThread = new Thread(new ClientHandler());
        clientThread.start();
        Timer timer = new Timer();
        timer.schedule(new ReportTask(), 0, 10000);
    }
}
