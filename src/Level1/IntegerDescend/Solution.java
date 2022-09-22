package Level1.IntegerDescend;

import java.util.*;

/*
 * Question : 
	함수 solution은 정수 n을 매개변수로 입력받습니다. 
	n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.
 * 
 * 	Solution : 1. 값을 받아서 내림차순 정렬
 * 			   2. 스트링에다 내림차순 값 ++
 * 			   3. parsing
 *  
 * */

public class Solution {

    public long solution(long n) {
        long answer = 0;
        String[] arr = String.valueOf(n).split("");
        
        long[] tmpArr = new long[arr.length];
        tmpArr = Arrays.stream(arr).sorted(Collections.reverseOrder()).mapToLong(Long::parseLong).toArray();
        
        String tmp = "";
        for(long a : tmpArr) {
        	tmp += String.valueOf(a);
        }
        
        answer = Long.parseLong(tmp);
        return answer;
        
        /* 내가 원하던 코딩 */
//        return Long.parseLong(String.valueOf(n).chars().mapToObj(ch -> (char) ch)
//                .sorted(Comparator.reverseOrder())
//                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
//                .toString());
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	long n = 118372;
		System.out.println(sol.solution(n));
	}
}
