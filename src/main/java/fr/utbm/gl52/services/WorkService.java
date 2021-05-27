package fr.utbm.gl52.services;

import fr.utbm.gl52.entity.WorkEntity;

import java.util.List;

public interface WorkService {
    List<WorkEntity> getWorkByUser(Long userId);
    }
