package security;

import entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Users user = userRepository.findByName(name);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", name));
        } else {
            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
                    new ArrayList<>());
        }
    }
}
