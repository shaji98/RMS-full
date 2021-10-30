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
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class Book extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String sid=request.getParameter("sc");
			HttpSession s1=request.getSession(false);
			String cid=(String)s1.getAttribute("cid");
			String dte="01-11-21";
			String sql_space="update table1 set status='booked' where sid=?";
			String sql_book="insert into booking values(?,?,?)";
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement(sql_space);
			ps.setString(1, sid);
			ps.execute();
			
			PreparedStatement ps1=cn.prepareStatement(sql_book);
			ps1.setString(1, sid);
			ps1.setString(2, cid);
			ps1.setString(3, dte);
			ps1.execute();
			
			out.print("Seat booked successfully...");
			RequestDispatcher rd=request.getRequestDispatcher("book.jsp");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
