package fr.utbm.gl52.repository;

import fr.utbm.gl52.entity.MeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<MeetingEntity, Long>, JpaSpecificationExecutor<MeetingEntity> {

}
