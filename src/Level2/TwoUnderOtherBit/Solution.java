package Level2.TwoUnderOtherBit;

/*
 * Question : 
	���� ���� x�� ���� �Լ� f(x)�� ������ ���� �����մϴ�.

	x���� ũ�� x�� ��Ʈ�� 1~2�� �ٸ� ���� �߿��� ���� ���� ��
	���� ���,
	
	f(2) = 3 �Դϴ�. ���� ǥ�� ���� 2���� ū ���� �߿��� ��Ʈ�� �ٸ� ������ 2�� �����̸鼭 ���� ���� ���� 3�̱� �����Դϴ�.
	��	��Ʈ	�ٸ� ��Ʈ�� ����
	2	000...0010	
	3	000...0011	1
	f(7) = 11 �Դϴ�. ���� ǥ�� ���� 7���� ū ���� �߿��� ��Ʈ�� �ٸ� ������ 2�� �����̸鼭 ���� ���� ���� 11�̱� �����Դϴ�.
	��	��Ʈ	�ٸ� ��Ʈ�� ����
	7	000...0111	
	8	000...1000	4
	9	000...1001	3
	10	000...1010	3
	11	000...1011	2
	�������� ��� �迭 numbers�� �Ű������� �־����ϴ�. numbers�� ��� ���鿡 ���Ͽ� �� ���� f ���� �迭�� ���ʴ�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	output : [3,11]
 * 
 * 	Solution : 1. ���ͳ� ����..
 * 			   2. ¦�� -> +1�� ���ָ� ��
 * 			   3. Ȧ���� ���, ���̽��� �и��ϴµ� 0�� ���� ���̽��� ã�Ƽ� 0�� insert ó��
 * 			   4. 0�� �ִ� ���̽������� ó���� ���� �ε����� ã�� StringBuilder�� �̿��Ͽ� ������ ����
 * 			   5. �������� �ڿ����� ��ȯ�Ͽ� ����
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