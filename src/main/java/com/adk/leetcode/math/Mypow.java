package com.adk.leetcode.math;

public class Mypow {
    public static double myPow(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) res *= x;//1000010110&1 = 0  1的时候res*x  0的时候x自己*x
            x *= x;
            b >>= 1; //b>32 16 8 4 2 1 0
        }
        return res;
    }

    public static void main(String[] args) {
        myPow(2.0000, 10);
    }
}
