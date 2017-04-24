package servletTry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletsuccess extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		
		Map<String,String[]> map = request.getParameterMap();
		System.out.println("Map:");
		for(Map.Entry<String, String[]> m : map.entrySet()) {
			System.out.println(m.getKey() + "--" + m.getValue()[0]);
		}
		String s = request.getRemoteHost();
		System.out.println("ÓÐ·Ã¿Í£º"+s);
		response.sendRedirect("/");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
