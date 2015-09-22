import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, 
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * @author Han
 *
 */
public class Solution {
    public List<Integer> grayCode1(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        int[] opers = new int[n];
        for (int i = 0; i < n; i++) {
            opers[i] = (int) Math.pow(2, i);
        }
        for (int i = 0; i < result.size(); i++) {
            for (int oper: opers) {
                if (result.contains(result.get(i) ^ oper) == false) {
                    result.add(result.get(i) ^ oper);
                }
            }
        }
        return result;
    }
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            ans.add(i >> 1 ^ i);
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 11; i++) {
            System.out.println(i + " => " + solution.grayCode(i));
        }
        System.out.println(3 + " => " + solution.grayCode(3));
    }
}
