-- 아래의 SQL 구문은 부서 별 평균 월급이 280만원을 초과하는 부서를 조회한 것이다.
-- 결과가 올바르지 않다고 할 때, 그 원인(20점)과 올바르게 수정한 SQL문을 조치내용(20점)에 작성하시오. (총 40점)

SELECT dept_code, format(sum(salary),0) 합계, format(avg(salary),0) 평균, count(*) 인원수
FROM employee
GROUP BY dept_code
HAVING avg(salary) > 2800000
ORDER BY dept_code;

SELECT dept_code, sum(salary) 합계, avg(salary) 평균, count(*) 인원수
FROM employee
WHERE salary > 2800000
GROUP BY dept_code
ORDER BY dept_code;


-- 아래의 SQL 구문은 보너스를 받은 사원들의 직급별 평균 급여가 300만원 이상을 초과하는 직급만 조회한 것이다.
-- 결과가 올바르지 않다고 할 때, 그 원인(30점)을 작성하고, 올바르게 수정한 SQL 문을 조치내용(30점)에 작성하시오. (총 60점)

SELECT job_code, format(avg(salary),0)
FROM employee
WHERE bonus is not null
GROUP BY job_code
HAVING avg(salary) >= 3000000;


SELECT job_code, avg(salary)
FROM employee
GROUP BY dept_code
HAVING bonus is not null AND avg(salary) >= 3000000;













