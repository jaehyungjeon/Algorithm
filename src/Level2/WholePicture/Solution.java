package Level2.WholePicture;

import java.util.*;

/*
 * Question : 
	������ �¾� īī��������� ��ü�� ��ǳ�� ������. 
	��ſ� �ð��� ������ �������� ��ü������ ��� ���� ī�޶� �տ� �Ϸķ� ������ ����. 
	�׷��� ���ڰ� ���ϴ� ��ġ�� ��� �޶� � ������ ���� ���ϴµ� �ð��� ���� �ɷȴ�. 
	�׿��� ���ε��� ������ ���⸦ ���߰�, Ʃ�갡 ���� ���� ���� ���� �ִ� ���̾��� Ʃ�꿡�Լ� ��� �� ĭ �̻� �������� ���⸦ ���ߴ�. 
	������ ��� ���� ���ƿ��� �濡, ������ ��ΰ� ���ϴ� ������ �����ϸ鼭�� �ٸ��� ���� ����� ���� �ʾ����� �����غ��� �Ǿ���. 
	�� ����� ���ϴ� ������ �Է����� �޾��� �� ��� ������ ������ �� �ֵ��� ���� ����� ���� ����ϴ� ���α׷��� �ۼ��غ���.
 * 
 * 	output : 3648
 * 
 * 	Solution : 1. N~F=0 , R~T>2
 * 			   2. ���ǿ� ����, ������ �Ÿ��� ���ϰ� true�� ��쿡�� ī��Ʈ�� ������Ű�� �ɵ�..?
 * 			   3. dfs�� ���ؼ� �ݺ����� ����
 * 
 * */

public class Solution {

	public static Map<Character, Integer> tot = new HashMap<Character, Integer>();
	public static int[] list;
	public static boolean[] visited;
	public static int answer;
	public static String[] dt;
	
    public int solution(int n, String[] data) {
        answer = 0;

        dt = data;
        
        tot.put('C', 0);
        tot.put('A', 1);
        tot.put('F', 2);
        tot.put('J', 3);
        tot.put('M', 4);
        tot.put('N', 5);
        tot.put('R', 6);
        tot.put('T', 7);
        
        list = new int[8];
        visited = new boolean[8];
        perm(0);
        
        return answer;
    }
    
    private static void perm(int cnt) {
        if (cnt == 8) {
            if (isCorrect())
                answer++;
            return;
        }
 
        for (int i = 0; i < 8; i++) {
            if (visited[i])
                continue;
 
            visited[i] = true;
            list[cnt] = i;
            perm(cnt + 1);
            visited[i] = false;
        }
    }
    
    private static boolean isCorrect() {
        for (String s : dt) {
            int first = list[tot.get(s.charAt(0))];
            int second = list[tot.get(s.charAt(2))];
            char op = s.charAt(3);
            int dist = s.charAt(4) - '0' + 1;
 
            int distance = Math.abs(first - second);
            if (op == '=') {
                if (distance != dist)
                    return false;
            } else if (op == '>' ) {
                if(distance <= dist)
                    return false;
            } else if (distance >= dist)
                return false;
        }
 
        return true; 
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
    	int n = 2;
    	String[] data = {"N~F=0", "R~T>2"};
		System.out.println(sol.solution(n, data));
	}
}