package fr.utbm.gl52.services;

import fr.utbm.gl52.entity.UserEntity;

public interface UserService {

    String getUserPasswordByEmail(String userEmail);

    UserEntity getUserByEmail(String userEmail);
}
