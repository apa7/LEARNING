package com.leetcode.problems;

/**
 * Created by apa7 on 2020/6/21.
 */
public class ProblemWeek20200703 {

    public int numSubmat(int[][] mat) {
        int maxRow = mat.length;
        int maxCol = mat[0].length;
        int[][] dp = new int[maxRow][maxCol];
        boolean[] rowdg = new boolean[maxRow];
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                dp[i][j] = (j == 0 ? 0 : dp[i][j - 1]) + mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < maxCol; i++) {
            for (int j = i; j < maxCol; j++) {
                for (int k = 0; k < maxRow; k++) {
                    int tmp = dp[k][j] - (i == 0 ? 0 : dp[k][i - 1]);
                    rowdg[k] = tmp == j - i + 1;
                }
                for (int k = 0; k < maxRow; k++) {
                    if (!rowdg[k]) {
                        continue;
                    }
                    int cntk = k;
                    while (cntk < maxRow && rowdg[cntk]) {
                        ++cntk;
                    }
                    --cntk;
                    res += (cntk - k + 1) * (cntk - k + 2) / 2;
                    k = cntk;
                }
            }
        }
        return res;
    }


    public void test() {
        numSubmat(new int[][]{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}});
    }

    public static void main(String[] args) {
        ProblemWeek20200703 p = new ProblemWeek20200703();
        p.test();
    }


}