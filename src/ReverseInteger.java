/**
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger {
    public static void main(String[] args) {

        System.out.println(reverse(123456));
        System.out.println(reverse(-654321));
        System.out.println(reverse(1534236469));
//        System.out.println(2 ^ 31 - 1);
    }

    public static int reverse(int x) {
        if (Integer.MIN_VALUE == x) {
            return 0;
        }
        int result = 0;
        int point = 1;
        if (x < 0) {
            x = -x;
            point = -1;
        }

        while (x > 0) {
            int remain = x % 10;
            x = x / 10;
            int temp = result;
            result = result * 10 + remain;
            if (result / 10 != temp) {
                return 0;
            }

        }
        return result * point;

    }

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 36 MB
     * , 在所有 Java 提交中击败了
     * 81.91%
     * 的用户
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        if (Integer.MIN_VALUE == x) {
            return 0;
        }
        int result = 0;
        // int point = 1;
        // if (x < 0) {
        //     x = -x;
        //     point = -1;
        // }

        while (x != 0) {
            int remain = x % 10;
            x = x / 10;
            int temp = result;
            result = result * 10 + remain;
            if (result / 10 != temp) {
                return 0;
            }

        }
        return result;

    }
}
