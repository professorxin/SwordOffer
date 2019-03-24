package Offer52;

public class Solution {
    /*题目描述
    请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现
    任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹
    配，但是与"aa.a"和"ab*a"均不匹配*/


    //需要多看几遍
    //设dp[i][j]为字符串str前i个字符与正则式pattern前j个字符的匹配结果，记m = str.length()，n = pattern.length()，因此所求最终结果为dp[m][n]。
    public boolean match(char[] str, char[] pattern) {

        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        //初始化第一行
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                //不是*的情况，单字符匹配
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*')
                    //是*的情况，要判断pattern[j - 2] 是否匹配当前 str[i - 1]
                    //匹配的话有如下三种情况，pattern[j - 1]匹配空字符串，单一的str[i - 1]字符，多个str[i - 1]字符
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        //不匹配的话pattern[j - 1]匹配空字符串
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(0|0);
    }

}
