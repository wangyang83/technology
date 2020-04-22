package com.redis.assist.domain;

import com.redis.assist.note.ErrorType;

/**
 * @author 王阳
 * @date 2020/4/20 9:12
 */


public class ResultDo<T>  {

    //错误码
    private Integer code;

    private String errorMag;

    //具体的内容
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getErrorMag() {
        return errorMag;
    }

    public void setErrorMag(String errorMag) {
        this.errorMag = errorMag;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setErrorWithErrorMsg(String errorMsg) {
        this.code = ErrorType.error.getResult();
        this.errorMag = errorMsg;
    }

    public void setSuccessWithResult(T result) {
        this.code = ErrorType.success.getResult();
        this.data = result;
    }
}
