package fr.utbm.gl52.controller;

import fr.utbm.gl52.entity.ResultEntity;
import fr.utbm.gl52.services.UserService;
import fr.utbm.gl52.utils.BaseResultUtil;
import fr.utbm.gl52.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    UserService userService ;

    //login
    @RequestMapping(value = "/verify",  method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultEntity Login(HttpServletRequest request){
        try{
            String compte=request.getParameter("compte");
            String password=request.getParameter("password");
            if(password.isEmpty()||compte.isEmpty()){
                return BaseResultUtil.resSuccess("please enter both compte and password!");
            }
            String b_password= userService.getUserPasswordByEmail(compte); ;
            String a_password= Md5Util.convertMD5(password);
            if(a_password.equals(b_password)) {
                return BaseResultUtil.resSuccess("successful log in!");
            }else{
                System.out.println("p"+password);
                System.out.println("a"+a_password);
                System.out.println("b"+b_password);
                return BaseResultUtil.resSuccess("wrong password !"+b_password.toString()+"   "+a_password.toString());
            }
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to log in！"+e.getMessage());
        }
    }
}
