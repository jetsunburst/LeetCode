import java.util.*;

public class ZeroSumSubarray {

  // 🐢 Brute Force Method - O(n^2)
  public boolean zeroSumSubarrayBruteForce(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum == 0) {
          return true;
        }
      }
    }
    return false;
  }

  // 🚀 Optimal Method - O(n) using Prefix Sum and HashSet
  public boolean zeroSumSubarrayOptimal(int[] nums) {
    Set<Integer> seen = new HashSet<>();
    seen.add(0); // Handles cases like [0] or prefixSum == 0 early
    int currentSum = 0;

    for (int i = 0; i < nums.length; i++) {
      currentSum += nums[i];
      if (seen.contains(currentSum)) {
        return true;
      }
      seen.add(currentSum);
    }
    return false;
  }

  // 🚦 Main method for testing
  public static void main(String[] args) {
    ZeroSumSubarray p = new ZeroSumSubarray();
    
    int[] test1 = {4, 2, -3, 1, 6}; // should return true
    int[] test2 = {1, 2, 3};        // should return false
    int[] test3 = {1, -1};          // should return true
    int[] test4 = {0};              // should return true

    System.out.println("Brute Force Results:");
    System.out.println(p.zeroSumSubarrayBruteForce(test1)); // true
    System.out.println(p.zeroSumSubarrayBruteForce(test2)); // false
    System.out.println(p.zeroSumSubarrayBruteForce(test3)); // true
    System.out.println(p.zeroSumSubarrayBruteForce(test4)); // true

    System.out.println("\nOptimal Results:");
    System.out.println(p.zeroSumSubarrayOptimal(test1)); // true
    System.out.println(p.zeroSumSubarrayOptimal(test2)); // false
    System.out.println(p.zeroSumSubarrayOptimal(test3)); // true
    System.out.println(p.zeroSumSubarrayOptimal(test4)); // true
  }
}

