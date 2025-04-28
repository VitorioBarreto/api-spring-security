package dio.spring_security.init;

import dio.spring_security.repository.UserRepository;
import dio.spring_security.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        AppUser user = repository.findByUsername("admin");
        if (user == null) {
            user = new AppUser();
            user.setName("ADMIN");
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("master123"));
            user.getRoles().add("MANAGER");
            repository.save(user);
        }

        user = repository.findByUsername("user");
        if (user == null) {
            user = new AppUser();
            user.setName("USER");
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("user123"));
            user.getRoles().add("USER");
            repository.save(user);
        }
    }

}