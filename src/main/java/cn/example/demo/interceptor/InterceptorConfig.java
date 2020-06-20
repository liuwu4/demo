package cn.example.demo.interceptor;

import cn.example.demo.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liuwu4
 * 22:43
 * description:拦截器
 */
@Component
public class InterceptorConfig implements HandlerInterceptor {
    private final static Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle-------request:" + request.getHeader("Authorization"));
        String authorization = request.getHeader("Authorization");
        boolean isHeader = HttpUtils.isHeadersKey("Authorization", request);
        if (!isHeader) {
            writeResponseBody(403, "请检查http[Authorization]头部信息是否完整", response);
            return false;
        }
        if (authorization.isEmpty()) {
            writeResponseBody(401, "当前用户的token信息无效", response);
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("after----------" + handler);
    }

    /**
     * 拦截url校验是否存在token
     *
     * @param code     http状态码
     * @param msg      提示信息
     * @param response HttpServletResponse
     * @throws IOException
     */
    private void writeResponseBody(int code, String msg, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.append(writeResponseBodyText(code, msg));
        printWriter.flush();
        printWriter.close();
    }

    /**
     * 写入response body 中的内容
     *
     * @param code http状态码
     * @param msg  信息
     * @return 状态码和信息的组合
     */
    private String writeResponseBodyText(int code, String msg) {
        return "{\"status\":" + code + ",\"msg\":\"" + msg + "\"}";

    }
}
