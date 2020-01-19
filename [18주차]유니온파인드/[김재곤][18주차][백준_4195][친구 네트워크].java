package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P4195_map2 {

    static int N, F, cnt;
    static int[] parent, num;
    static Map<String, Integer> map;
    static StringBuilder sb;

    static void init(String name1, String name2) {
        if(!map.containsKey(name1)) {
            map.put(name1, ++cnt);
        }
        if(!map.containsKey(name2)) {
            map.put(name2, ++cnt);
        }
    }
    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    // 속도 더 빠르게 만들기 void -> int
    /* static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            //sb.append(num[x] + "\n"); 속도차이 크다.
            sb.append(num[x]).append("\n");
            return;
        }
        if(x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        num[x] += num[y];
        sb.append(num[x]).append("\n");
    } */
    static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            //sb.append(num[x] + "\n"); 속도차이 크다.
            //sb.append(num[x]).append("\n");
            return num[x];
        }
        if(x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        parent[y] = x;
        num[x] += num[y];
        //sb.append(num[x]).append("\n");
        return num[x];
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                F = Integer.parseInt(br.readLine());
                parent = new int[F*2+1];
                num = new int[F*2+1];
                for (int j = 1; j < parent.length; j++) {
                    parent[j] = j;
                    num[j] = 1;
                }
                map = new HashMap<>();
                cnt = 0;
                for (int j = 0; j < F; j++) {
                    st = new StringTokenizer(br.readLine());
                    String name1 = st.nextToken();
                    String name2 = st.nextToken();
                    init(name1, name2);
                    //union(map.get(name1), map.get(name2));
                    sb.append(union(map.get(name1), map.get(name2))).append("\n");
                }
            }
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
}