package Level2.CollectionDictionary;

/*
 * Question : 
	사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 
	사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.

	단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * 	Solution : 1. A -> AA -> AAA -> AAAA -> AAAAA -> AAAAE -> AAAAI -> AAAAO -> AAAAU -> AAAE -> AAAI -> AAAO -> AAAU -> AAE
 * 			   2. DFS로 단어를 계속 조합해나가면서 다음 차례에 올 단어 == 제시한 단어 -> RETURN
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