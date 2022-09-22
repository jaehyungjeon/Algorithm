package Level2.MinValueSQL;

import java.util.*;

/*
 * Question : 
	ANIMAL_INS ���̺��� ���� ��ȣ�ҿ� ���� ������ ������ ���� ���̺��Դϴ�. 
	ANIMAL_INS ���̺� ������ ������ ������, ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE�� 
	���� ������ ���̵�, ���� ��, ��ȣ ������, ��ȣ ���� �� ����, �̸�, ���� �� �߼�ȭ ���θ� ��Ÿ���ϴ�.

	NAME	TYPE	NULLABLE
	ANIMAL_ID	VARCHAR(N)	FALSE
	ANIMAL_TYPE	VARCHAR(N)	FALSE
	DATETIME	DATETIME	FALSE
	INTAKE_CONDITION	VARCHAR(N)	FALSE
	NAME	VARCHAR(N)	TRUE
	SEX_UPON_INTAKE	VARCHAR(N)	FALSE
	���� ��ȣ�ҿ� ���� ���� ���� ������ ���� ���Դ��� ��ȸ�ϴ� SQL ���� �ۼ����ּ���.
 * 
 * 	Solution : 1. ��Į�� �̿�
 *  
 * */

public class Solution {
	SELECT TMP.DATETIME
	FROM (SELECT RANK() OVER(ORDER BY DATETIME ASC) AS RANKING,
	       DATETIME
	FROM   ANIMAL_INS) TMP
	WHERE TMP.RANKING = 1;
}