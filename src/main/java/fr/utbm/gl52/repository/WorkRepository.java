package fr.utbm.gl52.repository;


import fr.utbm.gl52.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long>, JpaSpecificationExecutor<WorkEntity> {

    @Query(value = "select * from WORK where USER_ID = ?1", nativeQuery = true)
    List<WorkEntity> getWorkByUser(Long userId);
}
