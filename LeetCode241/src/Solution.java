import java.util.ArrayList;
import java.util.List;
/**
 * Given a string of numbers and operators, 
 * return all possible results from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * 
 * Example 1
 * Input: "2-1-1"
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 * @author Han
 *
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for (int index = 0; index < input.length(); index++) {
            char operator = input.charAt(index);
            if (operator == '+' || operator == '-' || operator == '*') {
                List<Integer> first = this.diffWaysToCompute(input.substring(0, index));
                List<Integer> second = this.diffWaysToCompute(input.substring(index + 1));
                for (int i: first) {
                    for (int j: second) {
                        result.add(this.compute(i, j, operator));
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
    public int compute(int i, int j, char op) {
        if (op == '+') {
            return i + j;
        } else if (op == '-') {
            return i - j;
        } else {
            return i * j;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s0 = null;
        String s1 = "";
        String s2 = "12*13";
        String s3 = "2-1-1";
        String s4 = "2*3-4*5";
        String s5 = "2*3-4*5*3-4*5*3-4";
        
//        System.out.println(solution.diffWaysToCompute(s0));
//        System.out.println(solution.diffWaysToCompute(s1));
        System.out.println(solution.diffWaysToCompute(s2));
        System.out.println(solution.diffWaysToCompute(s3));
        System.out.println(solution.diffWaysToCompute(s4));
        System.out.println(solution.diffWaysToCompute(s5));
    }
}
