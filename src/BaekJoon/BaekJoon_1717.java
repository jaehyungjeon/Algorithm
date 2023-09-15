package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
	Question : 초기에 
	$n+1$개의 집합 
	$\{0\}, \{1\}, \{2\}, \dots , \{n\}$이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
	
	집합을 표현하는 프로그램을 작성하시오.

	input			 
	7 8
	0 1 3
	1 1 7
	0 7 6
	1 7 1
	0 3 7
	0 4 2
	0 1 1
	1 1 1
	
	output
	NO
	NO
	YES
	
	Solution : 1. 집합의 부모를 찾아서 해당 부모가 같은지를 비교하면 쉽다.
			   2. 0일때는 부모를 합치는 union 결국 최종적인 부모로 고정시키는 역할이다.
			   3. 해당 인덱스의 최종 부모를 찾아 부모가 같으면 YES를 아니면 NO를 반환한다.
	
*/

public class BaekJoon_1717 {

	public static int N, M;
	public static int[] parent;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			parent[i] = i;
		}
		
		while(M-- > 0) {
			st = new StringTokenizer(br.readLine());
			
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(command == 1) {
				sb.append(isSame(a, b) ? "YES" : "NO").append("\n");
			} else if(command == 0) { // 부분집합을 합친다.
				union(a, b);
			} else { // 0과 1 외의 것이 들어올 가능성 배제
				continue;
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		// 최종 부모를 찾는다.
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x < y) { // x의 부모가 y가 된다.
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}
	
	public static boolean isSame(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x == y) return true;
		else return false;
	}
}
