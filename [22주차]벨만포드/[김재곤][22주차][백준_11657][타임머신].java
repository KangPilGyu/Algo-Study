package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//타임머신
public class P11657_1 {
    static int N, M;
    static ArrayList<Cb>[] list;
    static int[] fast;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            list = new ArrayList[N+1];
            fast = new int[N+1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            Arrays.fill(fast, Integer.MAX_VALUE);
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                list[start].add(new Cb(end, time));
            }
            fast[1] = 0;
            for (int i = 1; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 0; k < list[j].size(); k++) {
                        Cb eCb = list[j].get(k);
                        if(fast[j] != Integer.MAX_VALUE && fast[eCb.city] > fast[j] + eCb.time) {
                            fast[eCb.city] = fast[j] + eCb.time;
                        }
                    }
                }
            }
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k < list[j].size(); k++) {
                    Cb eCb = list[j].get(k);
                    if(fast[j] != Integer.MAX_VALUE && fast[eCb.city] > fast[j] + eCb.time) {
                        System.out.println(-1);
                        return;
                    }
                }
                if(fast[j] != Integer.MAX_VALUE) {
                    sb.append(fast[j]).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            }
            sb.delete(0, 2);
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Cb {
    int city;
    int time;
    public Cb() {}
    public Cb(int city, int time) {
        this.city = city;
        this.time = time;
    }
}
//방법2
/* 
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	static int N, M, arr[][], dist[];
	static boolean isAll;
	
	static boolean bellman(int start) {
		dist[start] = 0;
		for(int i = 1; i <= N; i++) {
			isAll = true;
			for(int j = 1; j <= M; j++) {
				if(dist[arr[j][0]] == Integer.MAX_VALUE) {
					continue;
				}
				if(dist[arr[j][0]] + arr[j][2] < dist[arr[j][1]] ) {
					dist[arr[j][1]] = dist[arr[j][0]] + arr[j][2];
					isAll = false;
				}
			}
			if(isAll == true) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	//	System.setIn(new FileInputStream("src/bellman_11657.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M+1][3];
		dist = new int[N+1];
		
		for(int i = 1; i <= M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st1.nextToken());
			arr[i][1] = Integer.parseInt(st1.nextToken());
			arr[i][2] = Integer.parseInt(st1.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		if(bellman(1) == true) {
			for(int i = 2; i <= N; i++) {
				System.out.println(dist[i] == Integer.MAX_VALUE ? -1 : dist[i] );
			}
		}else {
			System.out.println(-1);
		}
		
		
	}

}
 */