package servletTry;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servletDemo1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		realpath();
//		����ת��(req, resp);
		resp.setContentType("text/html; charset=utf-8");
		resp.getWriter().write("��ã�");
	}

	private void ����ת��(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("�˿ͣ�Ҫ���£����ܰ첻��");
		System.out.println("1�ţ��첻�ˣ��Ұ�����2�š�");
		this.getServletContext().getRequestDispatcher("/sld2").forward(req, resp);
		System.out.println("1�ţ�����ˣ����㡣");
	}

	private void realpath() throws IOException, FileNotFoundException {
		String path = this.getServletContext().getRealPath("/WEB-INF/classes/servletTry/xcy.properties");
		Properties pro = new Properties();
		pro.load(new FileInputStream(path));
		System.out.println(pro.get("xcy"));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
