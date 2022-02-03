package laustrup.shoutback.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import laustrup.shoutback.models.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

    // String attributes
    @Column(nullable = false, length = 40) private String username,password;
    @Lob @Column private String description;

    // Isn't boolean, for political correctness sake
    @Enumerated(EnumType.ORDINAL) @Column private Gender gender;

    @JsonBackReference
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Post> posts;

    @JsonBackReference
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Comment> comments;

    // Constructor for JPA
    public User(){}
    // Constructor for creating user
    public User(String username,String password,String description,Gender gender) {
        this.username = username;
        this.password = password;
        this.description = description;
        this.gender = gender;
        posts = new ArrayList<>();
    }

}
