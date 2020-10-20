package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//세그먼트 트리 최댓값, 최솟값
public class P2357 {
    static int N, M;
    static long max, min;
    static long[] arr; //, maxTree, minTree;
    static long[][] tree;
    static void makeTree() {
        int a = 1;
        while (true) {
            if(N <= a) {
                break;
            }
            a *= 2;
        }
        tree = new long[2][a*2];
    }
    //tree 두개 사용
    /* static void makeTree() {
        int a = 1;
        while (true) {
            if(N <= a) {
                break;
            }
            a *= 2;
        }
        maxTree = new long[a*2];
        minTree = new long[a*2];
    } */
    static long init(int idx, int node, int start, int end) {
        if(start == end) {
            return tree[idx][node] = arr[start];
        }
        if(idx == 0) {
            return tree[idx][node] = Math.min(init(idx, node*2, start, (start+end)/2), init(idx, node*2+1, (start+end)/2+1, end));
        } else {
            return tree[idx][node] = Math.max(init(idx, node*2, start, (start+end)/2), init(idx, node*2+1, (start+end)/2+1, end));
        }
    }
    //tree 두개 사용
    /* static void init(int node, int start, int end) {
        if(start == end) {
            maxTree[node] = arr[start];
            minTree[node] = arr[start];
        } else {
            init(node*2, start, (start+end)/2);
            init(node*2+1, (start+end)/2+1, end);
            maxTree[node] = Math.max(maxTree[node*2], maxTree[node*2+1]);
            minTree[node] = Math.min(minTree[node*2], minTree[node*2+1]);
        }
    } */
    static long find(int idx, int node, int start, int end, int a, int b) {
        if(b < start || end < a) {
            if(idx == 0) {
                return Long.MAX_VALUE;
            } else {
                return 0;
            }
        }
        if(a <= start && end <= b) {
            return tree[idx][node];
        }
        if(idx == 0) {
            return Math.min(find(idx, node*2, start, (start+end)/2, a, b), find(idx, node*2+1, (start+end)/2+1, end, a, b));    
        } else {
            return Math.max(find(idx, node*2, start, (start+end)/2, a, b), find(idx, node*2+1, (start+end)/2+1, end, a, b));
        }
    }
    //tree 두개 사용
    /* static long findMax(int node, int start, int end, int a, int b) {
        if(b < start || end < a) {
            return 0;
        }
        if(a <= start && end <= b) {
            return maxTree[node];
        }
        return Math.max(findMax(node*2, start, (start+end)/2, a, b), findMax(node*2+1, (start+end)/2+1, end, a, b));
    }
    static long findMin(int node, int start, int end, int a, int b) {
        if(b < start || end < a) {
            return Long.MAX_VALUE;
        }
        if(a <= start && end <= b) {
            return minTree[node];
        }
        return Math.min(findMin(node*2, start, (start+end)/2, a, b), findMin(node*2+1, (start+end)/2+1, end, a, b));
    } */
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            //int tl = (int)Math.pow(2, (int)Math.ceil(Math.log(N)/Math.log(2)))*2;
            //tree = new long[2][tl];
            makeTree();
            arr = new long[N+1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            init(0, 1, 1, N);
            init(1, 1, 1, N);
            //init(1, 1, N);
            for (int i = 0; i < M; i++) {
                max = 0;
                min = Long.MAX_VALUE;
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(find(0, 1, 1, N, a, b)).append(' ');
                sb.append(find(1, 1, 1, N, a, b)).append('\n');
                //sb.append(findMin(1, 1, N, a, b)).append(' ');
                //sb.append(findMax(1, 1, N, a, b)).append('\n');
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}