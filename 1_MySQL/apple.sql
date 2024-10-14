CREATE TABLE product(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(200),
content TEXT,
price INT
);

CREATE TABLE member(
	id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(60),
    name VARCHAR(50),
    email VARCHAR(50),
    phone VARCHAR(13)
);
-- DROP TABLE member;
SELECT * FROM product;
SELECT * FROM member;

INSERT INTO product(title, content, price) VALUES
( 'White and Black', 'Born in France', '120000'),
( 'Red Knit', 'Born in Seoul', '110000'),
( 'Grey Yordan', 'Born in the States', '130000'),
('Blue Wave', 'Born in Tokyo', 125000),
('Green Forest', 'Born in Canada', 140000),
('Yellow Sun', 'Born in Brazil', 115000),
('Purple Night', 'Born in Italy', 135000),
('Orange Sunset', 'Born in Australia', 150000),
('Brown Earth', 'Born in India', 100000),
('Pink Blossom', 'Born in China', 145000),
('Cyan Sea', 'Born in Mexico', 130000),
('Silver Star', 'Born in the UK', 160000),
('Gold Treasure', 'Born in Egypt', 175000),
('Turquoise Dream', 'Born in Greece', 120000),
('Ivory Mist', 'Born in Russia', 155000),
('Coral Reef', 'Born in the Philippines', 125000),
('Navy Depths', 'Born in Spain', 140000),
('Lavender Fields', 'Born in the Netherlands', 110000),
('Magenta Sky', 'Born in Norway', 150000),
('Burgundy Wine', 'Born in Portugal', 160000),
('Charcoal Shadow', 'Born in Sweden', 135000),
('Peach Sunrise', 'Born in Ireland', 120000),
('Teal Oasis', 'Born in Thailand', 145000),
('Emerald Isle', 'Born in Ireland', 128000),
('Crimson Wave', 'Born in Japan', 122000),
('Violet Sky', 'Born in Thailand', 148000),
('Sapphire Ocean', 'Born in the Caribbean', 165000),
('Amber Dawn', 'Born in Morocco', 135000),
('Jade Valley', 'Born in China', 140000),
('Onyx Depths', 'Born in South Africa', 155000),
('Ruby Dream', 'Born in Turkey', 150000),
('Citrine Light', 'Born in Brazil', 125000),
('Obsidian Night', 'Born in Iceland', 170000),
('Aqua Lagoon', 'Born in Fiji', 145000),
('Golden Sands', 'Born in Egypt', 175000),
('Cobalt Breeze', 'Born in New Zealand', 130000),
('Beryl Ridge', 'Born in Canada', 118000),
('Mauve Whispers', 'Born in France', 132000),
('Scarlet Plains', 'Born in Australia', 142000),
('Indigo Dreams', 'Born in the USA', 155000),
('Quartz Crystal', 'Born in Germany', 138000),
('Copper Glow', 'Born in Mexico', 145000),
('Slate Mountain', 'Born in Norway', 126000),
('Cerulean Twilight', 'Born in the UK', 135000),
('Amber Fields', 'Born in Spain', 120000),
('Mint Breeze', 'Born in Italy', 139000),
('Sandstone Coast', 'Born in Greece', 122000),
('Cherry Blossom', 'Born in Japan', 144000),
('Wisteria Sky', 'Born in Portugal', 160000),
('Coral Sunset', 'Born in the Maldives', 148000),
('Periwinkle Meadow', 'Born in Sweden', 130000),
('Rustic Hills', 'Born in the Czech Republic', 117000),
('Turquoise Bay', 'Born in the Bahamas', 140000),
('Lilac Dream', 'Born in Finland', 150000),
('Pewter River', 'Born in Denmark', 125000),
('Tangerine Glow', 'Born in Thailand', 138000),
('Zinc Horizon', 'Born in Argentina', 160000),
('Almond Grove', 'Born in Australia', 115000),
('Berry Bliss', 'Born in Italy', 135000),
('Ocean Breeze', 'Born in Hawaii', 130000),
('Peach Dream', 'Born in New Zealand', 145000),
('Lavender Mist', 'Born in France', 120000),
('Misty Mountain', 'Born in Scotland', 155000),
('Sunset Boulevard', 'Born in the USA', 170000),
('Granite Falls', 'Born in Canada', 140000),
('Copper Sands', 'Born in Egypt', 165000),
('Fuchsia Fields', 'Born in Mexico', 142000),
('Steel Wave', 'Born in Russia', 155000),
('Walnut Woods', 'Born in Brazil', 135000),
('Seashell Beach', 'Born in Greece', 140000),
('Blush Horizon', 'Born in Italy', 128000),
('Nightfall Serenade', 'Born in the UK', 160000),
('Marmalade Dream', 'Born in Australia', 150000),
('Lime Breeze', 'Born in Thailand', 125000),
('Champagne Sky', 'Born in France', 138000),
('Sunlit Forest', 'Born in Norway', 145000),
('Obsidian Ocean', 'Born in Iceland', 170000),
('Crimson Sunset', 'Born in Spain', 135000),
('Glacial Valley', 'Born in the Arctic', 160000),
('Emerald Dream', 'Born in Ireland', 148000),
('Hazel Grove', 'Born in Canada', 120000),
('Maple Leaf', 'Born in Japan', 134000),
('Sunset Symphony', 'Born in Portugal', 160000),
('Granite Peak', 'Born in the USA', 140000);


