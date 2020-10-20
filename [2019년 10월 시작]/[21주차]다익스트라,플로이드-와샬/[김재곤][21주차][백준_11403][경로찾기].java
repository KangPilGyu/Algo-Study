package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//경로 찾기
public class P11403 {
    static int N;
    static int[][] G;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            N = Integer.parseInt(br.readLine());
            G = new int[N][N];
            for (int i = 0; i < G.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < G.length; j++) {
                    G[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        if(j == i || i == k) {
                            continue;
                        }
                        if(G[j][i] == 1 && G[i][k] == 1) {
                            G[j][k] = 1;
                        }
                    }
                }
            }
            for (int[] i : G) {
                for (int j : i) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/* 
방법 2
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		boolean[][] has = new boolean[n][n];

		for(int i=0 ; i<n ; i++){
			String[] input = br.readLine().split(" ");
			for(int j=0 ; j<n ; j++){
				has[i][j] = input[j].compareTo("1")==0? true : false;
			}
		}

		for(int k=0 ; k<n ; k++){
			for(int i=0 ; i<n ; i++){
				for(int j=0 ; j<n ; j++){
					if(!has[i][j]){
						has[i][j] = has[i][k] && has[k][j];
					}
				}
			}
		}
		for(int i=0 ; i<n ; i++){
			for(int j=0 ; j<n ; j++){
				if(has[i][j]){
					sb.append(1+" ");
				}
				else{
					sb.append(0+" ");
				}
			}
			sb.replace(sb.length()-1, sb.length(), "\n");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.print(sb.toString());		
	}
}
 */