package Level2.SkillTree;

import java.util.*;

/*
 * Question : 
	���� ��ų�̶� � ��ų�� ���� ���� ���� ����� �ϴ� ��ų�� ���մϴ�.
	���� ��� ���� ��ų ������ ����ũ �� ����Ʈ�� ��Ʈ �� ����϶�, ����� ������ ���� ����Ʈ�� ��Ʈ�� ����� �ϰ�, ����Ʈ�� ��Ʈ�� ������ ���� ����ũ�� ����� �մϴ�.
	
	�� ������ ���� �ٸ� ��ų(���� ��)�� ������ ������� ��� �� �ֽ��ϴ�. ���� ����ũ �� ���� �� ����Ʈ�� ��Ʈ �� ����� ���� ��ųƮ���� ����������, 
	��� �� ����ũ�� ����Ʈ�� ��Ʈ �� ����ũ �� ���� �� ����� ���� ��ųƮ���� �Ұ����մϴ�.
	
	���� ��ų ���� skill�� �������� ���� ��ųƮ��1�� ���� �迭 skill_trees�� �Ű������� �־��� ��, ������ ��ųƮ�� ������ return �ϴ� solution �Լ��� �ۼ����ּ���.
 * 
 * 
 * 	Solution : 1. ���Ե��� �ʴ� ���ڴ� ����������, indexOf�� ������� ��ġ�ϸ�(0) answer++;
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