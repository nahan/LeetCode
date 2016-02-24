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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        for (Interval item: intervals) {
            result = this.insert(result, item);
        }
        return result;
    }
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
        Interval i1 = new Interval(2, 6);
        Interval i2 = new Interval(8, 10);
        Interval i3 = new Interval(15, 18);
        List<Interval> list = new ArrayList<Interval>();
        list.add(i0);
        list.add(i1);
        list.add(i2);
        list.add(i3);
        solution.print(list);
        solution.merge(list);
        solution.print(list);
        Interval i4 = new Interval(1, 4);
        Interval i5 = new Interval(0, 4);
        List<Interval> list1 = new ArrayList<Interval>();
        list1.add(i4);
        list1.add(i5);
        solution.print(list1);
        solution.merge(list1);
        solution.print(list1);
        
        Interval i6 = new Interval(1, 10);
        Interval i7 = new Interval(2, 3);
        Interval i8 = new Interval(4, 5);
        Interval i9 = new Interval(6, 7);
        Interval i10 = new Interval(8, 9);
        List<Interval> list2 = new ArrayList<Interval>();
        list2.add(i6);
        list2.add(i7);
        list2.add(i8);
        list2.add(i9);
        list2.add(i10);
        solution.print(list2);
        solution.merge(list2);
        solution.print(list2);
        
        Interval i11 = new Interval(2, 3);
        Interval i12 = new Interval(4, 5);
        Interval i13 = new Interval(6, 7);
        Interval i14 = new Interval(8, 9);
        Interval i15 = new Interval(1, 10);
        List<Interval> list3 = new ArrayList<Interval>();
        list3.add(i11);
        list3.add(i12);
        list3.add(i13);
        list3.add(i14);
        list3.add(i15);
        solution.print(list3);
        solution.merge(list3);
        solution.print(list3);
        
        Interval i16 = new Interval(2, 3);
        Interval i17 = new Interval(5, 5);
        Interval i18 = new Interval(2, 2);
        Interval i19 = new Interval(3, 4);
        Interval i20 = new Interval(3, 4);
        List<Interval> list4 = new ArrayList<Interval>();
        list4.add(i16);
        list4.add(i17);
        list4.add(i18);
        list4.add(i19);
        list4.add(i20);
        solution.print(list4);
        list4 = solution.merge(list4);
        solution.print(list4);
    }

}
