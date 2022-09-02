package com.ybw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ybw.demo.mapper.UserModelMapper;
import com.ybw.demo.service.UserModelService;
import com.ybw.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author yaobowei
* @description 针对表【user_info】的数据库操作Service实现
* @createDate 2022-08-29 19:41:21
*/
@Service(value = "UserModelService")
public class UserModelServiceImpl extends ServiceImpl<UserModelMapper, UserModel>
implements UserModelService {

    @Autowired
    UserModelMapper userModelMapper;

    @Override
    public Integer insert(UserModel userModel) {
        return userModelMapper.addUser(userModel);
    }

    @Override
    public UserModel selectByUserNameModel(String userName) {
        return userModelMapper.selectByUserNameModel(userName);
    }

    @Override
    public UserModel selectByIdModel(int id) {
        return userModelMapper.selectByIdModel(id);
    }
}
