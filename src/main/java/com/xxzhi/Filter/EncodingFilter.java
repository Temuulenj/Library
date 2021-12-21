package com.xxzhi.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Temuu
 */
public class EncodingFilter implements Filter {
    /**
     * 定义变量接收初始化的值
     */
    private static String encoding;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        // 设置字符编码链锁
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }

    /**
     *
     * @param config
     * 配置
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        // 接收web.xml配置文件中的初始参数
        encoding = config.getInitParameter("CharsetEncoding");

    }
}
