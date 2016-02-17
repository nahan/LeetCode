import java.util.Stack;


public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] list = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals("#")) {
                while (!stack.empty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.empty()) {
                        return false;
                    }
                    stack.pop();
                }
                stack.push(list[i]);
            } else {
                stack.push(list[i]);
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(solution.isValidSerialization("1,#"));
        System.out.println(solution.isValidSerialization("9,#,#,1"));
        System.out.println(solution.isValidSerialization("3,#,2,#,#"));
        System.out.println(solution.isValidSerialization("3,2,1,#,#,4,#,#,#"));
        System.out.println(solution.isValidSerialization("3,2,#,#,#"));
        System.out.println(solution.isValidSerialization("1,#,#,#,#"));
        System.out.println(solution.isValidSerialization("#"));
    }
}
