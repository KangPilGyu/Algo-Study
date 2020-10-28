import java.util.*;
class Main{
    public static void main(String[] ar){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine(), b = sc.nextLine();
        int n = a.length(), m = b.length(), cnt = 0;
        for(int i = 0; i < n; i++){
            if(a.substring(i).startsWith(b)){
                i += m - 1;
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
