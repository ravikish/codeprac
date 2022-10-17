package com.demo.testcode;

import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <p>
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * <p>
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */
public class CoinChangeProblemTwo {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int amount = 4;

        System.out.println();
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 0);

        // if amount is 0, there is only 1 way of making change (no money)
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i) {
                    dp[i] = dp[i] + dp[i - coin];
                }
            }
        }

        return dp[amount];
    }

}
