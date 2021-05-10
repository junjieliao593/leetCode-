import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效 。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(([]){})"));
        System.out.println(isValid("(){}}{"));
        System.out.println(isValid("{["));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        //奇数必不可能有效
        if (length % 2 == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (isStart(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && isMatching(stack.peek(), c)) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isStart(char s) {
        return s == '(' || s == '{' || s == '[';

    }

    public static boolean isMatching(char s1, char s2) {
        return (s1 == '(' && s2 == ')') || (s1 == '{' && s2 == '}') || (s1 == '[' && s2 == ']');

    }
}
