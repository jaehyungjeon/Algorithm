package Level2.SkillTree;

import java.util.*;

/*
 * Question : 
	선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
	예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
	
	위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 
	썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
	
	선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
 * 
 * 
 * 	Solution : 1. 포함되지 않는 문자는 지워버리고, indexOf로 순서대로 일치하면(0) answer++;
 * 
 * */

public class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(String s : skill_trees) {
        	String tmp = s;
        	
        	for(int i=0; i<s.length(); i++) {
        		String t = s.substring(i, i+1);
        		if(!skill.contains(t)) {
        			tmp = tmp.replace(t, "");
        		}
        	}

        	if(skill.indexOf(tmp) == 0) {
        		answer++;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(sol.solution(skill, skill_trees));
	}
}