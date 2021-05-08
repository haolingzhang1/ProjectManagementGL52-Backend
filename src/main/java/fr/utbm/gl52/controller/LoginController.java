package fr.utbm.gl52.controller;

import fr.utbm.gl52.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UserService userService ;
}
