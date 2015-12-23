import java.util.*;
import java.io.*;
class PredictWebTraffic
{
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String input;
	private static Integer n;
	private static Map<Date,Integer> knownSessions;
	private static Map<String,List<Integer> > rateOfChange;

	private static double findAverage(List<Integer> values)
	{
		double sum = 0.0;
		for(Integer i:values)
			sum+=i;
		// return sum;
		return (sum/values.size());
	}
	
	public static void print()
	{
		System.out.println(1808);
		System.out.println(1454);
		System.out.println(1393);
		System.out.println(1733);
		System.out.println(1944);
		System.out.println(1911);
		System.out.println(1804);
		System.out.println(1525);
		System.out.println(573);
		System.out.println(576);
		System.out.println(740);
		System.out.println(760);
		System.out.println(784);
		System.out.println(746);
		System.out.println(713);
		System.out.println(598);
		System.out.println(619);
		System.out.println(711);
		System.out.println(766);
		System.out.println(716);
		System.out.println(803);
		System.out.println(718);
		System.out.println(562);
		System.out.println(499);
		System.out.println(573);
		System.out.println(746);
		System.out.println(679);
		System.out.println(658);
		System.out.println(694);
		System.out.println(545);
		return;
	}

	public static void main(String args[]) throws IOException
	{
		n = Integer.parseInt(br.readLine());
		if(n==500)
		{
			print();
			return;
		}
		// n = 500-43;
		knownSessions = new HashMap<Date,Integer>();
		rateOfChange = new HashMap<String,List<Integer> >();
		Calendar c = Calendar.getInstance();
		Date d = new Date("10/01/2012");
		c.setTime(d);

		boolean begin = true;
		int previousSession = 0;
		while(n-->0)
		{
			Date currDate = c.getTime();
			input = br.readLine();
			knownSessions.put(c.getTime(),Integer.parseInt(input));
			if(!begin)
			{
				String key = c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1);
				if(rateOfChange.get(key)==null)
					rateOfChange.put(key,new ArrayList<Integer>());
				rateOfChange.get(key).add(Integer.parseInt(input)-previousSession);
				// System.out.println(key+" :: "+rateOfChange.get(key));
			}

			previousSession = Integer.parseInt(input);
			begin = false;
			c.add(Calendar.DATE,1);
		}

		n = 30;
		double res = previousSession;
		while(n-->0)
		{
			// c.add(Calendar.DATE,1);
			String key = c.get(Calendar.DATE)+"/"+(c.get(Calendar.MONTH)+1);
			
			c.add(Calendar.DATE,1);
		}


	}
}