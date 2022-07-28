package Level2.SkillDevelop;

import java.util.*;

/*
 * Question : 
	프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
	또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
	먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 
	각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 * 
 * 	output : [2, 1]
 * 
 * 	Solution : 1. 전체 100을 기준으로 progresses를 차감한다. -> {7, 70, 45}
 * 			   2. speeds로 저장값을 나눈다. -> {7, 2.xxx, 9}
 * 			   3. Math.ceil을 이용해 올림을 진행한다 -> {7, 3, 9}
 *			   4. 앞단의 수를 기점으로 차감했을 때, 0보다 작거나 같지 않으면 다음 기능을 수행한다. -> 7일째 2, 9일째 1 -> [2, 1]
 *				   
 *  Solution2 : 1. {5, 10, 1, 1, 20, 1}
 *  		    2. {5, 10, 1, 1, 20, 1}
 *  		    3. {5, 10, 1, 1, 20, 1}
 *  			4. 5일째 1, 10일째 3, 20일째 2 -> [1, 3, 2]
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