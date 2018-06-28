package com.webtest;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testservlet
 */
@WebServlet("/testservlet")
public class testservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testservlet() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	System.out.println("init调用");
    }
    
    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
    	super.service(arg0, arg1);
    	System.out.println("server调用");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<html>");
		response.getWriter().append("<body>");
		response.getWriter().append("<h4>hello world</h4>");
		response.getWriter().append("</body>");
		response.getWriter().append("</html>");
		ServletConfig servletConfig = this.getServletConfig();
		String initParameter = servletConfig.getInitParameter("name");
		//System.out.println(initParameter);
		Enumeration<String> initParameterNames = this.getInitParameterNames();
		while(initParameterNames.hasMoreElements()) {
			String nextElement = initParameterNames.nextElement();
			System.out.println("Key"+nextElement);
			String initParameter2 = servletConfig.getInitParameter(nextElement);
			System.out.println("Value"+initParameter2);
		}
		ServletContext servletContext = this.getServletContext();
		System.out.println(servletContext.getRealPath(""));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy.....");
	}

}
