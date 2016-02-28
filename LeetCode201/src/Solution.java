
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || m == n) {
            return m;
        }
        int element = this.getElement(n);
        if (m < element) {
            return 0;
        }
        return element + this.rangeBitwiseAnd(m - element, n - element);
    }
    public int getElement(int n) {
        int pow = (int) (Math.log(n) / Math.log(2));
        return (int) Math.pow(2, pow);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = 20000;
        int m = 2147483647;
        System.out.println("m: " + i + ", m: " + m + ", result: " + solution.rangeBitwiseAnd(i, m));
    }

}
