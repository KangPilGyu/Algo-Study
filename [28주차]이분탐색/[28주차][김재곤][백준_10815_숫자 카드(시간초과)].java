package rithm_p;
/* 
문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다. 두 숫자 카드에 같은 수가 적혀있는 경우는 없다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다

출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다.

예제 입력 1 
5
6 3 2 10 -10
8
10 9 -5 2 3 4 5 -10
예제 출력 1 
1 0 0 1 1 0 0 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearch_P10815 {
    static StringBuilder check(int[] card, StringTokenizer st) {
        StringBuilder sb  = new StringBuilder();
        while (st.hasMoreTokens()) {
            int c = 0;
            int start = 0;
            int end = card.length-1;
            int num = Integer.parseInt(st.nextToken());
            int mid;
            while (start <= end) {
                mid = (start+end) / 2;
                if(card[mid] == num) {
                    c=1;
                    break;
                } else if(card[mid] > num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            sb.append(c+" ");
        }
        return sb;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[] card = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                card[st.countTokens()-1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(card);
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            System.out.println(check(card, st).toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}