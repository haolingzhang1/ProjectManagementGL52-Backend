package fr.utbm.gl52.services;

import fr.utbm.gl52.entity.ProjectEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProjectService {

    public ProjectEntity checkGroup(Long supervisorId, Long projectId);
    public ProjectEntity chooseSubject(Long subjectId, Long projectId);
    public ProjectEntity refuseSubject(Long projectId);


}
