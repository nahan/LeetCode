import java.util.List;


public class StringProblems {
    /**************************** Methods ****************************/
    /**************************** Main ****************************/
    public static void main(String[] args) {
        System.out.println("Hello Backtracking.");
    }
    /**************************** Testing Methods ****************************/
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
    public void print(char[] array) {
        if (array == null) {
            return;
        }
        for (char item: array) {
            System.out.print(item + "\t");
        }
        System.out.println();
    }
    public void print(List<int[]> list) {
        for (int[] item: list) {
            for (int i = 0; i < item.length; i++) {
                System.out.print(item[i] + ", ");
            }
            System.out.println();
        }
    }
    public void printList(List<String> list) {
        System.out.println(list);
    }
    public void printMatrix(List<List<String>> matrix) {
        System.out.println(matrix);
    }
    public void printMatrix(char[][] matrix) {
        for (char[] item: matrix) {
            this.print(item);
        }
    }
}
