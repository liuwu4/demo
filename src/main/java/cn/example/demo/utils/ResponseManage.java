package cn.example.demo.utils;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwu4
 * 23:12
 * description: 返回信息
 */
public class ResponseManage {
    private final Map<String, Object> map = new HashMap<>(16);
    public Map<String, Object> response (Object object){
        map.put("code", HttpStatus.OK.value());
        map.put("message", HttpStatus.OK.getReasonPhrase());
        map.put("data", object);
        return map;
    }
}
