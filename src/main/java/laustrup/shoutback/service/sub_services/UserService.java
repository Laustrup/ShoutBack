package laustrup.shoutback.service.sub_services;

import laustrup.shoutback.models.User;
import laustrup.shoutback.repositories.CommentRepository;
import laustrup.shoutback.repositories.PostRepository;
import laustrup.shoutback.repositories.UserRepository;
import laustrup.shoutback.service.Service;

import java.util.List;

@org.springframework.stereotype.Service
public class UserService extends Service {

    public UserService(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        super(userRepo,postRepo,commentRepo);
    }

    // Methods created for acting and returning entities
    public User createUser(User user) {return userRepo.save(user);}
    public User deleteUser(Long id) {
        if (userRepo.existsById(id)) {
            User user = userRepo.findById(id).get();
            userRepo.delete(user);
            return user;
        }
        return null;
    }
    public boolean doesPasswordExist(String username,String password) {
        User user = userRepo.findByUsername(username);
        return user.getPassword().equals(password);
    }
}
