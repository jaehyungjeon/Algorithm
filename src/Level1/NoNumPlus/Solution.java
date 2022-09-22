package Level1.NoNumPlus;

import java.util.ArrayList;
import java.util.List;

/*
 * Question : 
	0���� 9������ ���� �� �Ϻΰ� ����ִ� ���� �迭 numbers�� �Ű������� �־����ϴ�.
	numbers���� ã�� �� ���� 0���� 9������ ���ڸ� ��� ã�� ���� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. for�� ������ 0~9���� �� ���°� +��Ų��.
 * */

public class Solution {
    
	public int solution(int[] numbers) {
        int answer = 0;
        
        List<Integer> map = new ArrayList<Integer>();
        for(int num : numbers) {
        	map.add(num);
        }
        
        for(int i=0; i<=9; i++) {
        	if(!map.contains(i)) {
        		answer+=i;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] numbers = {1,2,3,4,6,7,8,0};
		System.out.println(sol.solution(numbers));
	}
}
