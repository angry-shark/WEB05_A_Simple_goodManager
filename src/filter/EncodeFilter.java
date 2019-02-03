package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter("/login.jsp")
public class EncodeFilter implements Filter {

    private String encoding;

    public void destroy() {
    }


    //过滤的方法
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //chain.doFilter(req, resp);
       // ((HttpServletResponse)resp).sendRedirect("index.jsp");
    req.setCharacterEncoding(encoding);
    chain.doFilter(req,resp);

    }

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("Encoding");
    }

}
