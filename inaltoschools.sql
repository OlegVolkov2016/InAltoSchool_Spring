-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Час створення: Січ 11 2016 р., 00:31
-- Версія сервера: 10.1.9-MariaDB
-- Версія PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `inaltoschool_s`
--
CREATE DATABASE IF NOT EXISTS `inaltoschool_s` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `inaltoschool_s`;

-- --------------------------------------------------------

--
-- Структура таблиці `logins`
--

CREATE TABLE IF NOT EXISTS `logins` (
  `login_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Login''s ID',
  `role_id` int(11) NOT NULL COMMENT 'Appropriate role''s ID',
  `login_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'Login''s name',
  `login_password` int(11) NOT NULL COMMENT 'Login''s password hashcode',
  `login_question` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'Login''s security question',
  `login_answer` int(11) NOT NULL COMMENT 'Login''s security answer hashcode',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`login_id`),
  UNIQUE KEY `login_name` (`login_name`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users logins table';

--
-- Дамп даних таблиці `logins`
--

INSERT INTO `logins` (`login_id`, `role_id`, `login_name`, `login_password`, `login_question`, `login_answer`, `created`) VALUES
(1, 1, 'Admin', 92668751, 'Color', 0, '2016-01-09 22:50:12'),
(2, 2, 'Teacher', 2, 'Color', 2, '2016-01-09 22:53:57'),
(3, 3, 'Student', -1879145925, 'Color', 0, '2016-01-09 22:54:15'),
(9, 3, 'Dima', 3599307, 'Color', 112785, '2016-01-10 23:25:44');

-- --------------------------------------------------------

--
-- Структура таблиці `roles`
--

CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Role''s ID',
  `role_name` varchar(50) COLLATE utf8_bin NOT NULL COMMENT 'Role''s name',
  `role_details` text COLLATE utf8_bin COMMENT 'Role''s Information',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users roles (rights) table';

--
-- Дамп даних таблиці `roles`
--

INSERT INTO `roles` (`role_id`, `role_name`, `role_details`, `created`) VALUES
(1, 'Administrator', 'Database administrator', '2016-01-09 19:28:35'),
(2, 'Teacher', 'School teacher', '2016-01-09 19:28:35'),
(3, 'Student', 'School student', '2016-01-09 19:28:35');

-- --------------------------------------------------------

--
-- Структура таблиці `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'User''s ID',
  `login_id` int(11) NOT NULL COMMENT 'Appropriate login''s ID',
  `user_firstname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'User''s first name',
  `user_lastname` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'User ''s last name',
  `user_birthday` date DEFAULT NULL COMMENT 'User''s birthday',
  `user_address` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'User''s address',
  `user_phone` varchar(13) COLLATE utf8_bin DEFAULT NULL COMMENT 'User''s phone',
  `user_email` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'User''s email',
  `user_skype` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT 'User''s skype login',
  `user_details` text COLLATE utf8_bin COMMENT 'User''s information',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login_id` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Users data table';

--
-- Дамп даних таблиці `users`
--

INSERT INTO `users` (`user_id`, `login_id`, `user_firstname`, `user_lastname`, `user_birthday`, `user_address`, `user_phone`, `user_email`, `user_skype`, `user_details`, `created`) VALUES
(1, 1, 'Oleg', 'Volkov', '1974-04-25', 'Kharkiv', '+380504007482', 'novasoft.print@gmail.com', 'novasoft.print', 'www.oleg-volkov.bz.ua', '2016-01-09 22:56:07'),
(2, 2, 'Mykola', 'Kotsuba', '1990-12-12', 'Ukraine', '+380632080781', 'mykolakotsyuba@gmail.com', 'kotsubam', 'www.inaltostudy.info', '2016-01-09 22:58:10'),
(3, 3, 'Alex', 'Colt', '1979-03-25', 'Kharkiv', '+380634424940', 'rsoftdesign@ukr.net', 'rsoftdesign', 'Java Basic', '2016-01-09 22:59:29'),
(5, 9, 'Dima', 'Korobko', '1991-11-24', 'Kharkiv', '', '', '', '', '2016-01-10 23:25:44');

--
-- Обмеження зовнішнього ключа збережених таблиць
--

--
-- Обмеження зовнішнього ключа таблиці `logins`
--
ALTER TABLE `logins`
  ADD CONSTRAINT `logins_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Обмеження зовнішнього ключа таблиці `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`login_id`) REFERENCES `logins` (`login_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
