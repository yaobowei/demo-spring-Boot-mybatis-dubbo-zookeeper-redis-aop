package com.ybw.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName comment_info
 */
@TableName(value ="comment_info")
public class CommentModel implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String message;

    /**
     * 
     */
    private Integer contentId;

    /**
     * 
     */
    private Integer msgId;

    /**
     * 
     */
    private Integer userId;

    /**
     * 
     */
    private Integer likeNum;

    /**
     * 
     */
    private String imageUrl;

    /**
     * 
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     */
    public Integer getContentId() {
        return contentId;
    }

    /**
     * 
     */
    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    /**
     * 
     */
    public Integer getMsgId() {
        return msgId;
    }

    /**
     * 
     */
    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    /**
     * 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     * 
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     * 
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * 
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CommentModel other = (CommentModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getContentId() == null ? other.getContentId() == null : this.getContentId().equals(other.getContentId()))
            && (this.getMsgId() == null ? other.getMsgId() == null : this.getMsgId().equals(other.getMsgId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getLikeNum() == null ? other.getLikeNum() == null : this.getLikeNum().equals(other.getLikeNum()))
            && (this.getImageUrl() == null ? other.getImageUrl() == null : this.getImageUrl().equals(other.getImageUrl()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getContentId() == null) ? 0 : getContentId().hashCode());
        result = prime * result + ((getMsgId() == null) ? 0 : getMsgId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getLikeNum() == null) ? 0 : getLikeNum().hashCode());
        result = prime * result + ((getImageUrl() == null) ? 0 : getImageUrl().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", message=").append(message);
        sb.append(", contentId=").append(contentId);
        sb.append(", msgId=").append(msgId);
        sb.append(", userId=").append(userId);
        sb.append(", likeNum=").append(likeNum);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}