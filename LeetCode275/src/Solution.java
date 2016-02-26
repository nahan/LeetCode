
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length < 2) {
            return citations == null || citations.length == 0? 0: citations[0] == 0? 0: 1;
        }
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
}
