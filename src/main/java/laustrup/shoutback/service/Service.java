package laustrup.shoutback.service;

import laustrup.shoutback.repositories.CommentRepository;
import laustrup.shoutback.repositories.PostRepository;
import laustrup.shoutback.repositories.UserRepository;

@org.springframework.stereotype.Service
public class Service {

    protected UserRepository userRepo;
    protected PostRepository postRepo;
    protected CommentRepository commentRepo;

    public Service(UserRepository userRepo,PostRepository postRepo,CommentRepository commentRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }

}
