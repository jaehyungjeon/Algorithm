package Level2.MoreHot;

import java.util.*;

/*
 * Question : 
	매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 
	모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
	섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
	Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
	Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 	output : 2
 * 
 * 	Solution : 1. 우선순위 큐를 이용하여 들어오는 배열을 순차대로 담는다.
 * 			   2. poll을 통해 순서대로 꺼내며, 만들어지지 않을 경우 return -1을 해준다. (answer = -1 로 할 경우, 런타임 에러가 남)
 * 			   3. 공식값을 큐에 offer시킨다.
 * 			   4. 결괏값 return
 *   
 * */

public class Solution {
	
	public Queue<Integer> q = new PriorityQueue<Integer>();
	
	public int solution(int[] scoville, int K) {
        int answer = 0;
        for(int val : scoville) {
        	q.offer(val);
        }
        
        while(q.peek() <= K) {
        	if(q.size() <= 1) {
        		return -1;
        	}
        	
        	q.offer(q.poll() + (q.poll() * 2));
        	answer++;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(sol.solution(scoville, K));
	}
}