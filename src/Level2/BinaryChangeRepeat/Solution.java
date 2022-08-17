package Level2.BinaryChangeRepeat;

/*
 * Question : 
	0�� 1�� �̷���� � ���ڿ� x�� ���� ���� ��ȯ�� ������ ���� �����մϴ�.

	x�� ��� 0�� �����մϴ�.
	x�� ���̸� c��� �ϸ�, x�� "c�� 2�������� ǥ���� ���ڿ�"�� �ٲߴϴ�.
	���� ���, x = "0111010"�̶��, x�� ���� ��ȯ�� ���ϸ� x = "0111010" -> "1111" -> "100" �� �˴ϴ�.
	
	0�� 1�� �̷���� ���ڿ� s�� �Ű������� �־����ϴ�. s�� "1"�� �� ������ ����ؼ� s�� ���� ��ȯ�� ������ ��, 
	���� ��ȯ�� Ƚ���� ��ȯ �������� ���ŵ� ��� 0�� ������ ���� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. [0] = ȸ��, [1] = 0 ���� ����
 * 			   2. ��� 0�� �����ϸ鼭 ī��Ʈ�� ����
 *   		   3. dfs �̿��ϸ� �����..?
 *   		   4. Binary�� ��ȯ�ؼ� 1�� �ƴҰ����� ��͵���
 * */

public class Solution {

	public static int num = 0;
	public static int count = 0;
	
	public int[] solution(String s) {
        int[] answer = {};
        
    	dfs(s);
    	
    	answer = new int[] {num, count};
        return answer;
    }
    
    public static void dfs(String s) {
    	String str = "";
    	num++;
    	
    	for(int i=0; i<s.length(); i++) {
    		if(s.charAt(i) == '0') {
    			count++;
    		} else {
    			str += s.charAt(i);
    		}
    	}
    	
    	int length = str.length();
    	String Binary = Integer.toBinaryString(length);
    	String LenStr = String.valueOf(Integer.parseInt(Binary, 2));
    	s = Binary; // ���̸� String����
    	
	    if(!LenStr.equals("1")) {
	    	dfs(Binary);
	    }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String s = "110010101001";
		System.out.println(sol.solution(s));
	}
}