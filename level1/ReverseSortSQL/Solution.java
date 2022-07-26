package ReverseSortSQL;

/*
 * Question : 
	ANIMAL_INS ���̺��� ���� ��ȣ�ҿ� ���� ������ ������ ���� ���̺��Դϴ�. ANIMAL_INS ���̺� ������ ������ ������, 
	ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME, SEX_UPON_INTAKE�� 
	���� ������ ���̵�, ���� ��, ��ȣ ������, ��ȣ ���� �� ����, �̸�, ���� �� �߼�ȭ ���θ� ��Ÿ���ϴ�.
	
	NAME	TYPE	NULLABLE
	ANIMAL_ID	VARCHAR(N)	FALSE
	ANIMAL_TYPE	VARCHAR(N)	FALSE
	DATETIME	DATETIME	FALSE
	INTAKE_CONDITION	VARCHAR(N)	FALSE
	NAME	VARCHAR(N)	TRUE
	SEX_UPON_INTAKE	VARCHAR(N)	FALSE
	���� ��ȣ�ҿ� ���� ��� ������ �̸��� ��ȣ �������� ��ȸ�ϴ� SQL���� �ۼ����ּ���. �̶� ����� ANIMAL_ID �������� �����ּ���. SQL�� �����ϸ� ������ ���� ��µǾ�� �մϴ�.
	
	NAME	DATETIME
	Rocky	2016-06-07 09:17:00
	Shelly	2015-01-29 15:01:00
	Benji	2016-04-19 13:28:00
	Jackie	2016-01-03 16:25:00
	*Sam	2016-03-13 11:17:00
	..���� ����
 * 
 * 	Solution : 1. NAME �� NULL �� �� ���
 * */

public class Solution {
	SELECT NAME, DATETIME
	FROM   ANIMAL_INS
	ORDER BY ANIMAL_ID DESC
}