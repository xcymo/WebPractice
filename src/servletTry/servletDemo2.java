package servletTry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servletDemo2 extends HttpServlet {
	//�����ļ���get
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�������ˣ�");
//		String path = this.getServletContext().getRealPath("/WEB-INF/classes/essay.docx");//����ط�Ҫ���ļ�·��
//		File file = new File(path);
//		FileInputStream fis = new FileInputStream(file);
//		ServletOutputStream sos = response.getOutputStream();
//		System.out.println(file.getName());
//		String filename = URLEncoder.encode(file.getName(), "UTF-8");
//		response.setHeader("content-disposition", "attachment;filename="+filename);
//		response.setHeader("content-type", "docx");//������ļ���׺
//		int len = 1;
//		byte[] arr = new byte[8096];
//		while((len = fis.read(arr)) != -1) {
//			sos.write(arr, 0, len);
//		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("****************dopost------------------");
		doGet(request, response);
	}

}
