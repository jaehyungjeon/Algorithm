package Level2.CandidateKey;

import java.util.*;

/*
 * Question : 
	프렌즈대학교 컴퓨터공학과 조교인 제이지는 네오 학과장님의 지시로, 학생들의 인적사항을 정리하는 업무를 담당하게 되었다.

	그의 학부 시절 프로그래밍 경험을 되살려, 모든 인적사항을 데이터베이스에 넣기로 하였고, 이를 위해 정리를 하던 중에 후보키(Candidate Key)에 대한 고민이 필요하게 되었다.
	
	후보키에 대한 내용이 잘 기억나지 않던 제이지는, 정확한 내용을 파악하기 위해 데이터베이스 관련 서적을 확인하여 아래와 같은 내용을 확인하였다.
	
	관계 데이터베이스에서 릴레이션(Relation)의 튜플(Tuple)을 유일하게 식별할 수 있는 속성(Attribute) 또는 속성의 집합 중, 다음 두 성질을 만족하는 것을 후보 키(Candidate Key)라고 한다.
	유일성(uniqueness) : 릴레이션에 있는 모든 튜플에 대해 유일하게 식별되어야 한다.
	최소성(minimality) : 유일성을 가진 키를 구성하는 속성(Attribute) 중 하나라도 제외하는 경우 유일성이 깨지는 것을 의미한다. 즉, 릴레이션의 모든 튜플을 유일하게 식별하는 데 꼭 필요한 속성들로만 구성되어야 한다.
	제이지를 위해, 아래와 같은 학생들의 인적사항이 주어졌을 때, 후보 키의 최대 개수를 구하라.
	
	위의 예를 설명하면, 학생의 인적사항 릴레이션에서 모든 학생은 각자 유일한 "학번"을 가지고 있다. 따라서 "학번"은 릴레이션의 후보 키가 될 수 있다.
	그다음 "이름"에 대해서는 같은 이름("apeach")을 사용하는 학생이 있기 때문에, "이름"은 후보 키가 될 수 없다. 그러나, 만약 ["이름", "전공"]을 함께 사용한다면 
	릴레이션의 모든 튜플을 유일하게 식별 가능하므로 후보 키가 될 수 있게 된다.
	물론 ["이름", "전공", "학년"]을 함께 사용해도 릴레이션의 모든 튜플을 유일하게 식별할 수 있지만, 최소성을 만족하지 못하기 때문에 후보 키가 될 수 없다.
	따라서, 위의 학생 인적사항의 후보키는 "학번", ["이름", "전공"] 두 개가 된다.
	
	릴레이션을 나타내는 문자열 배열 relation이 매개변수로 주어질 때, 이 릴레이션에서 후보 키의 개수를 return 하도록 solution 함수를 완성하라.
 * 
 * 
 * 	Solution : 1. 인터넷 참조
 * 			   2. 백트래킹을 통한 후보키 목록을 중복없이 담는다 -> HashSet 이용
 * 			   3. 유일성 체크를 위해 contains 조건을 이용
 * 			   4. 다각도의 소스 분석이 이뤄져야 할듯..?
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
        //유일성 판단하기
        for(String data : set){
            String[] temp = data.split("");
            
            //유일성 판단하기위한 set
            HashSet<String> set2 = new HashSet<>();
            for(int i=0; i<relation.length; i++){
            	String cdd = "";
            	for(String data2 : temp){
            		int c = Integer.parseInt(data2);
	                cdd += relation[i][c];
            	}
              set2.add(cdd);
            }
            
            //만약 유일하다면 최소성 검사
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