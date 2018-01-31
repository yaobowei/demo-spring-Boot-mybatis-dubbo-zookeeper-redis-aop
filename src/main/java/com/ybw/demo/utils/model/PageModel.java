package com.ybw.demo.utils.model;

/**
 * Created by yao on 2018/1/22
 * 分页基类，作为传输参数使用
 */


public class PageModel {

    private Integer pageNum=0;

    private Integer pageSize=0;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
