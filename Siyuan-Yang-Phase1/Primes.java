import java.math.BigInteger;
import java.util.ArrayList; 

/*
 *  Desc: This class generates primes, twin primes, and hexagon crosses using BigInteger data types.
 */
public class Primes {
	
	// Pair class implementation.
    private class Pair<T> 
	{
        private T first;
		private T second;
		Pair(T first, T second)
		{
			this.first = first;
			this.second = second;
		}
		public T getFirst() {return first;}
		public T getSecond() {return second;}
		@Override
		public String toString()
		{
			return (first + ", " + second);
		}
	}
	
	// Member variables for containing out lists of integers, twin primes, hexagon crosses, and the pairs of twin primes that make up the hex crosses.
	ArrayList<BigInteger> primeList = new ArrayList<BigInteger>();
	ArrayList<Pair<BigInteger>> twinList = new ArrayList<Pair<BigInteger>>();
	ArrayList<Pair<BigInteger>> hexesList = new ArrayList<Pair<BigInteger>>();
	int counter = 0;
	int counter2 = 0;
	int counter3 = 0;
	
	// Add a prime to the prime list if and only iff it is not already in the list. (ignore duplicates)
	public void addPrime(BigInteger x)
	{
		if (!primeList.contains(x))
		{
			primeList.add(x);
		}
	}
	
	// Output the prime list. Each prime should be on a separate line and the total number of primes should be on the following line.
	public void printPrimes()
	{
		for (int i = 0; i < primeList.size(); i++)
		{
			System.out.println(primeList.get(i));
		}
		System.out.println("Total Primes: " + counter);
	}
		
	// Output the twin prime list. Each twin prime should be on a separate line with a comma separating them, and the total number of twin primes should be on the following line.
	public void printTwins()
	{
		for (int i = 0; i < twinList.size(); i++)
		{
			System.out.println(twinList.get(i));
		}
		System.out.println("Total Twins: " + counter2);
	}
		
	// Output the hexagon cross list. Each should be on a separate line listing the two twin primes and the corresponding hexagon cross, with the total number on the following line.
	public void printHexes()
	{
		for (int i = 0; i < hexesList.size(); i++)
		{
			BigInteger a = hexesList.get(i).getFirst().subtract(BigInteger.ONE);
			BigInteger b = hexesList.get(i).getFirst().add(BigInteger.ONE);
			BigInteger c = hexesList.get(i).getSecond().subtract(BigInteger.ONE);
			BigInteger d = hexesList.get(i).getSecond().add(BigInteger.ONE);
			BigInteger first = hexesList.get(i).getFirst();
			BigInteger second = hexesList.get(i).getSecond();
			System.out.println("Prime Pairs: " + a + ", " + b + " and " + c + ", " + d + " separated by " + first + ", " + second);
		}
		System.out.println("Total Hexes: " + counter3);
	}
	
    static boolean isPrime(BigInteger n) 
    { 
        if (n.compareTo(BigInteger.ONE) <= 0) 
            return false; 
        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) < 0; i.add(BigInteger.ONE))
            if (n.mod(i).equals(BigInteger.ZERO)) 
                return false;       
        return true; 
    } 
    
	// Generate and store a list of primes.
	public void generatePrimes(int count)
	{
		BigInteger m = BigInteger.ONE;
		while (counter < count)
		{
			if (m.isProbablePrime(10))
			{
				addPrime(m);
				counter++;
			}
			m = m.add(BigInteger.ONE);
		}
	}
	
	// Generate and store a list of twin primes.
	public void generateTwinPrimes()
	{
		for (int i = 0; i < primeList.size() - 1; i++)
		{
			BigInteger first = primeList.get(i);
			BigInteger second = primeList.get(i+1);
			if (second.equals(first.add(BigInteger.valueOf(2))))
			{
				Pair<BigInteger> temp = new Pair(first, second);
				twinList.add(temp);
				counter2++;
			}
		}
	}
	
	// Generate and store the hexagon crosses, along with the two twin primes that generate the hexagon cross.
	public void generateHexPrimes()
	{
		ArrayList<BigInteger> avgList = new ArrayList<BigInteger>();
		for (int i = 0; i < twinList.size(); i++)
		{
			BigInteger first = twinList.get(i).getFirst();
			BigInteger second = twinList.get(i).getSecond();
			BigInteger avg = first.add(second).divide(BigInteger.valueOf(2));
			avgList.add(avg);
		}
		for (int i = 0; i < avgList.size(); i++)
		{
			BigInteger e = avgList.get(i);
			BigInteger doublee = e.multiply(BigInteger.valueOf(2));
			if (avgList.contains(doublee))
			{
				Pair<BigInteger> temp = new Pair(e, doublee);
				hexesList.add(temp);
				counter3++;
			}
		}
	}
}
