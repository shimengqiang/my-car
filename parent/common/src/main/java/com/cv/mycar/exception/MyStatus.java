package com.cv.mycar.exception;

/**
 * @author shimengqiang
 * @Date 2020-04-16-9:47
 * @Version 1.0
 */
public enum MyStatus {
    SUCCESS(2000, "SUCCESS"),
    ERROR(5000, "ERROR"),
    ;

    /**
     * 枚举值
     */
    public final int status;

    /**
     * 枚举描述
     */
    public final String message;

    MyStatus(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
