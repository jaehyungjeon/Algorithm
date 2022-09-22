package Level1.MinRemove;

import java.util.*;

/*
 * Question : 
	정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
	단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
	예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
 * 
 * 	Solution : 1. 갯수가 1이면 최솟값 뺐을 경우 없으므로 -1 리턴
 * 			   2. 아닐 경우, 최솟값을 뽑는 스트림
 * 			   3. 필터로 최솟값을 제외한 나머지를 배열에 담아 리턴
 *  
 * */

public class Solution {
	
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        if(arr.length <= 1) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            int min = Arrays.stream(arr).min().getAsInt(); // 최솟값
            answer = Arrays.stream(arr).filter(idx -> idx != min).toArray();
        }
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] arr = {4, 3, 2, 1};
		System.out.println(sol.solution(arr));
	}
}
