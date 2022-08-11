package Level2.FindDecimal;

import java.util.*;

/*
 * Question : 
	한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
	각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	output : 3
 * 
 * 	Solution : 1. DFS로 경우의 수를 모두 만들어주자
 * 			   2. 소수 판정하는 함수를 하나 새로 따서 비교
 * 			   3. DFS로 돌리되, boolean을 이용하여 동일한 접근을 막도록 실시
 * 			   4. 리스트에 중복되지 않은 수들을 담고 소수 비교실시
 * 
 * */

public class Solution {

	public static List<Integer> list = new ArrayList<Integer>(); 
	public static boolean[] visited = new boolean[7];
	
    public int solution(String numbers) {
        int answer = 0;
        
        for(int i=0; i<numbers.length(); i++) {
        	dfs(numbers, "", i+1);
        }
        
        for(int i=0; i<list.size(); i++) {
        	if(isDecimal(list.get(i))) answer++;
        }
        
        return answer;
    }
    
    /* DFS 활용 백트래킹 */
    public static void dfs(String str, String tmp, int depth) {
    	if(tmp.length() == depth) {
    		int num = Integer.parseInt(tmp);
    		if(!list.contains(num)) list.add(num);
    		return;
    	} else {
    		for(int i=0; i<str.length(); i++) {
    			if(!visited[i]) {
    				visited[i] = true;
	    			tmp+=str.charAt(i);
	    			dfs(str, tmp, depth);
	    			visited[i] = false;
	    			tmp = tmp.substring(0, tmp.length() - 1);
    			}
    		}
    	}
    }
    
    /* 소수 판정 */
    public static boolean isDecimal(int n) {
    	if(n < 2) return false;
    	
    	for(int i=2; i<=Math.sqrt(n); i++) {
    		if(n % i == 0) return false;
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	String numbers = "011";
		System.out.println(sol.solution(numbers));
	}
}