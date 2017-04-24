package servletTry;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;

public class servletlogin extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		String username = "";
		String password = "";
		for(int i = 0; cookies != null && i < cookies.length; i++) {
			if("username".equals(cookies[i].getName())){
				username = cookies[i].getValue();
			}
			if("password".equals(cookies[i].getName())){
				password = cookies[i].getValue();
			}
		}
		writer.write("<form action='"+request.getContextPath()+"/servlet/dologin' method='post'>");
		writer.write("<div>用户名：");
		writer.write("<input type='text' name='username' value='"+username+"'/></div>");
		writer.write("<div>密码：");
		writer.write("<input type='password' name='password' value = '"+password+"'/></div>");
		writer.write("<div><input type='checkbox' name='remember'/>");
		writer.write("记住用户名和密码</div>");
		writer.write("<input type='submit' value='登录'/>");
		writer.write("</form>");
		writer.write("<br/><br/><div>测试用户名：xcy，密码：123</div>");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

}
