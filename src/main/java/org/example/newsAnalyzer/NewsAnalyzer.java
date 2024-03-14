package org.example.newsAnalyzer;


import org.example.entity.NewsItem;

import java.util.*;
import java.util.stream.Collectors;

public class NewsAnalyzer {
    private static final String[] POSITIVE_WORDS = {"up", "rise", "good", "success", "high"};
    public static int positiveCount;
    public static List<NewsItem> positiveNewsItems = new ArrayList<>();


    private static boolean isPositive(String headline) {
        String[] words = headline.split("\\s+");
        int positiveCount = 0;
        for (String word : words) {
            for (String positiveWord : POSITIVE_WORDS) {
                if (word.equals(positiveWord)) {
                    positiveCount++;
                    break;
                }
            }
        }

        return (positiveCount * 2) > words.length;
    }

    private static List<NewsItem> priorityNewItem() {
        return positiveNewsItems.stream()
                .sorted(Comparator.comparingInt(NewsItem::getPriority).reversed())
                .limit(3).collect(Collectors.toList());


    }


    public static void newsItemReceived(NewsItem newsItem) {
        boolean isPositive = isPositive(newsItem.getHeadline());
        if (isPositive) {
            positiveNewsItems.add(newsItem);
            positiveCount++;
        }
    }


    public static Set<String> getUniqueWordsPerItem() {
        List<NewsItem> newsItemList = priorityNewItem();
        Set<String> uniqueHeadlines = new HashSet<>();
        for (NewsItem newsItem:newsItemList){
            String[] words = newsItem.getHeadline().split("\\s+");
            uniqueHeadlines.addAll(Arrays.asList(words));
        }
        return uniqueHeadlines;

    }
}




