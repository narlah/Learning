package kosev;

public class findPitoXNumber {
    public static void main(String[] args){

	System.out.println("Pi will be calculated to the number you provide. Insert number : ");
    //    int a = System.in.readInt();
	double pi = 3;

	for(int i=0,j=2;i<=12;i++,j+=2){
	    int coef = j * (j+1) * (j+2);
	    pi += Math.pow(-1, i%2)*4/(coef);

	}
	System.out.println(pi);
    }
}
