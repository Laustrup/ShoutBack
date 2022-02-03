package laustrup.shoutback.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comment")
@Data
@Getter
@Setter
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

}
