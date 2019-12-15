package rithm_p;

import java.util.Arrays;
import java.util.Scanner;

//단지번호붙이기
public class P2667 {

    static int mapSize;
    static String k;
    static int z;
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int[][] house;
    static int[][] visit;
    static int[]apt; //Arraylist
    static int cntApt = 0;
    static int cntHouse;

    static void dfs(int x, int y) {
        for (int i = 0; i < dx.length; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            //if(x1 < 0 || y1 < 0 || x1 > N || y1 > N);
            if (house[x1][y1] == 1 && visit[x1][y1] == 0) {
                visit[x1][y1] = 1;
                cntHouse++;
                dfs(x1, y1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mapSize = scanner.nextInt();
        house = new int[mapSize+2][mapSize+2];
        visit = new int[mapSize+2][mapSize+2];
        apt = new int[mapSize*mapSize]; //N*N/2 + 1

        for (int i = 1; i <= mapSize; i++) {
            k = scanner.next();
            z = 1;
            for (byte b : k.getBytes()) {
                if(b != 48){
                    house[i][z] = 1;
                }
                z++;
            }
        }

        for (int x = 1; x <= mapSize; x++) {
            for (int y = 1; y <= mapSize; y++) {
                if (house[x][y] == 1 && visit[x][y] == 0 ) {
                    visit[x][y] = 1;
                    cntHouse = 1;
                    cntApt++;
                    dfs(x, y);
                    apt[cntApt] = cntHouse;
                }
            }
        }
        
        Arrays.sort(apt);
        System.out.println(cntApt);
        for (int cntH : apt) {
            if (cntH != 0) {
                System.out.println(cntH);
            }
        }

        scanner.close();
    }
}

/* 정사각형 모양의 지도
1 = 집 있음
0 = 집 없음
단지: 연결된 집들의 모임 
단지에 번호 붙이기
연결: 상하좌우에 다른 집 있는 경우(대각선 X)
입력: 지도
출력: 단지수, 각 단지의 집의 수(오름차순)

입
지도크기: N
다음 N줄에 N개의 0과1로 이루어진 자료

출
총 단지수
단지 내 집의 수 (오름차순)한줄씩

2차원 배열 => 그래프 => BFS or DFS

7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
*/