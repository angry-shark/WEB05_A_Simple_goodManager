package listener;

import model.User;
import utils.SessionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class SessionAttributeListener implements HttpSessionListener, HttpSessionAttributeListener {//单点登陆功能

    // Public constructor is required by servlet spec
    public SessionAttributeListener() {

    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */

      if(sbe.getName().equals("user")){
          User user = (User)sbe.getValue();
          //判断是否有其他客户端登陆
          if(SessionManager.sessionMap.containsKey(user.getUsername())){
              //如果有，则获取已存在的客户端并移除
              HttpSession httpSession = SessionManager.sessionMap.get(user.getUsername());//获取已存在且已登录的session
              httpSession.removeAttribute("user");//把登陆用户信息从已登录的session中移除
              SessionManager.sessionMap.remove(user.getUsername());//把session从sessionMap中移除
          }
          //SessionManager.sessionMap.put(user.getUsername(), sbe.getSession());
          SessionManager.test(user.getUsername(),sbe.getSession());
      }
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        if(sbe.getName().equals("user")){
            System.out.println("Remove");
        }
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
        if(sbe.getName().equals("user")){
            System.out.println("Replace");
            sbe.getSession().getServletContext().getRequestDispatcher("/index,jsp");
        }
    }
}
