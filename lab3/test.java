import java.io.*;
public class test
{
	public static void main(String[] args) throws IOException {
		Testing n = new Testing("http://localhost:9999/lab32/First","http://localhost:9999/lab31/First");
		n.postAddInfo("lol:lol:dhj:kl:kl,lk","anmi");
		n.postAddInfo("lol","dnmi");
		n.postAddInfo("lol:9.0","anmr");
		n.postAddInfo("lol","dnmr");
		n.postAddInfo("lol:lol:dhj:kl:kl,lk","cnmi");
		n.postAddInfo("lol:9.1","cnmr");
	}


}