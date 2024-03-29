package org.example.util;

import org.example.newsAnalyzer.NewsAnalyzer;
import java.util.TimerTask;

public class ReportTask extends TimerTask {
    @Override
    public void run() {

        if (NewsAnalyzer.positiveNewsItems == null) {
            System.out.println("No newsfeed yet!");
        } else {
            System.out.println("Unique headlines of up to three of the highest-priority positive news items:");
            System.out.println(NewsAnalyzer.getUniqueWordsPerItem());
            System.out.println(NewsAnalyzer.positiveCount);
            System.out.println("---------------------------------------------");
        }
        NewsAnalyzer.positiveCount = 0;
        NewsAnalyzer.positiveNewsItems.clear();
    }
}


