package demo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Riceive extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		res.setContentType(" text/plain ");
		ServletOutputStream out = res.getOutputStream();
		out.print(" recive user message: ");
		out.print(req.getParameter(" message "));

	} // end service

} // end receive