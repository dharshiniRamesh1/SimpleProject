package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.Statement;



public class Sqlconnectin extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		try {
			
			String str="create table studentmarks(sname varchar(30),m1 int,m2 int)";
		     
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		    Statement st = cn.createStatement();
			st.execute(str);
			System.out.print("Created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	



}
}
