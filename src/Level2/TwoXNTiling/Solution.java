package Level2.TwoXNTiling;

/*
 * Question : 
	���� ���̰� 2�̰� ������ ���̰� 1�� ���簢������� Ÿ���� �ֽ��ϴ�. �� ���簢�� Ÿ���� �̿��Ͽ� ������ ���̰� 2�̰� ������ ���̰� n�� �ٴ��� ���� ä����� �մϴ�. 
	Ÿ���� ä�� ���� ������ ���� 2���� ����� �ֽ��ϴ�.

	Ÿ���� ���η� ��ġ �ϴ� ���
	Ÿ���� ���η� ��ġ �ϴ� ���
	������ n�� 7�� ���簢���� ������ ���� ä�� �� �ֽ��ϴ�.
	
	���簢���� ������ ���� n�� �Ű������� �־��� ��, �� ���簢���� ä��� ����� ���� return �ϴ� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. �Ǻ���ġ�� �̿��ϴ� ���� -> �Լ��� ���� �ð��ʰ�
 * 			   2. for���� �̿��Ͽ� ������ -> 0��° �迭�� ��, 1��° �迭�� ���� ���� 1,2�� �ʱ�ȭ
 * 			   3. �������� for��
 * 
 * */

public class Solution {

	public static int answer = 0;
	
    public int solution(int n) {
        return Fibonacci(n);
    }
    
    public static int Fibonacci(int n) {
    	int[] arr = new int[n];
    	arr[0] = 1;
    	arr[1] = 2;
    	
		for(int i=2; i<n; i++) {
			int num = arr[i-1] + arr[i-2];
			arr[i] = num % 1000000007;
		}
    	
    	return arr[n-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 4;
		System.out.println(sol.solution(n));
	}
}