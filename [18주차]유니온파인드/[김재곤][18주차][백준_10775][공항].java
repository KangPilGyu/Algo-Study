package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//항공
public class P10775 {

    static int G;
    static int P;
    static int[] gate;
    static int cnt = 0;

    static int find(int x) {
        if(x == gate[x]) {
            return x;
        }
        return gate[x] = find(gate[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        gate[x] = y;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            G = Integer.parseInt(br.readLine());
            P = Integer.parseInt(br.readLine());
            gate = new int[G+1];
            for (int i = 1; i < gate.length; i++) {
                gate[i] = i;
            }
            for (int i = 1; i <= P; i++) {
                int gi = find(Integer.parseInt(br.readLine()));

                if(gi == 0) {
                    break;
                }
                union(gi, gi-1);
                cnt++;
            }
            System.out.println(cnt);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/* 
public class P10775 {

    static int G;
    static int P;
    static int[] gate;
    static int cnt = 0;
//  static void docking(int i, int cnt) {
//       for (int j = 1; j <= dck[i]; j++) {
//            if(gate[j] == 0) {
//                gate[j] = i;
//                docking(i+1, cnt+1);
//                gate[j] = 0;
//            }
//            if(max < cnt) {
//               max = cnt;
//            }
//        }
//    } 

    static int find(int gi) {
        if(gi == gate[gi]) {
            return gi;
        }
        return gate[gi] = find(gate[gi]);
    }
    static void union(int gi) {
        gi = find(gi);
        int gi1 = find(gi-1);
        if(gi != gi1) {
            gate[gi] = gi1;
            cnt++;
        }
        //cnt++; 여기에 위치하면 union()호출시 무조건 cnt 값이 오른다.
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            G = Integer.parseInt(br.readLine());
            P = Integer.parseInt(br.readLine());
            gate = new int[G+1];
            for (int i = 1; i < gate.length; i++) {
                gate[i] = i;
            }
            for (int i = 1; i <= P; i++) {
                int gi = Integer.parseInt(br.readLine());
                //if(gate[gi])      if문과 union에 gate[gi]를 사용하면 런타임 에러 발생!!
                //이유 2를 3번 넣을 경우    0 1 2 3 4 ->    1) 0 1 1 3 4,  2) 0 0 1 3 4,   3) 0 0 0 3 4
                //2를 두번 넣으면 1,2 gate는 더이상 도킹이 불가능하고 노드0을 루트노드로 가진다. 하지만 gete[gi]로 보면 2를 두번넣은 2)에서 2는 
                //0이 아닌 1이므로 세번째 넣은 2에서 break가 되지 않고 union()함수를 호출한다.
                if(find(gi) == 0) {
                    break;
                }
                //union(gate[gi])
                union(find(gi));
            }
            System.out.println(cnt);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 
*/