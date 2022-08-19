package Level2.CandidateKey;

import java.util.*;

/*
 * Question : 
	��������б� ��ǻ�Ͱ��а� ������ �������� �׿� �а������ ���÷�, �л����� ���������� �����ϴ� ������ ����ϰ� �Ǿ���.

	���� �к� ���� ���α׷��� ������ �ǻ��, ��� ���������� �����ͺ��̽��� �ֱ�� �Ͽ���, �̸� ���� ������ �ϴ� �߿� �ĺ�Ű(Candidate Key)�� ���� ����� �ʿ��ϰ� �Ǿ���.
	
	�ĺ�Ű�� ���� ������ �� ��ﳪ�� �ʴ� ��������, ��Ȯ�� ������ �ľ��ϱ� ���� �����ͺ��̽� ���� ������ Ȯ���Ͽ� �Ʒ��� ���� ������ Ȯ���Ͽ���.
	
	���� �����ͺ��̽����� �����̼�(Relation)�� Ʃ��(Tuple)�� �����ϰ� �ĺ��� �� �ִ� �Ӽ�(Attribute) �Ǵ� �Ӽ��� ���� ��, ���� �� ������ �����ϴ� ���� �ĺ� Ű(Candidate Key)��� �Ѵ�.
	���ϼ�(uniqueness) : �����̼ǿ� �ִ� ��� Ʃ�ÿ� ���� �����ϰ� �ĺ��Ǿ�� �Ѵ�.
	�ּҼ�(minimality) : ���ϼ��� ���� Ű�� �����ϴ� �Ӽ�(Attribute) �� �ϳ��� �����ϴ� ��� ���ϼ��� ������ ���� �ǹ��Ѵ�. ��, �����̼��� ��� Ʃ���� �����ϰ� �ĺ��ϴ� �� �� �ʿ��� �Ӽ���θ� �����Ǿ�� �Ѵ�.
	�������� ����, �Ʒ��� ���� �л����� ���������� �־����� ��, �ĺ� Ű�� �ִ� ������ ���϶�.
	
	���� ���� �����ϸ�, �л��� �������� �����̼ǿ��� ��� �л��� ���� ������ "�й�"�� ������ �ִ�. ���� "�й�"�� �����̼��� �ĺ� Ű�� �� �� �ִ�.
	�״��� "�̸�"�� ���ؼ��� ���� �̸�("apeach")�� ����ϴ� �л��� �ֱ� ������, "�̸�"�� �ĺ� Ű�� �� �� ����. �׷���, ���� ["�̸�", "����"]�� �Բ� ����Ѵٸ� 
	�����̼��� ��� Ʃ���� �����ϰ� �ĺ� �����ϹǷ� �ĺ� Ű�� �� �� �ְ� �ȴ�.
	���� ["�̸�", "����", "�г�"]�� �Բ� ����ص� �����̼��� ��� Ʃ���� �����ϰ� �ĺ��� �� ������, �ּҼ��� �������� ���ϱ� ������ �ĺ� Ű�� �� �� ����.
	����, ���� �л� ���������� �ĺ�Ű�� "�й�", ["�̸�", "����"] �� ���� �ȴ�.
	
	�����̼��� ��Ÿ���� ���ڿ� �迭 relation�� �Ű������� �־��� ��, �� �����̼ǿ��� �ĺ� Ű�� ������ return �ϵ��� solution �Լ��� �ϼ��϶�.
 * 
 * 
 * 	Solution : 1. ���ͳ� ����
 * 			   2. ��Ʈ��ŷ�� ���� �ĺ�Ű ����� �ߺ����� ��´� -> HashSet �̿�
 * 			   3. ���ϼ� üũ�� ���� contains ������ �̿�
 * 			   4. �ٰ����� �ҽ� �м��� �̷����� �ҵ�..?
 * 			    
 * */

public class Solution {
	 
	public static boolean[] visited;
	public static int len;
	public static HashSet<String> set = new HashSet<String>();
	public static List<String> list = new ArrayList<>();
	
    public int solution(String[][] relation) {
        int answer = 0;
        
        len = relation[0].length;
        visited = new boolean[len];
        
        for(int i=1; i<=len; i++) {
        	comb(0, i, relation);
        	unique(relation);
        	set.clear();
        }
        
        answer = list.size();
        return answer;
    }
    
    public static void comb (int start, int r, String[][] relation) {
        if(r == 0){
            String temp="";
            for(int i=0; i<len; i++){
                if(visited[i]){
                    temp+=i;
                }
            }
            set.add(temp);
        }
        
        for(int i=start; i<len; i++){
            if(!visited[i]){
                visited[i]=true;
                comb(start+1, r-1, relation);
                visited[i]=false;
            }
        }
    }
    
    public void unique(String[][] relation) {
        //���ϼ� �Ǵ��ϱ�
        for(String data : set){
            String[] temp = data.split("");
            
            //���ϼ� �Ǵ��ϱ����� set
            HashSet<String> set2 = new HashSet<>();
            for(int i=0; i<relation.length; i++){
            	String cdd = "";
            	for(String data2 : temp){
            		int c = Integer.parseInt(data2);
	                cdd += relation[i][c];
            	}
              set2.add(cdd);
            }
            
            //���� �����ϴٸ� �ּҼ� �˻�
            if(set2.size() == relation.length){
                boolean flag = true;
                for(String data3 : list){
                    int cnt = 0;
                    String[] temp3 = data3.split("");         
                    for(String data4 : temp3){
                        if(data.contains(data4)){
                            cnt++;
                        }
                    }
                    
                    if(cnt == data3.length()){
                        flag = false;
                    }
                }
                
                if(flag){
                   list.add(data);
                }
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		System.out.println(sol.solution(relation));
	}
}