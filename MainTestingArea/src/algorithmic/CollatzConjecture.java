package algorithmic;
public class CollatzConjecture {

    public static void main(String[] args) {
        long n = 1231231221;
        int counter =0;
        while(n !=1){
            if (n%2==0) {//odd
                n/=2;
            } else {
                n=n*3+1;
            }
            counter++;
            System.out.println(n);
        }
        System.out.println("steps : "  + counter);
    }

}