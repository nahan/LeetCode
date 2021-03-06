import java.util.HashMap;


/**
 * Count the number of prime numbers less than a non-negative number, n
 */
public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            primes[i] = true;
        }
        int m = (int)Math.sqrt(n);
        for (int i = 2; i <= m; i++) {
            if (primes[i] == true) {
                for (int k = i * i; k <= n; k += i) {
                    primes[k] = false;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (primes[i] == true) {
                count += 1;
            }
        }
        return count;
    }
    public int countPrimes1(int n) {
        int count = 0;
        boolean[] primes = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            if (primes[i] == false) {
                count ++;
            }
            for (int j = i; j < n; j += i) {
                primes[j] = true;
            }
        }
        return count;
    }
	public int countPrimes0(int n) {
		int count = 0;
		HashMap<Integer, Boolean> primeMap = new HashMap<Integer, Boolean>();
		for (int i = 2; i < n; i ++) {
			primeMap.put(i, true);
		}
		int m = (int) Math.sqrt(n);
		for (int i = 2; i <= m; i ++) {
			if (primeMap.get(i) == true) {
				for (int k = i * i; k <= n; k += i) {
					primeMap.put(k, false);
				}
			}
		}
		for (int i = 2; i < n; i ++) {
			if (primeMap.get(i) == true) {
				count += i;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countPrimes(0));
		System.out.println(solution.countPrimes(1));
		System.out.println(solution.countPrimes(2));
		System.out.println(solution.countPrimes1(2));
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
		System.out.println(solution.countPrimes(1500000));
		System.out.println(solution.countPrimes1(1500000));

	}
}
