package rithm_p;
/* 
문제
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.

달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.

달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

출력
첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

예제 입력 1 
2 1 5
예제 출력 1 
4
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch_P2869 {
    static int start(int A, int B, int V) {
        int start = 0;
        int end = V;
        int mid = 0;
        int count = 0;
        int sub = A - B;
        while (true) {
            mid = (start+end)/2;
            count = mid/(A - B);
            if((V-(count*sub)) > A) {
                start = mid;
            } else if((V-(count*sub)) == A) {
                break;
            } else {
                if((count*sub)+A-V >= sub) {
                    end = mid;
                } else {
                    break;
                }
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            System.out.println(start(A, B, V));
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


/* 
public class BinarySearch_P2869 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            V -= A;
            int day = 1;
            if(V%(A-B) == 0) {
                day += (V/(A-B));
            } else {
                day += (V/(A-B)+1);
            }
            System.out.println(day);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 */