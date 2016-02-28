
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        
        return this.getResult(m, n);
    }
    public int getResult(int m, int n) {
        if (m == 0 || m == n) {
            return m;
        }
        int element = this.getElement(n);
        if (m < element) {
            return 0;
        }
        return element + this.getResult(m - element, n - element);
    }
    public int getElement(int n) {
        int i = 0;
        while ((int) Math.pow(2, i) <= n) {
            i += 1;
        }
        return (int) Math.pow(2, i - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = 20000;
        int m = 2147483647;
        System.out.println("m: " + i + ", m: " + m + ", result: " + solution.rangeBitwiseAnd(i, m));
    }

}
