package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//히스토그램에서 가장 큰 직사각형
public class P6549 {
    static int[] hstg;
    static int[] hstgTree;
    static void makeTree(int n) {
        int a = 1;
        while (true) {
            if(n <= a) {
                break;
            }
            a *= 2;
        }
        hstgTree = new int[a*2];
    }
    static int set(int node, int start, int end) {
        if(start == end) {
            return hstgTree[node] = start;
        }
        int left = set(node*2, start, (start+end)/2);
        int right = set(node*2+1, (start+end)/2+1, end);
        if(hstg[left] < hstg[right]) {
           return hstgTree[node] = left; 
        } else {
            return hstgTree[node] = right;
        }
    }
    static int index(int node, int start, int end, int lf, int rg) {
        if(rg < start || end < lf) {
            return -1;
        }
        if(lf <= start && end <= rg) {
            return hstgTree[node];
        }
        int idxLF = index(node*2, start, (start+end)/2, lf, rg);
        int idxRG = index(node*2+1, (start+end)/2+1, end, lf, rg);
        if(idxLF == -1) {
            return idxRG;
        } else if(idxRG == -1) {
            return idxLF;
        } else {
            return hstg[idxLF] < hstg[idxRG] ? idxLF : idxRG;
        }
    }
    static long maxA(int lf, int rg) {
        int md = index(1, 1, hstg.length-1, lf, rg);
        long max = (long)(rg - lf + 1) * (long)hstg[md];
        if(lf <= md -1) {
            max = Math.max(maxA(lf, md-1), max);
        }
        if(md + 1 <= rg) {
            max = Math.max(maxA(md + 1, rg), max);
        }
        return max;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;
            while (true) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                if(n == 0) {
                    break;
                }
                hstg = new int[n+1];
                for (int i = 1; i <= n; i++) {
                    hstg[i] = Integer.parseInt(st.nextToken());
                }
                makeTree(n);
                set(1, 1, n);
                sb.append(maxA(1, n)).append('\n');
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}