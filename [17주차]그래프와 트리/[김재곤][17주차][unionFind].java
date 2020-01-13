package rithm_p;

/**
 * unionFind
 */
public class unionFind {

    static int[] parent = new int[100001];

    //자신이 속한 트리의 루트번호를 찾는다. 트리의 시간복잡도는 O(logN)이지만 아래의 코드대로 하면 O(N)[N은 트리의 level]일 될수 있기 때문에 좋지 않다.
    static int find(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            return find(parent[x]);
        }
    }

    //좀 더 효율적으로 찾기
    static int find1(int x) {
        if(x == parent[x]) {
            return x;
        } else {
            return parent[x] = find1(parent[x]);
        }
    }
    //find 코드 길이 줄임
    static int find2(int x) {
        return parent[x] == x ? x : (parent[x] = find1(parent[x]));
    }

    //두 집합을 합친다. 일자로 늘어지는 트리가 생길수 있다. O(1) => 이럴경우 find함수의 시간 복잡도가 O(N)이 될수 있다. 트리의 이점 사라짐
    static void union(int x, int y) {
        if(x != y ){
            parent[y] = x;
        }
    }

    //이렇게 x,y의 루트노드끼리 합하면 트리의 Level이 일자로 늘어나는 경우가 거의 없어진다. O(1)
    static void union1(int x, int y) {
        x = find1(x);
        y = find1(y);
        if(x != y ){
            parent[y] = x;
        }
    }

    //Level이 다른 두 집합의 합
    static int[] rank;
    static void union2(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) return;
        if(rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
        if(rank[x] == rank[y]) {
            rank[x]++;
        }
    }

    static long start;
    static long end;
    public static void main(String[] args) {
        
        //초기화
        //자기 자신이 부모가 된다.
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        //1
        for (int i = 2; i < parent.length; i++) {
            union(i-1,i);
        }
        start = System.currentTimeMillis();
        if(find(9999) == find(10000)) {
            System.out.println("같은 집합");
        } else {
            System.out.println("다른 집합");
        }
        end = System.currentTimeMillis();
        System.out.println((end - start)+"ms");
/* 
        //2
        for (int i = 2; i < parent.length; i++) {
            union1(i-1,i);
        }
        start = System.currentTimeMillis();
        if(find1(99999) == find1(100000)) {
            System.out.println("같은 집합");
        } else {
            System.out.println("다른 집합");
        }
        end = System.currentTimeMillis();
        System.out.println((end - start)+"ms");
 */
    }
}