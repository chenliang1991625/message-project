package com.my.cn.messageproject.pojo;
//new Result(true, StatusCode.OK, "发送成功");

public class Result<T> {
    private Boolean idOldConsumer;
    private String requState;
    private T data;

    public Result() {
    }

    public Result(Boolean idOldConsumer, String requState, T data) {
        this.idOldConsumer = idOldConsumer;
        this.requState = requState;
        this.data = data;
    }


    public Boolean getIdOldConsumer() {
        return idOldConsumer;
    }

    public void setIdOldConsumer(Boolean idOldConsumer) {
        this.idOldConsumer = idOldConsumer;
    }

    public String getRequState() {
        return requState;
    }

    public void setRequState(String requState) {
        this.requState = requState;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "idOldConsumer=" + idOldConsumer +
                ", requState='" + requState + '\'' +
                ", data=" + data +
                '}';
    }
}
