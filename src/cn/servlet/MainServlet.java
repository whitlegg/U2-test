package cn.servlet;

import cn.domain.Card;
import cn.domain.Some;
import cn.domain.User;
import cn.service.CardService;
import cn.service.UserService;
import cn.service.impl.CardServiceimpl;
import cn.service.impl.UserServiceimpl;
import cn.untils.BaseServlet;
import cn.untils.PageBean;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/main")
public class MainServlet extends BaseServlet {
    UserService userService = new UserServiceimpl();
    CardService cardService = new CardServiceimpl();
    //查询
    public void list(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> map = request.getParameterMap();
        Integer p = 1;
        String pstr = request.getParameter("p");
        if(pstr!=null&&!pstr.isEmpty()){
            p = Integer.valueOf(pstr);
        }
        Some some = new Some();
        try {
            BeanUtils.populate(some,map);
            PageBean pb = userService.findall(some,p);
            request.setAttribute("pb",pb);
            List<Card> card = cardService.findCard();
            request.getSession().setAttribute("card", card);
            request.setAttribute("some",some);
            request.getRequestDispatcher("/main.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //添加
    public void add(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> map = request.getParameterMap();
        //new 实体类
        //xx xx = new xx();
        User user = new User();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sf.format(date);
        try {
            BeanUtils.populate(user,map);
            Date parse = sf.parse(format);
            user.setCreatedate(parse);
            //填装xx实体类
            //调用service层方法
            boolean b = userService.addUser(user);
            if(b){
                request.setAttribute("tryadd","ok");
            }else{
                request.setAttribute("tryadd","no");
            }
            list(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //删除
    public void del(HttpServletRequest request, HttpServletResponse response){
       //传递的需要条件id 进行删除
        String id = request.getParameter("id");
        try {
            //调用service层方法调用判断b
            boolean b =  userService.removeUserById(id);
            if(b){
                request.setAttribute("trydel","ok");
            }else{
                request.setAttribute("trydel","no");
            }
            list(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //修改显示
    public void updataUI(HttpServletRequest request, HttpServletResponse response){
        //条件id
        String id = request.getParameter("id");
        try {
            //根据条件查询
            // xx updata = xx.findUpdata(id);
            User user = userService.updataUI(id);


            //设置updata的值
            request.setAttribute("user",user);
            request.getRequestDispatcher("/updata.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //修改
    public void updata(HttpServletRequest request, HttpServletResponse response){
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sf.format(date);
        try {

            BeanUtils.populate(user,map);
            Date parse = sf.parse(format);
            user.setCreatedate(parse);
            //调用service层方
            boolean b =userService.updataUserService(user);
            if(b){
                request.setAttribute("tryup","ok");
            }else{
                request.setAttribute("tryup","no");
            }
            list(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}