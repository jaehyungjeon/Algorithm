package PlusMinusMerge;

/*
 * Question : 
	어떤 정수들이 있습니다. 이 정수들의 절댓값을 차례대로 담은 정수 배열 absolutes와 이 정수들의 부호를 차례대로 담은 불리언 배열 signs가 매개변수로 주어집니다.
 	실제 정수들의 합을 구하여 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	Solution : 1. sign이 음수면 -1 곱하고 더한다.
 * */

public class Solution {

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i=0; i<absolutes.length; i++) {
        	if(!signs[i]) { // 음수
        		answer += absolutes[i] * -1;
        	} else {
        		answer += absolutes[i];
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] absolutes = {4,7,12};
    	boolean[] signs = {true,false,true};
		System.out.println(sol.solution(absolutes, signs));
	}
}
