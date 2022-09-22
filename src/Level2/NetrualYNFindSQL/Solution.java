package Level2.NetrualYNFindSQL;

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
	보호소의 동물이 중성화되었는지 아닌지 파악하려 합니다. 
	중성화된 동물은 SEX_UPON_INTAKE 컬럼에 'Neutered' 또는 'Spayed'라는 단어가 들어있습니다. 
	동물의 아이디와 이름, 중성화 여부를 아이디 순으로 조회하는 SQL문을 작성해주세요. 이때 중성화가 되어있다면 'O', 아니라면 'X'라고 표시해주세요.
 * 
 * 	Solution : 1. CASE로 묶었는데.. 더 좋은 방법이 있을지 생각해봐야 함.
 * 			   2. 2CASE로 한줄로 묶는 방법 사용.
 * 			   3. 찾아보니 다 똑같은 방식을 사용함.
 *  
 * */

public class Solution {
	SELECT ANIMAL_ID,
		   NAME,
		   CASE WHEN UPPER(SEX_UPON_INTAKE) LIKE '%NEUTERED%' THEN 'O'
		        WHEN UPPER(SEX_UPON_INTAKE) LIKE '%SPAYED%' THEN 'O'
		        ELSE 'X' END AS '중성화'
    FROM ANIMAL_INS 
    
    /* 한줄로 변경 */
    SELECT ANIMAL_ID,
		   NAME,
		   CASE WHEN UPPER(SEX_UPON_INTAKE) LIKE '%NEUTERED%' OR UPPER(SEX_UPON_INTAKE) LIKE '%SPAYED%' THEN 'O'
		        ELSE 'X' END AS '중성화'
    FROM ANIMAL_INS       
}