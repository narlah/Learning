package interviewPickings.interviewBit.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> res = new ArrayList<>();
        intervals.add(newInterval);
        intervals.sort(Comparator.comparingInt(a -> a.start));

        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= current.end) {
                current = new Interval(current.start, Math.max(current.end, intervals.get(i).end));
            } else {
                res.add(new Interval(current.start, current.end));
                current.start = intervals.get(i).start;
                current.end = intervals.get(i).end;
            }
        }
        res.add(current);
        return res;
    }

    public ArrayList<Interval> mergeOverlapping(ArrayList<Interval> intervals) {

        ArrayList<Interval> res = new ArrayList<>();
        intervals.sort(Comparator.comparingInt(a -> a.start));

        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= current.end) {
                current = new Interval(current.start, Math.max(current.end, intervals.get(i).end));
            } else {
                res.add(new Interval(current.start, current.end));
                current.start = intervals.get(i).start;
                current.end = intervals.get(i).end;
            }
        }
        res.add(current);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> arr = new ArrayList<>();
        Integer[][] a = new Integer[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        for (Integer[] z : a) {
            arr.add(new Interval(z[0], z[1]));
        }
        MergeIntervals m = new MergeIntervals();
        ArrayList<Interval> res = m.insert(arr, new Interval(4, 9));
        for (Interval interval : res) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public ArrayList<Interval> insertOld(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> res = new ArrayList<>();
        intervals.add(newInterval);
        intervals.sort(Comparator.comparingInt(a -> a.start));

        PriorityQueue<Interval> minEndTimes = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));
        minEndTimes.offer(intervals.get(0));
        int currentStart = intervals.get(0).start;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= minEndTimes.peek().end) {
                minEndTimes.offer(new Interval(currentStart, Math.max(minEndTimes.poll().end, intervals.get(i).end)));
            } else {
                Interval endI = minEndTimes.poll();
                res.add(new Interval(currentStart, endI.end));
                currentStart = intervals.get(i).start;
                minEndTimes.offer(new Interval(currentStart, intervals.get(i).end));
            }

        }
        if (!minEndTimes.isEmpty()) res.add(new Interval(currentStart, minEndTimes.peek().end));
        return res;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}