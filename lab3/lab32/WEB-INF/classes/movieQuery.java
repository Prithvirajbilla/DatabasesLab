import java.io.*;
import java.util.*;

class movieQuery
{
	static String movieRatings = "C:/dbms/tomcat/webapps/lab32/WEB-INF/classes/movieratings.csv" ;
	static String movieinfo  = "C:/dbms/tomcat/webapps/lab32/WEB-INF/classes/movieinfo.csv";
	public Map<String,String> directorMovie = new HashMap<String,String>() ;
	public Map<String,List<String> > actorsMovie = new HashMap<String,List<String> >();
	public Map<String,List<String> > yearsMovie = new HashMap<String,List<String> >();
	public Map<String,String[] > movieVars = new HashMap<String,String[] >();
	public Map<String, Double > ratingMoive = new HashMap<String,Double> ();
	void readMovieInfo() throws IOException 
	 {
		 File f = new File(movieinfo);
		 BufferedReader in = null;
		 try {
			 	in = new BufferedReader(new FileReader(f));
		 	 } 
		 catch (FileNotFoundException e)
		 {
			 System.out.println("File is not present in the disk");
			 e.printStackTrace();
		 }
		 
		 String Line = in.readLine();
		 while (Line != null)
		 {
			 String[] MovieVars = Line.split(":");
			 /** Variables
			  * 
			  */
			 String Title = MovieVars[0];
			 String Director = MovieVars[1];
			 String Year = MovieVars[2];
			 //String Genre = MovieVars[3];
			 String[] Actors = MovieVars[4].split(",");
			 directorMovie.put(Title, Director);
			 for(int i = 0;i < Actors.length;i++)
			 {
				 List<String> moviesList = actorsMovie.get(Actors[i].trim());
				 
				 if (moviesList != null)
				 {
					 moviesList.add(Title);
					 actorsMovie.put((Actors[i]).trim(), moviesList);
				 }
				 else
				 {
					 List<String> movie = new ArrayList<String>();
					 movie.add(Title);
					 actorsMovie.put(Actors[i].trim(),movie);
				 }

			 }
			 List<String> moviesYearList = yearsMovie.get(Year);
			 if (moviesYearList != null)
			 {
				 moviesYearList.add(Title);
				 yearsMovie.put(Year, moviesYearList);
			 }
			 else
			 {
				 List<String> movie = new ArrayList<String>();
				 movie.add(Title);
				 yearsMovie.put(Year,movie);
			 }
			 movieVars.put(Title,Line.split(":",2)[1].split(":"));
			 
			 Line = in.readLine();
		 }
		 
		 in.close();
	 }
	void readMovieRatings() throws IOException 
	 {
		 File f = new File(movieRatings);
		 BufferedReader in = null;
		 try {
			 	in = new BufferedReader(new FileReader(f));
		 	 } 
		 catch (FileNotFoundException e)
		 {
			 e.printStackTrace();
		 }
		 
		 String Line = in.readLine();
		 while (Line != null)
		 {
			 String[] MovieVars = Line.split(":");
			 /** Variables
			  * 
			  */
			 String Title = MovieVars[0];
			 Double Rating =Double.parseDouble( MovieVars[1]);
			 ratingMoive.put(Title,Rating);
			 Line = in.readLine();
		 }
		 in.close();
		 
	 }

