package repositories;


import entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    Set<Authority> findByNameIn(Set<String> names);
}
