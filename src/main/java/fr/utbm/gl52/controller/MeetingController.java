package fr.utbm.gl52.controller;

import fr.utbm.gl52.entity.MeetingEntity;
import fr.utbm.gl52.entity.ResultEntity;
import fr.utbm.gl52.repository.MeetingRepository;
import fr.utbm.gl52.utils.BaseResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/meeting")
public class MeetingController {

    @Autowired
    MeetingRepository meetingRepository;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ResultEntity createMeeting(@RequestParam("meetingStart") Date meetingStart,
                                      @RequestParam("meetingEnd") Date meetingEnd,
                                      @RequestParam("supervisorId") Long supervisorId) {
        try {
            MeetingEntity meetingEntity=new MeetingEntity();
            meetingEntity.setMeetingEnd(meetingEnd);
            meetingEntity.setMeetingStart(meetingStart);
            meetingEntity.setSupervisorId(supervisorId);
            meetingRepository.save(meetingEntity);
            return BaseResultUtil.resSuccess("successfully create an available meeting time ",meetingEntity);
        } catch (Exception e) {
            return BaseResultUtil.resFailed("failed to create a meeting time！" ,e.getMessage());
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultEntity searchMeeting() {
        try {

            List<MeetingEntity> meetingLists= meetingRepository.findAll();
            return BaseResultUtil.resSuccess("successfully find the meetings",meetingLists);
        } catch (Exception e) {
            return BaseResultUtil.resFailed("failed to find meetings！" , e.getMessage());
        }
    }

    @RequestMapping(value = "/chooseMeeting", method = RequestMethod.GET)
    public ResultEntity chooseMeeting(@RequestParam("meetingId") Long meetingId,
                                      @RequestParam("projectId") Long projectId) {
        try {
            MeetingEntity meeting= meetingRepository.findById(meetingId).get();
            meeting.setProjectId(projectId);
            meetingRepository.save(meeting);
            return BaseResultUtil.resSuccess("successfully choose the meeting",meeting);
        } catch (Exception e) {
            return BaseResultUtil.resFailed("failed to choose meetings！" , e.getMessage());
        }
    }
}
