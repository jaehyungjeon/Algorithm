package Level2.MinValueSQL;

import java.util.*;

/*
 * Question : 
	ANIMAL_INS 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. 
	ANIMAL_INS 테이블 구조는 다음과 같으며, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE는 
	각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.

	NAME	TYPE	NULLABLE
	ANIMAL_ID	VARCHAR(N)	FALSE
	ANIMAL_TYPE	VARCHAR(N)	FALSE
	DATETIME	DATETIME	FALSE
	INTAKE_CONDITION	VARCHAR(N)	FALSE
	NAME	VARCHAR(N)	TRUE
	SEX_UPON_INTAKE	VARCHAR(N)	FALSE
	동물 보호소에 가장 먼저 들어온 동물은 언제 들어왔는지 조회하는 SQL 문을 작성해주세요.
 * 
 * 	Solution : 1. 스칼라 이용
 *  
 * */

public class Solution {
	SELECT TMP.DATETIME
	FROM (SELECT RANK() OVER(ORDER BY DATETIME ASC) AS RANKING,
	       DATETIME
	FROM   ANIMAL_INS) TMP
	WHERE TMP.RANKING = 1;
}