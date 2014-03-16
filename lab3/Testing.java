import java.net.*;
import java.util.*;
import java.io.*;

public class Testing
{
	public String link1; // link1
	public String   link2;
	public String filename = "log.txt";
	public Testing(String ps,String ps2)
	{
		link1 = ps;
		link2 = ps2;
	}
	public void postAddInfo(String ans,String what) throws IOException
	{

		String urlParameters ="";
		if(what.equals("anmi"))
		{
			urlParameters = "anmi="+ans+"&SUBMIT=anmi";
		}
		else if(what.equals("anmr"))
		{
			urlParameters = "anmr="+ans+"&SUBMIT=anmr";
		}
		else if(what.equals("cnmi"))
		{
			urlParameters= "cnmi="+ans+"&SUBMIT=cnmi";
		}
		else if(what.equals("cnmr"))
		{
			urlParameters= "cnmr="+ans+"&SUBMIT=cnmr";
		}
		else if(what.equals("dnmi"))
		{
			urlParameters= "dnmi="+ans+"&SUBMIT=dnmi";
		}
		else if(what.equals("dnmr"))
		{
			urlParameters= "dnmr="+ans+"&SUBMIT=dnmr";
		}
		// for link1

		String request = link1;


		long startTime = System.currentTimeMillis();

		URL url = new URL(request); 
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();   
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setInstanceFollowRedirects(false); 
		connection.setRequestMethod("POST"); 
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		connection.setRequestProperty("Content-Language", "en-US");
		connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
		connection.setUseCaches (false);
		FileWriter fw = new FileWriter(filename,true);
		BufferedWriter bw = new BufferedWriter(fw);
		DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
		wr.writeBytes(urlParameters);
		wr.close();
		long timeTaken = System.currentTimeMillis() - startTime;
		int statusCode = connection.getResponseCode();
		String content = "link1 "+ what + " " + Long.toString(timeTaken)+ " statuscode: " +statusCode +"\n" ;
		bw.append(content);
		bw.close();
        System.out.println(connection.getResponseMessage());
		connection.disconnect();
		


		// for link2
		String request1 = link2;


		long startTime1 = System.currentTimeMillis();

		URL url1 = new URL(request1); 
		HttpURLConnection connection1 = (HttpURLConnection) url.openConnection();   
		connection1.setDoOutput(true);
		connection1.setDoInput(true);
		connection1.setInstanceFollowRedirects(false); 
		connection1.setRequestMethod("POST"); 
		connection1.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
		connection1.setRequestProperty("Content-Language", "en-US");
		connection1.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
		connection1.setUseCaches (false);
		FileWriter fw1 = new FileWriter(filename,true);
		BufferedWriter bw1 = new BufferedWriter(fw1);
		DataOutputStream wr1 = new DataOutputStream(connection1.getOutputStream ());
		wr1.writeBytes(urlParameters);
		wr1.close();
		long timeTaken1 = System.currentTimeMillis() - startTime;
		int statusCode1 = connection.getResponseCode();
		String content1 ="link2 " +what + " " + Long.toString(timeTaken1) + " statuscode: " +statusCode1 +"\n" ;
		bw1.append(content1);
		bw1.close();
        System.out.println(connection1.getResponseMessage());
		connection1.disconnect();
	}
}