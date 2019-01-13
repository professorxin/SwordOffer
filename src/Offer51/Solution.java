package Offer51;

public class Solution {

    /*题目描述
    给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=
    A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。*/

    //时间复杂度为O(n^2)
    public int[] multiply(int[] A) {
        if (A == null) return null;
        int len = A.length;
        int[] B = new int[len];
        int result = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == i) continue;
                result *= A[j];
                B[i] = result;
            }
            result = 1;
        }
        return B;
    }


    //时间复杂度O(n)，代码优雅
    public int[] multiply1(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }
}
