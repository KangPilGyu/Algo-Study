import java.util.*;
class Main{
	public static void main(String[] args) {
		byte [] arr = new Scanner(System.in).next().getBytes();
		int joi=0, ioi=0;
		for(int i=0; i<arr.length-2; i++) {
			if(arr[i] == 'J' && arr[i+1] == 'O' && arr[i+2] == 'I') joi++; 
			if(arr[i] == 'I' && arr[i+1] == 'O' && arr[i+2] == 'I') ioi++;
		}
		System.out.println(joi+"\n"+ioi);
	}
}
