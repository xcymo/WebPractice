package sessionTry;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import User.Product;

import DButil.DButils;

public class Store extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<head><title>商城首页</title></head>");
		HttpSession session = request.getSession();
		Enumeration names = session.getAttributeNames();
		boolean b = true;
		if(names.hasMoreElements()) {
			String name =(String) names.nextElement();
			if(name.equals("cart")){
				b = false;
			}
		}
		if(b){
			Map<String, Integer> maps = new LinkedHashMap<String, Integer>();
			session.setAttribute("cart", maps);
		}
		
		Map<String, Product> map = DButils.getMap();
		for(Entry<String, Product> m : map.entrySet()){
			out.print("<a href='"+request.getContextPath()+"/servlet/detail?id="+m.getKey()+"' target='_blank'>"+m.getValue().getName()+"</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.print("&nbsp;&nbsp;&nbsp;&nbsp;<a href='"+request.getContextPath()+"/servlet/cartProceed?id="+m.getKey()+"' target='_blank'>加入购物车</a><br/>");
		}
		
		out.print("<a href='"+request.getContextPath()+"/servlet/cart' target='_blank'>查看购物车</a>");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
