-- phpMyAdmin SQL Dump
-- version 3.3.8.1
-- http://www.phpmyadmin.net
--
-- 主机: w.rdc.sae.sina.com.cn:3307
-- 生成日期: 2015 年 03 月 24 日 22:01
-- 服务器版本: 5.5.23
-- PHP 版本: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `app_unionyhd`
--

-- --------------------------------------------------------

--
-- 表的结构 `wechat_settings`
--

CREATE TABLE IF NOT EXISTS `wechat_settings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL COMMENT '键',
  `val` text NOT NULL COMMENT '值',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `wechat_settings`
--

INSERT INTO `wechat_settings` (`id`, `name`, `val`) VALUES
(5, 'TONKEN', ''),
(6, 'APP_ID', ''),
(7, 'APP_SECRET', ''),
(8, 'ENCODING_AES', '');