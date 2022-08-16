package Level2.Fatigue;

import java.util.*;

/*
 * Question : 
	XX���ӿ��� �Ƿε� �ý���(0 �̻��� ������ ǥ���մϴ�)�� ������, ���� �Ƿε��� ����ؼ� ������ Ž���� �� �ֽ��ϴ�. 
	�̶�, �� �������� Ž���� �����ϱ� ���� �ʿ��� "�ּ� �ʿ� �Ƿε�"�� ���� Ž���� ������ �� �Ҹ�Ǵ� "�Ҹ� �Ƿε�"�� �ֽ��ϴ�. 
	"�ּ� �ʿ� �Ƿε�"�� �ش� ������ Ž���ϱ� ���� ������ �־�� �ϴ� �ּ����� �Ƿε��� ��Ÿ����, "�Ҹ� �Ƿε�"�� ������ Ž���� �� �Ҹ�Ǵ� �Ƿε��� ��Ÿ���ϴ�. 
	���� ��� "�ּ� �ʿ� �Ƿε�"�� 80, "�Ҹ� �Ƿε�"�� 20�� ������ Ž���ϱ� ���ؼ��� ������ ���� ���� �Ƿε��� 80 �̻� �̾�� �ϸ�, ������ Ž���� �Ŀ��� �Ƿε� 20�� �Ҹ�˴ϴ�.

	�� ���ӿ��� �Ϸ翡 �� ���� Ž���� �� �ִ� ������ ������ �ִµ�, �� ������ ���� �� �������� �ִ��� ���� Ž���Ϸ� �մϴ�. 
	������ ���� �Ƿε� k�� �� ������ "�ּ� �ʿ� �Ƿε�", "�Ҹ� �Ƿε�"�� ��� 2���� �迭 dungeons �� �Ű������� �־��� ��, ������ Ž���Ҽ� �ִ� �ִ� ���� ���� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. dfs�� �̿��� Ǯ�� - ��� ���̽��� ���غ��ڴ�.
 * 			   2. dfs�� depth => Ž���� �� �ִ� �ִ� ���� ��
 * 			   3. k -> �Ƿε� �̹Ƿ�, �ѹ� ������ 2��° �迭�� ���� ���� �ٽ� dfs ������.
 * 
 * */

public class Solution {

	public int answer = 0;
	public boolean[] visit;
	
    public int solution(int k, int[][] dungeons) {
    	visit = new boolean[dungeons.length];
    	
    	dfs(0, k, dungeons);
    	
        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
    	for(int i=0; i<dungeons.length; i++) {
    		if(!visit[i] && dungeons[i][0] <= k) {
    			visit[i] = true;
    			dfs(depth + 1, k - dungeons[i][1], dungeons);
    			visit[i] = false;
    		}
    	}
    	
    	answer = Math.max(answer, depth);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int k = 80;
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		System.out.println(sol.solution(k, dungeons));
	}
}