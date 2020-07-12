package com.leetcode.problems;

/**
 * 5463. 服务中心的最佳位置 显示英文描述
 * 通过的用户数221
 * 尝试过的用户数550
 * 用户总通过次数258
 * 用户总提交次数1993
 * 题目难度Hard
 * 一家快递公司希望在新城市建立新的服务中心。公司统计了该城市所有客户在二维地图上的坐标，并希望能够以此为依据为新的服务中心选址：使服务中心 到所有客户的欧几里得距离的总和最小 。
 * <p>
 * 给你一个数组 positions ，其中 positions[i] = [xi, yi] 表示第 i 个客户在二维地图上的位置，返回到所有客户的 欧几里得距离的最小总和 。
 * <p>
 * 换句话说，请你为服务中心选址，该位置的坐标 [xcentre, ycentre] 需要使下面的公式取到最小值：
 * <p>
 * <p>
 * <p>
 * 与真实值误差在 10^-5 之内的答案将被视作正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：positions = [[0,1],[1,0],[1,2],[2,1]]
 * 输出：4.00000
 * 解释：如图所示，你可以选 [xcentre, ycentre] = [1, 1] 作为新中心的位置，这样一来到每个客户的距离就都是 1，所有距离之和为 4 ，这也是可以找到的最小值。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：positions = [[1,1],[3,3]]
 * 输出：2.82843
 * 解释：欧几里得距离可能的最小总和为 sqrt(2) + sqrt(2) = 2.82843
 * 示例 3：
 * <p>
 * 输入：positions = [[1,1]]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：positions = [[1,1],[0,0],[2,0]]
 * 输出：2.73205
 * 解释：乍一看，你可能会将中心定在 [1, 0] 并期待能够得到最小总和，但是如果选址在 [1, 0] 距离总和为 3
 * 如果将位置选在 [1.0, 0.5773502711] ，距离总和将会变为 2.73205
 * 当心精度问题！
 * 示例 5：
 * <p>
 * 输入：positions = [[0,1],[3,2],[4,5],[7,6],[8,9],[11,1],[2,12]]
 * 输出：32.94036
 * 解释：你可以用 [4.3460852395, 4.9813795505] 作为新中心的位置
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= positions.length <= 50
 * positions[i].length == 2
 * 0 <= positions[i][0], positions[i][1] <= 100
 * Created by apa7 on 2020/7/12.
 */
public class Problem5463 {

    //求费马尔点，退火算法
    class Solution {

        int dx[] = new int[]{0, 0, -1, 1};
        int dy[] = new int[]{-1, 1, 0, 0};  //上下左右四个方向

        public double getMinDistSum(int[][] positions) {
            Point[] points = new Point[positions.length];
            int i = 0;
            for (int[] pos : positions) {
                points[i++] = new Point(pos[0], pos[1]);
            }
            return search(points);
        }

        double search(Point p[]) {
            Point s = p[0];       //随机初始化一个点开始搜索
            double t = 200;       //初始化温度
            double ans = 50 * 200;//初始答案值
            while (t > 0.00001) { //停止搜索阈值
                boolean flag = true;
                while (flag) {
                    flag = false;
                    for (int i = 0; i < 4; i++)    //上下左右四个方向
                    {
                        Point z = new Point(s.x + dx[i] * t, s.y + dy[i] * t);
                        double tp = getSum(p, z);
                        if (ans > tp) {
                            ans = tp;
                            s = z;
                            flag = true;
                        }
                    }
                }
                t *= 0.99; //温度下降速度
            }
            return ans;
        }

        double dist(Point A, Point B) {
            return Math.sqrt((A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y));
        }

        double getSum(Point p[], Point t) {
            double ans = 0;
            for (Point point : p) {
                ans += dist(point, t);
            }
            return ans;
        }

        class Point {
            double x, y;

            Point(double x, double y) {
                this.x = x;
                this.y = y;
            }
        }

    }
}
