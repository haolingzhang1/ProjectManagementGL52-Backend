package fr.utbm.gl52.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fr.utbm.gl52.entity.*;
import fr.utbm.gl52.repository.*;
import fr.utbm.gl52.services.ProjectService;
import fr.utbm.gl52.services.UserService;
import fr.utbm.gl52.services.WorkService;
import fr.utbm.gl52.utils.BaseResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    MeetingRepository meetingRepository;

    @Autowired
    ProjectService projectService;

    @Autowired
    WorkService workService;

    @Autowired
    WorkRepository workRepository;

    @Autowired
    DocumentRepository documentRepository;

    //add student lists to project
    @RequestMapping(value = "/createGroup", method = {RequestMethod.POST, RequestMethod.GET})
    public ResultEntity createGroup(@RequestBody String groupInfo) {
        try {

            JSONObject jsonParams = JSONObject.parseObject(groupInfo);
            Long projectId = Long.parseLong(jsonParams.getString("projectId"));
            ProjectEntity project = projectRepository.findById(projectId).get();
            JSONArray studentLists = jsonParams.getJSONArray("email");
            //for every student, insert project id for them
            for (Object student : studentLists) {
                String email = student.toString();
                UserEntity user = userService.getUserByEmail(email);
                user.setProjectId(project.getProjectId());
                WorkEntity work = new WorkEntity();
                work.setProjectId(project.getProjectId());
                work.setUserId(user.getUserId());
                workRepository.save(work);
                userRepository.save(user);
                }
            return BaseResultUtil.resSuccess("successfully create a group in project " , project);
        } catch (Exception e) {
            return BaseResultUtil.resFailed("failed to create a group！" , e.getMessage());
        }
    }

    @RequestMapping(value = "/checkGroup", method = RequestMethod.GET)
    public ResultEntity checkGroup(@RequestParam("supervisorId") Long supervisorId,
                                   @RequestParam("projectId") Long projectId){
        try{
            ProjectEntity project= projectService.checkGroup(supervisorId,projectId);
            return BaseResultUtil.resSuccess("successfully validate the group", project);
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to validate the group！",null);
        }
    }

    //for students
    @RequestMapping(value = "/getProjectByUser", method = RequestMethod.GET)
    public ResultEntity getProjectByUser(@RequestParam("userId") Long userId){
        try{
            HashMap<String,Object> saveResult = new HashMap<>();
            List<WorkEntity> works = workService.getWorkByUser(userId);
            List<JSONObject> projectLists = new ArrayList<>();
            for(WorkEntity work:works){
                ProjectEntity project = projectRepository.findById(work.getProjectId()).get();
                SubjectEntity subject = subjectRepository.findById(project.getSubjectId()).get();
                UserEntity supervisor = userRepository.getUserById(project.getSupervisorId());
                List<MeetingEntity> meetings = meetingRepository.getMeetingByProject(work.getProjectId());
                List<DocumentEntity> documents = documentRepository.getDocumentByProject(work.getProjectId());

                JSONObject json_subject = new JSONObject();
                json_subject.put("id", subject.getSubjectId());
                json_subject.put("name", subject.getSubjectName());
                json_subject.put("description", subject.getSubjectDescription());

                JSONObject json_supervisor = new JSONObject();
                json_supervisor.put("id", supervisor.getUserId());
                json_supervisor.put("name", supervisor.getFirstName() + " " + supervisor.getLastName());
                json_supervisor.put("email", supervisor.getEmail());

                JSONObject json_project = new JSONObject();
                json_project.put("id", project.getProjectId());
                json_project.put("title", project.getProjectTitle());
                json_project.put("subject", json_subject);
                json_project.put("supervisor", json_supervisor);
                json_project.put("meetings", meetings);
                json_project.put("documents", documents);
                json_project.put("grade", project.getProjectGrade());
                json_project.put("comments", project.getProjectComments());
                json_project.put("students", userRepository.getUsersOfProject(project.getProjectId()));

                projectLists.add(json_project);
            }
            return BaseResultUtil.resSuccess("successfully got the projects of user "+userId, projectLists);
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to get the projects of user "+userId,e.getMessage());
        }
    }

    //for supervisor
    @RequestMapping(value = "/getProjectBySupervisor", method = RequestMethod.GET)
    public ResultEntity getProjectBySupervisor(@RequestParam("supervisorId") Long userId){
        try{
            HashMap<String,Object> saveResult = new HashMap<>();
            List<ProjectEntity> projectLists = projectRepository.getWorkBySupervisor(userId);
            List<JSONObject> projectJSONLists = new ArrayList<>();
            for(ProjectEntity project:projectLists){
                SubjectEntity subject = subjectRepository.findById(project.getSubjectId()).get();
                UserEntity supervisor = userRepository.getUserById(project.getSupervisorId());
                List<MeetingEntity> meetings = meetingRepository.getMeetingByProject(project.getProjectId());
                List<DocumentEntity> documents = documentRepository.getDocumentByProject(project.getProjectId());

                JSONObject json_subject = new JSONObject();
                json_subject.put("id", subject.getSubjectId());
                json_subject.put("name", subject.getSubjectName());
                json_subject.put("description", subject.getSubjectDescription());

                JSONObject json_supervisor = new JSONObject();
                json_supervisor.put("id", supervisor.getUserId());
                json_supervisor.put("name", supervisor.getFirstName() + " " + supervisor.getLastName());
                json_supervisor.put("email", supervisor.getEmail());

                JSONObject json_project = new JSONObject();
                json_project.put("id", project.getProjectId());
                json_project.put("title", project.getProjectTitle());
                json_project.put("subject", json_subject);
                json_project.put("supervisor", json_supervisor);
                json_project.put("meetings", meetings);
                json_project.put("documents", documents);
                json_project.put("grade", project.getProjectGrade());
                json_project.put("comments", project.getProjectComments());
                json_project.put("students", userRepository.getUsersOfProject(project.getProjectId()));

                projectJSONLists.add(json_project);
            }
            return BaseResultUtil.resSuccess("successfully get the projects supervised by user "+userId, projectJSONLists);
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to get the projects supervised by user "+userId,e.getMessage());
        }
    }


    @RequestMapping(value = "/createProject", method = RequestMethod.POST)
    public ResultEntity createProject(@RequestBody String groupInfo) {
        try {
            ProjectEntity project = new ProjectEntity();
            JSONObject jsonParams = JSONObject.parseObject(groupInfo);
            JSONArray studentLists = jsonParams.getJSONArray("email");
            String title = jsonParams.getString("title");
            Long subjectId = Long.parseLong(jsonParams.getString("subjectId"));
            String supervisorEmail = jsonParams.getString("supervisorEmail");
            UserEntity supervisor = userService.getUserByEmail(supervisorEmail);
            project.setSupervisorId(supervisor.getUserId());
            project.setProjectTitle(title);
            project.setSubjectId(subjectId);
            projectRepository.save(project);
            //for every student, insert project id for them
            for (Object student : studentLists) {
                String email = student.toString();
                UserEntity user = userService.getUserByEmail(email);
                user.setProjectId(project.getProjectId());
                WorkEntity work = new WorkEntity();
                work.setProjectId(project.getProjectId());
                work.setUserId(user.getUserId());
                workRepository.save(work);
                userRepository.save(user);
            }
            WorkEntity work = new WorkEntity();
            work.setProjectId(project.getProjectId());
            work.setUserId(supervisor.getUserId());
            workRepository.save(work);
            return BaseResultUtil.resSuccess("successfully create a group in project " , project);
        } catch (Exception e) {
            return BaseResultUtil.resFailed("failed to create a group！" , e.getMessage());
        }
    }


}
