import java.util.ArrayList;
import java.util.List;

/**
 * For a given array, there are at most only two elements can appear more than n/3 times.
 * @author Hunter Na
 *
 */

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int candidate0 = 0;
        int candidate1 = 1;
        int counter0 = 0;
        int counter1 = 0;
        for (int item: nums) {
            if (item == candidate0) {
                counter0 += 1;
            } else if (item == candidate1) {
                counter1 += 1;
            } else if (counter0 == 0) {
                candidate0 = item;
                counter0 = 1;
            } else if (counter1 == 0) {
                candidate1 = item;
                counter1 = 1;
            } else {
                counter0 -= 1;
                counter1 -= 1;
            }
        }
        counter0 = 0;
        counter1 = 0;
        for (int item: nums) {
            if (item == candidate0) {
                counter0 += 1;
            }
            if (item == candidate1) {
                counter1 += 1;
            }
        }
        if (counter0 > nums.length / 3) {
            result.add(candidate0);
        }
        if (counter1 > nums.length / 3) {
            result.add(candidate1);
        }
        return result;
    }
    public int majorityElementBoyerMoore(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int n = num.length;
        int candidate = num[0], counter = 0;
        for (int i : num) {
            System.out.println("head, candidate: " + candidate + ", counter: " + counter);
            if (counter == 0) {
                candidate = i;
                counter = 1;
            } else if (candidate == i) {
                counter++;
            } else {
                counter--;
            }
            System.out.println("end, candidate: " + candidate + ", counter: " + counter);
        }

        counter = 0;
        for (int i : num) {
            if (i == candidate)
                counter++;
        }
        if (counter < (n + 1) / 2)
            return -1;
        return candidate;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a0 = null;
        int[] a1 = {};
        int[] a2 = {1};
        int[] a3 = {1, 2};
        int[] a4 = {1, 3, 1};
        int[] a5 = {1, 3, 3, 4};
        int[] a6 = {1, 1, 3, 1, 3, 3};
        System.out.println(solution.majorityElement(a0));
        System.out.println("1. length: " + a1.length + ", times: " + a1.length / 3 + ", result: " + solution.majorityElement(a1));
        System.out.println("2. length: " + a2.length + ", times: " + a2.length / 3 + ", result: " + solution.majorityElement(a2));
        System.out.println("3. length: " + a3.length + ", times: " + a3.length / 3 + ", result: " + solution.majorityElement(a3));
        System.out.println("4. length: " + a4.length + ", times: " + a4.length / 3 + ", result: " + solution.majorityElement(a4));
        System.out.println("5. length: " + a5.length + ", times: " + a5.length / 3 + ", result: " + solution.majorityElement(a5));
        System.out.println("6. length: " + a6.length + ", times: " + a6.length / 3 + ", result: " + solution.majorityElement(a6));
    }

}
