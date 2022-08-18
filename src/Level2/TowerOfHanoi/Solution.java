package Level2.TowerOfHanoi;

import java.util.*;
import java.util.Map.Entry;

/*
 * Question : 
	�ϳ��� ž(Tower of Hanoi)�� ������ �����Դϴ�. �� ���� ��հ� �� �⵿�� ���� �� �ִ� ũ�Ⱑ �پ��� ���ǵ��� �ְ�, 
	������ �����ϱ� ������ �� ��տ� ���ǵ��� ���� ���� ���� �ֵ��� ������� �׿� �ֽ��ϴ�. 
	������ ������ ���� �� ���� ������ ������Ű�鼭, �� ��տ� ���� ���ǵ��� �� ���� �״�� �ٸ� ������� �Űܼ� �ٽ� �״� ���Դϴ�.

	�� ���� �ϳ��� ���Ǹ� �ű� �� �ֽ��ϴ�.
	ū ������ ���� ���� ���� �־�� �ȵ˴ϴ�.
	�ϳ��� ž�� �� ���� ����� ���� ���� 1��, 2��, 3���̶�� �ϰڽ��ϴ�. 1������ n���� ������ �ְ� �� n���� ������ 3�� �������� �ּ� Ƚ���� �ű���� �մϴ�.
	
	1�� ��տ� �ִ� ������ ���� n�� �Ű������� �־��� ��, n���� ������ 3�� �������� �ּҷ� �ű�� ����� return�ϴ� solution�� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. �ϳ����� ž�� ��͸� �̿��Ͽ� ���Ѵ�.
 * 			   2. A -> B�� ���� ���̽�, B -> C�� ���� ���̽�, A->C
 * 
 * */

public class Solution {

    public static List<int[]> list = new ArrayList<int[]>();
	
    public int[][] solution(int n) {
        Hanoi(n,1,2,3);
        int[][] answer = new int[list.size()][2];
        
        for(int i=0; i<list.size(); i++) {
        	answer[i][0] = list.get(i)[0];
        	answer[i][1] = list.get(i)[1];
        }
        
        return answer;
    }
    
	public static void Hanoi(int N, int start, int mid, int to) {
		int[] move = {start, to};
		
		if (N == 1) {
			// CASE 2 : 1 -> 3 ����
			list.add(move);
		} else {
			// A -> B (1 -> 2)
			Hanoi(N - 1, start, to, mid);
			
			// CASE 1 : 1 -> 2 ����, CASE 3 : 2 -> 3 ����  
			list.add(move);
	    
			// B -> C (2 -> 3)
			Hanoi(N - 1, mid, start, to);
		}
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 2;
		System.out.println(sol.solution(n));
	}
}