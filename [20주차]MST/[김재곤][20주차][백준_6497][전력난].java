package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//전력난
public class P6497 {
    static int N;
    static int M;
    static int[] parent;
    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y) {
            parent[y] = x;
            return 1;
        }
        return 0;
    }
    static boolean nm(StringTokenizer st) {
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) {
                return false;
            }
            parent = new int[N+1];
            for (int i = 0; i <= N; i++) {
                parent[i] = i;
            }
            return true;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;
            PriorityQueue<Info> pQueue = new PriorityQueue<>();
            while (nm(new StringTokenizer(br.readLine()))) {
                int total = 0;
                for (int i = 0; i < M; i++) {
                    st = new StringTokenizer(br.readLine());
                    Info info = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    total += info.light;
                    pQueue.add(info);
                }
                for (int i = 0; i < M; i++) {
                    Info x = pQueue.poll();
                    if(union(x.city1, x.city2) == 1) {
                        total -= x.light;
                    }
                }
                sb.append(total).append('\n');
            }
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Info implements Comparable<Info>{
    int city1;
    int city2;
    int light;
    public Info() {}
    public Info(int city1, int city2, int light) {
        this.city1 = city1;
        this.city2 = city2;
        this.light = light;
    }
    @Override
    public int compareTo(Info i) {
        return this.light > i.light ? 1 : -1;
    }
}