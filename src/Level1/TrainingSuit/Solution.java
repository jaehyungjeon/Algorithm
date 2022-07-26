package TrainingSuit;

import java.util.Arrays;

/*
 * Question : 
	점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
	학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
	예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
	체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
	
	전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
	체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
 * 
 * 	Solution : 1. 체육복 도난 번호와 여벌 번호가 일치하면 answer++; 값은 미할당 값으로(-1)
 * 			   2. 도난번호가 여벌 번호 +- 1이면, answer++; 값은 미할당 값으로(-1)
 * 			   3. 첫번째 테스트로 정렬없이 시행했을 때 테스트 케이스 에러가 나왔었음...
 * 			   4. lost, reserve 모두 오름차순 정렬
 * 			   5. 정렬을 하지 않으면 일부 lost 누락으로 기댓값이 더 크게 나오는 오류가 있었음.
 * */

public class Solution {

    public int solution(int n, int[] lost, int[] reserve) {
    	int answer = n - lost.length;
    	
    	Arrays.sort(lost);
    	Arrays.sort(reserve);
    	
    	for(int i=0; i<lost.length; i++) {
    		for(int j=0; j<reserve.length; j++) {
    			if(lost[i] == reserve[j]) { // 여벌 번호와 분실 번호가 같을 경우
    				answer++;
    				reserve[j] = -1;
    				lost[i] = -1;
    				break;
    			}
    		}
    	}
    	
    	for(int i=0; i<lost.length; i++) {
    		for(int j=0; j<reserve.length; j++) {
    			if((lost[i] == (reserve[j]-1) || lost[i] == (reserve[j]+1)) && reserve[j] > 0) {
    				answer++;
    				reserve[j] = -1;
    				lost[i] = -1;
    				break;
    			}
    		}
    	}
    	
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 5;
    	int[] lost = {2, 4};
    	int[] reserve = {3};
		System.out.println(sol.solution(n, lost, reserve));
	}
}
