SELECT * FROM member
WHERE status = 0; -- 회원 탈퇴한 사람

SELECT * FROM member
WHERE id = 'sdmsdm123';

-- 트리거 ===========================================
-- status 가 false 되면 delete_at 이 현재 시간으로 찍힘
DELIMITER //
CREATE TRIGGER set_deleted_at
BEFORE UPDATE ON member
FOR EACH ROW
BEGIN
    IF NEW.status = false AND OLD.status <> false THEN
        SET NEW.deleted_at = NOW();
    END IF;
END //
DELIMITER ;

-- DROP TRIGGER IF EXISTS set_deleted_at; 트리거 삭제
SHOW TRIGGERS; -- 트리거 확인

-- 스케쥴러 =============================================
DROP event del_memberinfo_over30day; -- 이벤트 스케쥴러 삭제
select * from information_schema.events; -- 이벤트 스케쥴러 확인
-- SHOW VARIABLES LIKE 'event%'; -- 스케쥴러 on / off 체크
-- SET GLOBAL event_scheduler = ON; -- off 상태면 on 으로

CREATE EVENT del_memberinfo_over30day
ON SCHEDULE EVERY 1 minute
COMMENT '회원탈퇴'
DO
UPDATE member
SET pwd = null,
    addr = null,
    phone = null,
    email = null,
    name = null,
    nickname = null,
    age = null,
    gender = null, 
    member_manner = null,
    member_img = null,
    member_hobby = null,
    member_info = null,
    member_location = null,
    member_type = null,
    last_recommendation_time = null
WHERE status = false
AND TIMESTAMPDIFF(minute, deleted_at , now()) > 1; -- 확인용으로 1분뒤 삭제로 설정중
-- ===================================================
