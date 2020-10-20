package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//플로이드
public class P11404 {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            map = new int[N+1][N+1];
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                if(map[start][end] > cost || map[start][end] == 0) {
                    map[start][end] = cost;
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        if(j == k || map[j][i] == 0 || map[i][k] == 0) {
                            continue;
                        }
                        if(map[j][k] > map[j][i] + map[i][k] || map[j][k] == 0) {
                            map[j][k] = map[j][i] + map[i][k];
                        }
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append('\n');
            }
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}