package fr.utbm.gl52.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fr.utbm.gl52.entity.ProjectEntity;
import fr.utbm.gl52.entity.ResultEntity;
import fr.utbm.gl52.entity.SubjectEntity;
import fr.utbm.gl52.repository.SubjectRepository;
import fr.utbm.gl52.services.ProjectService;
import fr.utbm.gl52.services.SubjectService;
import fr.utbm.gl52.utils.BaseResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/create", method = {RequestMethod.POST, RequestMethod.GET})
    public ResultEntity createSubject(@RequestBody String subjectInfo) {
        try {

            SubjectEntity subjectEntity;
            JSONObject jsonParams = JSONObject.parseObject(subjectInfo);
            String subjectName = jsonParams.getString("subjectName");
            String subjectDescrption = jsonParams.getString("subjectDescription");
            subjectEntity=subjectService.createSubject(subjectName, subjectDescrption);
            return BaseResultUtil.resSuccess("successfully create a subject "+subjectEntity);
        } catch (Exception e) {
            return BaseResultUtil.resFailed("failed to create a subject！" + e.getMessage());
        }
    }

    //for students to see the list of subjects
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResultEntity searchSubjectLists() {
        try {
           List<SubjectEntity> subjectLists= subjectService.searchSujbects();
            return BaseResultUtil.resSuccess(subjectLists);
        } catch (Exception e) {
            return BaseResultUtil.resFailed("failed to find list of subjects！" + e.getMessage());
        }
    }

    @RequestMapping(value = "/chooseSubject", method = RequestMethod.GET)
    public ResultEntity chooseSubject(@RequestParam("subjectId") Long subjectId,
                                   @RequestParam("projectId") Long projectId){
        try{
            ProjectEntity project= projectService.chooseSubject(subjectId,projectId);
            return BaseResultUtil.resSuccess("successfully choose the subject"+project);
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to choose the subject！");
        }
    }

    @RequestMapping(value = "/checkSubject", method = RequestMethod.GET)
    public ResultEntity checkSubject(@RequestParam("projectId") Long projectId,
                                     @RequestParam("check") String check){
        try{
            if(check.equals("true")){
                return BaseResultUtil.resSuccess("successfully validate the subject");
            }
            ProjectEntity project= projectService.refuseSubject(projectId);
            return BaseResultUtil.resSuccess("successfully refuses the subject"+project);
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed for this operation！");
        }
    }
}
