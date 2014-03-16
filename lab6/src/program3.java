import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class program3 {

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
        System.out.println("Enter a parametrised string");
        String input = br.readLine();
        
        PreparedStatement ppt = conn.prepareStatement(input);
        int count = input.replaceAll("[^?]", "").length();
       
        for(int i= 1; i <= count; i++)
        {
        	String inp = br.readLine();
        	
        	ppt.setString(i,inp);
        }
        ppt= conn.prepareStatement(ppt.toString());
        try
        {
        	ResultSet rs = ppt.executeQuery();
        	if(rs == null)
        	{
        		System.out.println("No results found in the db");
        	}
        	else
        	{
        		ResultSetMetaData rsmd = rs.getMetaData();

        		int col = rsmd.getColumnCount();
    			for(int i = 1;i <= col;i++)
    			{
    				System.out.print(rsmd.getColumnName(i)+"\t |  ");
    			}
    			System.out.print("\n");

        		while(rs.next())
        		{
        			for(int i = 1;i <= col;i++)
        			{
        				System.out.print(rs.getString(i)+"\t |  ");
        			}
        			System.out.print("\n");
        		}
        	}
        	
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
	}

}
