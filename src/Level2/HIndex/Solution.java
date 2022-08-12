package Level2.HIndex;

import java.util.*;

/*
 * Question : 
	H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
	어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
	어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * 	Solution : 1. 오름차순으로 정렬 후, 해당 인덱스의 수가 h이상이면 논리에 맞으므로 리턴시킨다.
 * 
 * */

public class Solution {

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        for(int i=0; i<citations.length; i++) {
        	int h = citations.length - i;
        	
        	if(citations[i] >= h) {
        		return h;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(sol.solution(citations));
	}
}