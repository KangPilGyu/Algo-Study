// 재귀
import java.util.*;
public class Main{
    static StringBuffer sb = new StringBuffer();
    static String[] str = {"\"재귀함수가 뭔가요?\"\n"
        , "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
        , "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
        , "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n"
    };
    static void Recursion(int n, int cnt){
        StringBuffer hypon = new StringBuffer();
        for(int i = 0; i < cnt; i++) hypon.append("____");
        // 재귀함수가 뭔가요?
        sb.append(hypon);
        sb.append(str[0]);
        
        // 기저조건
        if(cnt == n){
            sb.append(hypon);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }else{
            // 답변이 들어감
            for(int i = 1; i < str.length; i++){
                sb.append(hypon);
                sb.append(str[i]);
            }
            //재귀호출
            Recursion(n, ++cnt);
        }
        sb.append(hypon);
        sb.append("라고 답변하였지.\n");
    }
    public static void main(String[] args) {
        int n = new java.util.Scanner(System.in).nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        Recursion(n, 0);
        System.out.print(sb);
    }
}