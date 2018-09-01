public class f7 {
    // ***************************f6**********************************

    // ***************************f6**********************************
    public static void main(String[] args) throws InterruptedException {
        // ***************************f6**********************************
        System.out.println(a());
        return;
        // ***************************************************************

    }

    private static int a() {
        try {
            System.out.println(1);
            return 5;
        } finally {
            System.out.println(2);
            return 4;
        }

    }
}