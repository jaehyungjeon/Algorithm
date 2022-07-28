package Level2.NormalSquare;

/*
 * Question : 
	���� ���̰� Wcm, ���� ���̰� Hcm�� ���簢�� ���̰� �ֽ��ϴ�. 
	���̿��� ����, ���� ����� �����ϰ� ���� ���·� ���� �׾��� ������, ��� ����ĭ�� 1cm x 1cm ũ���Դϴ�. �� ���̸� ���� ���� ���� 1cm �� 1cm�� ���簢������ �߶� ����� �����̾��µ�, 
	�������� �� ���̸� �밢�� ������ 2���� �մ� �������� �߶� ���ҽ��ϴ�. 
	�׷��Ƿ� ���� ���簢�� ���̴� ũ�Ⱑ ���� �����ﰢ�� 2���� �������� �����Դϴ�. 
	���ο� ���̸� ���� �� ���� �����̱� ������, �� ���̿��� ���� ������ ����, ���� ����� �����ϰ� 1cm �� 1cm�� �߶� ����� �� �ִ� ��ŭ�� ����ϱ�� �Ͽ����ϴ�.
	������ ���� W�� ������ ���� H�� �־��� ��, ����� �� �ִ� ���簢���� ������ ���ϴ� solution �Լ��� �ϼ��� �ּ���.
 * 
 * 	output : 80
 * 
 * 	Solution : 1. ���� ��Ģ�� �ִ������� ���Ѵ����� ��ü���� ���ִ� ������ ���ϴ� �����̴�.
 *   
 * */

public class Solution {
	
    public long solution(int w, int h) {
        long answer = 1;
        long x = (long)w;
        long y = (long)h;
        long gcd = gcd(Math.max(x, y), Math.min(x, y));
        answer = (long)((x*y) - (x+y-gcd));
        return answer;
    }
    
    public long gcd(long x, long y) {
    	if(y == 0) return x;
    	
    	return gcd(y, x%y);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int w = 8;
    	int h = 12;
		System.out.println(sol.solution(w, h));
	}
}