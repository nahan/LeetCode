
/**
 * Write a function that takes an unsigned integer and 
 * returns the number of ’1' bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
 * so the function should return 3.
 * @author Han
 *
 */
public class Solution {
    public int hammingWeight(int n) {
        
        int m1 = 0x55555555;
        int m2 = 0x33333333;
        int m4 = 0x0f0f0f0f;
        int m8 = 0x00ff00ff;
        int m16 = 0x0000ffff;
        
        n = (n & m1) + ((n >> 1) & m1); 
        n = (n & m2) + ((n >> 2) & m2);  
        n = (n & m4) + ((n >> 4) & m4);
        n = (n & m8) + ((n >> 8) & m8); 
        n = (n & m16) + ((n >> 16) & m16); 
        
        return n;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 101; i++) {
            System.out.println(solution.hammingWeight(i));
        }
    }
}
