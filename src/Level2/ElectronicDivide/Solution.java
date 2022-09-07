package Level2.ElectronicDivide;

import java.util.*;

/*
 * Question : 
	n개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있습니다. 당신은 이 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할하려고 합니다. 
	이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞추고자 합니다.

	송전탑의 개수 n, 그리고 전선 정보 wires가 매개변수로 주어집니다.
	전선들 중 하나를 끊어서 송전탑 개수가 가능한 비슷하도록 두 전력망으로 나누었을 때, 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	output : 3
 * 
 * 	Solution : 1. 최상위 부모노드를 찾아서 쪼개면 된다는 생각으로 접근
 * 			   2. 연관성 있는 노드들의 map과 그에 따른 List를 담음
 * 			   3. DFS를 이용해 각 위치의 최상위 노드를 구함
 * 			   4. 담겨진 배열에서 절댓값을 이용한 계산
 * 
 * */

public class Solution {

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=0; i<wires.length; i++) {
        	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(); // 부모노드에 따른 자식노드를 담도록
        	int[] tot = new int[n+1];
        	
        	for(int j=1; j<n+1; j++) {
        		tot[j] = 1;
        		map.put(j, new ArrayList<Integer>());
        	}
        	
        	for(int j=0; j<wires.length; j++) {
        		if(i==j) continue;
        		
        		int parentNode = wires[j][0];
        		int childNode = wires[j][1];
        		
        		// 연관성 노드 취합
        		map.get(parentNode).add(childNode);
        		map.get(childNode).add(parentNode);
        	}
        	
        	dfs(n, map, n, tot);
        	
        	int p1 = 0;
        	int p2 = 0;
        	for(int j=1; j<tot.length; j++) {
        		if(tot[j] == 1) p1++;
        		else p2++;
        	}
        	
        	answer = Math.min(answer, Math.abs(p1 - p2));
        }
        
        return answer;
    }
    
    public void dfs(int i, Map<Integer, List<Integer>> map, int parent, int[] tot) {
    	if(tot[i] == parent) return;
    	
    	tot[i] = parent;
    	
    	for(int j : map.get(i)) {
    		dfs(j, map, parent, tot);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 9;
    	int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		System.out.println(sol.solution(n, wires));
	}
}