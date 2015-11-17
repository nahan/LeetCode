import java.util.List;


public class SubsetProblems {
    /**************************** Subsets ****************************/
    /**
     * Given a set of distinct integers, nums, 
     * return all possible subsets.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }
    /**************************** Subsets II ****************************/
    /**
     * Given a collection of integers that might contain duplicates, nums, 
     * return all possible subsets.
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return null;
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        System.out.println("Hello Backtracking.");
        SubsetProblems problem = new SubsetProblems();
        problem.testSubsets();
//        problem.testSubsetsWithDup();
    }
    /**************************** Testing Methods ****************************/
    public void testSubsets() {
        int[] nums0 = {1, 2, 3};
        this.print(this.subsets(nums0));
    }
    public void testSubsetsWithDup() {
        int[] nums0 = {1, 2, 2};
        this.print(this.subsetsWithDup(nums0));
    }
    /**************************** Printing Methods ****************************/
    public void print(int n) {
        System.out.println(n);
    }
    public void print(int[] array) {
        if (array == null) {
            return;
        }
        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(List<List<Integer>> list) {
        System.out.println(list);
    }
}
