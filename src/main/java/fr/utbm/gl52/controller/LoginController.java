package fr.utbm.gl52.controller;

import com.alibaba.fastjson.JSONObject;
import fr.utbm.gl52.entity.ResultEntity;
import fr.utbm.gl52.entity.UserEntity;
import fr.utbm.gl52.services.UserService;
import fr.utbm.gl52.utils.BaseResultUtil;
import fr.utbm.gl52.utils.Md5Util;
import org.apache.catalina.User;
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
    //if success return user type as teacher or student
    @RequestMapping(value = "/verify",  method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public ResultEntity Login(HttpServletRequest request){
        try{
            String compte=request.getParameter("compte");
            String password=request.getParameter("password");
            if(password.isEmpty()||compte.isEmpty()){
                return BaseResultUtil.resSuccess("please enter both compte and password!",null);
            }
            String b_password= userService.getUserPasswordByEmail(compte);
            UserEntity user=userService.getUserByEmail(compte);
            String a_password= Md5Util.convertMD5(password);
            if(a_password.equals(b_password)) {
                JSONObject obj = new JSONObject();
                obj.put("type", user.getType());
                obj.put("userId", user.getUserId());
                obj.put("userName", user.getFirstName() + " " + user.getLastName());
                return BaseResultUtil.resSuccess("successful log in!",obj);
            }else{
                return BaseResultUtil.resFailed("wrong password !",null);
            }
        }catch(Exception e) {
            return BaseResultUtil.resFailed("failed to log in！",e.getMessage());
        }
    }
}
