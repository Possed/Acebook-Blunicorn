package com.makersacademy.acebook;
import javax.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import java.util.Date;
import static javax.persistence.TemporalType.TIMESTAMP;

@Data
@Entity
public class Post {

    private @Id @GeneratedValue Long id;
    private String content;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdAt;

    private Post() {}

    public Post(String content) {
        this.content = content;
    }

}
