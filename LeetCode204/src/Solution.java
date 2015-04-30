
/**
 * Count the number of prime numbers less than a non-negative number, n
 */
public class Solution {
	public int countPrimes(int n) {
		int count = 0;
		for (int i = 2; i < n; i ++) {
			if (isPrime(i) == true) {
				count += i;
			}
		}
		return count;
	}
	public boolean isPrime(int n) {
		for (int i = 2; i < n; i ++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countPrimes(0));
		System.out.println(solution.countPrimes(1));
		System.out.println(solution.countPrimes(2));
		System.out.println(solution.countPrimes(3));
		System.out.println(solution.countPrimes(4));
		System.out.println(solution.countPrimes(5));
		System.out.println(solution.countPrimes(6));
		System.out.println(solution.countPrimes(7));
		System.out.println(solution.countPrimes(8));
		System.out.println(solution.countPrimes(9));
		System.out.println(solution.countPrimes(10));
		System.out.println(solution.countPrimes(100));
		System.out.println(solution.countPrimes(499979));

	}
}
