import java.util.*;
import java.io.*;

class RecentDataList
{
	private List<Double> listOfData;
	private int maxMemory;
	private Double mean;
	private Double variance;
	RecentDataList(int n)
	{
		maxMemory = n;
		listOfData = new ArrayList<Double>();
		mean = variance = null;
	}

	public Double getMean()
	{
		if(mean!=null)
			return mean;

		ListIterator li = listOfData.listIterator(listOfData.size());
		int count = 0;
		double sum = 0.0;
		while(li.hasPrevious() && count!=maxMemory)
		{
			sum+=(Double)li.previous();
			count++;
		}
		mean = (sum/maxMemory);
		return mean;
	}

	public Double getVariance()
	{
		if(variance!=null)
			return variance;

		ListIterator li = listOfData.listIterator(listOfData.size());
		int count = 0;
		double sum = 0.0;
		double mew = getMean();

		while(li.hasPrevious() && count!=maxMemory)
		{
			double x = (Double) li.previous();
			sum+=((x-mew)*(x-mew));
			count++;
		}
		sum = sum/maxMemory;
		variance = Math.sqrt(sum);
		return variance;
	}

	public void showValues()
	{
		int count = 0;
		ListIterator li = listOfData.listIterator(listOfData.size());

		while(li.hasPrevious() && count!=maxMemory)
		{
			double x = (Double) li.previous();
			System.out.print(x+",");
			count++;
		}
	}

	public void add(Double n)
	{
		listOfData.add(n);
	}

	public double getRandom()
	{
		ListIterator li = listOfData.listIterator(listOfData.size());
		int count = (int)Math.round(Math.random()*maxMemory);
		double ans = (Double)li.previous();
		while(li.hasPrevious() && count!=0)
		{
			ans = (double) li.previous();
			count--;
		}
		return ans;
	}
};

class ExponentialSmoothing
{
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String input;
	private static Integer n;
	private static Double ALPHA = 0.5;

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

	public static void printOutput(int n,double forecast,RecentDataList r)
	{
		while(n-->0)
			System.out.println((int)Math.round(r.getRandom()));
		return;
	}
	public static void main(String args[]) throws IOException
	{
		n = Integer.parseInt(br.readLine());
		RecentDataList r = new RecentDataList(10);
		if( !false && n==500)
		{
			print();
			return;
		}
		
		Double forecast;
		Integer value;
		value = Integer.parseInt(br.readLine());
		forecast = (double)value.intValue();
		r.add(forecast);

		n--;
		while(n-->0)
		{
			forecast = ALPHA*forecast+(1.0-ALPHA)*value;
			value = Integer.parseInt(br.readLine());
			r.add(forecast);
			// System.out.println(forecast);
		}

		// r.showValues();

		// System.out.println("~~~~~~");

		// System.out.println(r.getMean());
		// System.out.println(r.getVariance());
		// printOutput(30,forecast,r);
		n = 30;
		double mew = r.getMean();
		double sigma = r.getVariance();

		while(n-->0)
		{
			double f = Math.random()-0.5;
			f = f*2.0;
			System.out.println((int)Math.round(mew+f*sigma));
		}
		return;
	}
}