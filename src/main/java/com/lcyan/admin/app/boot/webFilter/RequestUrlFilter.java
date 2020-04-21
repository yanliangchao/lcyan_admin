package com.lcyan.admin.app.boot.webFilter;

import com.google.gson.Gson;
import com.lcyan.admin.app.boot.config.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Yan Liangchao
 * @version 1.0
 * @date 2020/4/20 13:51
 * @email liangchao.yan-ext@yanfeng.com
 */
@WebFilter(filterName = "RequestUrlFilter")
@Slf4j
@Component
public class RequestUrlFilter implements Filter {

    @Override
    public void destroy() {
        log.info("【销毁 RequestUrlFilter】");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        Gson gson = new Gson();
        //获取IP地址
        String ipAddress = IpUtil.getIpAddr(httpServletRequest);

        log.info("【访问IP {} 】", ipAddress);
        /**
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String value= httpServletRequest.getHeader(name);
            System.out.println(name + ":" + value);
        }
        log.info("【请求头信息 {} 】", httpServletRequest.getHeader("date"));

        BufferedReader reader = httpServletRequest.getReader();
        StringBuilder sb = new StringBuilder();
        char[]buff = new char[1024];
        int len;
        while((len = reader.read(buff)) != -1) {
            sb.append(buff,0, len);
        }
         */
        log.info("【请求路径 {},请求方法 {}】", httpServletRequest.getRequestURL(),httpServletRequest.getMethod());
        //log.info("【请求参数 {} 】", sb.toString());
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        log.info("【初始化 RequestUrlFilter】");
    }

}
