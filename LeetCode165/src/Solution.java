
/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point 
 * and is used to separate number sequences.
 * 
 * For instance, 2.5 is not "two and a half" or "half way to version three", 
 * it is the fifth second-level revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 * @author Han
 *
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null) {
            if (version1 == null && version2 == null) {
                return 0;
            }
            return version1 == null ? -1 : 1;
        }
        if (version1.length() == 0 || version2.length() == 0) {
            if (version1.length() == version2.length()) {
                return 0;
            }
            return version1.length() == 0 ? -1 : 1;
        }
        
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        
        int length = s1.length > s2.length ? s1.length : s2.length;
        int[] v1 = new int[length];
        int[] v2 = new int[length];
        
        for (int i = 0; i < s1.length; i++) {
            v1[i] = s1[i].equals("") ? 0 : Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < s2.length; i++) {
            v2[i] = s2[i].equals("") ? 0 : Integer.parseInt(s2[i]);
        }
        
        for (int i = 0; i < length; i++) {
            if (v1[i] < v2[i]) {
                return -1;
            } else if (v1[i] > v2[i]) {
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("Expect: 1, Output: " + solution.compareVersion("1", "0"));
        System.out.println("Expect: -1, Output: " + solution.compareVersion("1", "2"));
        System.out.println("Expect: 0, Output: " + solution.compareVersion("1", "1"));
        
        System.out.println("Expect: 1, Output: " + solution.compareVersion(".1", ".0"));
        System.out.println("Expect: -1, Output: " + solution.compareVersion(".1", ".2"));
        System.out.println("Expect: 0, Output: " + solution.compareVersion(".1", ".1"));
        
        System.out.println("Expect: -1, Output: " + solution.compareVersion("0.1", "1.1"));
        System.out.println("Expect: 1 Output: " + solution.compareVersion("1.1", "0.1"));
        System.out.println("Expect: -1 Output: " + solution.compareVersion("1.1", "1.2"));
        System.out.println("Expect: 1 Output: " + solution.compareVersion("1.2", "1.1"));
        System.out.println("Expect: -1 Output: " + solution.compareVersion("1.2", "13.37"));
        System.out.println("Expect: 1 Output: " + solution.compareVersion("13.37", "1.1"));
        System.out.println("Expect: 0 Output: " + solution.compareVersion("1.1", "1.1"));
        
        System.out.println("Expect: 1 Output: " + solution.compareVersion("10.6.5", "10.6"));
        System.out.println("Expect: 0 Output: " + solution.compareVersion("1.0", "1"));
    }
}
