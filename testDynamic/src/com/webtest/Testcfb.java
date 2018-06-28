package com.webtest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testcfb
 */
@WebServlet("/Testcfb")
public class Testcfb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testcfb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		Integer cfb = Integer.parseInt(name);
		writer.append("<html>");
		writer.append("<body>");
		for (int i = 1; i <= cfb; i++) {
			for (int j = 1;j<=i;j++) {
				writer.append("<span>"+j+"*"+i+"="+i*j+"</span>&nbsp");
			}
			writer.append("</br>");
		}
		
		writer.append("</body>");
		writer.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
