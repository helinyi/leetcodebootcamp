class Solution {

    public int find(int i, int tar, int[] arr, Integer[][] dp) {

        if (tar == 0)
            return 0;
        if (i >= arr.length)
            return (int) 1e9;
        if (dp[i][tar] != null)
            return dp[i][tar];

        int take = (int) 1e9;
        int ntake = (int) 1e9;

        if (arr[i] <= tar)
            take = 1 + find(i, tar - arr[i], arr, dp);
        ntake = find(i + 1, tar, arr, dp);

        return dp[i][tar] = Math.min(take, ntake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        Integer[][] dp = new Integer[n][amount + 1];

        if (amount == 0)
            return 0;
        int ans = find(0, amount, coins, dp);

        if (ans == (int) 1e9)
            return -1;
        return ans;

    }
}