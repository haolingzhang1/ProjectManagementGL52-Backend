package fr.utbm.gl52.repository;

import fr.utbm.gl52.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    @Query(value = "select USER_PASSWORD from USER where USER_EMAIL = ?1", nativeQuery = true)
    String getUserPasswordByEmail(String userEmail);

    @Query(value = "select * from USER where USER_EMAIL = ?1", nativeQuery = true)
    UserEntity getUserByEmail(String userEmail);

    @Query(value = "select * from USER where USER_ID = ?1", nativeQuery = true)
    UserEntity getUserById(Long userId);

    /**
     * Get the list of users that work on project. Passwords will not be returned.
     * @param projectId WORK.PROJECT_ID
     * @return a Java List of UserEntity objects
     */
    @Query(value = "select USER.USER_ID, USER.USER_FIRSTNAME, USER.USER_LASTNAME, USER.USER_EMAIL, NULL AS USER_PASSWORD, USER.USER_TYPE, USER.PROJECT_ID from USER inner join WORK on USER.USER_ID = WORK.USER_ID where WORK.PROJECT_ID = ?1 and USER.USER_TYPE = 'S'", nativeQuery = true)
    List<UserEntity> getUsersOfProject(Long projectId);
}
