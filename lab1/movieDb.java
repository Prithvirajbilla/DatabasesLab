import java.io.*;
import java.util.*;

class movieDb
{
	 static String movieRatings = "movieratings.csv" ;
	 static String movieinfo  = "movieinfo.csv";
	 /*HashMaps are coming */
	 
	 static Map<String,String> directorMovie = new HashMap<String,String>() ;
	 static Map<String,List<String> > actorsMovie = new HashMap<String,List<String> >();
	 static Map<String,List<String> > yearsMovie = new HashMap<String,List<String> >();
	 static Map<String,String[] > movieVars = new HashMap<String,String[] >();
	 static Map<String, Double > ratingMoive = new HashMap<String,Double> ();
	 
	 static void readMovieInfo() throws IOException 
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
		 
		 
	 }
	 static void readMovieRatings() throws IOException 
	 {
		 File f = new File(movieRatings);
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
			 Double Rating =Double.parseDouble( MovieVars[1]);
			 ratingMoive.put(Title,Rating);
			 Line = in.readLine();
		 }
		 
		 
	 }

	 public static void main(String args[]) throws IOException
	 {
		 readMovieRatings();
		 readMovieInfo();
		 System.out.println("Enter the string:");
		 String query = null;
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 query = br.readLine();
		 while(query!= null)
		 {
			 if (query.length() < 2)
			 {
				 System.exit(0);
			 }
			 String[] queryList = query.split(" ",2);
			 String queryType = queryList[0];
			 String queryString = queryList[1];
			 if(queryType.equals("q1"))
			 {
				 String DirectorName = directorMovie.get(queryString);
				 if (DirectorName != null)
				 {
					 System.out.println(DirectorName);
				 }
				 else
				 {
					 System.out.println("We can't find the movie in our database");
				 }
			 }
			 else if(queryType.equals("q2"))
			 {
				 List<String> MoviesList = actorsMovie.get(queryString);
				 if(MoviesList != null)
				 {
					 for (int j = 0; j < MoviesList.size(); j++) 
					 {
						 System.out.println(MoviesList.get(j));
					 }
				}
				 else
				 {
					 System.out.println("We can't find the actor in our database");
				 }
				 
			 }
			 else if(queryType.equals("q3"))
			 {
				 List<String> moviesList = yearsMovie.get(queryString);
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
					 System.out.println(MovieReq);
				 }
				 else
				 {
					 System.out.println("we can't find this in our database");
				 }
			 }
			 else if(queryType.equals("q0"))
			 {
				 System.exit(0);
			 }
			 else
			 {
				 System.out.println("Not found query");
			 }
			 query = br.readLine();
		 }
		 
	 }
	
}
