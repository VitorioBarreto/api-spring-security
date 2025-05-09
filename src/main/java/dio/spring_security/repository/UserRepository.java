package dio.spring_security.repository;

import dio.spring_security.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);
    boolean existsByUsername(String username);
}