package Level1.신고결과받기;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Question : 
 * 신입사원 무지는 게시판 불량 이용자를 신고하고 처리 결과를 메일로 발송하는 시스템을 개발하려 합니다. 무지가 개발하려는 시스템은 다음과 같습니다.

	각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
	신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
	한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
	k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
	유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
	다음은 전체 유저 목록이 ["muzi", "frodo", "apeach", "neo"]이고, k = 2(즉, 2번 이상 신고당하면 이용 정지)인 경우의 예시입니다.
	
	유저 ID	유저가 신고한 ID	설명
	"muzi"	"frodo"	"muzi"가 "frodo"를 신고했습니다.
	"apeach"	"frodo"	"apeach"가 "frodo"를 신고했습니다.
	"frodo"	"neo"	"frodo"가 "neo"를 신고했습니다.
	"muzi"	"neo"	"muzi"가 "neo"를 신고했습니다.
	"apeach"	"muzi"	"apeach"가 "muzi"를 신고했습니다.
	각 유저별로 신고당한 횟수는 다음과 같습니다.
	
	유저 ID	신고당한 횟수
	"muzi"	1
	"frodo"	2
	"apeach"	0
	"neo"	2
	위 예시에서는 2번 이상 신고당한 "frodo"와 "neo"의 게시판 이용이 정지됩니다. 이때, 각 유저별로 신고한 아이디와 정지된 아이디를 정리하면 다음과 같습니다.
	
	유저 ID	유저가 신고한 ID	정지된 ID
	"muzi"	["frodo", "neo"]	["frodo", "neo"]
	"frodo"	["neo"]	["neo"]
	"apeach"	["muzi", "frodo"]	["frodo"]
	"neo"	없음	없음
	따라서 "muzi"는 처리 결과 메일을 2회, "frodo"와 "apeach"는 각각 처리 결과 메일을 1회 받게 됩니다.
	
	이용자의 ID가 담긴 문자열 배열 id_list, 각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report, 정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때, 각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 * 
 * 
 * Solution : 1. id_list별 신고 당한 횟수의 Map 만든다.
 * 			  2. count를 셀 수 있는 Map을 하나 더 추가한다. -> k의 갯수에 따라서 셋팅하기 위함
 * 			  3. 신고당한 id에 따른 map 값을 셋팅한다.
 * 			  4. k번째 이상일 경우, 해당 id에 셋팅된 값을 1씩 증가시킨다.
 * 
 * */

class Solution {
	public HashMap<String, HashSet<String>> idMap = new HashMap<String, HashSet<String>>();
	public HashMap<String, Integer> reportMap = new HashMap<String, Integer>();
	
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        for(int i=0; i<id_list.length; i++) {
        	HashSet<String> a = new HashSet<String>();
        	
        	idMap.put(id_list[i], a);
        	
        	reportMap.put(id_list[i], 0);
        }
        
        for(String a : report) {
        	String[] reportId = a.split(" ");
    		idMap.get(reportId[1]).add(reportId[0]);
        }
	    
        
        for(String id : idMap.keySet()) {
        	HashSet<String> t = idMap.get(id);
        	if(t.size() >= k) {
        		for(String b : t) {
        			reportMap.put(b, reportMap.get(b)+1);
        		}
        	}
        }
        
        answer = new int[id_list.length];
        for(int i=0; i<reportMap.size(); i++) {
        	answer[i] = reportMap.get(id_list[i]);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    	String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		System.out.println(sol.solution(id_list, report, 2));
	}
}