package com.cv.mycar.exception;

/**
 * @author shimengqiang
 * @Date 2020-04-16-9:45
 * @Version 1.0
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    /**
     * 状态码
     */
    protected int status;
    /**
     * 应答信息
     */
    protected String message;

    /**
     * 异常错误码-错误信息
     */
    protected MyStatus myStatus;

    /**
     * 附加数据：作为返回结果的result
     */
    protected Object additionalData;


    /**
     * @param myStatus
     */
    public MyException(MyStatus myStatus) {
        super(myStatus.message);
        this.status = myStatus.status;
        this.message = myStatus.message;
        this.myStatus = myStatus;
    }

    public MyException(MyStatus myStatus, Object additionalData) {
        super(myStatus.message);
        this.status = myStatus.status;
        this.message = myStatus.message;
        this.myStatus = myStatus;
        this.additionalData = additionalData;
    }

    /**
     * 业务校验异常
     *
     * @param status  应答状态
     * @param message 应答信息
     */
    public MyException(int status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    /**
     * @param message
     */
    public MyException(String message) {
        super(message);
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MyStatus getMyStatus() {
        return myStatus;
    }

    public void setMyStatus(MyStatus myStatus) {
        this.myStatus = myStatus;
    }

    public Object getAdditionalData() {
        return additionalData;
    }

    public MyException setAdditionalData(Object additionalData) {
        this.additionalData = additionalData;
        return this;
    }

}
    