import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class program1 {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws IOException, SQLException {
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

		//Execute the query and print the results
		
		//creating a Statement
		Statement stmt = conn.createStatement();
		
		String dropMovie = "DROP  TABLE IF EXISTS Movie";
		String dropMoviePerson = "DROP  TABLE IF EXISTS MoviePerson";
		String dropAwards = "DROP  TABLE IF EXISTS MovieAwards";
		String dropCastings = "DROP  TABLE IF EXISTS Castings";
	
		stmt.executeUpdate(dropAwards);
		stmt.executeUpdate(dropCastings);
		stmt.executeUpdate(dropMovie);
		stmt.executeUpdate(dropMoviePerson);


		//First i have to create tables in the database;
		
		String createMovieSql = "CREATE TABLE IF NOT EXISTS Movie" + 
								"(MovieName VARCHAR(255) not NULL, " +
								" YearofRelease INTEGER, " + 
								" Producer VARCHAR(255), " + 
								" Director VARCHAR(255), " + 
								" PRIMARY KEY ( MovieName )," +
								"UNIQUE  (MovieName))";
		
		
		stmt.executeUpdate(createMovieSql);
		//created movie table
		
		String createMoviePersonSql = "CREATE TABLE IF NOT EXISTS MoviePerson" +
									  "(Name VARCHAR(255) not NULL, " +
									  "Address VARCHAR(255), "+
									  "PhoneNumber VARCHAR(255), " +
									  "emailid	VARCHAR(255), " +
									  "PRIMARY KEY( Name )," +
									  "UNIQUE  (Name))";
		stmt.executeUpdate(createMoviePersonSql);
		
		//creating the MovieAwards Table
		
		String createMovieAwardsTable = "CREATE TABLE IF NOT EXISTS MovieAwards"+
										"(MovieName VARCHAR(255) not NULL, " +
										"YearofAward INTEGER, " +
										 "AwardName VARCHAR(255)," +
										 " FOREIGN KEY (MovieName)"+
										 "REFERENCES Movie(MovieName))";
		stmt.executeUpdate(createMovieAwardsTable);
		
		String createCastingTable = "CREATE TABLE IF NOT EXISTS Castings " +
									"(MovieName VARCHAR(255), Actor VARCHAR(255)," +
									" FOREIGN KEY (MovieName) REFERENCES Movie(MovieName),"+
									"FOREIGN KEY (Actor) REFERENCES Movieperson(Name))";
		
		stmt.executeUpdate(createCastingTable);
		//checking the time
		
		long startTime = System.currentTimeMillis();
		//importing the csv file
		String moviep = "MoviePersons.csv";
		File fMovieP = new File (moviep);
		BufferedReader in = null;
		 try {
			 	in = new BufferedReader(new FileReader(fMovieP));
		 	 } 
		 catch (FileNotFoundException e)
		 {
			 System.out.println("File is not present in the disk");
			 e.printStackTrace();
		 }
		 String Line1 = in.readLine();
		 String insertMoviePerson = "INSERT  INTO  MoviePerson(Name, Address, PhoneNumber, emailid)"+
				 					" VALUES (?,?,?,?)";
		 
		 PreparedStatement moviePersonStmt = conn.prepareStatement(insertMoviePerson);
		 while(Line1 != null)
		 {
			 String[] MovieVars = Line1.split(",");
			 moviePersonStmt.setString(1, MovieVars[0].trim());
			 moviePersonStmt.setString(2,MovieVars[1].trim());
			 moviePersonStmt.setString(3,MovieVars[2].trim());
			 moviePersonStmt.setString(4,MovieVars[3]);
			 try
			 {
				 moviePersonStmt.executeUpdate();
			 }
			 catch(SQLException e)
			 {
				 
			 }
			 Line1 = in.readLine();
			 
		 }
		 in.close();
		 
		 
		String movie = "Movies.csv";
		File f = new File(movie);
		in = null;
		 try {
			 	in = new BufferedReader(new FileReader(f));
		 	 } 
		 catch (FileNotFoundException e)
		 {
			 System.out.println("File is not present in the disk");
			 e.printStackTrace();
		 }
		 
		 String Line = in.readLine();
		 String insertMovie = "INSERT  INTO  Movie(MovieName,YearOfRelease,Producer,Director) " +
				 				"VALUES (?,?,?,?) ";
		 String insertCasting ="INSERT  INTO Castings(MovieName,Actor)"+
				 				"VALUES (?,?) ";
		 PreparedStatement movieStmt = conn.prepareStatement(insertMovie);
		 PreparedStatement castingStmt = conn.prepareStatement(insertCasting);
		 while (Line != null)
		 {
			 String[] MovieVars = Line.split(",");
			 String Title = MovieVars[0].trim();
			 String Year = MovieVars[1].trim();
			 String Producer = MovieVars[2].trim();
			 String Director = MovieVars[3].trim();
			 
			 if (Year.equals(""))
			 {
				 Year = "0";
			 }
			 movieStmt.setString(1,Title);
			 movieStmt.setLong(2,Integer.parseInt(Year));
			 movieStmt.setString(3,Producer);
			 movieStmt.setString(4,Director);
			 try
			 {
				 movieStmt.executeUpdate();
			 }
			 catch(SQLException e)
			 {
				 
			 }
			 
			 String[] Actors = MovieVars[4].split(":");
			 for(int i = 0; i < Actors.length ; i++)
			 {
				 castingStmt.setString(1, Title);
				 castingStmt.setString(2,Actors[i].trim());
				 
				 try
				 {
					 castingStmt.executeUpdate();
				 }
				 catch (SQLException E)
				 {

				 }
			 }
			 
			 Line = in.readLine(); 
		 }
		 in.close();
		 
		 in = null;
		 String movieAF = "MovieAwards.csv";
		 File fmovieAF = new File(movieAF);
		 try {
			 	in = new BufferedReader(new FileReader(fmovieAF));
		 	 } 
		 catch (FileNotFoundException e)
		 {
			 System.out.println("File is not present in the disk");
			 e.printStackTrace();
		 }
		 String Line2 = in.readLine();
		 String insertMovieAward = "INSERT  INTO  MovieAwards(MovieName, YearofAward, AwardName)"+
				 					" VALUES (?,?,?)";
		 PreparedStatement movieAwardStmt = conn.prepareStatement(insertMovieAward);
		// Now reading the csv file and inserting in to database;
		 while(Line2 != in.readLine())
		 {
			 String[] MovieVars = Line2.split(",");
			 movieAwardStmt.setString(1, MovieVars[0].trim());
			 movieAwardStmt.setLong(2,Integer.parseInt(MovieVars[1].trim()));
			 movieAwardStmt.setString(3,MovieVars[2].trim());
			 try
			 {
				 movieAwardStmt.executeUpdate();
			 }
			 catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
			 Line2= in.readLine();

		 }
		 in.close();
	      long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      System.out.println("[insertion completed]");
	      System.out.println("[Process completed with using prepared Statement]");
	      System.out.println("Time taken in milliseconds " + elapsedTime);
	}

	}


