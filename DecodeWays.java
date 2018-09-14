/**
 * Date: 14th Sept, 2018
 * @author enashah
 */

/**
 * This problem was asked by Facebook.
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
 * For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
 * You can assume that the messages are decodable. For example, '001' is not allowed.
 */
public class DecodeWays {

    public static void main(String[] args) {
        String s = "65";
        System.out.println(solution(s) + "");
    }

    private static int solution(String s) {
        if (s == null) {
            return 0;
        }
        int decode[] = new int[s.length() + 1];
        decode[s.length()] = 1;
        decode[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                decode[i] = Integer.parseInt(s.substring(i, i + 2)) <= 26 ? decode[i + 1] + decode[i + 2]
                        : decode[i + 1];
            }
        }
        return decode[0];
    }
}
