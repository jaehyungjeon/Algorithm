package Level2.BridgeOverTruck;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * Question : 
	Ʈ�� ���� �밡 ���� ���������� ������ �ٸ��� ������ ������ �ǳʷ� �մϴ�. ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� �˾Ƴ��� �մϴ�. 
	�ٸ����� Ʈ���� �ִ� bridge_length�� �ö� �� ������, �ٸ��� weight ���ϱ����� ���Ը� �ߵ� �� �ֽ��ϴ�. ��, �ٸ��� ������ ������ ���� Ʈ���� ���Դ� �����մϴ�.

	���� ���, Ʈ�� 2�밡 �ö� �� �ְ� ���Ը� 10kg���� �ߵ�� �ٸ��� �ֽ��ϴ�. ���԰� [7, 4, 5, 6]kg�� Ʈ���� ������� �ִ� �ð� �ȿ� �ٸ��� �ǳʷ��� ������ ���� �ǳʾ� �մϴ�.
	
	��� �ð�	�ٸ��� ���� Ʈ��	�ٸ��� �ǳʴ� Ʈ��	��� Ʈ��
	0	[]	[]	[7,4,5,6]
	1~2	[]	[7]	[4,5,6]
	3	[7]	[4]	[5,6]
	4	[7]	[4,5]	[6]
	5	[7,4]	[5]	[6]
	6~7	[7,4,5]	[6]	[]
	8	[7,4,5,6]	[]	[]
	����, ��� Ʈ���� �ٸ��� �������� �ּ� 8�ʰ� �ɸ��ϴ�.
	
	solution �Լ��� �Ű������� �ٸ��� �ö� �� �ִ� Ʈ�� �� bridge_length, �ٸ��� �ߵ� �� �ִ� ���� weight, Ʈ�� �� ���� truck_weights�� �־����ϴ�. 
	�̶� ��� Ʈ���� �ٸ��� �ǳʷ��� �ּ� �� �ʰ� �ɸ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.
 * 
 * 	output : 8
 * 
 * 	Solution : 1. ������� �ʾҴ� ����
 * 			   2. ť�� Ȱ���Ͽ� poll ���� ���� ����� ���� ���� ��.
 * 			   3. ť�� ������� ��(���� ����), ť�� ���̰� max�� ���� ��(else-if), ť�� ��ﶧ(else)
 * 			   4. 
 * 
 * 
 * */

public class Solution {
   
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> truckQueue = new LinkedList<Integer>();
        int totSum = 0;
        
        for(int val : truck_weights) {
        	while(true) {
        		if(truckQueue.isEmpty()) { // ť�� ���������
        			truckQueue.offer(val);
        			answer++;
        			totSum += val;
        			break;
        		} else if(truckQueue.size() == bridge_length) { // ���̰� ������
        			totSum -= truckQueue.poll();
        		} else { // ť�� ������� ���� ���
        			if((totSum + val) > weight) {
        				truckQueue.offer(0);
        				answer++;
        			} else {
        				truckQueue.offer(val);
        				totSum += val;
        				answer++;
        				break;
        			}
        		}
        	}
        }
        
        answer += bridge_length;
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		System.out.println(sol.solution(bridge_length, weight, truck_weights));
	}
}