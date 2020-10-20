package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//외판원 순회
public class P2098 {
    static int N;
    static int[][] cost, W;
    static int INF = 987654321; //  <== 이렇게 쓰기전에  Integer.Max_VALUE 썼는데 시간초과 나옴 순전히 이것 때문에 !!
    static int tour(int start, int visit) {
        if(visit == (1 << N) - 1) {
            if(W[start][0] == 0) {
                return INF;
            }
            return W[start][0]; // ifelse 쓰면 조금 더 빨라짐
        }
        if(cost[start][visit] >= 0) {
            return cost[start][visit];
        }
        int result = INF; // Integer.MAX_VALUE/2 하면 시간초과 안남
        for (int i = 0; i < N; i++) {
            //if(W[start][i] == 0) continue;
            //if((visit & (1 << i)) != 0) continue; 요게 좀 더 빠름
            if(W[start][i] != 0 && (visit & (1 << i)) == 0) {
                int c = tour(i, visit | (1 << i)) + W[start][i];
                result = Math.min(result, c);
                //result = Math.min(result, tour(i, visit | (1 << i)) + W[start][i]); 이게 더 빠름
            }
        }
        cost[start][visit] = result;
        return cost[start][visit];
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            W = new int[N][N];
            cost = new int[N][1 << N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(cost[i], -1); // 없어도 상관없음 없애면 속도 더 빨라짐
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    W[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(tour(0, 1));
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}