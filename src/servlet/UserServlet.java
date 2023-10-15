package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import domain.PageBean;
import domain.User;
import service.impl.UserService;
import service.impl.UserServiceImpl;


@WebServlet("/user")
public class UserServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

        //1.获取参数
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示的记录数

        if(currentPage == null || "".equals(currentPage)){

            currentPage = "1";
        }

        if(rows == null || "".equals(rows)){
            rows = "5";
        }
        
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();


        //2.调用service方法
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage,rows,condition);

        //System.out.println(pb);

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//灏嗘煡璇㈡潯浠跺瓨鍏equest
        //4.转发到list.jsp
        request.getRequestDispatcher("/user_list.jsp").forward(request,response);
	}
	
	public void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service保存
        UserService service = new UserServiceImpl();
        service.addUser(user);

        //5.跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/login.jsp");
	}
	
	
	public void registUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service保存
        UserService service = new UserServiceImpl();
        service.registUser(user);

        //5.跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/user_login.jsp");
	}
	
	public void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        UserService service = new UserServiceImpl();
        service.deleteUser(id);

        //3.跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
	}
	
	public void delSelectedUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取所有的id
        String[] ids = request.getParameterValues("uid");
        //2.调用service删除
        UserService service = new UserServiceImpl();
        service.delSelectedUser(ids);

        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
	}
	
	
	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service修改
        UserService service = new UserServiceImpl();
        service.updateUser(user);
        

        //5.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		
        //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取数据
        //2.1获取用户填写验证码
        String verifycode = request.getParameter("verifycode");

        //3.验证码校验
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/user_login.jsp").forward(request,response);

            return;
        }

        Map<String, String[]> map = request.getParameterMap();
        //4.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //5.调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.loginUser(user);
        //6.判断是否登录成功
        if(loginUser != null){
            //登录成功
            //将用户存入session
            session.setAttribute("user",loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            //登录失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误！");
            //跳转登录页面
            request.getRequestDispatcher("/user_login.jsp").forward(request,response);

        }
	}
	
	public void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取id
        String id = request.getParameter("id");
        //2.调用Service查询
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);

        //3.将User存入request
        request.setAttribute("user",user);
        //4.转发到update.jsp
        request.getRequestDispatcher("/user_update.jsp").forward(request,response);
	}
	
	public void destroyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //删除用户信息
        request.removeAttribute("user");
        //转发到update.jsp
        request.getRequestDispatcher("/user_login.jsp").forward(request,response);
	}
	
	
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userServlet的find方法");
	}
	
	
}
	
	