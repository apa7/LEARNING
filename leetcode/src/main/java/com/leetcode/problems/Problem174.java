package com.leetcode.problems;

/**
 * 174. 地下城游戏
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 * <p>
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p>
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * 通过次数12,704提交次数29,334
 * Created by apa7 on 2020/7/12.
 */
public class Problem174 {

    class Solution {
        int maxRow;
        int maxCol;
        int[][] dg;

        public int calculateMinimumHP(int[][] dungeon) {
            this.maxRow = dungeon.length;
            if (maxRow == 0) return -1;
            this.maxCol = dungeon[0].length;
            this.dg = dungeon;
            return -calculate(0, 0);
        }

        public int calculate(int row, int col) {
            if (row >= maxRow || col >= maxCol) {
                return 0;
            }

            if (row + 1 == maxRow && col + 1 == maxCol) {
                return dg[row][col];
            }
            int nextVal = 0;
            if (row + 1 >= maxRow) {
                nextVal = calculate(row, col + 1);
            } else if (col + 1 >= maxCol) {
                nextVal = calculate(row + 1, col);
            } else if (dg[row + 1][col] > dg[row][col + 1]) {
                nextVal = calculate(row + 1, col);
            } else {
                nextVal = calculate(row, col + 1);
            }
            return dg[row][col] + nextVal;
        }
    }

    private void test() {

        new Solution().calculateMinimumHP(new int[][]{{-2}});
    }

    public static void main(String[] args) {
        new Problem174().test();
    }
}
