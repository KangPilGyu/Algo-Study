package rithm_p;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//문자열 내림차순으로 배치하기
public class skillCheck1_3 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        
        //방법1
        String[] arrSt = new String[str.length()];
        arrSt = str.split("");
        Arrays.sort(arrSt, Comparator.reverseOrder());
        String str2 = "";
        for (String string : arrSt) {
            str2 += string;
        }
        System.out.println(str2);

        //방법2
        char[] chr = str.toCharArray();
        Arrays.sort(chr);
        String answer = new StringBuilder(new String(chr)).reverse().toString();
        System.out.println(answer);

        //방법3
        String answer2 = Stream.of(str.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
        //toString() 사용하면 값에 나오지 않는다.
        System.out.println(answer2);

        scanner.close();

    }
    
}