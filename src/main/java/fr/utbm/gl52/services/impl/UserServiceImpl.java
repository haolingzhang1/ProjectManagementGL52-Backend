package fr.utbm.gl52.services.impl;

import fr.utbm.gl52.repository.UserRepository;
import fr.utbm.gl52.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
}
