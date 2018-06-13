package com.makersacademy.acebook;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {
    private @Id @GeneratedValue Long id;
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;


    private Comment() {}

    public Comment(String content) {
        this.content = content;
    }
}
