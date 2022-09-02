package com.ybw.demo.mapper;

import com.ybw.demo.model.CommentModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
* @author yaobowei
* @description 针对表【comment_info】的数据库操作Mapper
* @createDate 2022-08-29 19:53:23
* @Entity generator.CommentModel
*/
@Component
public interface CommentModelMapper extends BaseMapper<CommentModel> {

    int insertAll(CommentModel commentModel);

    List<CommentModel> selectByMsgId(int msgId);

    void updateLikeNumForId(int id,int num);
}




