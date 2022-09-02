package com.ybw.demo.mapper;

import com.ybw.demo.model.ContentModel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
* @author yaobowei
* @description 针对表【content_info】的数据库操作Mapper
* @createDate 2022-08-29 20:02:02
* @Entity com.ybw.demo.model.ContentModel
*/
@Component
public interface ContentModelMapper extends BaseMapper<ContentModel> {

    int insertAll(ContentModel contentModel);

    ContentModel selectById(int id);

    ContentModel selectLastRecord();

    void updateLikeNumById(int id,int num);
}




