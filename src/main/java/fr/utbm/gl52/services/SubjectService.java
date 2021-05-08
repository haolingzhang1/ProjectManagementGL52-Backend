package fr.utbm.gl52.services;

import fr.utbm.gl52.entity.SubjectEntity;

import java.util.List;

public interface SubjectService {
    public SubjectEntity createSubject(String subjectName, String subjectDescription);
    public List<SubjectEntity> searchSujbects();

}
