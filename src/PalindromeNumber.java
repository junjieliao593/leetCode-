/**
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome2(0));
        System.out.println(isPalindrome2(10));
        System.out.println(isPalindrome2(-123321));
        System.out.println(isPalindrome2(123321));
        System.out.println(isPalindrome2(1876885181));
    }

    /**
     * 方法一：反转比较
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        int begin = x;
        int temp = 0;
        while (x != 0) {
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        return begin == temp;
    }


    /**
     * 方法二：只反转比较一半
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 9 ms
     * , 在所有 Java 提交中击败了
     * 99.20%
     * 的用户
     * 内存消耗：
     * 38 MB
     * , 在所有 Java 提交中击败了
     * 95.50%
     * 的用户
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int revert = 0;
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x = x / 10;
        }
        //奇偶分别判断
        return x == revert || revert / 10 == x;
    }
}
