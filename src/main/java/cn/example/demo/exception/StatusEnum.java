package cn.example.demo.exception;

import cn.example.demo.currency.StatusInterface;

public enum StatusEnum implements StatusInterface {
    EXCEL_NULL(2005, "当前excel中没有数据");
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
}
