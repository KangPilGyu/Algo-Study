package week2;

import java.util.Scanner;

public class dial_5622 {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();	
		int num = 1;
		int sum = 0;
		String[] arr = new String[str.length()];

		for (int i = 0; i < str.length();i++) {
			
			arr[i] = str.substring(i,i+1);
			
			switch (arr[i]) {
			case "A": case "B": case "C": 
				num = 2;
				break;
			case "D": case "E": case "F": 
				num = 3;
				break;
			case "G": case "H": case "I": 
				num = 4;
				break;
			case "J": case "K": case "L": 
				num = 5;
				break;
			case "M": case "N": case "O": 
				num = 6;
				break;
			case "P": case "Q": case "R": case "S": 
				num = 7;
				break;
			case "T": case "U": case "V": 
				num = 8;
				break;
			case "W": case "X": case "Y": case "Z": 
				num = 9;
				break;

			default:
				num = -1;
				break;
			}
			
			sum += (num+1);
			
		}
		System.out.println(sum);

	}

}
