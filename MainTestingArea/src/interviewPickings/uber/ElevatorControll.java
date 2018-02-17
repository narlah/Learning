package interviewPickings.uber;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class ElevatorControll {
    private volatile int upwardCounter = 0;
    private volatile int downwardCounter = 0;
    private static final int FLOORS = 10;
    private Vector<Boolean> floors = new Vector<>(FLOORS); // skyscraper eh :P
    private volatile boolean goingUp = true;
    private volatile int elevatorPointer = 0;
    private Random r = new Random();

    //time to move from floor to floor - 1 second
    public static void main(String[] args) throws InterruptedException {
        ElevatorControll elohim = new ElevatorControll();
        elohim.elevatorFlightControlStart();
    }

    private void elevatorFlightControlStart() throws InterruptedException {
        for (int i = 0; i < FLOORS; i++) floors.add(false); //why fill failed ?
        Thread thread = new Thread(new AcceptRequestLoop());
        thread.start();


        for (int i = 0; i < 1000; i++) {
            Thread.sleep(200);
            System.out.println(Arrays.toString(floors.toArray()));

            if (upwardCounter == 0 && downwardCounter == 0) continue;
            if ((upwardCounter == 0 && goingUp) || (downwardCounter == 0 && !goingUp)) {
                goingUp = !goingUp;
            }
            boolean thisFloorIsRequested = floors.get(elevatorPointer);
            int smallDotYouArehere = elevatorPointer;
            if (goingUp) {
                System.out.println("blq " + thisFloorIsRequested + " " + upwardCounter + " " + elevatorPointer);
                if (thisFloorIsRequested) {
                    upwardCounter = upwardCounter - 1;
                    if (upwardCounter == 0 && downwardCounter == 0) continue;
                }
                elevatorPointer++;
            } else {
                if (thisFloorIsRequested) {
                    downwardCounter = downwardCounter - 1;
                    if (upwardCounter == 0 && downwardCounter == 0) continue;
                }
                elevatorPointer--;
            }
            System.out.println("going " + (goingUp ? "up " : "down ") + "->" + elevatorPointer + "  was  at " + thisFloorIsRequested + " up : " + upwardCounter + " | down : " + downwardCounter);
            if (elevatorPointer >= 0 && elevatorPointer < FLOORS) floors.set(smallDotYouArehere, false);

        }
    }

    //Thread to accept a floor request every 1-5 seconds
    class AcceptRequestLoop implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep((r.nextInt(5) + 1) * 1000);
                    int triggerFloor = r.nextInt(FLOORS - 1);
                    if (!floors.get(triggerFloor) && elevatorPointer != triggerFloor) { //lets go on adventure , btw == means elevator reopens doors and accepts people - not affecting our algorithm
                        if (triggerFloor > elevatorPointer)
                            upwardCounter = upwardCounter + 1;
                        else
                            downwardCounter = downwardCounter + 1;
                        floors.set(triggerFloor, true);
                        System.out.println(triggerFloor + " was requested / elevator is at " + elevatorPointer + " " + upwardCounter + " " + downwardCounter);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
