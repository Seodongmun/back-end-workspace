SET @cutOffDate = DATE_ADD(NOW(), INTERVAL 30 DAY); -- 오늘부터 30일뒤에
DELETE FROM member	-- 멤버테이블에서
WHERE status = false -- status가 false고
AND deleted_at <= @cutOffDate; -- 회원탈퇴한 날에서 30일 뒤에 멤버테이터 모두 삭제 