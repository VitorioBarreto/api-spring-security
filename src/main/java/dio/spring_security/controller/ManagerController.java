package dio.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/managers-area")
public class ManagerController {

    @GetMapping
    public String managersArea() {
        return "Área de Managers (somente MANAGER)";
    }
}
