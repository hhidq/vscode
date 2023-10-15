package servlet;

import java.io.IOException;

import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class BaseServlet extends HttpServlet {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   try {
		   // 获取请求标识
           String methodName = request.getParameter("method");
           // 获取指定类的字节码对象
           Class<? extends BaseServlet> clazz = this.getClass();//这里的this指的是继承BaseServlet对象
           // 通过类的字节码对象获取方法的字节码对象
           Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
           // 让方法执行
           method.invoke(this, request, response);

       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
    }
   
//   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	   
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }

    
//    //直接将传入的对象序列化为json，并且写回客户端
//    public void writeValue(Object obj,HttpServletResponse response) throws ServletException, IOException {
//    	ObjectMapper mapper=new ObjectMapper();
//		response.setContentType("application/json;charset=utf-8");
//		mapper.writeValue(response.getOutputStream(),obj);
//	
//    }
//    
//    //将传入的对象序列化为json，返回
//    public String writeValueAsString(Object obj,HttpServletResponse response) throws ServletException, IOException {
//    
//    	ObjectMapper mapper=new ObjectMapper();
//		response.setContentType("application/json;charset=utf-8");
//		return mapper.writeValueAsString(obj);
//	
//    	
//    }
}

