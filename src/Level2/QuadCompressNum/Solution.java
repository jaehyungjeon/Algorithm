package Level2.QuadCompressNum;

import java.util.*;

/*
 * Question : 
	0�� 1�� �̷���� 2n x 2n ũ���� 2���� ���� �迭 arr�� �ֽ��ϴ�. ����� �� arr�� ���� Ʈ���� ���� ������� �����ϰ��� �մϴ�. ��ü���� ����� ������ �����ϴ�.

	����� �����ϰ��� �ϴ� Ư�� ������ S��� �����մϴ�.
	���� S ���ο� �ִ� ��� ���� ���� ���̶��, S�� �ش� �� �ϳ��� �����ŵ�ϴ�.
	�׷��� �ʴٸ�, S�� ��Ȯ�� 4���� ������ ���簢�� ����(����� ���� �������ֽñ� �ٶ��ϴ�.)���� �ɰ� ��, �� ���簢�� ������ ���� ���� ����� ������ �õ��մϴ�.
	arr�� �Ű������� �־����ϴ�. ���� ���� ������� arr�� �������� ��, �迭�� ���������� ���� 0�� ������ 1�� ������ �迭�� ��Ƽ� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 	output : [10, 15]
 * 
 * 	Solution : 1. DP�� �̿�
 * 			   2. ũ�Ⱑ 1�̸�(���� x) �ش� ������ ī��Ʈ ����
 * 			   3. check�� ���� �ش� �������� ����� �´��� ��
 * 			   4. �����Ͽ� ��� �ݺ�(quad ���)
 * 
 * */

public class Solution {
	int[] answer;
	
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        quad(arr.length, 0, 0, arr);
        
        for(int a : answer) {
        	System.out.println(a);
        }
        
        return answer;
    }
    
    public void quad(int x, int y, int z, int[][] arr) {
    	if(x == 1) {
    		answer[arr[y][z]]++;
    		return;
    	}
    	
    	if(check(x, y, z, arr)) return;
    	
    	quad(x/2, y, z, arr);
    	quad(x/2, y + x/2, z, arr);
    	quad(x/2, y, z + x/2, arr);
    	quad(x/2, y + x/2, z + x/2, arr);
    }
    
    public boolean check(int x, int y, int z, int[][] arr) {
    	for(int i=y; i<y+x; i++) {
    		for(int j=z; j<z+x; j++) {
    			if(arr[y][z] != arr[i][j]) return false;
    		}
    	}
    	
    	answer[arr[y][z]]++;
    	return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
		System.out.println(sol.solution(arr));
	}
}