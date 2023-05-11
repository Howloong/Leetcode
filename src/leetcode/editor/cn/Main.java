package leetcode.editor.cn;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static int max = 0;
    public static int count = 100002;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int index = 0;
        while (index++ < N) {
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            System.out.println(cal(A, B, C));
        }
    }

    public static double cal(int A, int B, int C) {
        int delta = 4 * A * A - 8 * A * B * C;
        if (delta < 0) {
            return 0;
        }
        double x1, y1, x2, y2;
        x1 = (2 * A - 2 * B * C + Math.sqrt(delta)) / (2 * B * B);
        x2 = (2 * A - 2 * B * C - Math.sqrt(delta)) / (2 * B * B);
        y1 = B * x1 + C;
        y2 = B * x2 + C;
        return 1;
    }

}