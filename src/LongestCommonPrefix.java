/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"owerfl", "flow", "flight", "owerfl"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"aa", "aa"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flower", "flower", "flower"}));
    }

    /**
     * 纵向扫描
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        int j = 0;
        StringBuilder re = new StringBuilder("");
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs.length - 1; ) {
            if (strs[i].length() <= j || strs[i + 1].length() <= j || strs[i].equals("") || strs[i + 1].equals("")) {
                return re.toString();
            }
            if (strs[i].charAt(j) == strs[i + 1].charAt(j)) {
                if (i == strs.length - 2) {
                    re.append(strs[i].charAt(j));
                    j++;
                    i = 0;
                } else {
                    i++;
                }
            } else {
                return re.toString();
            }
        }
        return re.toString();
    }



}
