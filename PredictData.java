import java.util.*;
import java.io.*;
class PredictData
{
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String input;
	private static Map<Date,Integer> knownSessions;
	private static PrintWriter year1;
	private static PrintWriter year2;
	private static PrintWriter year3;

	public static void main(String args[]) throws IOException
	{
		knownSessions = new HashMap<Date,Integer>();
		Calendar c = Calendar.getInstance();
		Date d = new Date("10/01/2012");
		// year1 = new PrintWriter(new BufferedWriter(new FileWriter("2012.txt")));
		// year2 = new PrintWriter(new BufferedWriter(new FileWriter("2013.txt")));
		// year3 = new PrintWriter(new BufferedWriter(new FileWriter("2014.txt")));

		c.setTime(d);

		// System.out.println(c.getTime());


		while((input = br.readLine())!=null)
		{
			Date currDate = c.getTime();
			knownSessions.put(c.getTime(),Integer.parseInt(input));
			// if(currDate.getYear()==2012)
			// 	;
			// System.out.println(c.getTime()+"\t"+knownSessions.get(c.getTime()));
			if(c.get(Calendar.YEAR)==2014)
				System.out.println(c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1)+"/"+c.get(Calendar.YEAR)+"\t"+input);
			c.add(Calendar.DATE,1);
		}


	}
}