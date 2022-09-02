package com.ybw.demo.data.result;

import com.ybw.demo.model.CommentModel;
import com.ybw.demo.model.ContentModel;

import java.io.Serializable;
import java.util.List;

public class ContentDataResult implements Serializable {

    ContentModel contentModel;

    List<CommentModel> commentModelList;

    public ContentDataResult() {
    }

    public ContentDataResult(ContentModel contentModel, List<CommentModel> commentModelList) {
        this.contentModel = contentModel;
        this.commentModelList = commentModelList;
    }

    public ContentModel getContentModel() {
        return contentModel;
    }

    public void setContentModel(ContentModel contentModel) {
        this.contentModel = contentModel;
    }

    public List<CommentModel> getCommentModelList() {
        return commentModelList;
    }

    public void setCommentModelList(List<CommentModel> commentModelList) {
        this.commentModelList = commentModelList;
    }
}
