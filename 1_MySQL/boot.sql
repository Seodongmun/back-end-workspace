SELECT * FROM channel;
SELECT * FROM comment;
SELECT * FROM member;
SELECT * FROM subscribe;
SELECT * FROM video;
SELECT * FROM video_like;

CREATE TABLE board(
	no INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(20),
    content TEXT,
    date DATETIME DEFAULT CURRENT_TIMESTAMP,
    url VARCHAR(200)
);
SELECT * FROM board;

INSERT INTO board(title, content) VALUES('테스트','테스트 정보입니다');
SELECT * FROM member.board;
SELECT * FROM member.board
LIMIT 0,5; 
-- 첫 번째 페이지 (page=1)
 -- 5 * 0 = 0 / 10 * 0 = 0


SELECT * FROM board
LIMIT 5,5;
 -- 두 번째 페이지 (page=2)
 -- 5 * 1 = 5 / 10 * 1 = 10

SELECT * FROM board
LIMIT 10,5; 
-- 세 번째 페이지 (page=3)
-- 5 * 2 = 10 / 10 * 2 = 20

DELETE FROM board
WHERE no = '1';

-- DROP TABLE member.board; 
