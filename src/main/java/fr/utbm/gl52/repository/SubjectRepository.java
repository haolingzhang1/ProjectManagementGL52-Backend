package fr.utbm.gl52.repository;

import fr.utbm.gl52.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long>, JpaSpecificationExecutor<SubjectEntity> {

    @Query(value = "select * from SUBJECT where SUBJECT_NAME = ?1", nativeQuery = true)
    List<SubjectEntity> findSubjectByName(String subjectName);

    @Query(value = "select * from SUBJECT ", nativeQuery = true)
    List<SubjectEntity> searchSujbects();


}
