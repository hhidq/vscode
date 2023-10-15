package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import domain.Course;
import domain.PageBean;
import service.impl.CourseService;
import service.impl.CourseServiceImpl;

@WebServlet("/course")
public class CourseServlet extends BaseServlet {
	
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
        CourseService service = new CourseServiceImpl();
        PageBean<Course> pb = service.findCourseByPage(currentPage,rows,condition);

        //System.out.println(pb);

        //3.将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        //4.转发到list.jsp
        request.getRequestDispatcher("/course_list.jsp").forward(request,response);
        

	}

	
	public void addCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
        request.setCharacterEncoding("UTF-8");
        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();
        
        System.out.println(request.getParameter("gender"));
        //3.封装对象
        Course course = new Course();

        try {
            BeanUtils.populate(course,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    
        //4.调用Service保存
        CourseService service = new CourseServiceImpl();
        service.addCourse(course);

        //5.跳转到userListServlet
        response.sendRedirect(request.getContextPath()+"/course?method=findAll");
	}
	
	
	public void delStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取id
        String id = request.getParameter("id");
        //2.调用service删除
        CourseService service = new CourseServiceImpl();
        service.deleteCourse(id);

        //3.跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath()+"/course?method=findAll");
	}
	
	public void delSelectedCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取所有的id
        String[] ids = request.getParameterValues("id");

        //2.调用service删除
        CourseService service = new CourseServiceImpl();
        service.delSelectedCourse(ids);

        //3.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/course?method=findAll");
	}
	
	public void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取map
        Map<String, String[]> map = request.getParameterMap();
        //3.封装对象
        Course course = new Course();
        try {
            BeanUtils.populate(course,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //4.调用Service修改
        CourseService service = new CourseServiceImpl();
        service.updateCourse(course);

        //5.跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/course?method=findAll");
	}
	
	public void findCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取id
        String id = request.getParameter("id");
        //2.调用Service查询
        CourseService service = new CourseServiceImpl();
        Course course = service.findCourseById(id);

        //3.将User存入request
        request.setAttribute("course",course);
        //4.转发到update.jsp
        request.getRequestDispatcher("/course_update.jsp").forward(request,response);
	}
	
	public void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("courseServlet的find方法");
	}

}