package rithm_p;

/**
 * PRGMS_cote
 */
public class PRGMS_cote {
    static int solution(String p, String s) {
        int answer = 0;
        for (int i = 0; i < p.length(); i++) {
            //System.out.println(p.substring(i, i+1));
            int subP = Integer.parseInt(p.substring(i, i+1));
            int subS = Integer.parseInt(s.substring(i, i+1));
            int x = Math.max(subP, subS);
            int y = Math.min(subP, subS);
            //System.out.println(Math.abs(x-y));
            //System.out.println(Math.abs(10-y+x));
            answer += Math.min(x-y, 10-x+y);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution("00000000000000000000", "91919191919191919191"));
    }
}