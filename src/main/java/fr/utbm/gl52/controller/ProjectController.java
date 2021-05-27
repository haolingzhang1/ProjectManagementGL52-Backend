package fr.utbm.gl52.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fr.utbm.gl52.entity.*;
import fr.utbm.gl52.repository.ProjectRepository;
import fr.utbm.gl52.repository.UserRepository;
import fr.utbm.gl52.repository.WorkRepository;
import fr.utbm.gl52.services.ProjectService;
import fr.utbm.gl52.services.UserService;
import fr.utbm.gl52.services.WorkService;
import fr.utbm.gl52.utils.BaseResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    ProjectService projectService;

    @Autowired
    WorkService workService;

    @Autowired
    WorkRepository workRepository;


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

    @RequestMapping(value = "/getProjectByUser", method = RequestMethod.GET)
    public ResultEntity getProjectByUser(@RequestParam("userId") Long userId){
        try{
            List<WorkEntity> works = workService.getWorkByUser(userId);
            List<ProjectEntity> projectLists = new ArrayList<>();
            for(WorkEntity work:works){
               ProjectEntity project =  projectRepository.findById(work.getProjectId()).get();
                projectLists.add(project);
            }
            return BaseResultUtil.resSuccess("successfully get the projects of "+userId,projectLists );
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to get the projects of "+userId,null);
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
            UserEntity supervisor = userService.getUserByEmail(supervisorEmail);
            project.setSupervisorId(supervisor.getUserId());
            project.setProjectTitle(title);
            project.setSubjectId(subjectId);
            WorkEntity work = new WorkEntity();
            work.setProjectId(project.getProjectId());
            work.setUserId(supervisor.getUserId());
            workRepository.save(work);
            projectRepository.save(project);
            return BaseResultUtil.resSuccess("successfully create a group in project " , project);
        } catch (Exception e) {
            return BaseResultUtil.resFailed("failed to create a group！" , e.getMessage());
        }
    }


}
