package Level1.PrimeNum;

import java.util.ArrayList;
import java.util.List;

import PrimeNum.Solution;

/*
 * Question : 
	주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
	숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	Solution : 1. 모든 합치는 경우의 수를 담는다.
 * 			   2. 나머지가 0이 되는 케이스를 담아서
 * 			   3. 2가지 일 경우에 answer++;
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
