package laustrup.shoutback.controllers.sub_controllers;

import laustrup.shoutback.controllers.Controller;
import laustrup.shoutback.models.Comment;
import laustrup.shoutback.repositories.CommentRepository;
import laustrup.shoutback.repositories.PostRepository;
import laustrup.shoutback.repositories.UserRepository;
import laustrup.shoutback.service.sub_services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CommentController extends Controller {

    private CommentService commentService;

    public CommentController(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        super(userRepo, postRepo, commentRepo);
        commentService = new CommentService(userRepo, postRepo, commentRepo);
    }

    @PutMapping(value = "/create_comment", consumes = "application/json")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentRepo.save(comment), HttpStatus.CREATED);
    }
    @PutMapping(value = "/edit_comment", consumes = "application/json")
    public ResponseEntity<Comment> editComment(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentRepo.save(comment), HttpStatus.OK);
    }

    @DeleteMapping("/comment/:{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(commentService.deleteComment(id),HttpStatus.OK);
    }
}
