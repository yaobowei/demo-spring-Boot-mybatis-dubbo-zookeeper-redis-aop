package com.ybw.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ybw.demo.model.UserModel;
import org.springframework.stereotype.Component;

/**
* @author yaobowei
* @description 针对表【user_info】的数据库操作Mapper
* @createDate 2022-08-29 19:41:21
* @Entity generator.domain.UserModel
*/
@Component
public interface UserModelMapper extends BaseMapper<UserModel> {

    int addUser(UserModel userModel);

    UserModel selectByUserNameModel(String userName);

    UserModel selectByIdModel(int id);
}
