package fr.utbm.gl52.repository;

import fr.utbm.gl52.entity.MeetingEntity;
import fr.utbm.gl52.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<MeetingEntity, Long>, JpaSpecificationExecutor<MeetingEntity> {

    @Query(value = "select * from MEETING where PROJECT_ID = ?1", nativeQuery = true)
    List<MeetingEntity> getMeetingByProject(Long projectId);
}
