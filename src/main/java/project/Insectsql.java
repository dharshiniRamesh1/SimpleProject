package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insectsql
 */
@WebServlet("/Insectsql")
public class Insectsql extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
			String sname=req.getParameter("sname");
			int m1=Integer.parseInt(req.getParameter("m1"));
			int m2=Integer.parseInt(req.getParameter("m2"));
			String str="insert into studentmarks value(?,?,?);";
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			PreparedStatement   ps=con.prepareStatement(str);
			ps.setString(1, sname);
			ps.setInt(2, m1);
			ps.setInt(3, m2);
			ps.execute();
			String str1="select*from studentmarks";
			PreparedStatement ps1=con.prepareStatement(str1);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
				String sname1=rs.getString("sname");
				int m11=rs.getInt("m1");
				int m21=rs.getInt("m2");
				try {
					PrintWriter pw=res.getWriter();
					pw.println("name :"+sname1+"mark1:"+m11+"mark2:" +m21);
					
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}
		System.out.println("created");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
