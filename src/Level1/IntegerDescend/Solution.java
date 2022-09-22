package Level1.IntegerDescend;

import java.util.*;

/*
 * Question : 
	�Լ� solution�� ���� n�� �Ű������� �Է¹޽��ϴ�. 
	n�� �� �ڸ����� ū�ͺ��� ���� ������ ������ ���ο� ������ �������ּ���. ������� n�� 118372�� 873211�� �����ϸ� �˴ϴ�.
 * 
 * 	Solution : 1. ���� �޾Ƽ� �������� ����
 * 			   2. ��Ʈ������ �������� �� ++
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
        
        /* ���� ���ϴ� �ڵ� */
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
