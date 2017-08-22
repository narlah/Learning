package kosev;

import java.text.*;

public class findPitoXNumber {
    public static void main(String[] args){

	System.out.println("Pi will be calculated to the number you provide. Insert number : ");
    //    int a = System.in.readInt();
	double pi = 3;
	DecimalFormat df = new DecimalFormat();
	df.setMinimumFractionDigits(25);
	for(int i=0,j=2;i<=10;i++,j+=2){
	    int coef = j * (j+1) * (j+2);
	    double fullConf = Math.pow(-1, i%2)*4d/((double)coef);
	    pi +=fullConf;
	    
	    System.out.println(pi + " " + fullConf);
	}
	System.out.println(df.format(pi));
    }
}
