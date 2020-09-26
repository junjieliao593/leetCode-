/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        String maxStr = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            int left = i;
            int right = i;
            boolean flag = true;
            while (left >= 0 && right < s.length() && flag) {
                if (s.charAt(left) == s.charAt(right)) {
                    temp = s.substring(left, right + 1);
                } else if (right + 1 < s.length() && s.charAt(left) == s.charAt(right + 2))
                    temp = s.substring(left, right + 2);
                if (temp.length() > maxStr.length()) {
                    maxStr = temp;
                } else {
                    flag = false;
                }
                right++;
                left--;
            }

        }
        return maxStr;
    }
}
