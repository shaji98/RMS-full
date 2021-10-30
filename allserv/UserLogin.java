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
import javax.servlet.http.HttpSession;

import calldatabase.GetData;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String cid=request.getParameter("cid");
			String password=request.getParameter("password");
			Connection cn=GetData.getCn();
			PreparedStatement ps=cn.prepareStatement("select cname,cid from customer where cid=? and password=? ");
			ps.setString(1, cid);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				HttpSession ses=request.getSession();
				ses.setAttribute("cname",rs.getString(1));
				HttpSession ses1=request.getSession();
				ses1.setAttribute("cid",rs.getString(2));
				RequestDispatcher rd=request.getRequestDispatcher("userhome.html");
				rd.forward(request, response);
			}else {
				out.print("Wrong User ID or Password!!!");
				RequestDispatcher rd=request.getRequestDispatcher("userlogin.html");
				rd.include(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
