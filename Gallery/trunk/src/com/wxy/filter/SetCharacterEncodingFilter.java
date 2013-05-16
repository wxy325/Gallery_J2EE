package com.wxy.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-12
 * Time: 下午6:08
 * To change this template use File | Settings | File Templates.
 */
public class SetCharacterEncodingFilter implements Filter {
    protected String encoding = null;

    public void destroy()
    {
        this.encoding = null;
    }

    public void init(FilterConfig filterConfig) throws ServletException
    {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException

    {
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
        chain.doFilter(request, response);
    }

}
