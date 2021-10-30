package allserv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import calldatabase.GetData;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String id=request.getParameter("sid");
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement("select * from table1 where sid=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps1=cn.prepareStatement("delete from table1 where sid=?");
				ps1.setString(1, id);
				ps1.execute();
				out.print("Record Deleted...");
				RequestDispatcher rd=request.getRequestDispatcher("delete.html");
				rd.include(request, response);
			}else {
				out.print("no record found");
				RequestDispatcher rd=request.getRequestDispatcher("delete.html");
				rd.include(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
