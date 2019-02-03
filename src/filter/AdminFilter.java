package filter;

import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest HttpReq = (HttpServletRequest)req;
        HttpServletResponse HttpRes = (HttpServletResponse)resp;
        Object o = HttpReq.getSession().getAttribute("user");

        //权限判断
        if(o == null){
            HttpRes.sendRedirect(HttpReq.getContextPath() + "/index.jsp");
        }else{
            User user = (User)o;
            if(user.isAdmin()){
                //如果为管理员账号，放行
                chain.doFilter(req,resp);
            }
            else {
                //如果为普通用户
                HttpRes.sendRedirect(HttpReq.getContextPath() +     "/index.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
