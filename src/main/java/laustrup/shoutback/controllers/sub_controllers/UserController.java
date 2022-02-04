package laustrup.shoutback.controllers.sub_controllers;

import laustrup.shoutback.controllers.Controller;
import laustrup.shoutback.models.User;
import laustrup.shoutback.repositories.CommentRepository;
import laustrup.shoutback.repositories.PostRepository;
import laustrup.shoutback.repositories.UserRepository;
import laustrup.shoutback.service.sub_services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController extends Controller {

    private UserService userService;

    public UserController(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        super(userRepo,postRepo,commentRepo);
        userService = new UserService(userRepo,postRepo,commentRepo);
    }

    @GetMapping("/user/:{id}")
    public ResponseEntity<User> getUser(@PathVariable(name="id") Long id) {
        return new ResponseEntity<>(userRepo.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping(value = "/user", consumes = "application/json")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_user/:{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name="id") Long id) {
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }

}
