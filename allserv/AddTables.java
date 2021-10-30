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

import calldatabase.GetData;

/**
 * Servlet implementation class AddTables
 */
@WebServlet("/AddTables")
public class AddTables extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			int sid=(int)(Math.random()*1000);
			String size=request.getParameter("size");
			int cost=Integer.parseInt(request.getParameter("cost"));
			String facility=request.getParameter("facility");
			String status="free";
			
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement("insert into table1 values(?,?,?,?,?)");
			ps.setInt(1, sid);
			ps.setString(2, size);
			ps.setInt(3, cost);
			ps.setString(4, facility);
			ps.setString(5, status);
			ps.execute();
			out.println("Table Added Successfully..."
					+ "Table number is "+sid);
			RequestDispatcher rd=request.getRequestDispatcher("addtables.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
