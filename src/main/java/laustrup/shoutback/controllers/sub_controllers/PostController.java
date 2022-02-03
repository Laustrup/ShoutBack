package laustrup.shoutback.controllers.sub_controllers;

import laustrup.shoutback.controllers.Controller;
import laustrup.shoutback.models.Post;
import laustrup.shoutback.repositories.CommentRepository;
import laustrup.shoutback.repositories.PostRepository;
import laustrup.shoutback.repositories.UserRepository;
import laustrup.shoutback.service.sub_services.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PostController extends Controller {

    private PostService postService;

    public PostController(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        super(userRepo,postRepo,commentRepo);
        postService = new PostService(userRepo, postRepo, commentRepo);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        return new ResponseEntity<>(postRepo.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/create_post", consumes = "application/json")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(postService.createPost(post),HttpStatus.CREATED);
    }
    @PutMapping(value = "/edit_post", consumes = "application/json")
    public ResponseEntity<Post> editPost(@RequestBody Post post) {
        return new ResponseEntity<>(postRepo.save(post),HttpStatus.OK);
    }

    @DeleteMapping("/delete_post/:{id}")
    public ResponseEntity<Post> deletePost(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(postService.deletePost(id),HttpStatus.OK);
    }
}
