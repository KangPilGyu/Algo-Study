package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//생태학
public class P4358 {
    static String tree;
    static int num = 0;
    static StringBuilder sb = new StringBuilder();
    static void percent(Tree kind, StringBuilder sb1) {
        if(kind.word != 0) {
            sb.append(sb1);
            sb.append(" ").append(Math.round(((float)kind.word/num)*1000000.0)/10000.0).append('\n');
        }
        for (int i = 0; i < kind.name.length; i++) {
            if(kind.name[i] != null) {
                sb1.append((char)(i+32));
                percent(kind.name[i], sb1);
                sb1.deleteCharAt(sb1.length()-1);
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Tree kind = new Tree();
            while (true) {
                tree = br.readLine();
                if(tree.length() == 0) {
                    break;
                }
                num++;
                kind.insert(tree);    
            }
            for (int i = 0; i < kind.name.length; i++) {
                if(kind.name[i] != null) {
                    StringBuilder sb1 = new StringBuilder();
                    sb1.append((char)(i+32));
                    percent(kind.name[i], sb1);
                }
            }
            System.out.println(sb.toString());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Tree {
    Tree[] name = new Tree[95];
    int word = 0;
    public Tree() {}
    public void insert(String tree) {
        if(tree.length() == 0) {
            word++;
        } else {
            if (name[tree.charAt(0) - ' '] == null) {
                name[tree.charAt(0) - ' '] = new Tree();
            }
            name[tree.charAt(0) - ' '].insert(tree.substring(1));
        }
    }
}