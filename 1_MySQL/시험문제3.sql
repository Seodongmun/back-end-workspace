-- 다음은 직원 테이블에서 사원명, 직급코드, 보너스를 받는 사원 수를 조회하여 직급코드 순으로 오름차순 정렬하는 구문이다.
-- 이 코드의 결과가 올바르지 않다고 할 때 그 이유를 원인(20점)에 기술하고, 알맞은 SQL문을 조치내용(20점)에 작성하시오. (총 40점)

SELECT emp_name, job_code, count(*) as 사원수
FROM employee
WHERE bonus != NULL
GROUP BY job_code
ORDER BY job_code;


SELECT * FROM employee;
SELECT emp_name, job_code , count(bonus) AS 사원수
FROM employee
WHERE bonus is not null
GROUP BY emp_id;





SELECT * FROM employee;
SELECT * FROM department;
-- 다음 두 개의 테이블을 조인하여 emp_id, emp_name, dept_id, dept_title 컬럼을 조회하였을 때 문제가 발생한다.
-- 아래의 내용과 문제상황을 보고, 발생한 원인(30점)과 알맞은 SQL 문을 조치사항(30점)에 작성하시오. (총 60점)

SELECT emp_id, emp_name, dept_id, dept_title
FROM employee
JOIN department USING (dept_id);




SELECT emp_id, emp_name, dept_id, dept_title
FROM employee
JOIN department ON (dept_code=dept_id)
WHERE dept_id IN ('D9') AND dept_title LIKE '%총무부%';







