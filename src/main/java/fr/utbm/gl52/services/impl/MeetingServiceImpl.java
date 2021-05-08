package fr.utbm.gl52.services.impl;

import fr.utbm.gl52.repository.MeetingRepository;
import fr.utbm.gl52.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    MeetingRepository meetingRepository;
}
