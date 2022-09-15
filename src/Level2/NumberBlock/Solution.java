package Level2.NumberBlock;

import java.util.*;

/*
 * Question : 
	�׷��ÿ��� 0���� �� ���ο� ���� ����� ��ġ�ϱ�� �Ͽ����ϴ�. ���� ����� ��Ģ�� ������ �����ϴ�.

	����� ��ȣ�� n �� ��, ���� ó�� ����� n * 2��° ��ġ�� ��ġ�մϴ�. �״����� n * 3, �״����� n * 4, ...�� �����մϴ�.���� ������ ����� ����ִ� �ڸ���� �� ��������� ���ο� ������� ����ֽ��ϴ�.
	
	���� ��� 1�� ����� 2,3,4,5, ... �� ��ġ�� �켱 ��ġ�մϴ�. �״��� 2�� ����� 4,6,8,10, ... �� ��ġ�� ��ġ�ϰ�, 3�� ����� 6,9,12... �� ��ġ�� ��ġ�մϴ�.
	
	�̷��� 3�� ��ϱ��� ��ġ�ϰ� ���� ù 10���� ����� 0, 1, 1, 2, 1, 3, 1, 2, 3, 2�̵˴ϴ�.
	
	�׷��ô� ���̰� 1,000,000,000�� ���ο� 1�� ��Ϻ��� �����Ͽ� 10,000,000�� ��ϱ��� ���� ��Ģ���� ��� ���ҽ��ϴ�.
	
	�׷����� ������� Ư�� ������ � ����� ��� �ִ��� �˰� �ͽ��ϴ�.
	
	������ ��Ÿ���� �� �� begin, end �� �Ű������� �־� �� ��, �� ������ ��� �ִ� ����� ���� �迭(����Ʈ)�� return�ϴ� solution �Լ��� �ϼ��� �ּ���.
 * 
 *  output : [0, 1, 1, 2, 1, 3, 1, 4, 3, 5]
 * 
 * 	Solution : 1. for���� �����鼭 �ش� ������ ������ �� �� �ִ� boolean ���� �ϳ� �����Ѵ�.
 * 			   2. ������ ��ġ ������ �ڱ��ڽ��� ������ n*2 ���� ���� ��ġ�� �Ǳ⶧���� sqrt(������)�� �̿��Ͽ� 1�̻��� ���̽����� �ݺ����� ���� �� �ֵ��� �Ѵ�.
 * 			   3. �迭�� ���� �־��ְ� flag�� true�� �����Ͽ� ���� ������ ���� �ʵ��� �Ѵ�.
 * 			   4. �����鼭 false�� ��쿡�� 1�� ������Ѵ�. -> 0��°�� ������ �������� 1�� �����ϱ� ����
 * 			   5. ����, ����Ǵ� �������� flag = true �� break, �ƴ� ��쿡�� 1�� ����
 * 
 * */

public class Solution {

    public int[] solution(long begin, long end) {
    	int Begin = (int)begin;
    	int End = (int)end;
        int[] answer = new int[End - Begin + 1];
        
        int idx = 0;
        for(int i=Begin; i<=End; i++) {
        	boolean flag = false;
        	
        	if(i == 1) {
        		answer[idx++] = 0;
        		continue;
        	}
        	
        	for(int j=2; j<=Math.sqrt(i); j++) {
                if (i % j == 0 && i / j <= 10000000) {
                    answer[idx++] = i/j;
                    flag = true;
                    break;
                }
        	}
        	
            if(!flag) answer[idx++] = 1;
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		long begin = 1;
		long end = 10;
		System.out.println(sol.solution(begin, end));
	}
}