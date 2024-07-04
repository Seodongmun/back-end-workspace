-- 다음 조건에 맞는 사원을 조회하려고 SQL 구문을 작성했는데 제대로된 결과가 출력되지 않았다.
-- 그 이유를 원인(20점)에 작성하고 제대로된 SQL 구문을 조치사항(30점)에 작성하시오. (총 50점)
SELECT * FROM employee;

-- 조건
-- dept_code가 D6이거나 D9이고 salary가 300만원 이상이고
-- 이메일 주소가 _ 앞에 3글자인 사원의 emp_name, emp_no, dept_code, salary 조회
SELECT emp_name, emp_no, dept_code, salary
FROM employee
WHERE dept_code IN ('D6','D9') AND 
	  salary >= 3000000 AND
	  substr(email,4,1) IN ('_')
ORDER BY 4 DESC;


-- * 3개의 문제점이 있음
-- 결과 화면



-- 다음과 같이 NULL 값을 비교하였는데 정상적으로 작동하지 않았다.
-- 그 이유를 원인(10점)에 작성하고 제대로된 SQL 구문을 조치내용(10점)에 작성하시오. (총 20점)

-- 작성된 SQL문
SELECT * 
FROM employee 
WHERE bonus IS null;

-- NULL 값에 대한 비교처리가 되지 않음
-- 결과 화면

SELECT * FROM employee;