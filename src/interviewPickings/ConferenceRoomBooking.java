package interviewPickings;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class ConferenceRoomBooking {
    public static void main(String[] args) {
        ConferenceRoomBooking conferenceRoomBooking = new ConferenceRoomBooking();
        ArrayList<Float[]> rooms = new ArrayList<>();
        rooms.add(new Float[]{11.15f, 12.13f});
        rooms.add(new Float[]{12.13f, 12.14f});
        rooms.add(new Float[]{8f, 18f});
        rooms.add(new Float[]{11f, 13.45f});
        rooms.add(new Float[]{14f, 18.40f});
        rooms.add(new Float[]{13f, 15f});
        System.out.println("should be 3 : " + conferenceRoomBooking.getNumberOfRooms(rooms));
    }

    private int getNumberOfRooms(ArrayList<Float[]> rooms) {
        if (rooms == null || rooms.size() == 0) return 0;
        rooms.sort((Float[] a, Float[] b) -> (a[0] - b[0] <= 0 ? -1 : 1));
        //System.out.println("sorted " + Arrays.deepToString(rooms.toArray()));
        //sorted [[11.0, 13.45], [11.15, 12.13], [13.0, 15.0], [14.0, 18.4]]

        PriorityQueue<Float> minEndTimes = new PriorityQueue<>();
        minEndTimes.offer(rooms.get(0)[1]);
        for (int i = 1; i < rooms.size(); i++) {
            if (rooms.get(i)[0] >= minEndTimes.peek()) {
                minEndTimes.poll();
            }
            minEndTimes.offer(rooms.get(i)[1]);
        }
        return minEndTimes.size();
    }
}
