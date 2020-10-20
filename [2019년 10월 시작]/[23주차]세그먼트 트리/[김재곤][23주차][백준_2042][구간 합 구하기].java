package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구간 합 구하기
public class P2042 {
    static int N, M, K;
    static long[] tree, arr;
    static void init() {
        int a = 1;
        while (true) {
            if(N <= a) {
                break;
            }
            a *= 2;
        }
        tree = new long[a*2];
    }
    static long set(int node, int start, int end) {
        if(start == end) {
            return tree[node] = arr[start];
        }
        return tree[node] = set(node*2, start, (start+end)/2) + set(node*2+1, (start+end)/2+1, end);
    }
    static void update(int node, int start, int end ,int b, long c) {
        if(b < start || end < b) {
            return;
        }
        if(start == end) {
            arr[b] = c;
            tree[node] = c;
            return;
        }
        tree[node] -= (arr[b] - c);
        if(b <= (start+end)/2) {         
            update(node*2, start, (start+end)/2, b, c);
        } else {
            update(node*2+1, (start+end)/2+1, end, b, c);
        }
    }
    static long sum(int node, int start, int end, int b, long c) {
        if(c < start || end < b) {
            return 0;
        }
        if(b <= start && end <= c) {
            return tree[node];
        }     
        return sum(node*2, start, (start+end)/2, b, c) + sum(node*2+1, (start+end)/2+1, end, b, c);
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new long[N+1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            //tree 배열 생성
            init();
            //tree 배열 초기화
            set(1, 1, N);
            for (int i = 0; i < M+K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                long c = Integer.parseInt(st.nextToken());
                if(a == 1) {
                    update(1, 1, N, b, c);
                } else {
                    sb.append(sum(1, 1, N, b, c)).append('\n');
                }
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
}