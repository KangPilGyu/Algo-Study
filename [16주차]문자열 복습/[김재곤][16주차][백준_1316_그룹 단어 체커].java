package rithm_p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1316_2 {

    static int num;
    static int count = 0;
    static String word = "";
    static String comp = "";

    static void wordCk() {
        comp = "";
        for (String st : word.split("")) {
            if (comp.contains(st) && !comp.endsWith(st)) {
                return;
            }
            comp += st;
        }
        count++;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            num = Integer.parseInt(br.readLine());
            for (int i = 0; i < num; i++) {
                word = br.readLine();
                wordCk();
            }
            System.out.println(count);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
방법2
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = N;
		
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			boolean[] checker = new boolean[26];
			
			for(int j = 1; j < word.length(); j++) {
				if(word.charAt(j-1) != word.charAt(j)) {
					if(checker[word.charAt(j)-97] == true) {
						count--;
                        break;
					}
				}
				checker[word.charAt(j-1)-97] = true;
			}
		}
		
		System.out.println(count);
    }
}
*/ 