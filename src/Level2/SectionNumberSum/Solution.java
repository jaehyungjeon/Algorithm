package Level2.SectionNumberSum;

import java.util.*;

/*
 * Question : 
	철호는 수열을 가지고 놀기 좋아합니다. 어느 날 철호는 어떤 자연수로 이루어진 원형 수열의 연속하는 부분 수열의 합으로 만들 수 있는 수가 모두 몇 가지인지 알아보고 싶어졌습니다. 
	원형 수열이란 일반적인 수열에서 처음과 끝이 연결된 형태의 수열을 말합니다. 예를 들어 수열 [7, 9, 1, 1, 4] 로 원형 수열을 만들면 다음과 같습니다.
	원형 수열은 처음과 끝이 연결되어 끊기는 부분이 없기 때문에 연속하는 부분 수열도 일반적인 수열보다 많아집니다.
	원형 수열의 모든 원소 elements가 순서대로 주어질 때, 원형 수열의 연속 부분 수열 합으로 만들 수 있는 수의 개수를 return 하도록 solution 함수를 완성해주세요.
 *	
 *	output : 18
 * 
 * 	Solution : 1. 순회를 진행할 때 1, 2, 3, 4, 5 길이마다로 진행하는 것이 아닌 elements의 하나하나의 변화에 초점을 두어야 한다.
 * 			   2. start 변수 = 길이
 * 			   3. 중복된 합은 담지 않으므로 set을 사용
 * 			   4. while문 안에서 elements 마다의 길이 계산을 위한 for문 구현
 * 			   5. 값은 elements의 length를 초과할 시 오류가 발생하기 때문에 길이만큼 나눈 나머지값으로 세팅한다.
 * 			   6. 전체 갯수는 set안에 들어간 value의 사이즈 반환 
 *  
 * */

public class Solution {
	
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        int start = 1;
        while(start <= elements.length) {
        	for(int i=0; i<elements.length; i++) {
        		int val = 0;
        		for(int j=i; j<i + start; j++) {
        			val += elements[j % elements.length];
        		}
        		set.add(val);
        	}
        	
        	start++;
        }
        
        return set.size();
    }
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] elements = {7,9,1,1,4};
		System.out.println(sol.solution(elements));
	}
}