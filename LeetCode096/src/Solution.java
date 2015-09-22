/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 * @author Han
 *
 * Solution: 
 * @author liaison
 * https://leetcode.com/discuss/24282/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
 * G(n): the number of unique BST for a sequence of length n.
 * F(i, n), 1 <= i <= n: 
 * the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
 * 
 * G(n) = F(1, n) + F(2, n) + ... + F(n, n). 
 * G(0)=1, G(1)=1.
 * 
 * F(3, 7): the number of unique BST tree with number 3 as its root. 
 * To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, 
 * which is to say, we need to construct an unique BST out of its left subsequence [1, 2] 
 * and another BST out of the right subsequence [4, 5, 6, 7], 
 * and then combine them together 
 * (i.e. cartesian product). 
 * 
 * The tricky part is that 
 * we could consider the number of unique BST out of sequence [1,2] as G(2), 
 * and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). 
 * Therefore, F(3,7) = G(2) * G(4).
 * 
 * F(i, n) = G(i-1) * G(n-i)   1 <= i <= n
 */
public class Solution {
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for (int i = 2; i < result.length; i++) {
            for (int j = 1; j <= i; j++) {
                result[i] += result[j - 1] * result[i - j];
            }
        }
        return result[n];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.format("input: %d, output: %d\n", i, solution.numTrees(i));
        }
    }
}
