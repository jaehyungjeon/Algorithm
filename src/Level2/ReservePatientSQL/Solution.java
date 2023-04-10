package Level2.ReservePatientSQL;

import java.util.*;

/*
 * Question : APPOINTMENT 테이블에서 2022년 5월에 예약한 환자 수를 진료과코드 별로 조회하는 SQL문을 작성해주세요. 
 			  이때, 컬럼명은 '진료과 코드', '5월예약건수'로 지정해주시고 결과는 진료과별 예약한 환자 수를 기준으로 오름차순 정렬하고, 예약한 환자 수가 같다면 진료과 코드를 기준으로 오름차순 정렬해주세요.
 * 
 * 	Solution : 1. APNT_YMD를 TO_CHAR 형식으로 변환하여 202205 검색
 * 			   2. GROUP BY로 묶은 뒤 카운트 반영
 * 			   3. 정렬 실시
 *  
 * */

public class Solution {
	SELECT A.MCDP_CD "진료과코드",
    	   COUNT(A.MCDP_CD) AS "5월예약건수"
	FROM APPOINTMENT A
	WHERE TO_CHAR(A.APNT_YMD, 'YYYYMM') = '202205'
	GROUP BY A.MCDP_CD
	ORDER BY COUNT(A.MCDP_CD) ASC, A.MCDP_CD ASC
}