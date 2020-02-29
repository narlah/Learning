package learnStreams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SumPrimesToK {
    public static void main(String[] args) {
      int[] list = {6,100,1000,10000};
        for (int limit : list) {
            double sum = sumPrimesToK(limit);
            System.out.println(sum);
        }
    }

  private static double sumPrimesToK(int limit) {
    return Stream.iterate(0, e -> e+1).
        filter(SumPrimesToK::isPrime).
        mapToDouble(Math::sqrt).
        limit(limit).sum();
  }

  public static boolean isPrime(long n) {
    return IntStream.rangeClosed(2, (int)Math.sqrt(n))
        .allMatch(i -> n % i != 0);
  }
}
