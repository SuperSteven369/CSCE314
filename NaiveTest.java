// Author Name: Siyuan Yang
// Cited from the link https://www.geeksforgeeks.org/primality-test-set-1-introduction-and-school-method/
import java.math.BigInteger;

public class NaiveTest
{
	public static boolean isPrime(BigInteger n) 
    { 
	    if (n.compareTo(BigInteger.ONE) <= 0) return false;
	    if (n.compareTo(BigInteger.valueOf(3)) <= 0) return true;
	    
	    if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO) || n.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) return false;
	    
	    for (BigInteger i = BigInteger.valueOf(5); i.multiply(i).compareTo(n)<=0; i = i.add(BigInteger.valueOf(6))) {
	        if (n.mod(i).equals(BigInteger.ZERO) || n.mod(i.add(BigInteger.TWO)).equals(BigInteger.ZERO)) return false;
	    }
	    return true;
    } 
}
