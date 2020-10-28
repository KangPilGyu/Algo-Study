import java.util.*;
class Main{
    public static void main(String[] ar){
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while(tc-->0){
            String s = sc.next();
            while(s.contains("()")) s = s.replace("()", "");
            System.out.println(s.equals("") ? "YES" : "NO");
        }
    }
}
