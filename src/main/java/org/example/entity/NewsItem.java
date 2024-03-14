package org.example.entity;



import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewsItem implements Serializable {
    private String headline;
    private int priority;

}
