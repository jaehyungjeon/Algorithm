package Level2.SafeBoat;

import java.util.*;

/*
 * Question : 
	���ε��� ���� ������� ����Ʈ�� �̿��Ͽ� �����Ϸ��� �մϴ�. ����Ʈ�� �۾Ƽ� �� ���� �ִ� 2�� �ۿ� Ż �� ����, ���� ���ѵ� �ֽ��ϴ�.

	���� ���, ������� �����԰� [70kg, 50kg, 80kg, 50kg]�̰� ����Ʈ�� ���� ������ 100kg�̶�� 2��° ����� 4��° ����� ���� Ż �� ������ 
	1��° ����� 3��° ����� ������ ���� 150kg�̹Ƿ� ����Ʈ�� ���� ������ �ʰ��Ͽ� ���� Ż �� �����ϴ�.
	
	����Ʈ�� �ִ��� ���� ����Ͽ� ��� ����� �����Ϸ��� �մϴ�.
	
	������� �����Ը� ���� �迭 people�� ����Ʈ�� ���� ���� limit�� �Ű������� �־��� ��, ��� ����� �����ϱ� ���� �ʿ��� ����Ʈ ������ �ּڰ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * 	Solution : 1. ũ�ν��ϴ� ����� �����ߴٸ� ���� ����
 * 			   2. ť�� �غ�������, �ӵ� �̽�..
 * 			   3. ���� �ѹ� �ǽ�(��������) -> �� ���ڸ� ����(max)�� ���Ͽ� ũ�� �� ���� -> max�� ���� answer++; -> 70,80 2���� ���̽�
 * 			   4. if���ǹ��� ��ġ�ϸ� answer ������ �Բ� �ε����� ���� ���� -> 50 50 ���̽�
 * 			   5. return 3;
 * 
 * */

public class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int index = 0;
        for(int i=people.length - 1; i >= index; i--) {
        	if(people[i] + people[index] <= limit) {
        		index++;
        		answer++;
        	} else {
        		answer++;
        	}
        }
        
        return answer;
    }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		System.out.println(sol.solution(people, limit));
	}
}