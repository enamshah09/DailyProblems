import java.util.HashSet;

/**
 * 
 * @author enashah
 */

/**
 * This problem was recently asked by Google.
 * 
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
 * 
 * Bonus: Can you do this in one pass?
 */
public class SumPair {

    public static void main(String[] args) {
        int arr[] = {10, 15, 3, 7}, target = 17;
        
        System.out.println(soltution(arr, target));
    }

    private static boolean soltution(int[] arr, int target) {
        HashSet<Integer> hs = new HashSet<>();

        for (int val : arr) {
            if (hs.contains(val)) {
                System.out.println(target - val + " " + val);
                return true;
            } else {
                hs.add(target - val);
            }
        }
        return false;
    }
}
