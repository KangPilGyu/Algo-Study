package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//집합의 표현
public class P1717 {

    static int N;
    static int M;
    static int[] parent;

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x != y) {
            parent[y] = x;
        }
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            parent = new int[N+1];
            for (int i = 0; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int ch = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (ch == 0) {
                    union(x, y);
                } else {
                    if(find(x) == find(y)){
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}