-- --------------------------------------------------------
-- 호스트:                          3.34.33.114
-- 서버 버전:                        10.1.48-MariaDB-0ubuntu0.18.04.1 - Ubuntu 18.04
-- 서버 OS:                        debian-linux-gnu
-- HeidiSQL 버전:                  12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- cash 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `cash`;
CREATE DATABASE IF NOT EXISTS `cash` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cash`;

-- 테이블 cash.cashbook 구조 내보내기
DROP TABLE IF EXISTS `cashbook`;
CREATE TABLE IF NOT EXISTS `cashbook` (
  `cashbook_no` int(11) NOT NULL AUTO_INCREMENT,
  `member_id` varchar(50) NOT NULL,
  `category` enum('수입','지출') NOT NULL,
  `cashbook_date` date NOT NULL,
  `price` int(11) NOT NULL,
  `memo` text NOT NULL,
  `updatedate` datetime NOT NULL,
  `createdate` datetime NOT NULL,
  PRIMARY KEY (`cashbook_no`),
  KEY `FK_cashbook_member` (`member_id`),
  CONSTRAINT `FK_cashbook_member` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- 테이블 데이터 cash.cashbook:~11 rows (대략적) 내보내기
INSERT INTO `cashbook` (`cashbook_no`, `member_id`, `category`, `cashbook_date`, `price`, `memo`, `updatedate`, `createdate`) VALUES
	(17, 'admin', '수입', '2023-08-10', 316000, '#서울관악지청 #국비지원', '2023-08-12 17:30:15', '2023-08-12 17:30:15'),
	(19, 'admin', '지출', '2023-08-10', 7000, '#점심 #바른식탁', '2023-08-12 17:31:29', '2023-08-12 17:31:29'),
	(21, 'admin', '지출', '2023-07-04', 6500, '#점심 #밥뜨랑', '2023-08-12 17:39:47', '2023-08-12 17:39:47'),
	(22, 'admin', '지출', '2023-07-05', 6500, '#점심', '2023-08-12 17:45:14', '2023-08-12 17:45:14'),
	(23, 'admin', '수입', '2023-07-12', 500000, '#국민취업지원', '2023-08-14 09:04:02', '2023-08-14 09:04:02'),
	(24, 'admin', '수입', '2023-07-10', 316000, '#서울관악지청', '2023-08-14 09:04:52', '2023-08-14 09:04:52'),
	(25, 'admin', '수입', '2023-06-21', 75000, '#부천세무서 #종합소득세 #환급', '2023-08-14 09:06:20', '2023-08-14 09:06:20'),
	(26, 'admin', '수입', '2023-06-12', 500000, '#국민취업지원', '2023-08-14 09:06:55', '2023-08-14 09:06:55'),
	(27, 'admin', '수입', '2023-06-08', 284400, '#서울관악지청', '2023-08-14 09:07:25', '2023-08-14 09:07:25'),
	(28, 'admin', '수입', '2023-05-15', 316000, '#서울관악지청', '2023-08-14 09:08:16', '2023-08-14 09:08:16'),
	(29, 'admin', '지출', '2023-05-12', 500000, '#국민취업지원', '2023-08-14 09:09:04', '2023-08-14 09:09:04');

-- 테이블 cash.counter 구조 내보내기
DROP TABLE IF EXISTS `counter`;
CREATE TABLE IF NOT EXISTS `counter` (
  `counter_date` date NOT NULL,
  `counter_num` int(11) NOT NULL,
  PRIMARY KEY (`counter_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 cash.counter:~20 rows (대략적) 내보내기
INSERT INTO `counter` (`counter_date`, `counter_num`) VALUES
	('2023-07-09', 2),
	('2023-07-17', 3),
	('2023-07-20', 15),
	('2023-07-21', 2),
	('2023-07-22', 3),
	('2023-07-23', 1),
	('2023-07-25', 2),
	('2023-07-26', 1),
	('2023-07-27', 11),
	('2023-07-28', 8),
	('2023-07-29', 2),
	('2023-07-30', 1),
	('2023-08-02', 11),
	('2023-08-03', 1),
	('2023-08-07', 5),
	('2023-08-08', 1),
	('2023-08-09', 5),
	('2023-08-12', 10),
	('2023-08-13', 1),
	('2023-08-14', 3);

-- 테이블 cash.hashtag 구조 내보내기
DROP TABLE IF EXISTS `hashtag`;
CREATE TABLE IF NOT EXISTS `hashtag` (
  `cashbook_no` int(11) NOT NULL,
  `word` varchar(50) NOT NULL,
  `updatedate` datetime NOT NULL,
  `createdate` datetime NOT NULL,
  PRIMARY KEY (`cashbook_no`,`word`),
  CONSTRAINT `FK_hashtag_cashbook` FOREIGN KEY (`cashbook_no`) REFERENCES `cashbook` (`cashbook_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 cash.hashtag:~16 rows (대략적) 내보내기
INSERT INTO `hashtag` (`cashbook_no`, `word`, `updatedate`, `createdate`) VALUES
	(17, '국비지원', '2023-08-12 17:30:15', '2023-08-12 17:30:15'),
	(17, '서울관악지청', '2023-08-12 17:30:15', '2023-08-12 17:30:15'),
	(19, '바른식탁', '2023-08-12 17:31:29', '2023-08-12 17:31:29'),
	(19, '점심', '2023-08-12 17:31:29', '2023-08-12 17:31:29'),
	(21, '밥뜨랑', '2023-08-12 17:39:47', '2023-08-12 17:39:47'),
	(21, '점심', '2023-08-12 17:39:47', '2023-08-12 17:39:47'),
	(22, '점심', '2023-08-12 17:45:14', '2023-08-12 17:45:14'),
	(23, '국민취업지원', '2023-08-14 09:04:02', '2023-08-14 09:04:02'),
	(24, '서울관악지청', '2023-08-14 09:04:52', '2023-08-14 09:04:52'),
	(25, '부천세무서', '2023-08-14 09:06:20', '2023-08-14 09:06:20'),
	(25, '종합소득세', '2023-08-14 09:06:20', '2023-08-14 09:06:20'),
	(25, '환급', '2023-08-14 09:06:20', '2023-08-14 09:06:20'),
	(26, '국민취업지원', '2023-08-14 09:06:55', '2023-08-14 09:06:55'),
	(27, '서울관악지청', '2023-08-14 09:07:25', '2023-08-14 09:07:25'),
	(28, '서울관악지청', '2023-08-14 09:08:16', '2023-08-14 09:08:16'),
	(29, '국민취업지원', '2023-08-14 09:09:04', '2023-08-14 09:09:04');

-- 테이블 cash.member 구조 내보내기
DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `member_id` varchar(50) NOT NULL,
  `member_pw` varchar(50) NOT NULL,
  `updatedate` datetime NOT NULL,
  `createdate` datetime NOT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 테이블 데이터 cash.member:~1 rows (대략적) 내보내기
INSERT INTO `member` (`member_id`, `member_pw`, `updatedate`, `createdate`) VALUES
	('admin', '*A4B6157319038724E3560894F7F932C8886EBFCF', '2023-08-12 17:29:47', '2023-08-12 17:29:47');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
