package ru.lanit.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class EncodingFilter implements Filter {
    public final static String SESSION_LOCALE = "sessionLocale";

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        chain.doFilter(request, response);
    }

    public void destroy() {}

    public void init(FilterConfig arg0) throws ServletException {}
}
