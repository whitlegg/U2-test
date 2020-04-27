package cn.untils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(urlPatterns = "/base")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String cmd = request.getParameter("cmd");
        //获取Class对象
        Class aClass = this.getClass();
        //获取方法对象
        Method method = null;
        try {
            //执行方法
            method = aClass.getMethod(cmd, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(aClass.newInstance(), request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}