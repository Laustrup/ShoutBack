package laustrup.shoutback.service.sub_services;

import laustrup.shoutback.models.Comment;
import laustrup.shoutback.models.Post;
import laustrup.shoutback.repositories.CommentRepository;
import laustrup.shoutback.repositories.PostRepository;
import laustrup.shoutback.repositories.UserRepository;
import laustrup.shoutback.service.Service;

@org.springframework.stereotype.Service
public class CommentService extends Service {

    public CommentService(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        super(userRepo, postRepo, commentRepo);
    }

    public Comment deleteComment(Long id) {
        if (commentRepo.existsById(id)) {
            Comment comment = commentRepo.findById(id).get();
            commentRepo.delete(comment);
            return comment;
        }
        return null;
    }
}
