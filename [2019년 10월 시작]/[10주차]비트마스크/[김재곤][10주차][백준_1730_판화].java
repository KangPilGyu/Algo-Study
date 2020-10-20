package rithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class P1730_3 {

	public static void main(String[] args) {
		
		//long start = System.currentTimeMillis();
		//System.out.println(Runtime.getRuntime().totalMemory());
		int n = 6;
		String direction = "DRDRRUU";
		String[] array = direction.split("");
		
		ArrayList<int[]> xyList = new ArrayList<>();
		int x = 0;
		int y = 0;
		for (int i = 0; i < array.length; i++) {
			int xy[] = new int[2];
			if(i == 0) {
				Arrays.fill(xy, 0);
				xyList.add(xy);
				xy = new int[2];
			}
			if (array[i].equals("D")) {
				y = y + 1;
				xy[0] = x;
				xy[1] = y;
			}else if(array[i].equals("U")) {
				y = y - 1;
				xy[0] = x;
				xy[1] = y;
			}else if(array[i].equals("R")) {
				x = x + 1;
				xy[0] = x;
				xy[1] = y;
			}else if(array[i].equals("L")) {
				x = x - 1;
				xy[0] = x;
				xy[1] = y;
			}
			xyList.add(xy);
		}
		//System.out.println(Runtime.getRuntime().totalMemory());
		int m = 0;
		HashMap<Integer, String> hm = new HashMap<>();
		for (int i = 0; i < xyList.size()-1; i++) {
			int[] xy1 = xyList.get(i);
			int[] xy2 = xyList.get(i+1);
			if (i == 0) {
				if (array[i].equals("D")) {
					hm.put((xy1[1]*n+xy1[0]), "|");
					m = 0;
				} else if(array[i].equals("R")) {
					hm.put((xy1[1]*n+xy1[0]), "-");
					m = 1;
				}
			}else if ((Math.abs(xy2[0]-xy1[0]) == 0) && (Math.abs(xy2[1]-xy1[1]) == 1 )) {
				if (m == 1) {
					hm.put((xy1[1]*n+xy1[0]), "+");
					m = 0;
				} else {
					hm.put((xy1[1]*n+xy1[0]), "|");
				}
			} else if((Math.abs(xy2[0]-xy1[0]) == 1) && (Math.abs(xy2[1]-xy1[1]) == 0 )) {
				if (m == 0) {
					hm.put((xy1[1]*n+xy1[0]), "+");
					m = 1;
				} else {
					hm.put((xy1[1]*n+xy1[0]), "-");
				}
			}
			if(i == xyList.size() - 2) {
				if(m == 0) {
					if(array[array.length-1].equals("D") || array[array.length-1].equals("U")) {
						hm.put((xy2[1]*n+xy2[0]), "|");
					}else {
						hm.put((xy2[1]*n+xy2[0]), "+");
					}
				}else {
					if(array[array.length-1].equals("R") || array[array.length-1].equals("L")) {
						hm.put((xy2[1]*n+xy2[0]), "-");
					}else {
						hm.put((xy2[1]*n+xy2[0]), "+");
					}
				}
			}
		}
		//System.out.println(Runtime.getRuntime().totalMemory());
		for (int i = 0; i < n*n; i++) {
			if (hm.get(i) != null) {
				System.out.print(hm.get(i));
			}else {
				System.out.print(".");
			}
			if(i%6 == 5) {
				System.out.println();
			}
		}
		//System.out.println(Runtime.getRuntime().totalMemory());
		//System.out.println();
		//long end = System.currentTimeMillis();
		//System.out.print("½Ã°£:" + (end - start)/1000.0 + "ÃÊ");
    }

}