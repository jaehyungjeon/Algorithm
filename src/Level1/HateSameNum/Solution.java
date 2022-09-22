package Level1.HateSameNum;

import java.util.*;

/*
 * Question : 
	�迭 arr�� �־����ϴ�. �迭 arr�� �� ���Ҵ� ���� 0���� 9������ �̷���� �ֽ��ϴ�. 
	�̶�, �迭 arr���� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� �����Ϸ��� �մϴ�. 
	��, ���ŵ� �� ���� ������ ��ȯ�� ���� �迭 arr�� ���ҵ��� ������ �����ؾ� �մϴ�. ���� ���,
	
	arr = [1, 1, 3, 3, 0, 1, 1] �̸� [1, 3, 0, 1] �� return �մϴ�.
	arr = [4, 4, 4, 3, 3] �̸� [4, 3] �� return �մϴ�.
	�迭 arr���� ���������� ��Ÿ���� ���ڴ� �����ϰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���.
 * 
 * 	Solution : 1. ������ �ϳ� ������ְ� ù���翡�� arr[0]�� �־���
 * 			   2. for�� ���鼭 ���� ���� ��, stack�� ���� ��������
 * 			   3. ���� ���� ���� arr�� ��ȯ
 * 
 * */

public class Solution {

	public Stack<Integer> stack = new Stack<Integer>();
	
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        stack.push(arr[0]);
        for(int i=0; i<arr.length; i++) {
			if(!stack.peek().equals(arr[i])) {
				stack.push(arr[i]);	
			}
        }
        
        answer = stack.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] arr = {1, 1, 3, 3, 0, 1, 1};
		System.out.println(sol.solution(arr));
	}
}
