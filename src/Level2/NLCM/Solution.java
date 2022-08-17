package Level2.NLCM;

/*
 * Question : 
	�� ���� �ּҰ����(Least Common Multiple)�� �Էµ� �� ���� ��� �� ������ �Ǵ� ���� ���� ���ڸ� �ǹ��մϴ�. 
	���� ��� 2�� 7�� �ּҰ������ 14�� �˴ϴ�. ���Ǹ� Ȯ���ؼ�, n���� ���� �ּҰ������ n ���� ������ ��� �� ������ �Ǵ� ���� ���� ���ڰ� �˴ϴ�. 
	n���� ���ڸ� ���� �迭 arr�� �ԷµǾ��� �� �� ������ �ּҰ������ ��ȯ�ϴ� �Լ�, solution�� �ϼ��� �ּ���.
 * 
 * 
 * 	Solution : 1. �ִ������� ���ϴ� gcd
 * 			   2. ���� ���� �ִ� ������� ������ �ذ͵��� ���Ѵ�. -> �ּ� �����
 * 
 * */

public class Solution {

    public int solution(int[] arr) {
        int answer = arr[0];
        
        for(int i=1; i<arr.length; i++) {
        	int gcd = gcd(answer, arr[i]);
        	
        	answer = answer * arr[i] / gcd;
        }
        
        return answer;
    }
    
    public static int gcd(int a, int b) {
    	int x = Math.max(a, b);
    	int y = Math.min(a, b);
    	
    	while(x % y != 0) {
    		int r = x % y;
    		x = y;
    		y = r;
    	}
    	
    	return y;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] arr = {1,2,3};
		System.out.println(sol.solution(arr));
	}
}