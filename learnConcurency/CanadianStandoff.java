package learnConcurency;

public class CanadianStandoff {
    //or how to create deadlock
    class Canadian {
        public String getName() {
            return name;
        }

        private final String name;

        public Canadian(String name) {
            this.name = name;
        }

        synchronized void passYourself(Canadian c) {
            System.out.format("%s should pass , but there is %s at the door too \n", name, c.getName());
            c.letTheOtherPass(this);
        }

        synchronized void letTheOtherPass(Canadian c) {
            System.out.format("%s is letting me pass, let him (%s) pass first!  \n", this.getName(), c.getName());

        }

    }

    public static void main(String[] args) {
        CanadianStandoff canadianStandoff = new CanadianStandoff();
        canadianStandoff.startStandoff();
    }

    private void startStandoff() {
        final Canadian canadian1 = new Canadian("Smith");
        final Canadian canadian2 = new Canadian("Wesson");
        new Thread(() -> canadian1.passYourself(canadian2)).start();
        new Thread(() -> canadian2.passYourself(canadian1)).start();
    }
}
/*
    private synchronized void canada1() {
        Thread canadian1 = new Thread(() -> {
            if (letOthersPass) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        canadian1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        letOthersPass = false;
        notify();
        System.out.println("Canadian1 passed");
    }

    private synchronized void canada2() {
        Thread canadian2 = new Thread(() -> {
            if (letOthersPass) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        canadian2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        letOthersPass = false;
        notify();
        System.out.println("Canadian2 passed");

    }
    public static void Main(String[] args) {
        CanadianStandoff canadianStandoff = new CanadianStandoff();
        canadianStandoff.canada1();
        canadianStandoff.canada2();
    }

 */