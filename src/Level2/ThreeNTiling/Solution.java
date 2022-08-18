package Level2.ThreeNTiling;

/*
 * Question : 
	���� ���̰� 2�̰� ������ ���̰� 1�� ���簢�� ����� Ÿ���� �ֽ��ϴ�. 
	�� ���簢�� Ÿ���� �̿��Ͽ� ������ ���̰� 3�̰� ������ ���̰� n�� �ٴ��� ���� ä����� �մϴ�. Ÿ���� ä�� ���� ������ ���� 2���� ����� �ֽ��ϴ�

	Ÿ���� ���η� ��ġ �ϴ� ���
	Ÿ���� ���η� ��ġ �ϴ� ���
	������ n�� 8�� ���簢���� ������ ���� ä�� �� �ֽ��ϴ�.
	
	���簢���� ������ ���� n�� �Ű������� �־��� ��, �� ���簢���� ä��� ����� ���� return �ϴ� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. Ȧ�������� ������ü�� �̷����� ���� -> ¦����
 * 			   2. ��Ģ���� ã�Ⱑ ������� ���� �ҽ� ����
 * 			    
 * */

public class Solution {

    public int solution(int n) {
        return Fibonacci(n);
    }
    
    public static int Fibonacci(int n) {
    	long[] arr = new long[5001]; // ������ ���̴� 5000 ������ �ڿ����̹Ƿ�, 5001�� �迭 �ʱ�ȭ
    	arr[0] = 1;
    	arr[2] = 3;
    	
		for(int i=4; i<=n; i+=2) { // ¦���� ����
			arr[i] = arr[i-2] * 3;
			for(int j=i-4; j>=0; j-=2) { // ������������
				arr[i] += arr[j] * 2;
			}
			arr[i] = arr[i] % 1000000007;
		}
    	
    	return (int)arr[n];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int n = 4;
		System.out.println(sol.solution(n));
	}
}