package dio.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users-area")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Área de usuários autenticados";
    }
}
