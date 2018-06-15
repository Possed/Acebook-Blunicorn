package com.makersacademy.acebook;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Post {

    private @Id @GeneratedValue Long id;
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Integer likes = 0;


    private Post() {}

    public Post(String content) {
        this.content = content;
    }

}
