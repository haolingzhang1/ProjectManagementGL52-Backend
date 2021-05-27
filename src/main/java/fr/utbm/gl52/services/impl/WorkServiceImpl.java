package fr.utbm.gl52.services.impl;

import fr.utbm.gl52.entity.WorkEntity;
import fr.utbm.gl52.repository.WorkRepository;
import fr.utbm.gl52.services.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkRepository workRepository;

    public List<WorkEntity> getWorkByUser(Long userId){
        return workRepository.getWorkByUser(userId);
    }

}
