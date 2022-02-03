package laustrup.shoutback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Data
@Setter
@Getter
public class Post {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false) private User author;

    @Column(nullable = false, length = 30) private String title;
    @Lob @Column(nullable = false) private String content;

    @Column(nullable = false) private LocalDate date;

    @ElementCollection @Column private List<String> hashtags;
    @JsonBackReference @OneToMany @Column private List<Comment> Comments;

    @Column(nullable = false) private boolean isPoliticalCorrect;

    // Constructor for JPA
    public Post(){}
    // Constructor for creating a post
    public Post(User author,String title, String content,
                List<String> hashtags,boolean isPoliticalCorrect) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.hashtags = hashtags;
        this.isPoliticalCorrect = isPoliticalCorrect;

        date = LocalDate.now();
        Comments = new ArrayList<>();
    }

}
