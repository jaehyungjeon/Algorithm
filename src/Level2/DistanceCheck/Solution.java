package Level2.DistanceCheck;

import java.util.*;

/*
 * Question : 
	�����ڸ� ����ϴ� �Ҹ��� īī���� ������ ���� �Խ��ϴ�.

	�ڷγ� ���̷��� ���� ������ ���� �����ڵ��� �Ÿ��� �ּ� ��⸦ �ؾ��ϴµ� ���� ���� ������ ��ŭ
	�Ʒ��� ���� ��Ģ���� ���ǿ� �Ÿ��� �ΰ� �ɵ��� �ȳ��ϰ� �ֽ��ϴ�.
	
	������ 5���̸�, �� ������ 5x5 ũ���Դϴ�.
	�Ÿ��α⸦ ���Ͽ� �����ڵ� ������ ����ư �Ÿ�1�� 2 ���Ϸ� ���� ���� �ּ���.
	�� �����ڰ� �ɾ��ִ� �ڸ� ���̰� ��Ƽ������ ���� ���� ��쿡�� ����մϴ�.
	���� ���,
	
	5���� ������ �� �Ҹ���� �� ���ǿ��� �����ڵ��� �Ÿ��α⸦ �� ��Ű�� �ִ��� �˰� �;������ϴ�. 
	�ڸ��� �ɾ��ִ� �����ڵ��� ������ ���� ������ ���Ǻ��� ���� 2���� ���ڿ� �迭 places�� �Ű������� �־����ϴ�. 
	�� ���Ǻ��� �Ÿ��α⸦ ��Ű�� ������ 1��, �� ���̶� ��Ű�� �ʰ� ������ 0�� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ��� �ּ���.
	
	Rule : �����ڰ� �ɾ��ִ� �ڸ�(P)�� �ǹ��մϴ�. �� ���̺�(O)�� �ǹ��մϴ�. ��Ƽ��(X)�� �ǹ��մϴ�.
 * 
 * 	Solution : 1. ��ĭ�� ���̿� �ΰ�, X�� ���е��� ���� �� 0�� ����
 *			   2. ������ ������ �� BFS�˰��� �̿��ؾ� �� ��.
 *			   3. BFS�� �ݺ��̱�� �ѵ�.. ���ǵ��� ���ϴ� ����� ��¥ ���� ������
 *			   4. �Ÿ�2, �밢���� ���ϴ� ������ ���� �����ҵ�
 *			   5. ��ü������ �ѹ� �� ���� �͵� ������ ������ٰ� �� -> 36��° ����
 * 
 * */

public class Solution {
	
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int t=0; t<places.length; t++) {
        	String[] tmp = places[t];
        	boolean check = false;
        	
	    	for(int i=0; i<places.length; i++) {
	        	for(int j=0; j<places[i].length; j++) {
	        		if(tmp[i].charAt(j) == 'P') {
	        			if(bfs(i, j, tmp)) {
	        				check = true;
	        				break;
	        			}
	        		}
	        	}
	        	if(check) {
	        		answer[t] = 0;
	        		break;
	        	}
	        }
	    	if(!check) {
	    		answer[t] = 1;
	    	}
        }
        
        return answer;
    }
    
    public static boolean bfs(int i, int j, String[] tmp) {
    	//�����¿�
    	int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    	
    	for(int[] d : dir) {
    		int nr = i + d[0];
    		int nc = j + d[1];
    		
    		if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
			if(tmp[nr].charAt(nc) == 'P') return true;
    	}
    	
    	// �Ÿ� 2
    	int[][] dir2 = new int[][]{{-2,0},{2,0},{0,-2},{0,2}};
    	for(int[] d : dir2) {
    		int nr = i + d[0];
    		int nc = j + d[1];
    		
    		if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
    		if(tmp[nr].charAt(nc) == 'P') {
    			if(tmp[(i+nr)/2].charAt((j+nc)/2) != 'X') {
    				return true;
    			}
    		}
    	}
    	
    	// �밢��
    	int[][] dir3 = new int[][]{{-1,-1},{-1,1},{1,-1},{1,1}};
    	for(int[] d : dir3) {
    		int nr = i + d[0];
    		int nc = j + d[1];
    		
    		if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;
    		if(tmp[nr].charAt(nc) == 'P') {
    			if(!(tmp[i].charAt(nc) == 'X' && tmp[nr].charAt(j) == 'X')) {
    				return true;
    			}
    		}
    	}
    	
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(sol.solution(places));
	}
}