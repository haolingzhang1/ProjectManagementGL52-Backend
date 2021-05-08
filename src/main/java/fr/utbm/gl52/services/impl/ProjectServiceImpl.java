package fr.utbm.gl52.services.impl;

import fr.utbm.gl52.entity.ProjectEntity;
import fr.utbm.gl52.repository.ProjectRepository;
import fr.utbm.gl52.services.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;


    @Override
    public ProjectEntity checkGroup(Long supervisorId, Long projectId) {
        ProjectEntity project=projectRepository.findById(projectId).get();
        project.setSupervisorId(supervisorId);
        projectRepository.save(project);
        return project;
    }

    @Override
    public ProjectEntity chooseSubject(Long subjectId, Long projectId) {
        ProjectEntity project=projectRepository.findById(projectId).get();
        project.setSubjectId(subjectId);
        projectRepository.save(project);
        return project;
    }

    @Override
    public ProjectEntity refuseSubject(Long projectId) {
        ProjectEntity project=projectRepository.findById(projectId).get();
        project.setSubjectId(0L);
        projectRepository.save(project);
        return project;
    }

    @Override
    public ProjectEntity addEvaluation(Long projectId, Long grade, String comments) {
        ProjectEntity project=projectRepository.findById(projectId).get();
        project.setProjectGrade(grade);
        project.setProjectComments(comments);
        projectRepository.save(project);
        return project;
    }

    @Override
    public ProjectEntity consulterEvaluation(Long projectId) {
        ProjectEntity project=projectRepository.findById(projectId).get();
        return project;
    }


}
