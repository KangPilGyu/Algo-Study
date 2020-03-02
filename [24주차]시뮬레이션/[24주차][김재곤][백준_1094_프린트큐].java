package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//프린트 큐
public class P1966 {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st; 
            int tc = Integer.parseInt(br.readLine());
            for (int i = 0; i < tc; i++) {
                st = new StringTokenizer(br.readLine());
                PrintQ printQ = new PrintQ(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                printQ.addQ(new StringTokenizer(br.readLine()));
                sb.append(printQ.getIm()).append('\n');
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class PrintQ {
    int N, M;
    Queue<Integer> queue = new LinkedList<>();
    public PrintQ(){}
    public PrintQ(int N, int M){
        this.N = N;
        this.M = M;
    }
    public void addQ(StringTokenizer st) {
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
    }
    public int getIm() {
        int order = this.M;
        int cnt = 0;
        while (true) {
            int x = queue.poll();
            if(search(x)) {
                queue.add(x);
                if(order == 0) {
                    order = queue.size();
                }
            } else {
                cnt++;
                if(order == 0) {
                    break;
                }
            }
            order--;
        }
        return cnt;
    }
    public boolean search(int x) {
        for (Integer i : queue) {
            if(i > x) {
                return true;
            }
        }
        return false;
    }
}