package me.joan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void appendResult(int a, int b, int c, List<List<Integer>> list) {
        /* Because the result is a List of Lists of Integers, we have to create
         *  a temporal triplet to add to that list. Kinda ugly. */
        List<Integer> triplet = new ArrayList<>();
        triplet.add(a);
        triplet.add(b);
        triplet.add(c);
        list.add(triplet);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Dual-Pivot Quicksort
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        /* Each number in the list is a candidate for the 'a' number.
         *  For each 'a', we find candidates 'b' and 'c' from the sides,
         *  using to our advantage the knowledge that the ordered list gives us. */
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue; // If current number is same as last, skip iteration.

            /* Indices for b and c */
            int j = i + 1;
            int k = len - 1;

            /* For every 'b', use dual pointers to find 'b' and 'c'.
             *  We start off with 'b' as leftmost value, b != a; and 'c' as the rightmost value of the list,
             *  then we will be picking bigger 'b' values or smaller 'c' values to make the sum equal to zero. */
            while (j < k) {
                int a = nums[i];
                int b = nums[j];
                int c = nums[k];
                int sum = a + b + c;

                /* First we check that the sum equals zero, then the 'else' cases. */
                if (sum == 0) {
                    /* If a+b+c == 0, append to result list and discard current 'b' and 'c' */
                    appendResult(a, b, c, result);
                    while(k > j + 1 && nums[j + 1] == nums[j]) j++; // If next 'b' == current 'b', skip until 'b' is unique.
                    while(j < k - 1 && nums[k - 1] == nums[k]) k--; // If prev 'c' == current 'c', skip until 'c' is unique.
                    j++; k--;
                }

                else if (sum > 0) k--; // If sum is too small, pick a bigger 'c'.
                else if (sum < 0) j++; // If sum is too large, pick a smaller 'b'.
            }
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0}));
        System.out.println(threeSum(new int[]{1, -1, -1, 0}));
        System.out.println(threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
    }
}
