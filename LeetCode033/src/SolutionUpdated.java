
public class SolutionUpdated {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                if (nums[left] <= target) {
                    if (nums[mid] >= nums[left]) {
                        return binarySearch(nums, target, left, mid);
                    } else {
                        right--;
                    }
                } else {
                    left++;
                }
            } else {
                if (nums[right] >= target) {
                    if (nums[mid] <= nums[right]) {
                        return binarySearch(nums, target, mid, right);
                    } else {
                        left++;
                    }
                } else {
                    right--;
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
    private int binarySearch(int[] list, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (list[mid] == target) {
                return mid;
            } else if (list[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return list[left] == target ? left : -1;
    }
}
