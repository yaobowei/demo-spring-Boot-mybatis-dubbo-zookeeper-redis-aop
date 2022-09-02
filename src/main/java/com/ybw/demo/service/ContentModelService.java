package com.ybw.demo.service;

import com.ybw.demo.model.ContentModel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author yaobowei
* @description 针对表【content_info】的数据库操作Service
* @createDate 2022-08-29 20:02:02
*/
public interface ContentModelService extends IService<ContentModel> {

    Integer insertAll(ContentModel contentModel);

    ContentModel selectById(int id);

    ContentModel selectLastRecord();

    void updateLikeNumForId(int id,int num);

}
