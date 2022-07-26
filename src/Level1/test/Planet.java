package test;

import java.util.*;

public class Planet {

	static int n;
    static PriorityQueue<Edge> q;
    static int[] parent;
    static int result;
    static po[] planet;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
 
        planet = new po[n];
        for(int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            planet[i] = new po(i, x, y, z);
        }
        q = new PriorityQueue<>();
        
        //x좌표 순서대로 오름차순 정렬 후 작은 값부터 q에 edge정보 저장.
        Arrays.sort(planet, (o1, o2) -> o1.x - o2.x);
        for(int i = 0; i < n - 1; i++) {
            q.offer(new Edge(planet[i].num, planet[i + 1].num, Math.abs(planet[i].x - planet[i + 1].x)));
        }
        //y좌표 순서대로 오름차순 정렬 후 작은 값부터 q에 edge정보 저장.
        Arrays.sort(planet, (o1, o2) -> o1.y - o2.y);
        for(int i = 0; i < n - 1; i++) {
            q.offer(new Edge(planet[i].num, planet[i + 1].num, Math.abs(planet[i].y - planet[i + 1].y)));
        }
        //z좌표 순서대로 오름차순 정렬 후 작은 값부터 q에 edge정보 저장.
        Arrays.sort(planet, (o1, o2) -> o1.z - o2.z);
        for(int i = 0; i < n - 1; i++) {
            q.offer(new Edge(planet[i].num, planet[i + 1].num, Math.abs(planet[i].z - planet[i + 1].z)));
        }
        
        parent = new int[n];
        kruskal();
        System.out.println(result);
    }
    
    public static void kruskal() {
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        while(!q.isEmpty()) {
            Edge edge = q.poll();
            int p1 = find(edge.s);
            int p2 = find(edge.e);
            
            if(p1 != p2) {
                union(p1, p2);
                result += edge.cost;
            }
        }
    }
    
    public static void union(int a, int b) {
        parent[a] = b;
    }
    
    public static int find(int a) {
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
    
    public static class po {
        int num;
        int x;
        int y;
        int z;
        
        public po(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    
    public static class Edge implements Comparable<Edge>{
        int s;
        int e;
        int cost;
        
        public Edge(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
 
        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
}
