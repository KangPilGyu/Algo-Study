package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//상근이의 여행
//가장 적은 종류의 비행기 = 가장 적은 간선, 모든 도시 = Spanning Tree, 가중치 없다 = 최소 신장 트리를 구할 필요 없다.
public class P9372 {
    static int T;
    static int N;
    static int M;
    static int[] trip;
    static int route;
    static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            trip[y] = x;
            return 1;
        }
        return 0;
    }
    static int find(int x) {
        if(x == trip[x]) {
            return x;
        }
        return trip[x] = find(trip[x]);
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                trip = new int[N+1];
                route = 0;
                for (int j = 0; j < N; j++) {
                    trip[j] = j;
                }
                for (int j = 0; j < M; j++) {
                    st = new StringTokenizer(br.readLine());
                    if(union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) == 1) {
                        route++;
                    }
                }
                System.out.println(route);
            }
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/* 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    static int M;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;
            T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                for (int j = 0; j < M; j++) {
                    br.readLine();
                }
                sb.append(N-1).append('\n');
            }
            System.out.println(sb.toString());
            br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/