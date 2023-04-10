package Level2.TableHashFunc;

import java.util.Arrays;

/*
 * Question : 
	��ȣ�� �����ϴ� � �����ͺ��̽��� �� ���̺��� ��� ���� Ÿ���� �÷���� �̷���� �ֽ��ϴ�. ���̺��� 2���� ��ķ� ǥ���� �� ������ ���� �÷��� ��Ÿ����, ���� Ʃ���� ��Ÿ���ϴ�.
	ù ��° �÷��� �⺻Ű�μ� ��� Ʃ�ÿ� ���� �� ���� �ߺ����� �ʵ��� ����˴ϴ�. ��ȣ�� �� ���̺� ���� �ؽ� �Լ��� ������ ���� �����Ͽ����ϴ�.
	
	�ؽ� �Լ��� col, row_begin, row_end�� �Է����� �޽��ϴ�.
	���̺��� Ʃ���� col��° �÷��� ���� �������� �������� ������ �ϵ�, ���� �� ���� �����ϸ� �⺻Ű�� ù ��° �÷��� ���� �������� �������� �����մϴ�.
	���ĵ� �����Ϳ��� S_i�� i ��° ���� Ʃ�ÿ� ���� �� �÷��� ���� i �� ���� ���������� ������ �����մϴ�.
	row_begin �� i �� row_end �� ��� S_i�� �����Ͽ� bitwise XOR �� ���� �ؽ� �����μ� ��ȯ�մϴ�.
	���̺��� ������ data�� �ؽ� �Լ��� ���� �Է� col, row_begin, row_end�� �־����� �� ���̺��� �ؽ� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	Solution : 1. ������ ���� �ǽ� -> Arrays.sort
 * 			   2. mod ���ϱ�
 * 			   3. XOR (^) ����
 * */

public class Solution {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        col -= 1;
        row_begin -= 1;
        
        int endCol = col;
        Arrays.sort(data, (o1, o2) -> {
        	if(o1[endCol] == o2[endCol]) return o2[0] - o1[0]; // �������� ����
        	return o1[endCol] - o2[endCol];
        });

        for(int i=row_begin; i<row_end; i++) {
        	int row = i+1;
        	int total = Arrays.stream(data[i]).map(o -> o % row).sum(); // S_i Mod
        	
        	// XOR
        	answer = (answer ^ total);
        }
        
        return answer;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
		int col = 2;
		int row_begin = 2;
		int row_end = 3;
		System.out.println(sol.solution(data, col, row_begin, row_end));
	}
}