package fr.utbm.gl52.repository;

import fr.utbm.gl52.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long>, JpaSpecificationExecutor<WorkEntity> {
}
