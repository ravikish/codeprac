package com.demo.testcode;

import static java.util.Arrays.fill;
import static java.util.Arrays.sort;

public class LIS {
    public static void main(String[] args) {
        int[] l = {0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};
        lis(l);
    }

    private static void lis(int[] l) {
        int length = l.length;
        int[] lengthen = new int[length];
        fill(lengthen, 1);

        int[] subsequence = new int[length];

        int i = 1, j = 0;

        for (i = 1; i < length; i++) {
            for (j = 0; j < i; j++) {
                if (l[j] <= l[i]) {
                    lengthen[i] = Math.max(lengthen[j] + 1, lengthen[i]);
                    subsequence[i] = j;
                }
            }
        }
        sort(lengthen);
        System.out.println("Longest increasing subsequence length is : " + lengthen[length - 1]);

       /* for (int value : subsequence) {
            System.out.print(value + " ");
        }*/
    }
}
