
/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 * @author Han
 *
 */
public class Solution {
	public boolean isUgly(int num) {
		if (num <= 1) return num == 1? true : false;
		while (num % 2 == 0) num /= 2;
		while (num % 3 == 0) num /= 3;
		while (num % 5 == 0) num /= 5;
		return num == 1 ? true : false;
	}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Solution solution = new Solution();
		for (int i = -1; i <= 100; i ++) {
			System.out.println("Is " + i + " ugly number? " + solution.isUgly(i));
		}
		System.out.println("Is " + 1641249143 + " ugly number? " + solution.isUgly(1641249143));
	}
}
