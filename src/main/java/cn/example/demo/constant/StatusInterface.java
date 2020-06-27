package cn.example.demo.constant;

/**
 * @author yj
 * @date 2020/06/22
 * @description 请求返回的统一格式接口
 */
public interface StatusInterface {
    public int getCode();

    public String getMessage();
}
