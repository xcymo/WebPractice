package servletTry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class cookie1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		//��ȡcookie
		Cookie[] cookies = request.getCookies();
		for(int i = 0; cookies != null && i < cookies.length; i++) {
				//д���ڿͻ���ҳ��
				String t = cookies[i].getValue();
				Date d = new Date(Long.parseLong(t));
				writer.write("���ϴη��ʵ�ʱ���ǣ�" + d.toLocaleString());
		}
		//�����η���ʱ��д�ڿͻ���cookie
		response.addCookie(new Cookie("lastAccessTime", System.currentTimeMillis()+""));
		writer.write("<br/><a href='/'>������ҳ</a>");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
