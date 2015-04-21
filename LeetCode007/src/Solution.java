import java.util.ArrayList;

//Reverse digits of an integer.
//
//Example1: x = 123, return 321
//Example2: x = -123, return -321
public class Solution {
	public int reverse(int x) {
		boolean isNegative = false;
		if (x < 0) {
			isNegative = true;
			x *= (-1);
		}
		ArrayList<Integer> array = new ArrayList<Integer>();
		while (x > 0) {
			array.add(x % 10);
			x = x / 10;
		}
		int result = 0;
		int length = array.size();
		if (length > 10) {
			return result;
		}
		for (int item: array) {
			if (length <= 0) {
				break;
			}
			if (isNegative == false && result >= Math.pow(2, 31) - 1) {
				return 0;
			}
			if (isNegative == true && result >= Math.pow(2, 31)) {
				return 0;
			}
			if (isNegative == false) {
				if (result <= Math.pow(2, 31) - 1) {
					result = (int) (result + item * Math.pow(10, length - 1));
				} else {
					return 0;
				}
			} else {
				if (result > (-1) * Math.pow(2, 31)) {
					result = result >= 0? (int) ((-1) * result - item * Math.pow(10, length - 1)) : (int) (result - item * Math.pow(10, length - 1));
				} else {
					return 0;
				}
			}
			length --;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		//int i = 2147483647;
		//int i = -1234567;
		//int i = -2147483648;
		int i = -10000000;
		System.out.println("original int: " + i);
		System.out.println(solution.reverse(i));
	}
}
