package fr.utbm.gl52.repository;

import fr.utbm.gl52.entity.DocumentEntity;
import fr.utbm.gl52.entity.SubjectEntity;
import fr.utbm.gl52.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long>, JpaSpecificationExecutor<DocumentEntity> {

    @Query(value = "select * from DOCUMENT where PROJECT_ID = ?1", nativeQuery = true)
    DocumentEntity getDocumentByProject(Long projectId);
}
