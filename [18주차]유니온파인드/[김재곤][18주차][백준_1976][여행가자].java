package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//여행 가자
public class P1976 {
    static int N;
    static int M;
    static int[] city;
    //static int[][] con;

    static int find(int i) {
        if(i == city[i]) {
            return i;
        }
        return city[i] = find(city[i]);
    }
    static void connect(int i, int j) {
        i = find(i);
        j = find(j);
        city[j] = i;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            //도시 수
            N = Integer.parseInt(br.readLine());
            //여행 계획에 속한 도시 수
            M = Integer.parseInt(br.readLine());

            //도시 집합
            city = new int[N+1];
            for (int i = 0; i <= N; i++) {
                city[i] = i;
            }
           
            //도시 연결 정보
            //con = new int[N][N];
            /* for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    con[i][j] = Integer.parseInt(st.nextToken());
                }
            } */
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    if ((Integer.parseInt(st.nextToken()) == 1) && j > i) { 
                        connect(i, j);
                    }
                }
            }

            //여행 계획
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M-1; i++) {
                int y = Integer.parseInt(st.nextToken());
                if(find(x) != find(y)) {
                    System.out.println("NO");
                    break;
                } else {
                    x = y;
                }
                if(i == M-2) {
                    System.out.println("YES");
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/* 
방법2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static boolean[] con;
	static String[] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		con = new boolean[N];
		map = new String[N];
		boolean able = true;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine();
		}
		st = new StringTokenizer(br.readLine());
		go(Integer.parseInt(st.nextToken()) - 1);
		for (int i = 1; i < M; i++) {
			if(con[Integer.parseInt(st.nextToken()) - 1]) continue;
			able = false;
			break;
		}
		if(able) System.out.println("YES");
		else System.out.println("NO");
	}

	private static void go(int in) {
		con[in] = true;
		for (int i = 0; i < N; i++) {
			if(map[in].charAt(i * 2) == '1' && !con[i]) {
				go(i);
			}
		}
	}
}
 */