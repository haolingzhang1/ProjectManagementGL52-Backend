package fr.utbm.gl52.services.impl;

import fr.utbm.gl52.entity.SubjectEntity;
import fr.utbm.gl52.repository.SubjectRepository;
import fr.utbm.gl52.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public SubjectEntity createSubject(String subjectName, String subjectDescription) {
        SubjectEntity subject = new SubjectEntity();
        subject.setSubjectName(subjectName);
        subject.setSubjectDescription(subjectDescription);
        subjectRepository.save(subject);
        return subject;
    }

    @Override
    public List<SubjectEntity> searchSujbects(){
        return subjectRepository.searchSujbects();
    }

}
