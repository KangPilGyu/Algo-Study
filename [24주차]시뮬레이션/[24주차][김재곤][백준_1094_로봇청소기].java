package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//로봇 청소기
public class P14503 { 
    static int r, c, d;
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            AutoSweeping as = new AutoSweeping(st);
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            as.roomSet(br);
            as.start(r, c, d);
            System.out.println(as.cnt);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
class AutoSweeping {
    int N, M, cnt = 0;
    //int[] dy = {0,-1,0,1};
    //int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int[] dx = {-1,0,1,0};
    int[][] room;
    public AutoSweeping() {}
    public AutoSweeping(StringTokenizer st) {
        this.N = Integer.parseInt(st.nextToken());
        this.M = Integer.parseInt(st.nextToken());
        room = new int[N][M];
    }
    public void roomSet(BufferedReader br) throws IOException{
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public void start(int r, int c, int d) {
        if(cnt == 0) {
            if(d == 3) {
                d = 1;
            } else if(d == 1) {
                d = 3;
            }
        }
        if(room[r][c] == 0) {
            room[r][c] = 2;
            cnt++;
        }
        //System.out.println(r + "," + c + "," + d + "," + this.cnt );
        for (int i = d; i < d+4; i++) {
            int r1 = r + dy[i%4];
            int c1 = c + dx[i%4];
            if(room[r1][c1] == 0) {
                start(r1, c1, (i+1)%4);
                return;
            }
        }
        if (room[r+dy[(d+1)%4]][c+dx[(d+1)%4]] == 1) {
            return;
        } else {
            start(r+dy[(d+1)%4], c+dx[(d+1)%4], d);
        }
    }
}