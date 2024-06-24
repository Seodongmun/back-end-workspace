-- **보안 및 권한 관리를 위해 ROOT 계정을 직접 사용하지 않는 것을 권장


-- 사용자 계정 생성
CREATE USER test IDENTIFIED BY 'test';

-- 사용자 계정 삭제
DROP USER test;

/*
	DCL(Date Control Language): 데이터 제어 언어
    - 계정에게 객체 접근 권한을 부여(GRANT)하거나 회소(REVOKE)하는 구문
    
    GRANT 권한, 권한, ... TO 계정;
    REVOKT 권한, 권한, ... FROM 계정; 
*/
-- 데이터베이스(스키마) 권한 부여 
GRANT ALL PRIVILEGES ON kh.* TO test;

-- 데이터베이스(스키마) 권한 회수 
-- REVOKE ALL PRIVILEGES ON *.* FROM test;
/* 문법오류는 있으나 실행은 문제 없음 */

/*
	데이터베이스(Datebase): 데이터의 집합을 저장하고 관리하는 시스템 
		- 데이터를 구조화하고 조직화하는데 사용
        - 여러 테이블, 뷰, 프로시저, 함수 등을 포함
    
    스키마(Schma) : 데이터베이스 내에 특정 테이블, 뷰, 프로시저, 함수 등을 그룹화
    --> 데이터베이스와 스키마를 같은 의미로 사용을 하지만, 몇몇 DBMS에서는 다르게 해석 
		MySQL에서는 대부분 두 용어를 같이 사용!
*/
-- 스키마 생성 
CREATE SCHEMA sample;

-- 스키마 삭제
DROP SCHEMA EXISTS sample;

-- 데이터베이스 생성 
CREATE DATABASE sample2;

-- 데이터베이스 삭제 
DROP DATABASE IF EXISTS sample2;

/*스키마와 데이터베이스는 같은 의미*/








