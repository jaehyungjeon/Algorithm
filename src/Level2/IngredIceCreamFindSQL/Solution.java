package Level2.IngredIceCreamFindSQL;

import java.util.*;

/*
 * Question : 상반기 동안 각 아이스크림 성분 타입과 성분 타입에 대한 아이스크림의 총주문량을 총주문량이 작은 순서대로 조회하는 SQL 문을 작성해주세요. 이때 총주문량을 나타내는 컬럼명은 TOTAL_ORDER로 지정해주세요.
 * 
 * 	Solution : 1. 테이블 조인(FLAVOR)
 * 			   2. GROUP BY로 성분 타입 묶기
 * 			   3. 총 주문량은 SUM으로 합 계산
 * 			   4. 서브쿼리 이용하여 바깥에서 TOTAL_ORDER 기준 오름차순
 *  
 * */

public class Solution {
	SELECT *
	FROM (SELECT B.INGREDIENT_TYPE,
	       SUM(A.TOTAL_ORDER) AS TOTAL_ORDER
	FROM FIRST_HALF A,
	     ICECREAM_INFO B
	WHERE A.FLAVOR = B.FLAVOR
	GROUP BY B.INGREDIENT_TYPE) T
	ORDER BY T.TOTAL_ORDER ASC
}