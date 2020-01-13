package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//트리
public class P1068 {

    static int N;
    static int[] parent;
    static int x;
    static int total = 0;

    static void leaf(int y) {
        int cnt = 0;
        for (int i = 0; i < parent.length; i++) {
            if(parent[i] == y) {
                leaf(i);
            } else {
                cnt++;
            }
        }
        if (cnt == N) {
            total++;
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = Integer.parseInt(st.nextToken());
            }
            x = Integer.parseInt(br.readLine());
            parent[x] = -1;

            for (int i = 0; i < parent.length; i++) {
                if(parent[i] == -1 && i != x) {
                    leaf(i);
                }
            }
            System.out.println(total);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}