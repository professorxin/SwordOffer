package Offer49;

public class Solution {

    //如果加号或者减号在数字中间的测试用例应该不能通过了
    public int StrToInt(String str) {
        int flag = 1, result = 0, n = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if ((str.charAt(i) < 48 || str.charAt(i) > 57) && (str.charAt(i) != 43 && str.charAt(i) != 45)) {
                return 0;
            }
            if (str.charAt(i) == 45) {
                flag = -1;
                continue;
            }
            if (str.charAt(i) == 43) {
                continue;
            }
            result += (str.charAt(i) - '0') * n;
            n *= 10;
        }
        return flag*result;
    }

    public static void main(String args[]) {
        System.out.println(new Solution().StrToInt("+123"));
    }


    //更加优雅的解法
    public int StrToInt1(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-'))  /* 符号判定 */
                continue;
            if (c < '0' || c > '9')                /* 非法输入 */
                return 0;
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }
}
