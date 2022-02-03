package laustrup.shoutback.service.sub_services;

import laustrup.shoutback.models.Post;
import laustrup.shoutback.repositories.CommentRepository;
import laustrup.shoutback.repositories.PostRepository;
import laustrup.shoutback.repositories.UserRepository;
import laustrup.shoutback.service.Service;

@org.springframework.stereotype.Service
public class PostService extends Service {

    public PostService(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        super(userRepo, postRepo, commentRepo);
    }

    // Methods created for acting and returning entities
    public Post createPost(Post post) {return postRepo.save(post);}
    public Post deletePost(Long id) {
        if (postRepo.existsById(id)) {
            Post post = postRepo.findById(id).get();
            postRepo.delete(post);
            return post;
        }
        return null;
    }

}
