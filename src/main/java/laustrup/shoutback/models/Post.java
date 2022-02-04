package laustrup.shoutback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false) private User author;

    @Column(nullable = false, length = 30) private String title;
    @Lob @Column(nullable = false) private String content;

    @Column(nullable = false) private LocalDate date;

    @Column(length = 50) private String hashtag;
    @JsonBackReference
    @JsonIgnoreProperties
    @OneToMany @Column private List<Comment> comments;

    @Column(nullable = false) private boolean isPoliticalCorrect;

    // Constructor for JPA
    public Post(){}
    // Constructor for creating a post
    public Post(User author,String title, String content,
                String hashtag,boolean isPoliticalCorrect) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
        this.isPoliticalCorrect = isPoliticalCorrect;

        date = LocalDate.now();
        comments = new ArrayList<>();
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;}

    public User getAuthor() {return author;}
    public void setAuthor(User author) {this.author=author;}

    public String getTitle() {return title;}
    public void setTitle() {this.title = title;}

    public String getContent() {return content;}
    public void setContent(String content) {this.content=content;}

    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date=date;}

    public String getHashtag() {return hashtag;}
    public void setHashtag(String hashtag) {this.hashtag = hashtag;}

    public List<Comment> getComments() {return comments;}
    public void addComment(Comment comment) {comments.add(comment);}
    public void setComments(List<Comment> comments) {this.comments=comments;}

    public boolean isPoliticalCorrect() {return isPoliticalCorrect;}
    public void setPoliticalCorrect(boolean politicalCorrect) {isPoliticalCorrect = politicalCorrect;}
}
