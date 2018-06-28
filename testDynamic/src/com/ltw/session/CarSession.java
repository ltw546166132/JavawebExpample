package com.ltw.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CarSession
 */
@WebServlet("/CarSession")
public class CarSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarSession() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		int idindex = Integer.parseInt(request.getParameter("id"));
		String[] name = {"hp1","hp2","hp3","hp4"};
		String key = name[idindex];
		Map<String,Integer> map = (Map<String, Integer>) session.getAttribute("cart");
		if (map==null) {	
			Map<String,Integer> map2 = new HashMap<String,Integer>();
			map2.put(key, 1);
			session.setAttribute("cart", map2);
		} else {
			if (map.containsKey(key)) {
				map.put(key, (map.get(key)+1));
			} else {
				map.put(key, 1);
			}
		}
		response.sendRedirect("commodity.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
