package week_1;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

class Point implements Comparable<Point>{
	public long x;
	public long y;
	public Point(long firstX, long firstY) {
		this.x = firstX;
		this.y = firstY;
	}
	@Override
	public int compareTo(Point o) {
		if (this.x > o.x) return 1;
		else if(this.x == o.x) return 0;
		else return -1;
	}
}

public class backjoon_2983 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		long loopSize= scanner.nextInt();
		long jump = scanner.nextInt();
		String str = scanner.next();
		char[] directions = str.toCharArray();

		long firstX = scanner.nextInt();
		long firstY = scanner.nextInt();
		long filter = (firstX + firstY) % 2;

		HashMap<Long, TreeSet<Point>> sumMap = new HashMap<Long, TreeSet<Point>>();
		HashMap<Long, TreeSet<Point>> diffMap = new HashMap<Long, TreeSet<Point>>();


		for (int i = 0; i < loopSize-1; i++) {
			long x = scanner.nextInt();
			long y = scanner.nextInt();

			if ((x+y)%2 == filter) {
				Point newPoint = new Point(x,y);
				TreeSet<Point> sumList = sumMap.get(x+y);

				if (sumList == null) {
					sumList = new TreeSet<Point>();
				}
				sumList.add(newPoint);
				sumMap.put(x+y, sumList);

				TreeSet<Point> diffList = diffMap.get(x-y);
				if (diffList == null) {
					diffList = new TreeSet<Point>();
				}
				diffList.add(newPoint);
				diffMap.put(x-y, diffList);
			}
		}

		long loopX = firstX;
		long loopY = firstY;
		for (char ch : directions) {
			long key = (ch == 'A' || ch == 'D') ? loopX-loopY : loopX+loopY;
			TreeSet<Point> vlist = (ch == 'A' || ch == 'D') ? diffMap.get(key) : sumMap.get(key);
			if (vlist == null || vlist.size() == 0) {
				continue;
			} else {
				boolean isXAdd = (ch == 'A' || ch == 'B') ? true : false;
				Point exPoint= new Point(loopX, loopY);
				Point hitPoint = (isXAdd)
						? vlist.higher(exPoint)
						: vlist.lower(exPoint);
				if (hitPoint == null) {
					continue;
				}
				loopX = hitPoint.x;
				loopY = hitPoint.y;
				vlist.remove(hitPoint);

				if (vlist.size() == 0) {
					vlist = null;
				}

				if (ch == 'A' || ch == 'D') {
					diffMap.put(key, vlist);

					TreeSet<Point> dlist = sumMap.get(hitPoint.x+hitPoint.y);
					dlist.remove(hitPoint);
					if (dlist == null || dlist.size() == 0) {
						dlist = null;
					}
					sumMap.put(hitPoint.x+hitPoint.y, dlist);
				} else {
					sumMap.put(key, vlist);

					TreeSet<Point> dlist = diffMap.get(hitPoint.x-hitPoint.y);
					dlist.remove(hitPoint);
					if (dlist == null || dlist.size() == 0) {
						dlist = null;
					}

					diffMap.put(hitPoint.x-hitPoint.y, dlist);
				}
			}
		}
		System.out.println(loopX +" "+loopY);
	}
}
