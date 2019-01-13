package Offer46;

public class Solution {
    /*题目描述
    每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
    其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的
    那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....
    这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,
    哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)*/

    //使用数组模拟环
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int[] array = new int[n];
        int i = -1, count = n, step = 0;
        while (count > 0) {
            //指向删除元素的下一个元素
            i++;
            //到达环尾之后回到环头
            if (i >= n) i = 0;
            //跳过已经删除的对象
            if (array[i] == -1) continue;
            //记录走过步数
            step++;
            //找到要删除的对象
            if (step == m ) {
                array[i] = -1;
                count--;
                step = 0;
            }
        }
        return i;
    }

    public static void main(String args[]) {
        System.out.println((-8)%3);
    }


    //之后要好好再看看这道题
    /*删除了一个元素之后，剩下的n-1个人的环的剩下的人和之前n个人的环剩下的人是一样的，然后剩下的n-1个人的环
    通过数学公式可以转化成之前的n个人的子问题*/
    //约瑟夫环，圆圈长度为 n 的解可以看成长度为 n-1 的解再加上报数的长度 m。因为是圆圈，所以最后需要对 n 取余。
    public int LastRemaining_Solution1(int n, int m) {
        if (n == 0)     /* 特殊输入的处理 */
            return -1;
        if (n == 1)     /* 递归返回条件 */
            return 0;
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }
}
