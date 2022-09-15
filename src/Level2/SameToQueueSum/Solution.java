package Level2.SameToQueueSum;

import java.util.*;

/*
 * Question : 
	길이가 같은 두 개의 큐가 주어집니다. 하나의 큐를 골라 원소를 추출(pop)하고, 추출된 원소를 다른 큐에 집어넣는(insert) 작업을 통해 각 큐의 원소 합이 같도록 만들려고 합니다. 
	이때 필요한 작업의 최소 횟수를 구하고자 합니다. 한 번의 pop과 한 번의 insert를 합쳐서 작업을 1회 수행한 것으로 간주합니다.

	큐는 먼저 집어넣은 원소가 먼저 나오는 구조입니다. 이 문제에서는 큐를 배열로 표현하며, 원소가 배열 앞쪽에 있을수록 먼저 집어넣은 원소임을 의미합니다. 
	즉, pop을 하면 배열의 첫 번째 원소가 추출되며, insert를 하면 배열의 끝에 원소가 추가됩니다. 예를 들어 큐 [1, 2, 3, 4]가 주어졌을 때, pop을 하면 맨 앞에 있는 원소 1이 추출되어 [2, 3, 4]가 되며, 이어서 5를 insert하면 [2, 3, 4, 5]가 됩니다.
	
	다음은 두 큐를 나타내는 예시입니다.
	
	queue1 = [3, 2, 7, 2]
	queue2 = [4, 6, 5, 1]
	두 큐에 담긴 모든 원소의 합은 30입니다. 따라서, 각 큐의 합을 15로 만들어야 합니다. 예를 들어, 다음과 같이 2가지 방법이 있습니다.
	
	queue2의 4, 6, 5를 순서대로 추출하여 queue1에 추가한 뒤, queue1의 3, 2, 7, 2를 순서대로 추출하여 queue2에 추가합니다. 
	그 결과 queue1은 [4, 6, 5], queue2는 [1, 3, 2, 7, 2]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 7번 수행합니다.
	queue1에서 3을 추출하여 queue2에 추가합니다. 그리고 queue2에서 4를 추출하여 queue1에 추가합니다. 
	그 결과 queue1은 [2, 7, 2, 4], queue2는 [6, 5, 1, 3]가 되며, 각 큐의 원소 합은 15로 같습니다. 이 방법은 작업을 2번만 수행하며, 이보다 적은 횟수로 목표를 달성할 수 없습니다.
	따라서 각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수는 2입니다.
	
	길이가 같은 두 개의 큐를 나타내는 정수 배열 queue1, queue2가 매개변수로 주어집니다. 
	각 큐의 원소 합을 같게 만들기 위해 필요한 작업의 최소 횟수를 return 하도록 solution 함수를 완성해주세요. 단, 어떤 방법으로도 각 큐의 원소 합을 같게 만들 수 없는 경우, -1을 return 해주세요.
 * 
 *  output : 2
 * 
 * 	Solution : 1. queue1과 queue2의 Sum을 따로 구하고 두 합계를 비교해나가면 된다.
 * 			   2. 두 수가 같을 경우까지 비교하며, 비교할 수 없을때는 return -1을 해준다. -> return을 하지 않으면 속도가 느려짐
 * 			   3. 두 수를 비교하여 클 경우에는 큰곳에서 작은곳으로 값을 이전시킨다.
 * 
 * */

public class Solution {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long q1Sum = 0;
        long q2Sum = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        
        
        for(int val : queue1) {
        	q1Sum += val;
        	q1.add(val);
        }
        
        for(int val : queue2) {
        	q2Sum += val;
        	q2.add(val);
        }
        
        while(q1Sum != q2Sum) {
        	answer++;
        	
        	if(q1Sum < q2Sum) {
        		q1Sum += q2.peek();
        		q2Sum -= q2.peek();
        		q1.add(q2.poll());
        	} else if(q2Sum < q1Sum) {
        		q2Sum += q1.peek();
        		q1Sum -= q1.peek();
        		q2.add(q1.poll());
        	}
        	
        	if(answer > (queue1.length + queue2.length) * 2) return -1;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] queue1= {1, 2, 1, 2};
		int[] queue2= {1, 10, 1, 2};
		System.out.println(sol.solution(queue1, queue2));
	}
}