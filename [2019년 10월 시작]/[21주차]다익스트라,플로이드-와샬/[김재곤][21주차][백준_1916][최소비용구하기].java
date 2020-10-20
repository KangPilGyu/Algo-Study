package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소비용구하기
public class P1916 {
    static int N;
    static int M;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PriorityQueue<City> pQueue = new PriorityQueue<>();
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            int[] visit = new int[N+1];
            int[] minCost = new int[N+1];
            Arrays.fill(minCost, Integer.MAX_VALUE);
            City[] cities = new City[N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int dstn = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                cities[start] = new City(dstn, cost, cities[start]);
            }
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pQueue.add(new City(s, 0, null));
            minCost[s] = 0;
            while (!pQueue.isEmpty()) {
                City scn = pQueue.poll();
                if (visit[scn.dstn] == 1) {
                    continue;
                }
                visit[scn.dstn] = 1;
                City sc = cities[scn.dstn];
                while (sc != null) {
                    if (visit[sc.dstn] != 1 && minCost[sc.dstn] > minCost[scn.dstn] + sc.cost) {
                        minCost[sc.dstn] = minCost[scn.dstn] + sc.cost;
                        pQueue.add(new City(sc.dstn, minCost[sc.dstn], null));
                    }
                    sc = sc.city;
                }
            }
            System.out.print(minCost[e]);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }    
    }
}
class City implements Comparable<City>{
    int dstn;
    int cost;
    City city;
    public City() {}
    public City(int dstn, int cost, City city) {
        this.dstn = dstn;
        this.cost = cost;
        this.city = city;
    }
    @Override
    public int compareTo(City o) {
        return this.cost > o.cost ? 1 : -1;
    }
}