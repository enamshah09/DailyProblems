/**
 * Date: 11th Sept, 2018
 * @author enashah
 */

/**
 * This problem was asked by Stripe.
 * 
 * Given an array of integers, find the first missing positive integer in linear
 * time and constant space. In other words, find the lowest positive integer
 * that does not exist in the array. The array can contain duplicates and
 * negative numbers as well.
 * 
 * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
 */

public class FirstMissingPositive {

    public static void main(String[] args) {
        int nums[] = { 3, 4, 1, -1 };

        int missingPositive = solution(nums);
        System.out.println(missingPositive);
    }

    private static int solution(int[] nums) {
        // Move the element to the correct position.
        for (int i = 0; i < nums.length;) {
            if (nums[i] < 0 || nums[i] > nums.length || nums[i] == i + 1) {
                i++;
            } else if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // Check for the Missing positive.
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return 0;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
