DROP DATABASE IF EXISTS ssafit_db;
CREATE DATABASE ssafit_db DEFAULT CHARACTER SET utf8mb4;

USE ssafit_db;

CREATE TABLE IF NOT EXISTS videos (
	`videoId` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(60) NOT NULL,
    `channelName` VARCHAR(45) NOT NULL,
	`url` VARCHAR(200) NOT NULL,
    `videoImg` VARCHAR(200) NOT NULL,
    `viewCnt` INT DEFAULT 0,
	`part` VARCHAR(20) NOT NULL,
    PRIMARY KEY(videoId)
);

CREATE TABLE IF NOT EXISTS reviews (
	`reviewId` INT NOT NULL AUTO_INCREMENT,
	`videoId` INT NOT NULL,
    `title` VARCHAR(60) NOT NULL,
    `writer` VARCHAR(45) NOT NULL,
	`content` VARCHAR(200),
    `viewCnt` INT DEFAULT 0,
    PRIMARY KEY(reviewId)
);

CREATE TABLE IF NOT EXISTS users(
	`id` VARCHAR(20) NOT NULL,
    `password` VARCHAR(20) NOT NULL,
    `name` VARCHAR(20) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO videos(title, channelName, url, videoImg, viewCnt, part)
VALUES 
("Lv.3 덤벨 하나로 어깨 깡패 만드는 루틴 (떠먹는홈트)","권혁TV","https://youtu.be/gsFShSYOovU","https://img.youtube.com/vi/gsFShSYOovU/0.jpg",0,"어깨"),
("일반인들이 '식스팩' 만들려면 얼마나 걸릴까? (빠르게 복근 만드는 운동루틴)","보통사람을 위한 운동채널","https://youtu.be/f6MrRoFRG6Y","https://img.youtube.com/vi/f6MrRoFRG6Y/0.jpg",0,"복근"),
("이게 사람 등이야?? 나바1위 선수의 광배근 넓히는 등운동 루틴 feat.정대진","핏블리 FITVELY","https://youtu.be/L_6uy4uWweQ","https://img.youtube.com/vi/L_6uy4uWweQ/0.jpg",0,"등"),
("[가슴루틴] 윗가슴 부터 채우는 가슴운동 루틴 순서/셋트/무게","핏블리 FITVELY","https://youtu.be/ySCSNVnAeFU","https://img.youtube.com/vi/ySCSNVnAeFU/0.jpg",0,"가슴"),
("탄탄한 하체 만드는 필수 하체운동 5가지","준규빌더","https://youtu.be/hrXfOwoEwSI","https://img.youtube.com/vi/hrXfOwoEwSI/0.jpg",0,"하체")
;


SELECT * FROM videos;
SELECT * FROM reviews;
SELECT * FROM users;
