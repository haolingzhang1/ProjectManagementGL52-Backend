package fr.utbm.gl52.services.impl;

import fr.utbm.gl52.repository.SubjectRepository;
import fr.utbm.gl52.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;
}
