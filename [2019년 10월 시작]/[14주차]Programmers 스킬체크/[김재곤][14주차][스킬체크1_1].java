package rithm_p;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;
import java.util.Scanner;

//자연수 뒤집어 배열로 만들기
public class skillCheck1_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        int[] answer;

        //방법1
        //answer = Stream.of(String.valueOf(n).split("")).sorted(Collections.reverseOrder()).mapToInt(Integer::parseInt).toArray();
        //Integer[] itg = Arrays.stream(answer).sorted(Collections.reverseOrder()).boxed().toArray(Integer[]::new);
        
        //방법2
        String[] st = Long.toString(n).split("");
        Arrays.sort(st, Collections.reverseOrder());
        answer = new int[st.length];
        
        for (int i = 0; i < st.length; i++) {
            answer[i] = Integer.parseInt(st[i]);
        }

        for (int nn : answer) {
            System.out.println(nn);
        }

        scanner.close();
    }
}