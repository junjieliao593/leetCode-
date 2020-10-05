/**
 * 最长回文子串
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
        System.out.println(longestPalindrome_dp("bdk"));
        System.out.println(longestPalindrome_dp("cbbd"));
        System.out.println(longestPalindrome_dp("ab"));
        System.out.println(longestPalindrome_dp("ccc"));
        System.out.println(longestPalindrome_dp("adddddda"));
    }

    public static String longestPalindrome_dp(String s) {
        if (s == null || s.length() == 1) return s;
        int n = s.length();
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            //i到i
            dp[i][i] = true;
        }
        //i = 1,2
        int max_i = 0;
        int max_j = 0;
        //i到j之间的字串判断（只计算长度超过3的）
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] == charArray[j]) {
                    if (j == (i + 1)) {
                        //最中间相邻两位相等的情况
                        dp[i][i + 1] = true;
                    } else {
                        //对称情况下由上一个状态决定
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && ((max_j - max_i) < (j - i))) {
                        max_j = j;
                        max_i = i;
                    }
                } else {
                    dp[i][j] = false;
                }

            }
        }


        String maxStr = s.substring(max_i, max_j + 1);


        return maxStr;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;
        int n = s.length();
        String maxStr = "";
        for (int i = 0; i < n; i++) {
            String temp = "";
            int left = i;
            int right = i;
            boolean flag = true;
            while (left >= 0 && right < n && flag) {
                flag = false;
                temp = s.substring(left, right + 1);
                if (isPalindrome(temp)) {
                    maxStr = maxStr.length() > temp.length() ? maxStr : temp;
                    flag = true;
                }
                right++;
                if (right < n) {
                    temp = s.concat(String.valueOf(s.charAt(right)));
                    if (isPalindrome(temp)) {
                        maxStr = maxStr.length() > temp.length() ? maxStr : temp;
                        flag = true;
                    }

                }
                left--;
                if (left >= 0 && right < n) {
                    temp = String.valueOf(s.charAt(left)).concat(s);
                    if (isPalindrome(temp)) {
                        maxStr = maxStr.length() > temp.length() ? maxStr : temp;
                        flag = true;
                    }

                }
            }

        }
        return maxStr;
    }

    /**
     * 暴力解法，会超出时间限制
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 1) return s;
        int n = s.length();
        String maxStr = "";
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s.substring(i, j + 1)) && maxStr.length() < j + 1 - i) {
                    maxStr = s.substring(i, j + 1);
                }
            }
        }
        return maxStr;
    }

    /**
     * 判断是否回文
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome(String s) {
        if (s == null || s.length() == 1) return true;
        char[] tempArray = s.toCharArray();
        StringBuilder reserve = new StringBuilder();
        for (int j = tempArray.length - 1; j >= 0; j--) {
            reserve.append(tempArray[j]);
        }
        return s.equals(reserve.toString());
    }

    /**
     * 参考方法
     *
     * @param s
     * @return
     */
    private static boolean isPalindrome2(String s) {
        if (s == null || s.length() == 1) return true;
        String reserve = new StringBuilder(s).reverse().toString();
        return s.equals(reserve);
    }


}
