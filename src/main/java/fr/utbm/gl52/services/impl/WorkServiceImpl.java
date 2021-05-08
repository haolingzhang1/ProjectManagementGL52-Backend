package fr.utbm.gl52.services.impl;

import fr.utbm.gl52.repository.WorkRepository;
import fr.utbm.gl52.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkRepository workRepository;
}
