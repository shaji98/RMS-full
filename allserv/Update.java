package allserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import calldatabase.GetData;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			HttpSession s=request.getSession(false);
			int sid=(int)s.getAttribute("sid");
			String size=request.getParameter("size");
			String cost=request.getParameter("cost");
			String facility=request.getParameter("facility");
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement("update table1 set size=?,cost=?,facility=? where sid=?");
			ps.setString(1, size);
			ps.setString(2, cost);
			ps.setString(3, facility);
			ps.setInt(4, sid);
			ps.execute();
			out.print("Record updated...");
			RequestDispatcher rd=request.getRequestDispatcher("update.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
