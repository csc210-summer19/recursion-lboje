/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Lucas Boje
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a
	// String with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n < 1000) {
			return String.valueOf(n);
		}
		if (n % 1000 < 100) {
			if (n % 1000 < 10) {
				return intWithCommas(n / 1000) + ",00" + n % 1000;
			}
			return intWithCommas(n / 1000) + ",0" + n % 1000;
		}
		return intWithCommas(n / 1000) + "," + n % 1000;
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (index >= len / 2) {
			return;
		}
		int temp = x[index];
		x[index] = x[len - index - 1];
		x[len - index - 1] = temp;
		reverseArray(x, index + 1, len);

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return arrayRange(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private int arrayRange(int[] a, int max, int min) {
		if (a[0] < min) {
			min = a[0];
		}
		if (a[0] > max) {
			max = a[0];
		}
		if (a.length == 1) {
			return max - min;
		}

		int[] newA = new int[a.length - 1];
		for (int i = 0; i < a.length - 1; i++) {
			newA[i] = a[i + 1];
		}
		return arrayRange(newA, max, min);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		if (nums.length < 2) {
			return true;
		}
		if (nums[0] > nums[1]) {
			return false;
		}
		int[] newNums = new int[nums.length - 1];
		for (int i = 0; i < nums.length - 1; i++) {
			newNums[i] = nums[i + 1];
		}
		return isSorted(newNums);
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		if (strs[0].equals(search)) {
			return true;
		}
		if (strs.length == 1) {
			return false;
		}

		String[] newStrs = new String[strs.length - 1];
		for (int i = 0; i < strs.length - 1; i++) {
			newStrs[i] = strs[i + 1];
		}

		return found(search, newStrs);
	}
}
