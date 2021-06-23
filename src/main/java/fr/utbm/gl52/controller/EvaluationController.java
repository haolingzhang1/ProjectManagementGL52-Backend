package fr.utbm.gl52.controller;

import com.alibaba.fastjson.JSONObject;
import fr.utbm.gl52.entity.ProjectEntity;
import fr.utbm.gl52.entity.ResultEntity;
import fr.utbm.gl52.services.ProjectService;
import fr.utbm.gl52.utils.BaseResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/evaluation")
public class EvaluationController {

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResultEntity addEvaluation(@RequestBody String evalParam){
        try {
            JSONObject jsonParams = JSONObject.parseObject(evalParam);
            Long projectId = jsonParams.getLong("projectId");
            Long grade = jsonParams.getLong("grade");
            String comments = jsonParams.getString("comments");

            ProjectEntity project = projectService.addEvaluation(projectId, grade, comments);
            return BaseResultUtil.resSuccess("Successfully added the evaluation.", project);
        } catch(Exception e) {
            return BaseResultUtil.resFailed("Failed to add the evaluation!", e.getMessage());
        }
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResultEntity consulterEvaluation(@RequestParam("projectId") Long projectId){
        try{
            ProjectEntity project = projectService.consulterEvaluation(projectId);
            return BaseResultUtil.resSuccess("successfully found the evaluation of this project", project);
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to find an evaluation for this project!",null);
        }
    }
}
