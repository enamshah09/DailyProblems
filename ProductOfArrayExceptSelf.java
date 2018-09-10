/**
 * Date: 9th Sept, 2018
 * @author enashah
 */

/**
 * This problem was asked by Uber.
 * 
 * Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 * 
 * Follow-up: what if you can't use division?
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        
        arr = solution(arr);
        for(int val: arr) {
            System.out.print(val + "\t");
        }
    }

    private static int[] solution(int[] arr) {
        if (arr == null || arr.length == 1) {
            return arr;
        }
        
        // Store Multiplication from left
        int mul = 1, nums[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            nums[i] = mul;
            mul *= arr[i];
        }
        
        // Update Multiplication from right 
        mul = 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            nums[i] *= mul;
            mul *= arr[i];
        }
        return nums;
    }
}
