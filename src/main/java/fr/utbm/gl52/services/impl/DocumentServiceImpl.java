package fr.utbm.gl52.services.impl;

import fr.utbm.gl52.repository.DocumentRepository;
import fr.utbm.gl52.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;
}
