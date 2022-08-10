package Level2.WholePicture;

import java.util.*;

/*
 * Question : 
	가을을 맞아 카카오프렌즈는 단체로 소풍을 떠났다. 
	즐거운 시간을 보내고 마지막에 단체사진을 찍기 위해 카메라 앞에 일렬로 나란히 섰다. 
	그런데 각자가 원하는 배치가 모두 달라 어떤 순서로 설지 정하는데 시간이 오래 걸렸다. 
	네오는 프로도와 나란히 서기를 원했고, 튜브가 뿜은 불을 맞은 적이 있던 라이언은 튜브에게서 적어도 세 칸 이상 떨어져서 서기를 원했다. 
	사진을 찍고 나서 돌아오는 길에, 무지는 모두가 원하는 조건을 만족하면서도 다르게 서는 방법이 있지 않았을까 생각해보게 되었다. 
	각 프렌즈가 원하는 조건을 입력으로 받았을 때 모든 조건을 만족할 수 있도록 서는 경우의 수를 계산하는 프로그램을 작성해보자.
 * 
 * 	output : 3648
 * 
 * 	Solution : 1. N~F=0 , R~T>2
 * 			   2. 조건에 따라서, 사이의 거리를 구하고 true일 경우에만 카운트를 증가시키면 될듯..?
 * 			   3. dfs를 통해서 반복적인 수행
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