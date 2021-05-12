package fr.utbm.gl52.controller;

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResultEntity addEvaluation(@RequestParam("comments") String comments,
                                      @RequestParam("grade") Long grade,
                                      @RequestParam("projectId") Long projectId){
        try{
            ProjectEntity project= projectService.addEvaluation(projectId,grade,comments);
            return BaseResultUtil.resSuccess("successfully add the evaluation",project);
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to add the evaluation！",null);
        }
    }

    @RequestMapping(value = "/consulter", method = RequestMethod.GET)
    public ResultEntity consulterEvaluation(@RequestParam("projectId") Long projectId){
        try{
            ProjectEntity project= projectService.consulterEvaluation(projectId);
            return BaseResultUtil.resSuccess("successfully search the evaluation",project);
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to search the evaluation！",null);
        }
    }
}
