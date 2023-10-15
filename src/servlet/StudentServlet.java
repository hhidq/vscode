package servlet;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;


import domain.PageBean;
import domain.Student;
import service.impl.StudentService;
import service.impl.StudentServiceImpl;

@WebServlet("/student")
public class StudentServlet extends BaseServlet {
	
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
        StudentService service = new StudentServiceImpl();
        PageBean<Student> pb = service.findStudentByPage(currentPage,rows,condition);

        //System.out.println(pb);

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.转发到list.jsp
        request.getRequestDispatcher("/student_list.jsp").forward(request,response);
        

	}

	
	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
        request.setCharacterEncoding("UTF-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        
        System.out.println(request.getParameter("gender"));
        //3.封装对象
        Student student = new Student();

        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    
        //4.调用Service保存
        StudentService service = new StudentServiceImpl();
        service.addStudent(student);

        //5.跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	
	public void delStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        StudentService service = new StudentServiceImpl();
        service.deleteStudent(id);

        //3.跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void delSelectedStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取所有的id
        String[] ids = request.getParameterValues("id");

        //2.调用service删除
        StudentService service = new StudentServiceImpl();
        service.delSelectedStudent(ids);

        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        Student student = new Student();
        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service修改
        StudentService service = new StudentServiceImpl();
        service.updateStudent(student);

        //5.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/student?method=findAll");
	}
	
	public void findStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取id
        String id = request.getParameter("id");
        //2.调用Service查询
        StudentService service = new StudentServiceImpl();
        Student student = service.findStudentById(id);

        //3.将User存入request
        request.setAttribute("student",student);
        //4.转发到update.jsp
        request.getRequestDispatcher("/student_update.jsp").forward(request,response);
	}
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userServlet的find方法");
	}

}