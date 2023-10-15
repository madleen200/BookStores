package services;

import entities.Users;
import org.apache.velocity.exception.ResourceNotFoundException;
import repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" User not found with id :" + id));
    }
    public Users save(Users user) {
        return userRepository.save(user);
    }
}
