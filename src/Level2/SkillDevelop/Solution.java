package Level2.SkillDevelop;

import java.util.*;

/*
 * Question : 
	���α׷��ӽ� �������� ��� ���� �۾��� ���� ���Դϴ�. �� ����� ������ 100%�� �� ���񽺿� �ݿ��� �� �ֽ��ϴ�.
	��, �� ����� ���߼ӵ��� ��� �ٸ��� ������ �ڿ� �ִ� ����� �տ� �ִ� ��ɺ��� ���� ���ߵ� �� �ְ�, �̶� �ڿ� �ִ� ����� �տ� �ִ� ����� ������ �� �Բ� �����˴ϴ�.
	���� �����Ǿ�� �ϴ� ������� �۾��� ������ ���� ���� �迭 progresses�� �� �۾��� ���� �ӵ��� ���� ���� �迭 speeds�� �־��� �� 
	�� �������� �� ���� ����� �����Ǵ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * 
 * 	output : [2, 1]
 * 
 * 	Solution : 1. ��ü 100�� �������� progresses�� �����Ѵ�. -> {7, 70, 45}
 * 			   2. speeds�� ���尪�� ������. -> {7, 2.xxx, 9}
 * 			   3. Math.ceil�� �̿��� �ø��� �����Ѵ� -> {7, 3, 9}
 *			   4. �մ��� ���� �������� �������� ��, 0���� �۰ų� ���� ������ ���� ����� �����Ѵ�. -> 7��° 2, 9��° 1 -> [2, 1]
 *				   
 *  Solution2 : 1. {5, 10, 1, 1, 20, 1}
 *  		    2. {5, 10, 1, 1, 20, 1}
 *  		    3. {5, 10, 1, 1, 20, 1}
 *  			4. 5��° 1, 10��° 3, 20��° 2 -> [1, 3, 2]
 * */

public class Solution {
	
	
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<progresses.length; i++) {
        	int tmp = (int)Math.ceil(((double)(100 - progresses[i]) / speeds[i]));
        	
        	if(!q.isEmpty() && q.peek() < tmp) {
        		list.add(q.size());
        		q.clear();
        	}
        	
        	q.offer(tmp);
        }
        
        list.add(q.size());
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] progresses = {93, 30, 55};
    	int[] speeds = {1, 30, 5};
		System.out.println(sol.solution(progresses, speeds));
	}
}