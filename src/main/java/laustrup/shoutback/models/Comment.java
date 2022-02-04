package laustrup.shoutback.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
public class Comment {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false) private User author;

    @Lob @Column(nullable = false) private String content;

    @Column(nullable = false) private LocalDate date;

    // Constructor for JPA
    public Comment(){}
    // Constructor for creating a Comment
    public Comment(User author,String content) {
        this.author = author;
        this.content = content;

        date = LocalDate.now();
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id=id;}

    public User getAuthor() {return author;}
    public void setAuthor(User author) {this.author=author;}

    public String getContent() {return content;}
    public void setContent(String content) {this.content=content;}

    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date=date;}

}
