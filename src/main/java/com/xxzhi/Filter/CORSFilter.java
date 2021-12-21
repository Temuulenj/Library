package com.xxzhi.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author temuulen
 */
@WebFilter("/")
public class CORSFilter implements Filter{
    @Override
    public  void  init(FilterConfig filterConfig) {
    }

    @Override
    public  void  doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)  throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.addHeader( "Access-Control-Allow-Origin" ,  "*" );
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public  void  destroy() {

    }
}