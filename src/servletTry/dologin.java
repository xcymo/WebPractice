package servletTry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dologin extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		Cookie nameRem = new Cookie("username", username);
		Cookie pwdRem = new Cookie("password", password);
		nameRem.setPath(request.getContextPath() + "/servlet/");
		pwdRem.setPath(request.getContextPath() + "/servlet/");
		
		if("xcy".equals(username)&&"123".equals(password)) {
			out.write("登录成功！");
			if(remember!=null) {
				nameRem.setMaxAge(Integer.MAX_VALUE);
				pwdRem.setMaxAge(Integer.MAX_VALUE);
			}else{
				nameRem.setMaxAge(0);
				pwdRem.setMaxAge(0);
			}
			response.addCookie(nameRem);
			response.addCookie(pwdRem);
			response.setHeader("refresh", "2;/");
		}else{
			out.write("用户名或密码错误！");
			response.setHeader("refresh", "2;"+request.getContextPath()+"/servlet/servletlogin");
		
		}
		
	}

}
