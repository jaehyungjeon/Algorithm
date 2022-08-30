package Level2.TwoUnderOtherBit;

/*
 * Question : 
	양의 정수 x에 대한 함수 f(x)를 다음과 같이 정의합니다.

	x보다 크고 x와 비트가 1~2개 다른 수들 중에서 제일 작은 수
	예를 들어,
	
	f(2) = 3 입니다. 다음 표와 같이 2보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 3이기 때문입니다.
	수	비트	다른 비트의 개수
	2	000...0010	
	3	000...0011	1
	f(7) = 11 입니다. 다음 표와 같이 7보다 큰 수들 중에서 비트가 다른 지점이 2개 이하이면서 제일 작은 수가 11이기 때문입니다.
	수	비트	다른 비트의 개수
	7	000...0111	
	8	000...1000	4
	9	000...1001	3
	10	000...1010	3
	11	000...1011	2
	정수들이 담긴 배열 numbers가 매개변수로 주어집니다. numbers의 모든 수들에 대하여 각 수의 f 값을 배열에 차례대로 담아 return 하도록 solution 함수를 완성해주세요.
 * 
 * 	output : [3,11]
 * 
 * 	Solution : 1. 인터넷 참고..
 * 			   2. 짝수 -> +1만 해주면 됨
 * 			   3. 홀수인 경우, 케이스를 분리하는데 0이 없는 케이스는 찾아서 0을 insert 처리
 * 			   4. 0이 있는 케이스에서는 처음과 끝의 인덱스를 찾고 StringBuilder를 이용하여 조합을 해줌
 * 			   5. 빌더값을 자연수로 변환하여 리턴
 * 
 * */

public class Solution {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	if(numbers[i] % 2 == 0) {
        		answer[i] = numbers[i] + 1;
        	} else {
        		StringBuilder sb = new StringBuilder();
        		String Binary = Long.toBinaryString(numbers[i]);
        		
        		if(!Binary.contains("0")) {
        			sb.append("10");
        			
        			sb.append(Binary.substring(1).replace("0", "1"));
        		} else {
        			int last = Binary.lastIndexOf("0");
        			int first = Binary.indexOf("1", last);
        			
        			sb.append(Binary, 0, last).append("1");
        			
        			sb.append("0");
        			
        			sb.append(Binary.substring(first + 1));
        		}
        		
        		answer[i] = Long.parseLong(sb.toString(), 2);
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		long[] numbers = {2,7};
		System.out.println(sol.solution(numbers));
	}
}