	public movieQuery() throws IOException
	{
		readMovieInfo();
		readMovieRatings();
	}
	 public String getActors(String Movie) throws IOException
	 {
	 	List<String> MoviesList = actorsMovie.get(Movie);
	 	String ans = "";
		 if(MoviesList != null)
		 {
			 for (int j = 0; j < MoviesList.size(); j++) 
			 {
				 ans= ans + "," + MoviesList.get(j);
			 }
			 return ans;
		}
		 else
		 {
			 return "We can't find the actor in our database";
		 }

	 }
	static void writeContent(String content,String filename) throws IOException
	 {
		 FileWriter fw = new FileWriter(filename,true);
		 BufferedWriter bw = new BufferedWriter(fw);
		 content ="\n" + content ;
		 bw.append(content);
		 bw.close();
	 }
     /**
      * Ability to add a new movie.
      * @param args
      * @throws IOException
      */
	 void addNewMovieInfo(String movie) throws IOException
	 {
		 String[] filmVars = movie.split(":");
		 String Title = filmVars[0];
		 String Director = filmVars[1];
		 String Year = filmVars[2];
		 //String Genre = filmVars[3];
		 String[] Actors = filmVars[4].split(",");
		 String check = directorMovie.get(Title);
		 if(check == null)
		 {
			 directorMovie.put(Title, Director);
			 for(int i = 0;i < Actors.length;i++)
			 {
				 List<String> moviesList = actorsMovie.get(Actors[i].trim());
				 
				 if (moviesList != null)
				 {
					 moviesList.add(Title);
					 actorsMovie.put((Actors[i]).trim(), moviesList);
					 //writing part
				 }
				 else
				 {
					 List<String> mov = new ArrayList<String>();
					 mov.add(Title);
					 actorsMovie.put(Actors[i].trim(),mov);
				 }

			 }
			 writeContent(movie,movieinfo);

			 List<String> moviesYearList = yearsMovie.get(Year);
			 if (moviesYearList != null)
			 {
				 moviesYearList.add(Title);
				 yearsMovie.put(Year, moviesYearList);
			 }
			 else
			 {
				 List<String> mov = new ArrayList<String>();
				 mov.add(Title);
				 yearsMovie.put(Year,mov);
			 }
			 movieVars.put(Title,movie.split(":",2)[1].split(":"));
		 }
		 else
		 {

		 }	 
	 }
	  String addNewMovieRating(String Line) throws IOException
	 {
		 String[] MovieVars = Line.split(":");
		 /** Variables
		  * 
		  */
		 String Title = MovieVars[0];
		 Double Rating =Double.parseDouble( MovieVars[1]);
		 Double checkTitle = ratingMoive.get(Title);
		 if(checkTitle == null)
		 {
			 ratingMoive.put(Title,Rating);
			 writeContent(Line,movieRatings);
			 return "Movie added to database";
			 
		 }
		 else
		 {
			 return "The movie already exist in our database.";
		 }

	 }
	 @SuppressWarnings("unused")
	String removeMovie(String Title,String filename) throws IOException
	 {
		 File f = new File(filename);
		 BufferedReader in = null;
		 try {
			 	in = new BufferedReader(new FileReader(f));
		 	 } 
		 catch (FileNotFoundException e)
		 {
			 return "File is not present in the disk";
		 }
		 
		 String Line = in.readLine();
		 int i =1;
		 while (Line != null)
		 {
			 String[] Vars = Line.split(":",2);
			 if(Vars[0].equals(Title))
			 {
				 in.close();
				 removeLineFromFile(filename,Line);
				 return "movie data removed succesfully";
			 }
			 i++;
			 Line = in.readLine();
			 if(Line == null)
			 {
				 return "Movie doesn't exist in our database";
			 }
		 }
		 in.close();
		 
		 return "Movie not  found";
	 }
	 public String removeLineFromFile(String file, String lineToRemove) {

		 try {

		   File inFile = new File(file);

		   if (!inFile.isFile()) {
		     return "Parameter is not an existing file";
		   }

		   //Construct the new file that will later be renamed to the original filename.
		   File tempFile = new File(inFile.getAbsolutePath() + ".tmp");

		   BufferedReader br = new BufferedReader(new FileReader(file));
		   PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

		   String line = null;

		   //Read from the original file and write to the new
		   //unless content matches data to be removed.
		   while ((line = br.readLine()) != null) {

		     if (!line.trim().equals(lineToRemove)) {

		       pw.println(line);
		       pw.flush();
		     }
		   }
		   pw.close();
		   br.close();
		   
		   tempFile.renameTo(inFile);
		   
		   //Delete the original file
		   if (!inFile.delete()) {
		     return "Could not delete file";
		   }

		   //Rename the new file to the filename the original file had.
		   if (!tempFile.renameTo(inFile))
		    return "Could not rename file";

		 }
		 catch (FileNotFoundException ex) {
		   ex.printStackTrace();
		 }
		 catch (IOException ex) {
		   ex.printStackTrace();
		 }
		 return "file written";
	 }
	  String  removeMovieFromInfo(String Title) throws IOException
	 {
		return removeMovie(Title,movieinfo);
	 }
	  String removeMovieFromRatings(String Title) throws IOException
	 {
		 return removeMovie(Title,movieRatings);
	 }
	 public String getDirector(String Movie) throws IOException
	 {
		 readMovieInfo();
		 String DirectorName = directorMovie.get(Movie);
		 if (DirectorName != null)
		 {
			 return DirectorName;
		 }
		 else
		 {
			 return "We can't find the movie in our database";
		 }

	 }
	 public  String getBestMovie(String Movie) throws IOException
	 {
		 List<String> moviesList = yearsMovie.get(Movie);
		 if(moviesList != null)
		 {
			 Double high_rate = (double) 0 ;
			 String MovieReq = null;
			 for(int i = 0; i < moviesList.size(); i++)
			 {
				 Double rate = ratingMoive.get(moviesList.get(i));
				 if(rate > high_rate)
				 {
					 MovieReq = moviesList.get(i);
					 high_rate = rate;
				 }
				 
			 }
			 return  MovieReq;
		 }
		 else
		 {
			return "not found" ;
		 }
	 }
	 public synchronized String addMovieInfo(String Movie) throws IOException
	 {
	 			 String[] check = Movie.split(":");
				 if(check.length < 4)
				 {
					return "You are supposed to input in the way";
				 }
				 else
				 {
					 addNewMovieInfo(Movie);
					 return "Added movie";
				}

	 }
	 public synchronized String addMovierating(String Movie) throws IOException
	 {
				 String[] check = Movie.split(":");
				 if(check.length < 2)
				 {
					 return "You are supposed to input in the way";
				 }
				 else
				 {
					 addNewMovieRating(Movie);
					 return "ADDEd movie";
				 }
	 }
	 public synchronized String removeMovieInfo(String queryString) throws IOException
	 {
	 			String h = removeMovieFromInfo(queryString);
				 directorMovie.clear();
				 actorsMovie.clear();
				 yearsMovie.clear();
				 movieVars.clear();
				 ratingMoive.clear();
				 
				 readMovieRatings();
				 readMovieInfo();

				 return h;
	 }
	 public synchronized String removeMovieRating(String queryString) throws IOException
	 {
	 			String h = 	removeMovieFromRatings(queryString);
				 directorMovie.clear();
				 actorsMovie.clear();
				 yearsMovie.clear();
				 movieVars.clear();
				 ratingMoive.clear();
				 readMovieRatings();
				 readMovieInfo();
				 return h;
	 }
	 public synchronized String changeRating (String queryString) throws IOException
	 {
	 			 String vars[] = queryString.split(":");
				 if (vars.length < 2)
				 {
					 return "Not an expected format";
				 }
				 else
				 {
					 removeMovieFromRatings(vars[0]);
					 directorMovie.clear();
					 actorsMovie.clear();
					 yearsMovie.clear();
					 movieVars.clear();
					 ratingMoive.clear();
					 readMovieRatings();
					 readMovieInfo();
					 addNewMovieRating(queryString);
					 return "Movie Rating Changed";
				 }
	 }
	 public synchronized String changeInfo(String queryString) throws IOException
	 {

			String vars[] = queryString.split(":");
		 if (vars.length < 4)
		 {
			 return "Not an expected format";
		 }
		 else
		 {
			 removeMovieFromInfo(vars[0]);
			 directorMovie.clear();
			 actorsMovie.clear();
			 yearsMovie.clear();
			 movieVars.clear();
			 ratingMoive.clear();
			 readMovieRatings();
			 readMovieInfo();
			 addNewMovieInfo(queryString);
			 return "Movie Info Changed";
		 }

	 }
	 public void readFile(String filename) throws IOException
	 {
	 	
	 	 File f = new File(filename);
		 BufferedReader in = null;
		 try {
			 	in = new BufferedReader(new FileReader(f));
		 	 } 
		 catch (FileNotFoundException e)
		 {
			 e.printStackTrace();
		 }
		 String line = in.readLine();
		 while(line != null)
		 {
		 	String vars[] = line.split(" ",2);
		 	if(vars[0].equals("addNewMovieInfo"))
		 	{
		 		addMovieInfo(vars[1]);
		 	}
		 	else if(vars[0].equals("addNewMovieRating"))
		 	{
		 		addMovierating(vars[1]);
		 	}
		 	else if(vars[0].equals("changeInfo"))
		 	{
		 		changeInfo(vars[1]);
		 	}
		 	else if(vars[0].equals("changeRating"))
		 	{
		 		changeRating(vars[1]);
		 	}
		 	else if(vars[0].equals("removeMovieInfo"))
		 	{
		 		removeMovieInfo(vars[1]);
		 	}
		 	else if(vars[0].equals("removeMovieRating"))
		 	{
		 		removeMovieRating(vars[1]);
		 	}
		 	line = in.readLine();
		 }
		 in.close();
		 f.delete();
		 File yourFile = new File(filename);
		if(!yourFile.exists()) {
		    yourFile.createNewFile();
		} 


	 }
}