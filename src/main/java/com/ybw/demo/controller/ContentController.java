package com.ybw.demo.controller;

import com.ybw.demo.data.result.BaseDataResult;
import com.ybw.demo.data.result.ContentDataResult;
import com.ybw.demo.data.result.LikeDataRespond;
import com.ybw.demo.model.CommentModel;
import com.ybw.demo.model.ContentModel;
import com.ybw.demo.service.CommentModelService;
import com.ybw.demo.service.ContentModelService;
import com.ybw.demo.utils.ResultUtil;
import com.ybw.demo.utils.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Random;

public class ContentController {

    @Autowired
    ContentModelService contentModelService;

    @Autowired
    CommentModelService commentModelService;

    @PostMapping(value = "get/content")
    Result<ContentDataResult> getContent(@RequestBody Integer id){
        if(id == null || id == 0) {
            int lastId = contentModelService.selectLastRecord().getId();
            Random random = new Random();
            id = random.nextInt(lastId);
        }
        ContentModel contentModel = contentModelService.selectById(id);
        if(contentModel == null){
            return ResultUtil.success(new BaseDataResult(10,false));
        } else if(id.equals(contentModel.getId())){
            return getContent(id);
        } else {
            List<CommentModel> commentModelList = commentModelService.selectByMsgId(contentModel.getId());
            return ResultUtil.success(new ContentDataResult(contentModel,commentModelList));
        }
    }

    @PostMapping(value = "add/content")
    Result<BaseDataResult> addContent(@RequestBody ContentModel contentModel){
        contentModelService.insertAll(contentModel);
        return ResultUtil.success(new BaseDataResult(1,true));
    }

    @PostMapping(value = "add/comment")
    Result<BaseDataResult> addComment(@RequestBody CommentModel commentModel){
        commentModelService.insertAll(commentModel);
        return ResultUtil.success(new BaseDataResult(1,true));
    }

    @PostMapping(value = "gushi/like")
    Result<BaseDataResult> addLike(@RequestBody LikeDataRespond dataRespond){
        if(dataRespond.getLikeId() == 0){
            return ResultUtil.success(new BaseDataResult(7,false));
        }
        if(dataRespond.getLikeType() == 1) { //内容
            ContentModel model = contentModelService.selectById(dataRespond.getLikeId());
            if(model == null) {
                return ResultUtil.success(new BaseDataResult(8,false));
            }
            contentModelService.updateLikeNumForId(dataRespond.getLikeId(),model.getLikeNum() + (dataRespond.getIsLike() == 1 ? 1 : -1));
            return ResultUtil.success(new BaseDataResult(4,true));
        } else if(dataRespond.getLikeType() == 2) { //评论
            CommentModel model = commentModelService.getById(dataRespond.getLikeId());
            if(model == null) {
                return ResultUtil.success(new BaseDataResult(8,false));
            }
            commentModelService.updateLikeNumForId(dataRespond.getLikeId(),model.getLikeNum() + (dataRespond.getIsLike() == 1 ? 1 : -1));
            return ResultUtil.success(new BaseDataResult(5,true));
        } else {
            return ResultUtil.success(new BaseDataResult(6,false));
        }
    }
}
