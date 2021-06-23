package fr.utbm.gl52.repository;

import fr.utbm.gl52.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long>, JpaSpecificationExecutor<ProjectEntity> {

    @Query(value = "select * from PROJECT where SUPERVISOR_ID = ?1", nativeQuery = true)
    List<ProjectEntity> getWorkBySupervisor(Long supervisorId);

    @Query(value = "select * from PROJECT where PROJECT_ID = ?1", nativeQuery = true)
    ProjectEntity getProject(Long projectId);
}

