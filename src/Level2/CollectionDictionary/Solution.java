package Level2.CollectionDictionary;

/*
 * Question : 
	������ ���ĺ� ���� 'A', 'E', 'I', 'O', 'U'���� ����Ͽ� ���� �� �ִ�, ���� 5 ������ ��� �ܾ ���ϵǾ� �ֽ��ϴ�. 
	�������� ù ��° �ܾ�� "A"�̰�, �״����� "AA"�̸�, ������ �ܾ�� "UUUUU"�Դϴ�.

	�ܾ� �ϳ� word�� �Ű������� �־��� ��, �� �ܾ �������� �� ��° �ܾ����� return �ϵ��� solution �Լ��� �ϼ����ּ���.
 * 
 * 
 * 	Solution : 1. A -> AA -> AAA -> AAAA -> AAAAA -> AAAAE -> AAAAI -> AAAAO -> AAAAU -> AAAE -> AAAI -> AAAO -> AAAU -> AAE
 * 			   2. DFS�� �ܾ ��� �����س����鼭 ���� ���ʿ� �� �ܾ� == ������ �ܾ� -> RETURN
 * */

public class Solution {

	public static int answer = 0;
	public static boolean isEquals = false;
	
    public int solution(String word) {
        dfs(word, 0, "");
        
        return answer;
    }
    
    public static void dfs(String word, int depth, String nextWord) {
    	String[] strArray = {"A", "E", "I", "O", "U"};
    	if(depth == 6) return;
    	
    	if(nextWord.equals(word)) {
    		isEquals = true;
    		return;
    	}
    	
    	for(int i=0; i<strArray.length; i++) {
    		if(isEquals) return;
    		
    		if(depth+1 < 6) answer++;
    		dfs(word, depth+1, nextWord.concat(strArray[i]));
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String word = "AAAAE";
		System.out.println(sol.solution(word));
	}
}