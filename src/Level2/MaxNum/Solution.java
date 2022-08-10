package Level2.MaxNum;

import java.util.*;

/*
 * Question : 
	0 �Ǵ� ���� ������ �־����� ��, ������ �̾� �ٿ� ���� �� �ִ� ���� ū ���� �˾Ƴ� �ּ���.
	���� ���, �־��� ������ [6, 10, 2]��� [6102, 6210, 1062, 1026, 2610, 2106]�� ���� �� �ְ�, ���� ���� ū ���� 6210�Դϴ�.
	0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��, ������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * 	Solution : 1. Arrays.sort�� ���� ū ����Ʈ -> �� ���� ���ϸ鼭 ū�ͺ��� �������� �����ϴ� �ڵ�
 * 
 * */

public class Solution {
	
	Queue<Integer> q = new LinkedList<Integer>();
	
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr  = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
        	arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, new Comparator<String>() {

        	@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2+o1).compareTo(o1+o2);
			}
        });
        
        if(arr[0].equals("0")) return "0";
        
        for(String s : arr) {
        	answer += s;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(sol.solution(numbers));
	}
}