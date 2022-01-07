package com.adk.leetcode.math;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Friend {
    //age[y] <= 0.5 * age[x] + 7
    //age[y] > age[x]
    //age[y] > 100 && age[x] < 100
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int length = ages.length, ans = 0;
        for (int k = 0, left = 0, right = 0; k < length; k++) {
            while (left < k && !check(ages[left], ages[k])) left++;
            if (right < k) right = k;
            while (right < length && check(ages[right], ages[k])) right++;
            if (right > left) ans += right - left - 1;
        }
        return ans;
    }
    boolean check(int x, int y) {
        if (y <= 0.5 * x + 7) return false;
        if (y > x) return false;
        if (y > 100 && x < 100) return false;
        return true;
    }
}
