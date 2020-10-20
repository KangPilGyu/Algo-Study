package rithm_p;

import java.util.Scanner;

public class skillCheck2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int battery = 0;

        while (N != 0) {
            battery += (N%2);
            N = N/2;
        }

        System.out.println(battery);

        scanner.close();
    }
    
}
/* 
이동방법
1.한번에 K칸을 앞으로 점프
2.현재온거리 X 2 순간이동

건전지
'1'번으로 이동시 K만큼 건전지 사용량이 든다.
'2'번으로 이동시 건전지 사용량이 줄지 않는다.

목적지
거리가 N 만큼 떨어진 장소
단,  '1'번 이동은 최소로...

return
건전지 사용량의 최솟값 
*/