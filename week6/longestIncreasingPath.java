class Solution {
    private int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // Right, left, down, up
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n]; // Memoization array
        int longestPath = 0;

        // Start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longestPath = Math.max(longestPath, dfs(matrix, i, j, m, n));
            }
        }
        return longestPath;
    }

    private int dfs(int[][] matrix, int x, int y, int m, int n) {
        // Return the stored value if it has already been computed
        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        // Initialize path length to 1
        int maxLength = 1;

        // Explore all four directions
        for (int[] dir : directions) {
            int newX = x + dir[0], newY = y + dir[1];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > matrix[x][y]) {
                int pathLength = 1 + dfs(matrix, newX, newY, m, n);
                maxLength = Math.max(maxLength, pathLength);
            }
        }

        // Store the computed length
        memo[x][y] = maxLength;
        return maxLength;
    }
}