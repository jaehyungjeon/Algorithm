package Level1.TwoNumPlus;

import java.util.Arrays;
import java.util.HashSet;

/*
 * Question : 
	���� �迭 numbers�� �־����ϴ�. 
	numbers���� ���� �ٸ� �ε����� �ִ� �� ���� ���� �̾� ���ؼ� ���� �� �ִ� ��� ���� �迭�� ������������ ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. for������ ���� ���ְ�..
 * 			   2. HaseSet �̿��ؼ� �ߺ� �����Ѵ���
 * 			   3. java Stream �̿��Ͽ� ���� �� �迭�� ���� �� �� return
 * 
 * */

public class Solution {

	public HashSet<Integer> set = new HashSet<Integer>();
	
    public int[] solution(int[] numbers) {
        int[] answer = {};
        
        Arrays.sort(numbers);
        
        for(int i=0; i<numbers.length; i++) {
        	for(int j=i+1; j<numbers.length; j++) {
        		set.add(numbers[i] + numbers[j]);
        	}
        }
        
        answer = set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] numbers = {5,0,2,7};
		System.out.println(sol.solution(numbers));
	}
}
