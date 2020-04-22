package com.redis.assist.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author 王阳
 * @date 2020/4/20 10:24
 */
public class SimplePage implements Serializable {

    protected static final long serialVersionUID = 5136213157391895517L;

    protected int page ;// 页码，默认是第一页
    protected int rows ;// 每页显示的记录数，默认是10
    protected int totalRecord;// 总记录数
    protected List data;// 对应的当前页记录


    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getRows() {
        return rows;
    }
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
    public int getTotalRecord() {
        return totalRecord;
    }
    public List getData() {
        return data;
    }

    public SimplePage setData(List data) {
        this.data = data;
        return this;
    }


}
