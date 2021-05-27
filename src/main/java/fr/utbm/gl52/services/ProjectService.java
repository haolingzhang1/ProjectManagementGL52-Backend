package fr.utbm.gl52.services;

import fr.utbm.gl52.entity.ProjectEntity;

public interface ProjectService {

     ProjectEntity checkGroup(Long supervisorId, Long projectId);
     ProjectEntity chooseSubject(Long subjectId, Long projectId);
     ProjectEntity refuseSubject(Long projectId);
     ProjectEntity addEvaluation(Long projectId,Long grade,String comments);
     ProjectEntity consulterEvaluation(Long projectId);
}
