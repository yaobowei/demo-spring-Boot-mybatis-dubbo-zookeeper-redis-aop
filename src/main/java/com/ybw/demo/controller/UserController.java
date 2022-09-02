package com.ybw.demo.controller;

import com.ybw.demo.data.result.BaseDataResult;
import com.ybw.demo.model.UserModel;
import com.ybw.demo.service.UserModelService;
import com.ybw.demo.utils.ResultUtil;
import com.ybw.demo.utils.Util;
import com.ybw.demo.utils.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UserController {

    @Autowired
    UserModelService userModelService;

    @PostMapping(value = "user/signUp")
    Result<BaseDataResult> signUp(@RequestBody UserModel model,BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error();
        }
        StringBuilder builder = new StringBuilder();
        if(model.getUserName() == null || model.getUserName().isEmpty()){
            Random random = new Random();
            builder.append("游客用户");
            builder.append(random.nextInt());
            //userName = "游客用户" + random.nextInt();
            model.setPassword(Util.string2Md5(""));
        }else {
            builder.append(model.getUserName());
            model.setPassword(Util.string2Md5(model.getPassword()));
        }
        model.setUserName(builder.toString());
        userModelService.insert(model);
        return ResultUtil.success(new BaseDataResult(3,false));
    }

    @PostMapping(value = "user/signIn")
    Result<BaseDataResult> signIn(@RequestBody UserModel model, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error();
        }
        UserModel userModel = userModelService.selectByUserNameModel(model.getUserName());
        if(userModel == null || !userModel.getPassword().equals(model.getPassword())) {
            return ResultUtil.success(new BaseDataResult(2,false));
        } else {
            return ResultUtil.success(new BaseDataResult(2,true));
        }
    }
}
