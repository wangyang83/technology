package com.redis.assist.note;


/**
 * @author 王阳
 * @date 2020/4/20 9:24
 */
public enum  ErrorType {
    success(200), error(400),sessionTimeOut(-100),sessionLoginOther(-200);

    private Integer result;

    private ErrorType(Integer result) {
        this.result = result;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
