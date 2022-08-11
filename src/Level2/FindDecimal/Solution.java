package Level2.FindDecimal;

import java.util.*;

/*
 * Question : 
	���ڸ� ���ڰ� ���� ���� ������ ������ֽ��ϴ�. ����� ���� ������ �ٿ� �Ҽ��� �� �� ���� �� �ִ��� �˾Ƴ��� �մϴ�.
	�� ���� ������ ���� ���ڰ� ���� ���ڿ� numbers�� �־����� ��, ���� �������� ���� �� �ִ� �Ҽ��� �� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	output : 3
 * 
 * 	Solution : 1. DFS�� ����� ���� ��� ���������
 * 			   2. �Ҽ� �����ϴ� �Լ��� �ϳ� ���� ���� ��
 * 			   3. DFS�� ������, boolean�� �̿��Ͽ� ������ ������ ������ �ǽ�
 * 			   4. ����Ʈ�� �ߺ����� ���� ������ ��� �Ҽ� �񱳽ǽ�
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
    
    /* DFS Ȱ�� ��Ʈ��ŷ */
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
    
    /* �Ҽ� ���� */
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