package fr.utbm.gl52.services.impl;

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
}
