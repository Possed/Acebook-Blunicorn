package com.makersacademy.acebook;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

import static javax.persistence.CascadeType.*;
import static javax.persistence.CascadeType.DETACH;

@Data
@Entity
@Table(name="comments")
public class Comment {

    private @Id @GeneratedValue Long id;
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="post_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Post post;

    @ManyToOne
    @JoinColumn(name="user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private Comment() {}

    public Comment(String content) {
        this.content = content;
    }

    public Comment(String content, Post post) {
        this.post = post;
        this.content = content;
    }
}
