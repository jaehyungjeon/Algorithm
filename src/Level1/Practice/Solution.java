package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Question : 
	�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.
	
	1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	
	1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, ���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 	Solution : 1. ��� ����� �ϵ��ڵ� �������� �迭�� ����
 * 			   2. ��ġ�ϴ� �Ϳ� �°� �������� ī��Ʈ ����������
 * 			   3. ������� ���� max�� �̴´�.
 * 			   4. ������ �迭�� �ѹ� ��� sort�� ��������
 * 			   5. ����Ʈ�� �迭�� ��ȯ�� �� return
 * */

public class Solution {

	public List<Integer> num = new ArrayList<Integer>();
	
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int firstcount = 0;
        int secondcount = 0;
        int thirdcount = 0;
        
        int[] arr = new int[3];
        for(int i=0; i<answers.length; i++) {
        	if(answers[i] == first[i%5]) {
        		firstcount++;
        	}
        	
        	if(answers[i] == second[i%8]) {
        		secondcount++;
        	}
        	
        	if(answers[i] == third[i%10]) {
        		thirdcount++;
        	}
        	
        	arr[0] = firstcount;
        	arr[1] = secondcount;
        	arr[2] = thirdcount;
        }
        
        int maxValue = Math.max(Math.max(firstcount, secondcount), thirdcount);
        if(maxValue == firstcount) num.add(1);
        if(maxValue == secondcount) num.add(2);
        if(maxValue == thirdcount) num.add(3);
        
        Collections.sort(num);
        answer = num.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int[] answers = {1,3,2,4,2};
		System.out.println(sol.solution(answers));
	}
}
