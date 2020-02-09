package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최단경로
//list 안쓰고 Node클래스에 Node type변수로 같은 정점 객체 저장(link) Node type 배열 사용
//Node[] nndd = new Node[V+1];
//class Node { int end, int cost, Node link }
//nndd[start] = new Node(end, cost, nndd[start]);
public class P1753 {
    static int V, E, K;
    static ArrayList<Node>[] list;
    static int[] visit, minCost;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PriorityQueue<Node> pQueue = new PriorityQueue<>();
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(br.readLine());
            visit = new int[V+1];
            minCost = new int[V+1];
            Arrays.fill(minCost, Integer.MAX_VALUE);
            list = new ArrayList[V+1];
            for (int i = 1; i <= V; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()); 
                int end = Integer.parseInt(st.nextToken());
                int key = Integer.parseInt(st.nextToken());
                list[start].add(new Node(end, key));
            }
            pQueue.add(new Node(K, 0));
            minCost[K] = 0;
            while (!pQueue.isEmpty()) {
                Node q = pQueue.poll();
                if(visit[q.node] == 1) {
                    continue;
                }
                visit[q.node] = 1;
                for (int i = 0; i < list[q.node].size(); i++) {
                    int node = list[q.node].get(i).node;
                    int key = list[q.node].get(i).key;
                    if(visit[node] != 1 && minCost[node] > (key + minCost[q.node])) {
                        minCost[node] = key + minCost[q.node];
                        pQueue.add(new Node(node, minCost[node]));
                    }
                }
            }
            for (int i = 1; i < V+1; i++) {
                if(minCost[i] != Integer.MAX_VALUE) {
                    sb.append(minCost[i]);
                } else {
                    sb.append("INF");
                }
                sb.append('\n');    
            }
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Node implements Comparable<Node>{
    int node;
    int key;
    public Node() {}
    public Node(int node, int key) {
        this.node = node;
        this.key = key;
    }
    @Override
    public int compareTo(Node o) {
        return this.key > o.key ? 1 : -1;
    }
}