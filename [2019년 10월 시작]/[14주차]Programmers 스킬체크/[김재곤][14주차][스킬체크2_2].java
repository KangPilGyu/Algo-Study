package rithm_p;

import java.util.ArrayList;

//뉴스 클러스터링
public class skillCheck2_2 {

    public static void main(String[] args) {
        int answer = 0;
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        for (int i = 0; i < str1.length()-1; i++) {
            if (str1.substring(i, i+2).matches("[a-zA-Z]{2}")) {
                list1.add(str1.substring(i, i+2).toLowerCase());
            }
        }

        for (int j = 0; j < str2.length()-1; j++) {
            if (str2.substring(j, j+2).matches("[a-zA-Z]{2}")) {
                list2.add(str2.substring(j, j+2).toLowerCase());
            }
        }

        float and = 0;
        float or = 0;
        float jcd = 0;
        
        for (String a2 : list2) {
            if(list1.contains(a2)) {
                //int idx = list1.indexOf(a2);
                list1.remove(a2);
                and++;
            }
        }
        
        or = list1.size() + list2.size();
          
        if(and == 0 && or == 0){
            jcd = 1;
        } else {
            jcd = and/or;
        }

        answer = (int)Math.floor((jcd * 65536));
        
        System.out.println(answer);
        
    }
    
}
/* 
기사 제목
블라인드 전형
코딩 테스트

유사한 기사 묶는 기준 = 자카드 유사도(집합 간의 유사도 검사)
A,B => J(A,B)(자카드 유사도) 는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값
두 집합이 공집합일 경우 J(A,B) = 1

입력
str1
str2
두 글자씩 끊어 다중집합의 원소로
공백, 숫자, 특수 문자 있으면 그 쌍은 버린다.
대소문자 차이는 무시

출력 
두 문자열의 자카드 유사도 출력
(0 ~ 1) x 65536 후 소수점 아래 버리고 정수부만 출력
 */