INSERT INTO member (id, password, name, email, phone) VALUES
('user001', 'password1', '홍길동', 'user001@example.com', '010-1111-0001'),
('user002', 'password2', '김철수', 'user002@example.com', '010-1111-0002'),
('user003', 'password3', '이영희', 'user003@example.com', '010-1111-0003'),
('user004', 'password4', '박지민', 'user004@example.com', '010-1111-0004'),
('user005', 'password5', '최재훈', 'user005@example.com', '010-1111-0005'),
('user006', 'password6', '정수빈', 'user006@example.com', '010-1111-0006'),
('user007', 'password7', '이상훈', 'user007@example.com', '010-1111-0007'),
('user008', 'password8', '김민지', 'user008@example.com', '010-1111-0008'),
('user009', 'password9', '장동건', 'user009@example.com', '010-1111-0009'),
('user010', 'password10', '이효리', 'user010@example.com', '010-1111-0010'),
('user011', 'password11', '이준호', 'user011@example.com', '010-1111-0011'),
('user012', 'password12', '김소연', 'user012@example.com', '010-1111-0012'),
('user013', 'password13', '이민호', 'user013@example.com', '010-1111-0013'),
('user014', 'password14', '박서준', 'user014@example.com', '010-1111-0014'),
('user015', 'password15', '정해인', 'user015@example.com', '010-1111-0015'),
('user016', 'password16', '배수지', 'user016@example.com', '010-1111-0016'),
('user017', 'password17', '최수영', 'user017@example.com', '010-1111-0017'),
('user018', 'password18', '정우성', 'user018@example.com', '010-1111-0018'),
('user019', 'password19', '이성경', 'user019@example.com', '010-1111-0019'),
('user020', 'password20', '김재원', 'user020@example.com', '010-1111-0020'),
('user021', 'password21', '박신혜', 'user021@example.com', '010-1111-0021'),
('user022', 'password22', '송중기', 'user022@example.com', '010-1111-0022'),
('user023', 'password23', '전지현', 'user023@example.com', '010-1111-0023'),
('user024', 'password24', '하정우', 'user024@example.com', '010-1111-0024'),
('user025', 'password25', '배정남', 'user025@example.com', '010-1111-0025'),
('user026', 'password26', '이엘', 'user026@example.com', '010-1111-0026'),
('user027', 'password27', '김고은', 'user027@example.com', '010-1111-0027'),
('user028', 'password28', '이승기', 'user028@example.com', '010-1111-0028'),
('user029', 'password29', '오연서', 'user029@example.com', '010-1111-0029'),
('user030', 'password30', '장나라', 'user030@example.com', '010-1111-0030'),
('user031', 'password31', '이준기', 'user031@example.com', '010-1111-0031'),
('user032', 'password32', '유재석', 'user032@example.com', '010-1111-0032'),
('user033', 'password33', '박명수', 'user033@example.com', '010-1111-0033'),
('user034', 'password34', '하하', 'user034@example.com', '010-1111-0034'),
('user035', 'password35', '이상민', 'user035@example.com', '010-1111-0035'),
('user036', 'password36', '신민아', 'user036@example.com', '010-1111-0036'),
('user037', 'password37', '김태리', 'user037@example.com', '010-1111-0037'),
('user038', 'password38', '이서진', 'user038@example.com', '010-1111-0038'),
('user039', 'password39', '정유미', 'user039@example.com', '010-1111-0039'),
('user040', 'password40', '고수', 'user040@example.com', '010-1111-0040'),
('user041', 'password41', '김남길', 'user041@example.com', '010-1111-0041'),
('user042', 'password42', '전현무', 'user042@example.com', '010-1111-0042'),
('user043', 'password43', '하유미', 'user043@example.com', '010-1111-0043'),
('user044', 'password44', '정진운', 'user044@example.com', '010-1111-0044'),
('user045', 'password45', '김재중', 'user045@example.com', '010-1111-0045'),
('user046', 'password46', '임윤아', 'user046@example.com', '010-1111-0046'),
('user047', 'password47', '이정현', 'user047@example.com', '010-1111-0047'),
('user048', 'password48', '신현준', 'user048@example.com', '010-1111-0048'),
('user049', 'password49', '강하늘', 'user049@example.com', '010-1111-0049'),
('user050', 'password50', '조인성', 'user050@example.com', '010-1111-0050');