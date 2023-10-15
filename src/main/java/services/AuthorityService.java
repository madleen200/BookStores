package services;

import entities.Authority;
import entities.Users;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.AuthorityRepository;
import repositories.UserRepository;

import java.util.List;
@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;
    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }
     public Authority findById(Long id) {
        return authorityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Authority not found with id :" + id));
    }
    public List<Authority> getAllAuthors() {
        return authorityRepository.findAll();
    }

    public Authority save(Authority authority) {
        return authorityRepository.save(authority);
    }

}
