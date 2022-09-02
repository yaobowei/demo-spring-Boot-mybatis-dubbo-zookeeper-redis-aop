package com.ybw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ybw.demo.service.CommentModelService;
import com.ybw.demo.mapper.CommentModelMapper;
import com.ybw.demo.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author yaobowei
* @description 针对表【comment_info】的数据库操作Service实现
* @createDate 2022-08-29 19:53:23
*/
@Service(value = "CommentModelService")
public class CommentModelServiceImpl extends ServiceImpl<CommentModelMapper, CommentModel>
    implements CommentModelService{

    @Autowired
    CommentModelMapper commentModelMapper;

    @Override
    public Integer insertAll(CommentModel commentModel) {
        return commentModelMapper.insertAll(commentModel);
    }

    @Override
    public List<CommentModel> selectByMsgId(int msgId) {
        return commentModelMapper.selectByMsgId(msgId);
    }

    @Override
    public void updateLikeNumForId(int id, int num) {
        commentModelMapper.updateLikeNumForId(id,num);
    }
}




