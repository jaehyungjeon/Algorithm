package MaxSQL;

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
	���� �ֱٿ� ���� ������ ���� ���Դ��� ��ȸ�ϴ� SQL ���� �ۼ����ּ���.
	
	����
	���� ��� ANIMAL_INS ���̺��� ������ ���ٸ�
	
	ANIMAL_ID	ANIMAL_TYPE	DATETIME	INTAKE_CONDITION	NAME	SEX_UPON_INTAKE
	A399552	Dog	2013-10-14 15:38:00	Normal	Jack	Neutered Male
	A379998	Dog	2013-10-23 11:42:00	Normal	Disciple	Intact Male
	A370852	Dog	2013-11-03 15:04:00	Normal	Katie	Spayed Female
	A403564	Dog	2013-11-18 17:03:00	Normal	Anna	Spayed Female
	���� �ʰ� ���� ������ Anna�̰�, Anna�� 2013-11-18 17:03:00�� ���Խ��ϴ�. ���� SQL���� �����ϸ� ������ ���� ���;� �մϴ�.

	�ð�
	2013-11-18 17:03:00
	�� �÷� �̸�(�� ���������� "�ð�")�� ��ġ���� �ʾƵ� �˴ϴ�.
 * 
 * 	Solution : 1. rank�Լ��� ��� ������ ������������ ���� ��, �ش� �κ��� ���������� ����
 * 			   2. ���� ���� �ٱ����� ���ĵ� ������ �ֻ�� �� 1�� ���
 * */

public class Solution {
	SELECT A.DATETIME AS �ð�
	FROM (SELECT RANK() OVER(ORDER BY DATETIME DESC) AS TIME,
	       DATETIME
	FROM   ANIMAL_INS) A
	WHERE TIME = 1;
}