package com.qf.pojo;

//因为返回的为三部分（code、msg、data），所创建一个返回类
//这个类定义了返回的json格式，即json含有哪些字段
public class BaseResponse<T> {
    private Integer code;
    private String msg;
    private T data;
    private long count;//查询的数据
    private Integer page;//当前页
    private Integer limit;//每页显示的数据

    public BaseResponse(StatusCode statusCode) {
        this.code=statusCode.getCode();
        this.msg=statusCode.getMsg();
    }

    public BaseResponse(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public BaseResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponse(T data, StatusCode statusCode) {
        this.data = data;
        this.code=statusCode.getCode();
        this.msg=statusCode.getMsg();
    }

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(Integer code, String msg, T data, long count) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.count = count;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
