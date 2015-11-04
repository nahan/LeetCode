/**
 * Given two numbers represented as strings, 
 * return multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * @author Han
 *
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        String n1 = this.reverseString(num1);
        String n2 = this.reverseString(num2);
        for (int i = 0; i < n1.length(); i++) {
            int index = i;
            for (int j = 0; j < n2.length(); j++) {
                result[index] += this.charToInt(n1.charAt(i)) * this.charToInt(n2.charAt(j));
                result[index + 1] += result[index] / 10;
                result[index] = result[index] % 10;
                index++;
            }
        }
        return this.intArrayToString(result);
    }
    public int charToInt(char ch) {
        return (int) ch - 48;
    }
    public String reverseString(String s) {
        StringBuilder builder = new StringBuilder(s);
        return builder.reverse().toString();
    }
    public String intArrayToString(int[] num) {
        StringBuilder builder = new StringBuilder();
        for (int i = num.length - 1; i >= 0; i--) {
            builder.append(num[i]);
        }
        int start = 0;
        for (int i = 0; i < builder.length() - 1; i++) {
            if (builder.charAt(i) == '0') {
                start++;
            } else {
                break; 
            }
        }
        return builder.substring(start);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "123";
        String s2 = "456";
        System.out.println(solution.multiply(s1, s2));
    }
}
