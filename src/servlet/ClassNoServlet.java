package servlet;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.ClassNo;
import domain.PageBean;
import service.impl.ClassNoService;
import service.impl.ClassNoServiceImpl;

@WebServlet("/classno")
public class ClassNoServlet extends BaseServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//查询单个对象
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//声明service的业务对象
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
        ClassNoService service = new ClassNoServiceImpl();
        PageBean<ClassNo> pb = service.findClassNoByPage(currentPage,rows,condition);

        //System.out.println(pb);

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.转发到list.jsp
        request.getRequestDispatcher("/classno_list.jsp").forward(request,response);
        
	}
	
	public void addClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
        request.setCharacterEncoding("UTF-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        
        //3.封装对象
        ClassNo classNo = new ClassNo();

        try {
            BeanUtils.populate(classNo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    
        //4.调用Service保存
        ClassNoService service = new ClassNoServiceImpl();
        service.addClassNo(classNo);

        //5.跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/classno?method=findAll");
	}
	
	
	public void delClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        ClassNoService service = new ClassNoServiceImpl();
        service.deleteClassNo(id);

        //3.跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath()+"/classno?method=findAll");
	}
	
	public void delSelectedClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取所有的id
        String[] ids = request.getParameterValues("id");

        //2.调用service删除
        ClassNoService service = new ClassNoServiceImpl();
        service.delSelectedClassNo(ids);

        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/classno?method=findAll");
	}
	
	public void updateClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
        request.setCharacterEncoding("utf-8");
        
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        ClassNo classNo = new ClassNo();
        try {
            BeanUtils.populate(classNo,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service修改
        ClassNoService service = new ClassNoServiceImpl();
        service.updateClassNo(classNo);

        //5.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/classno?method=findAll");
	}
	
	public void findClassNo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取id
        String id = request.getParameter("id");
        //2.调用Service查询
        ClassNoService service = new ClassNoServiceImpl();
        ClassNo classNo = service.findClassNoById(id);

        //3.将User存入request
        request.setAttribute("classNo",classNo);
        //4.转发到update.jsp
        request.getRequestDispatcher("/classno_update.jsp").forward(request,response);
	}
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("classNoServlet的find方法");
	}

}