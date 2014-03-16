import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 */

/**
 * @author billa
 *
 */
public class program2 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws IOException, SQLException
	{
		//Load the PostgreSQL JDBC driver class
		try
		{
			Class.forName("org.postgresql.Driver");
        } 
		catch (ClassNotFoundException cnfe)
		{
			System.out.println("Could not find the JDBC driver!");
			System.exit(1);
        }
		
		//Enter the connection details
		String hostname = "localhost";	// If PostgreSQL is running on some other machine enter the IP address of the machine here
		String username = "postgres"; // Enter your PostgreSQL username
		String password = "root"; // Enter your PostgreSQL password
		String dbName = "dbms"; // Enter the name of the database that has the university tables.
		String connectionUrl = "jdbc:postgresql://" + hostname +  "/" + dbName;
		Connection conn = null;

		//Connect to the database
		try 
		{
			conn = DriverManager.getConnection(connectionUrl,username, password);
            System.out.println("Connected successfullly");
        }
		catch (SQLException sqle) 
		{
			System.out.println("Connection failed");
			System.out.println(sqle);
		    // Uncomment the below line for a more detailed stack trace
		    sqle.printStackTrace();
            System.exit(1);
                
		}
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a String<MovieName, Year of Release, Producer, Director:");
            String inputQuery = br.readLine();
            String[] varQuery = inputQuery.split(",");
            if (varQuery.length < 4 || varQuery.length >4)
            {
            	System.out.println("not enough or more parameters");
            }
            else
            {
            	String MovieName = varQuery[0];
            	int YOR = Integer.parseInt(varQuery[1].trim());
            	String Producer = varQuery[2];
            	String Director = varQuery[3];
            	
            	String insertQuery = "INSERT INTO Movie VALUES(?,?,?,?)";
            	String updateQuery = "UPDATE Movie SET  YearOfRelease=?, Producer=?,Director=? Where MovieName=?";
            	PreparedStatement stmt = conn.prepareStatement(insertQuery);
            	PreparedStatement stmt1 = conn.prepareStatement(updateQuery);
        		stmt.setString(1, MovieName);
        		stmt.setLong(2,YOR);
        		stmt.setString(3,Producer);
        		stmt.setString(4,Director);
        		stmt1.setString(4,MovieName);
        		stmt1.setLong(1,YOR);
        		stmt1.setString(2, Producer);
        		stmt1.setString(3,Director);

            	try
            	{
            		stmt.executeUpdate();		
            		System.out.println("Inserting done!!");
            	}
            	catch (SQLException e)
            	{
            		
            		stmt1.executeUpdate();
            		System.out.println("Update done!!");
            		
            	}
            	
            }


	}
}

		


