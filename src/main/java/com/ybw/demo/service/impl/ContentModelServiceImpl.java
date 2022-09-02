package com.ybw.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ybw.demo.service.ContentModelService;
import com.ybw.demo.model.ContentModel;
import com.ybw.demo.mapper.ContentModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author yaobowei
* @description 针对表【content_info】的数据库操作Service实现
* @createDate 2022-08-29 20:02:02
*/
@Service(value = "ContentModelService")
public class ContentModelServiceImpl extends ServiceImpl<ContentModelMapper, ContentModel>
    implements ContentModelService {

    @Autowired
    ContentModelMapper contentModelMapper;

    @Override
    public Integer insertAll(ContentModel contentModel) {
        return contentModelMapper.insertAll(contentModel);
    }

    @Override
    public ContentModel selectById(int id) {
        return contentModelMapper.selectById(id);
    }

    @Override
    public ContentModel selectLastRecord() {
        return contentModelMapper.selectLastRecord();
    }

    @Override
    public void updateLikeNumForId(int id,int num) {
        contentModelMapper.updateLikeNumById(id,num);
    }
}




