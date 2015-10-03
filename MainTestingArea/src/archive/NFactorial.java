package archive;
//import java.util.Arrays;

import java.math.BigInteger;
public class NFactorial {

	public static void main(String[] args) {
		// ***************************f6**********************************
		int factorielBoundary = 100;
		BigInteger n= new BigInteger("1");
		for (int i = 1; i <= factorielBoundary; i++) {
			n=n.multiply(new BigInteger(""+i));
			//System.out.print(n.abs()+"");	
		}
		System.out.printf("The factorial of \"%d \" is %s", factorielBoundary, n.toString());
		// ***************************************************************
	}

}
