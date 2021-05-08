package fr.utbm.gl52.repository;

import fr.utbm.gl52.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    @Query(value = "select USER_PASSWORD from USER where USER_EMAIL = ?1", nativeQuery = true)
    String getUserPasswordByEmail(String userEmail);

    @Query(value = "select * from USER where USER_EMAIL = ?1", nativeQuery = true)
    UserEntity getUserByEmail(String userEmail);
}
