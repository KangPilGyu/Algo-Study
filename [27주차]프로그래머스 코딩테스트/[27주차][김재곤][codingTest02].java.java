package rithm_p;

public class PRGMS_cote02 {
    static int[] xr = {0, 1, 0, -1};
    static int[] yc = {-1, 0, 1, 0};
    static int solution02(int[][] office, int r, int c, String[] move) {
        int answer = office[r][c];
        int d = 0;
        office[r][c] = 0;
        for (int i = 0; i < move.length; i++) {
            if(move[i] == "go") {
                if (c+xr[d] < 0 || c+xr[d] > office.length-1 || r+yc[d] < 0 || r+yc[d] > office.length-1 || office[r+yc[d]][c+xr[d]] == -1) {
                    continue;
                }
                c += xr[d];
                r += yc[d];
                //System.out.println(answer);
                //System.out.println(c+","+r);
                answer += office[r][c];
                office[r][c] = 0;
            } else if(move[i] == "right") {
                d += (d != 3 ? 1 : -3);
                
            } else if(move[i] == "left") {
                d += (d != 0 ? -1 : 3);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[][] office = {{5,-1,4},{6,3,-1},{2,-1,1}};
        String[] move = {"go","go","right","go","right","go","left","go"};
        System.out.println(solution02(office, 1, 0, move));
    }
}