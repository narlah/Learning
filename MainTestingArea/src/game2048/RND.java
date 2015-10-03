package game2048;

import java.util.Random;

public class RND {

    private static Random generator = new Random();

    public static double generate() {
        return generator.nextDouble();
    }
}
