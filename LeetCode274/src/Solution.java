import java.util.Arrays;

/**
 * Given an array of citations (each citation is a non-negative integer) of a researcher, 
 * write a function to compute the researcher's h-index.
 * 
 * According to the definition of h-index on Wikipedia: 
 * "A scientist has index h if h of his/her N papers have at least h citations each, 
 * and the other N-h papers have no more than h citations each."
 * 
 * For example, 
 * given citations = [3, 0, 6, 1, 5], 
 * which means the researcher has 5 papers in total and 
 * each of them had received 3, 0, 6, 1, 5 citations respectively. 
 * Since the researcher has 3 papers with at least 3 citations each and 
 * the remaining two with no more than 3 citations each, his h-index is 3.
 * 
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 * 
 * @author Han
 *
 */
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length < 2) {
            return citations == null || citations.length == 0? 0: 1;
        }
        Arrays.sort(citations);
        int index = 1;
        while (index <= citations.length) {
            if (citations[citations.length - index] >= index) {
                index += 1;
            } else {
                break;
            }
        }
        return index - 1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] c00 = null;
        int[] c01 = {};
        int[] c02 = {1};
        int[] c03 = {3, 0, 6, 1, 5};
        int[] c04 = {1, 2, 3, 4, 5};
        int[] c05 = {1, 2, 3, 4, 5, 6};
        int[] c06 = {1, 2, 3, 4, 5, 6, 7};
        int[] c07 = {0, 1, 1, 2, 2};
        int[] c08 = {0, 1, 2, 2, 2};
        
        System.out.println("1. expected: 0, result: " + solution.hIndex(c00));
        System.out.println("2. expected: 0, result: " + solution.hIndex(c01));
        System.out.println("3. expected: 1, result: " + solution.hIndex(c02));
        System.out.println("4. expected: 3, result: " + solution.hIndex(c03));
        System.out.println("5. expected: 3, result: " + solution.hIndex(c04));
        System.out.println("6. expected: 3, result: " + solution.hIndex(c05));
        System.out.println("7. expected: 4, result: " + solution.hIndex(c06));
        System.out.println("8. expected: 2, result: " + solution.hIndex(c07));
        System.out.println("9. expected: 2, result: " + solution.hIndex(c08));
    }
}
