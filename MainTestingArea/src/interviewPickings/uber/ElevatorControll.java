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
            Thread.sleep(600);

            //nothing to do
            if (upwardCounter == 0 && downwardCounter == 0) continue;

            //moving
            boolean thisFloorIsRequested = floors.get(elevatorPointer);
            int smallDotYouAreHere = elevatorPointer;
            if (thisFloorIsRequested) floors.set(smallDotYouAreHere, false);
            if (goingUp) {
                //System.out.println("TFR \'" + thisFloorIsRequested + "\' upwardC " + upwardCounter + " | downwardC " + elevatorPointer);
                if (thisFloorIsRequested) {
                    upwardCounter = upwardCounter - 1;
                }
                smallDotYouAreHere++;
            } else {
                if (thisFloorIsRequested) {
                    downwardCounter = downwardCounter - 1;
                }
                smallDotYouAreHere--;
            }
            //if after moving we have nothing to do we do not move again
            if (upwardCounter == 0 && downwardCounter == 0) continue;
            //change direction if needed
            if ((upwardCounter == 0 && goingUp) || (downwardCounter == 0 && !goingUp)) {
                goingUp = !goingUp;
            } else if (smallDotYouAreHere >= 0 && smallDotYouAreHere < FLOORS) elevatorPointer = smallDotYouAreHere;
            System.out.println("going " + (goingUp ? "up -> " + elevatorPointer : elevatorPointer + " <-down ") + "  was  at " + thisFloorIsRequested + " up : " + upwardCounter + " | down : " + downwardCounter);

        }
    }

    //Thread to accept a floor request every 1-5 seconds
    class AcceptRequestLoop implements Runnable {
        @Override
        public void run() {
            Random r = new Random();
            for (int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep((r.nextInt(3) + 1) * 1000);
                    int triggerFloor = r.nextInt(FLOORS - 1);
                    if (!floors.get(triggerFloor) && elevatorPointer != triggerFloor) { //lets go on adventure , btw == means elevator reopens doors and accepts people - not affecting our algorithm
                        floors.set(triggerFloor, true);
                        if (triggerFloor > elevatorPointer)
                            upwardCounter = upwardCounter + 1;
                        else
                            downwardCounter = downwardCounter + 1;
                        System.out.println("REQUEST : " + triggerFloor + " was requested / elevator is at " + elevatorPointer + " UC " + upwardCounter + " DC" + downwardCounter + "  " + Arrays.toString(floors.toArray()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
