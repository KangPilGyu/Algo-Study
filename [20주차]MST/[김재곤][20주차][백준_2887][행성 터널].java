package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//행성 터널
public class P2887_2 {
    static int N;
    static int[] parent;
    static int find (int x) {
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
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PriorityQueue<Planet> pQueueX = new PriorityQueue<>();
            PriorityQueue<Planet> pQueueY = new PriorityQueue<>();
            PriorityQueue<Planet> pQueueZ = new PriorityQueue<>();
            PriorityQueue<Tn> pQueueT = new PriorityQueue<>();
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                pQueueX.add(new Planet(Integer.parseInt(st.nextToken()), i));
                pQueueY.add(new Planet(Integer.parseInt(st.nextToken()), i));
                pQueueZ.add(new Planet(Integer.parseInt(st.nextToken()), i));
            }
            
            for (int i = 0; i < N-1; i++) {
                Planet x1 = pQueueX.poll();
                Planet y1 = pQueueY.poll();
                Planet z1 = pQueueZ.poll();
                Planet x2 = pQueueX.peek();
                Planet y2 = pQueueY.peek();
                Planet z2 = pQueueZ.peek();
                pQueueT.add(new Tn(x1.node, x2.node, x2.xyz-x1.xyz));
                pQueueT.add(new Tn(y1.node, y2.node, y2.xyz-y1.xyz));
                pQueueT.add(new Tn(z1.node, z2.node, z2.xyz-z1.xyz));
            }
            int sz = pQueueT.size();
            int total = 0;
            for (int i = 0; i < sz; i++) {
                Tn t = pQueueT.poll();
                if(union(t.node1, t.node2) == 1) {
                    total += t.cost;
                }
            }
            System.out.println(total);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Tn implements Comparable<Tn>{
    int node1;
    int node2;
    int cost;
    public Tn() {}
    public Tn(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }
    @Override
    public int compareTo(Tn o) {
        return this.cost > o.cost ? 1 : -1;
    }
}
class Planet implements Comparable<Planet>{
    int xyz;
    int node;
    public Planet() {}
    public Planet(int xyz, int node) {
        this.xyz = xyz;
        this.node = node;
    }
    @Override
    public int compareTo(Planet o) {
        return this.xyz > o.xyz ? 1 : -1;
    }

}