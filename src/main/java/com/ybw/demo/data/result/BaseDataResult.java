package com.ybw.demo.data.result;

import java.io.Serializable;

public class BaseDataResult implements Serializable {

    Integer type;

    Boolean success;

    public BaseDataResult(Integer type, Boolean success) {
        this.type = type;
        this.success = success;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
