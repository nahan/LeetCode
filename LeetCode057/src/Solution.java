import java.util.ArrayList;
import java.util.List;

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
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            i += 1;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            int start = Math.min(intervals.get(i).start, newInterval.start);
            int end = Math.max(intervals.get(i).end, newInterval.end);
            newInterval = new Interval(start, end);
            intervals.remove(i);
        }
        intervals.add(i, newInterval);
        return intervals;
    }
    public void print(List<Interval> list) {
        for (Interval item: list) {
            System.out.print("[" + item.start + ", " + item.end + "], ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval i0 = new Interval(1, 3);
        Interval i1 = new Interval(6, 9);
        Interval i2 = new Interval(2, 5);
        List<Interval> list = new ArrayList<Interval>();
        list.add(i0);
        list.add(i1);
        solution.print(list);
        solution.insert(list, i2);
        solution.print(list);
    }

}
