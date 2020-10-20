package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//도시 분할 계획
public class P1647 {
    static int N;
    static int M;
    static int[] connec;
    static int[][] route;
    static int find(int x) {
        if(x == connec[x]) {
            return x;
        }
        return connec[x] = find(connec[x]);
    }
    static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            connec[y] = x;
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            connec = new int[N+1];
            for (int i = 0; i <= N; i++) {
                connec[i] = i;
            }
            route = new int[M][3];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                route[i][0] = Integer.parseInt(st.nextToken());
                route[i][1] = Integer.parseInt(st.nextToken());
                route[i][2] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(route, (a, b) -> Integer.compare(a[2], b[2]));
            int cost = 0;
            int cnt = 0;
            for (int i = 0; i < M; i++) {
                if(cnt == N-2) {
                    break;
                }
                if(union(route[i][0], route[i][1]) == 1) {
                    cost += route[i][2];
                    cnt++;
                }
            }
            System.out.println(cost);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}