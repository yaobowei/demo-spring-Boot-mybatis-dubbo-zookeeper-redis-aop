package com.ybw.demo.service;

import com.ybw.demo.model.CommentModel;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author yaobowei
* @description 针对表【comment_info】的数据库操作Service
* @createDate 2022-08-29 19:53:23
*/
public interface CommentModelService extends IService<CommentModel> {

    Integer insertAll(CommentModel commentModel);

    List<CommentModel> selectByMsgId(int msgId);

    void updateLikeNumForId(int id,int num);

}
