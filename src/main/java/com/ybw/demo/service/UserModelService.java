package com.ybw.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ybw.demo.model.UserModel;

/**
* @author yaobowei
* @description 针对表【user_info】的数据库操作Service
* @createDate 2022-08-29 19:41:21
*/
public interface UserModelService extends IService<UserModel> {

    Integer insert(UserModel userModel);

    UserModel selectByUserNameModel(String userName);

    UserModel selectByIdModel(int id);

}
