package package1;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;

public class getMovie extends HttpServlet  
{
	private static final long serialVersionUID = 1L;
	public Connection conn = null;
	public int rowcount = 0;


	public getMovie()
	{
		//Enter the connection details
		String hostname = "10.105.1.51";	// If PostgreSQL is running on some other machine enter the IP address of the machine here
		String username = "cs110050065"; // Enter your PostgreSQL username
		String password = "560050011"; // Enter your PostgreSQL password
		String dbName = "cs110050065"; // Enter the name of the database that has the university tables.
		String connectionUrl = "jdbc:postgresql://" + hostname +  "/" + dbName;
		try
		{
			conn = DriverManager.getConnection(connectionUrl,username, password);
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}

	}

	public String getHtmlView()
	{
		String res = "";

		String q = "SELECT * FROM movie";
		Statement ppt = null;
		ResultSet rs  = null;
		rowcount = 0;
		try
		{

			ppt= conn.createStatement();
			rs = ppt.executeQuery(q);
			while(rs.next())
			{

				rowcount = rowcount + 1;
				res=res +"<tr><td>"+Integer.toString(rowcount)+"</td>"+
                  "<td><a href=\"#\" id=\"moviename"+Integer.toString(rowcount)+"\" data-type=\"text\" data-pk=\""+rs.getString(1)+
                  "\" data-url=\"/lab7/Write\" data-title=\"Enter movie name\">"+rs.getString(1) +"</a></td>"+
                  "<td><a href=\"#\" id=\"yor"+Integer.toString(rowcount)+"\" data-type=\"number\" data-pk=\""+rs.getString(1)+"\" data-url=\"/lab7/Write\" data-title=\"Enter Year\">"+rs.getString(2)
                  +"</a></td> <td><a href=\"#\" id=\"Producer"+Integer.toString(rowcount)+"\" data-type=\"text\" data-pk=\""+rs.getString(1)+"\" data-url=\"/lab7/Write\" data-title=\"Enter Producer\">"+
                  rs.getString(3)+"</a></td> <td><a href=\"#\" id=\"Director"+Integer.toString(rowcount)+"\" data-type=\"text\" data-pk=\""+
                  rs.getString(1)+"\" data-url=\"/lab7/Write\" data-title=\"Enter Producer\">"+rs.getString(4)+"</a></td>"+
                  "<td><form method=\"post\" action=\"/lab7/Write\"><button type=\"submit\" value=\""+
                  rs.getString(1)+"\"name=\"button\" class=\"btn btn-primary\">Delete</button></form></td></tr>";
			}


		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		return res;
	}
	public String getJsView()
	{
		String res = "";
		for(int i = 1; i <= rowcount; i++)
		{
			res = res + "$('#moviename"+Integer.toString(i)+"').editable();";
   	 		res = res +  "$('#yor"+Integer.toString(i)+"').editable();";
   			res = res + "$('#Producer"+Integer.toString(i)+"').editable();";
    		res = res + "$('#Director"+Integer.toString(i)+"').editable();";
		}
		return res;
	}




}
