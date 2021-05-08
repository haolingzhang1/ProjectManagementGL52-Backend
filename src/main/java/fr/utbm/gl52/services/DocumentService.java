package fr.utbm.gl52.services;

import fr.utbm.gl52.entity.DocumentEntity;

public interface DocumentService {
    DocumentEntity getDocumentByProject(Long projectId);

}
