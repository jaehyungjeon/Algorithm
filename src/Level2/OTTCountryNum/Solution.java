package Level2.OTTCountryNum;

import java.util.*;

/*
 * Question : 
	124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
	
	124 나라에는 자연수만 존재합니다.
	124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
	예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.
	
	10진법	124 나라	10진법	124 나라
	1	1	6	14
	2	2	7	21
	3	4	8	22
	4	11	9	24
	5	12	10	41
	자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 * 
 * 
 * 	Solution : 1. 나누었을 때, 순서대로 들어갈 값들을 셋팅 -> 4, 1, 2
 * 			   2. 스트링 값을 이어붙이는 방식으로 나누기를 했을 때의 결과를 본다.
 * 			   3. n-1을 해줌으로써 해당 자리에 맞게끔 셋팅한다. 
 * 
 * */

public class Solution {

    public String solution(int n) {
    	String[] num = {"4", "1", "2"};
        String answer = "";
        
        while(n > 0) {
        	answer = num[n%3] + answer;
        	n = (n - 1)/3;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 4;
		System.out.println(sol.solution(n));
	}
}