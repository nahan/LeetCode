
/**
 * You are a product manager and currently leading a team to develop a new product. 
 * Unfortunately, the latest version of your product fails the quality check. 
 * Since each version is developed based on the previous version, 
 * all the versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, 
 * which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. 
 * You should minimize the number of calls to the API.
 * @author Han
 *
 */
class VersionControl {
    public boolean isBadVersion(int i) {
        if (i >= 2) {
            return true;
        } else {
            return false;
        }
    } 
}
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return getBad(1, n);
    }
    public int getBad(int start, int end) {
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid) == true) {
            if (mid == 1 || mid == end) {
                return mid;
            } else if (isBadVersion(mid - 1) == true) {
                return getBad(start, mid);
            }
            return mid;
        } else {
            return getBad(mid + 1, end);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(2));
    }
}
