package com.makersacademy.acebook;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.*;

@Data
@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="content")
    private String content;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany
    @JoinColumn(name="post_id")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private Post() {}

    public Post(String content) {
        this.content = content;
    }

    public Post(String content, User user) {
        this.content = content;
        this.user = user;
    }

}
