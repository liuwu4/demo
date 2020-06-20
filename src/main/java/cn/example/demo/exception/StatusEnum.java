package cn.example.demo.exception;

import cn.example.demo.currency.StatusInterface;

public enum StatusEnum implements StatusInterface {
    EXCEL_NULL(2005, "当前excel中没有数据"),
    STATUS_401(401, "当前用户的token已过期");
    private int code;
    private String message;

    StatusEnum(int code, String message) {
        this.code = code;

        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }


    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "StatusEnum{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}

