package sessionTry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import User.Product;

public class cartProceed extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Map<String, Integer> map = (Map<String, Integer>) session.getAttribute("cart");
		String id = request.getParameter("id");
		if(map.containsKey(id)) {
			int num = map.get(id);
			map.remove(id);
			map.put(id, num+1);
		}else{
			map.put(id, 1);
		}
		session.setAttribute("cart", map);
		out.print("成功加入购物车！~");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
