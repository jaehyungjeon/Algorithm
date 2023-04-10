package Level2.StatusChangeSQL;

import java.util.*;

/*
 * Question : 
	USED_GOODS_BOARD 테이블에서 2022년 10월 5일에 등록된 중고거래 게시물의 게시글 ID, 작성자 ID, 게시글 제목, 가격, 거래상태를 조회하는 SQL문을 작성해주세요. 
	거래상태가 SALE 이면 판매중, RESERVED이면 예약중, DONE이면 거래완료 분류하여 출력해주시고, 결과는 게시글 ID를 기준으로 내림차순 정렬해주세요.
 * 
 * 	Solution : 1. STATUS는 CASE WHEN 사용하여 변환
 * 			   2. 날짜는 TO_CHAR 이용하여 변환
 * 			   3. BOARD_ID 기준 오름차순
 *  
 * */

public class Solution {
	SELECT BOARD_ID,
    WRITER_ID,
    TITLE,
    PRICE,
    CASE WHEN STATUS = 'SALE' THEN '판매중'
         WHEN STATUS = 'RESERVED' THEN '예약중'
         WHEN STATUS = 'DONE' THEN '거래완료' END AS STATUS
	FROM   USED_GOODS_BOARD
	WHERE  TO_CHAR(CREATED_DATE, 'YYYYMMDD') = '20221005'
	ORDER BY BOARD_ID DESC
}