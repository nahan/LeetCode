
/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * Assume that the total area is never beyond the maximum possible value of int.
 * (A, B, C, D), (E, F, G, H)
 * @author Han
 *
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = A >= E ? A : E;
        int y1 = F >= B ? F : B;
        int x2 = C <= G ? C : G;
        int y2 = D <= H ? D : H;
        return area(A, B, C, D) + area(E, F, G, H) - area(x1, y1, x2, y2);
    }
    public int area(int x1, int y1, int x2, int y2) {
        if (x2 > x1 && y2 > y1) {
            return (x2 - x1) * (y2 - y1);
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("45: " + solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println("4: " + solution.computeArea(0, 0, 0, 0, -1, -1, 1, 1));
        System.out.println("17: " + solution.computeArea(-2, -2, 2, 2, -4, 3, -3, 4));
        System.out.println("19: " + solution.computeArea(-2, -2, 2, 2, 1, 1, 3, 3));
        System.out.println("16: " + solution.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
        System.out.println("16: " + solution.computeArea(-2, -2, 2, 2, -1, -1, 1, 1));
        System.out.println("2: " + solution.computeArea(0, 0, 1, 1, 3, 0, 4, 1));
    }
}
