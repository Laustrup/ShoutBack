package laustrup.shoutback.controllers;

import laustrup.shoutback.repositories.CommentRepository;
import laustrup.shoutback.repositories.PostRepository;
import laustrup.shoutback.repositories.UserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Controller {

    protected UserRepository userRepo;
    protected PostRepository postRepo;
    protected CommentRepository commentRepo;

    public Controller(UserRepository userRepo,PostRepository postRepo,CommentRepository commentRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

}
