import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Setup extends HttpServlet  
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Connection conn = null;

	public void init(ServletConfig config) throws ServletException
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
		super.init(config);
 	}

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
  	{
       response.setContentType("text/html");
       PrintWriter out = response.getWriter(); 
       Statement ppt = null;
       try
       {
       		 ppt = conn.createStatement();
       }
       catch(SQLException sqle)
	   {
	 		sqle.printStackTrace();
	   }

       String input = "CREATE TABLE IF NOT EXISTS USERS" +
       				  "(username VARCHAR(20) NOT NULL,"+
       				  	"password VARCHAR(20) NOT NULL,"+
       				  	"role VARCHAR(6) NOT NULL,"+
       				  	"PRIMARY KEY (username))";
	 try
	 {
	 	ppt.executeUpdate (input);
	 	out.println("Table Created Succesfully <br/>");
	 }
	 catch(SQLException sqle)
	 {
	 	sqle.printStackTrace();
	 }
	 String user1 = "INSERT INTO USERS(username,password,role) VALUES('user1','pass1','reader')";
	 String user2 = "INSERT INTO USERS(username,password,role) VALUES('user2','pass2','writer')";
	 String user3 = "INSERT INTO USERS(username,password,role) VALUES('user3','pass3','reader')";
	 String user4 = "INSERT INTO USERS(username,password,role) VALUES('user4','pass4','writer')";
	 try
	 {
	 	ppt.executeUpdate(user1);
	 	out.println("Query : " + user1 + "Succesfully Completed!! <br/>");
	 	ppt.executeUpdate(user2);
	 	out.println("Query : " + user2 + "Succesfully Completed!! <br/>");
	 	ppt.executeUpdate(user3);
	 	out.println("Query : " + user3 + "Succesfully Completed!! <br/>");
	 	ppt.executeUpdate(user4);
	 	out.println("Query : " + user4 + "Succesfully Completed!! <br/>");
	 }
	 catch(SQLException sqle)
	 {
	 	sqle.printStackTrace();
	 	out.println("Already Created USERs <br/>");
	 }
	  
	  

 	}



}