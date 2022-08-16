package Level2.Carpet;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	Leo�� ī���� �緯 ���ٰ� �Ʒ� �׸��� ���� �߾ӿ��� ��������� ĥ���� �ְ� �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.
	
	carpet.png
	
	Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� ������� �������� ��ĥ�� ������ ������ ���������, ��ü ī���� ũ��� ������� ���߽��ϴ�.
	
	Leo�� �� ī�꿡�� ���� ������ �� brown, ����� ������ �� yellow�� �Ű������� �־��� �� ī���� ����, ���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * 	Solution : 1. height�� �ּ� 3���� ����-> ���̿� yellow�� ���������� �ּ� 3���� �־����
 * 			   2. ���̴� �հ��� �����ٱ����� ���� -> �Ѿ�� height > width ��������
 * 			   3. ����Ʈ�� (height-2) * (width-2) �κ� -> �ڽ����� ���ΰ� 2��, ���ΰ� 2�� �� ���� ����
 * 
 * */

public class Solution {

    public int[] solution(int brown, int yellow) {
    	int[] answer = {};
        
        int sum = brown + yellow;
        int height = 0;
        int width = 0;
        
        for(height=3; height<=(int)Math.sqrt(sum); height++) {
        	if(sum % height == 0) {
        		width = sum/height;
        		
        		if((height-2) * (width-2) == yellow) {
        			answer = new int[] {width, height};
        		}
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int brown = 10;
		int yellow = 2;
		System.out.println(sol.solution(brown, yellow));
	}
}