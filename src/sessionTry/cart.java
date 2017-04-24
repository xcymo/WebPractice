package sessionTry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import User.Product;

import DButil.DButils;

public class cart extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<head><title>购物车</title></head>");
		HttpSession session = request.getSession();
		Map<String, Integer> maps = (Map<String, Integer>) session.getAttribute("cart");
		Map<String, Product> map = DButils.getMap();
		for(Entry<String, Integer> entry : maps.entrySet()) {
			String id = entry.getKey();
			Product product = map.get(id);
			out.print(product.getName()+",\t"+"数量："+entry.getValue()+"<br/>");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
