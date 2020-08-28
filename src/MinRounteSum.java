/**
 * [[1,3,1,2],[1,5,1,3],[3,2,1,2]]
 * 输出9
 */
public class MinRounteSum {
    public static void main(String[] args) {
        int[][] res = new int[][]{{1,3,1,2},{1,5,1,3},{3,2,1,2}};
        System.out.println(minPathSum(res));
    }
        /**
         * 根据输入的m x n 网格，找出一条从左上角到右下角的路径，使得路径上的数字总和为最小，并输出上述路径上的数字最小总和
         * @param grid int整型二维数组
         * @return int整型
         */
        public static int minPathSum (int[][] grid) {
            // write code here
            int[][] dp = new int[grid.length][grid[0].length];
            for (int i = grid.length - 1; i >= 0; i--) {
                for (int j = grid[0].length - 1; j >= 0; j--) {
                    if(i == grid.length - 1 && j != grid[0].length - 1)
                        dp[i][j] = grid[i][j] +  dp[i][j + 1];
                    else if(j == grid[0].length - 1 && i != grid.length - 1)
                        dp[i][j] = grid[i][j] + dp[i + 1][j];
                    else if(j != grid[0].length - 1 && i != grid.length - 1)
                        dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                    else
                        dp[i][j] = grid[i][j];
                }
            }
            return dp[0][0];
        }
    }

