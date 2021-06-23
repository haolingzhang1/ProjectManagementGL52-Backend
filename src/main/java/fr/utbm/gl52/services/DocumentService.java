package fr.utbm.gl52.services;

import fr.utbm.gl52.entity.DocumentEntity;

import java.util.List;

public interface DocumentService {
    List<DocumentEntity> getDocumentByProject(Long projectId);

    DocumentEntity getDocument(Long documentId);
}
