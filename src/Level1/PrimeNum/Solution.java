package Level1.PrimeNum;

import java.util.ArrayList;
import java.util.List;

import PrimeNum.Solution;

/*
 * Question : 
	�־��� ���� �� 3���� ���� ������ �� �Ҽ��� �Ǵ� ����� ������ ���Ϸ��� �մϴ�.
	���ڵ��� ����ִ� �迭 nums�� �Ű������� �־��� ��, nums�� �ִ� ���ڵ� �� ���� �ٸ� 3���� ��� ������ �� �Ҽ��� �Ǵ� ����� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. ��� ��ġ�� ����� ���� ��´�.
 * 			   2. �������� 0�� �Ǵ� ���̽��� ��Ƽ�
 * 			   3. 2���� �� ��쿡 answer++;
 * */

public class Solution {

    public int solution(int[] nums) {
        int answer = 0;

        List<Integer> num = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++) {
        	for(int j=i+1; j<nums.length; j++) {
        		for(int k=j+1; k<nums.length;k++) {
        			num.add(nums[i] + nums[j] + nums[k]);
        		}
        	}
        }
        
        int[] count = new int[num.size()];
        for(int i=0; i<num.size(); i++) {
        	for(int j=0; j<num.get(i); j++) {
        		int remain = num.get(i) % (j+1);
        		if(remain == 0) {
        			count[i] += 1;
        		}
        	}
        	if(count[i] == 2) {
        		answer++;
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] nums = {1,2,3,4};
		System.out.println(sol.solution(nums));
	}
}
