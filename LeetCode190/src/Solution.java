/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 
 * (represented in binary as 00000010100101000001111010011100), 
 * return 964176192 
 * (represented in binary as 00111001011110000010100101000000).
 * @author Han
 *
 */
public class Solution {
    public int reverseBits(int n) {
        n = (n & 0x55555555) << 1 | ((n >> 1) & 0x55555555);
        n = (n & 0x33333333) << 2 | ((n >> 2) & 0x33333333);
        n = (n & 0x0F0F0F0F) << 4 | ((n >> 4) & 0x0F0F0F0F);
        n = (n & 0x00FF00FF) << 8 | ((n >> 8) & 0x00FF00FF);
        n = n << 16 | n >>> 16;
        return n;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 964176190; i < 964176193; i++) {
            System.out.format("%d -> %d\n", i, solution.reverseBits(i));
        }
        System.out.format("%d -> %d\n", 2, solution.reverseBits(2));
    }
}
