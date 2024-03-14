package org.example.entity;



import java.io.Serializable;


public class NewsItem implements Serializable {
    private static final long serialVersionUID = 12345L;
    private String headline;
    private int priority;


    public NewsItem(String headline, int priority) {
        this.headline = headline;
        this.priority = priority;
    }

    public String getHeadline() {
        return headline;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "headline='" + headline + '\'' +
                ", priority=" + priority +
                '}';
    }
}
