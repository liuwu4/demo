package cn.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwu4
 * 23:12
 * description: 对http操作
 */
public class HttpUtils {
    private final Map<String, Object> map = new HashMap<>(16);
    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 是否存在指定的头部字段
     *
     * @param key     字段名
     * @param request request
     * @return boolean
     */
    public static boolean isHeadersKey(String key, HttpServletRequest request) {
        Map<String, Object> isKey = headersInfo(request);
        return isKey.containsKey(key.toLowerCase());
    }

    /**
     * response body返回格式
     *
     * @param object body data返回的内容
     * @return object
     */
    public Map<String, Object> response(Object object) {
        map.put("code", HttpStatus.OK.value());
        map.put("message", HttpStatus.OK.getReasonPhrase());
        map.put("data", object);
        return map;
    }

    /**
     * 将所有的头部信息存放在map中
     *
     * @param request request
     * @return map
     */
    private static Map<String, Object> headersInfo(HttpServletRequest request) {
        Map<String, Object> chunkKeys = new HashMap<>(16);
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String element = enumeration.nextElement();
            chunkKeys.put(element, request.getHeader(element));
        }
        return chunkKeys;
    }


}
