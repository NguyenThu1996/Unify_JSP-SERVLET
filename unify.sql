-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 28, 2020 lúc 07:10 PM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `unify`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `u_id` int(10) NOT NULL,
  `buyDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`id`, `u_id`, `buyDate`) VALUES
('0a490bea-5f0f-4a77-8f72-525c74f0ddab', 0, '2020-04-23'),
('1', 1, '2020-04-23'),
('13ececf6-2fea-47a9-9b7d-cf81a4471ad0', 0, '2020-04-23'),
('2', 2, '2020-04-17'),
('283f4f9c-73e4-4745-96bc-026846918588', 0, '2020-04-26'),
('c7908783-a36e-4d0d-afd1-3e07212aac73', 0, '2020-04-22'),
('cd5d266d-00d9-4864-9447-959ce9e292d1', 0, '2020-04-23');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cartitem`
--

CREATE TABLE `cartitem` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitPrice` float NOT NULL,
  `pro_id` int(10) NOT NULL,
  `cat_id` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `cate_id` int(10) NOT NULL,
  `cate_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`cate_id`, `cate_name`) VALUES
(1, 'Men'),
(2, 'Woman'),
(3, 'Children');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(10) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `price` float NOT NULL,
  `cate_id` int(10) NOT NULL,
  `des` varchar(2000) COLLATE utf8_unicode_ci NOT NULL,
  `image` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `name`, `price`, `cate_id`, `des`, `image`) VALUES
(1, 'Vest', 23, 1, '<p>Vest</p>\r\n', '1587869990236.jpg'),
(2, 'Shirt01', 45, 2, 'Very good', '1587565460303.jpg'),
(3, 'Shirt', 45000, 2, '<p>relaxed fit linen shirt</p>\r\n', '1587564828514.jpg'),
(4, 'Jean', 40000, 2, '<p>Do you like ?</p>\r\n', '1587565522128.jpg'),
(5, 'T-Shirt', 585, 2, '<p>i like it ! And You ?</p>\r\n', '1587569891170.png'),
(6, ' T-Shirt - Black', 52, 2, '<p>Beatifull Girl</p>\r\n', '1587609385192.jpg'),
(7, 'vest', 230000, 1, '<p>my color</p>\r\n', '1587869528268.jpg'),
(8, 'T-shirt', 200000, 2, '<p>While</p>\r\n', '1587869567002.jpg'),
(9, 'children', 23000, 3, '<p>Babe cute</p>\r\n', '1587869742362.jpg'),
(10, 'children', 340000, 3, '<p>So cute</p>\r\n', '1587869805956.jpg'),
(11, 'Cute', 230000, 3, '<p>my babe&nbsp;</p>\r\n', '1587869854741.png'),
(12, 'Jean', 5600000, 1, '<p>Very Good</p>\r\n', '1587869895666.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(36) COLLATE utf8_unicode_ci NOT NULL,
  `avatar` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `role_id` int(10) NOT NULL,
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `avatar`, `role_id`, `username`) VALUES
(1, 'nguyenvanthu.ptp@gmail.com', '123', '1587571289199.jpg', 1, 'nguyenthu1'),
(2, 'nguyenthu@gmail.com', '123', '1587571266942.jpg', 2, 'nguyenthu2'),
(3, 'nguyenvanthu22.ptp@gmail.com', '123', '1587571009911.jpg', 2, 'user'),
(4, 'nguyenvanthu.ptp@gmail.com', '123', '1587572315786.jpg', 2, 'user'),
(5, 'nguyenvanthu.ptp@gmail.com', '123', '1587606551853.jpg', 1, 'nguyenthu12'),
(7, 'nguyenvanthu123.ptp@gmail.com', '123', '1587608274826.jpg', 1, 'admin01'),
(8, 'nguyenvanthu32.ptp@gmail.com', '123', '1587608337137.jpg', 1, 'admin12'),
(9, 'nguyenvanthu212.ptp@gmail.com', '123', '1587608364598.jpg', 2, 'dely'),
(10, 'nguyenvanthuas.ptp@gmail.com', '3313', '1587608380613.jpg', 2, '12213'),
(11, 'nguyenvanth213u.ptp@gmail.com', '213', '1587608409505.jpg', 2, '3'),
(12, 'nguyenvanth222.ptp@gmail.com', '123', '1587608466251.jpg', 2, 'admin231'),
(13, 'nguyenvanthu.test@gmail.com', '123', '1587873153544.jpg', 2, 'ThuPros'),
(14, 'nguyenvanthu.ptssp@gmail.com', '123', '1587874391771.jpg', 2, 'Thu0202'),
(15, 'nguyenthu0506@gmail.com', '123', NULL, 2, 'user02'),
(16, 'nguyenvanthuasas@gmail.com', '123', NULL, 2, 'nguyenthu03'),
(17, 'nguyenvanthu.itbk@gmail.com', '123', NULL, 2, 'user03'),
(18, 'nguyenvanthu.as@gmail.com', '123', NULL, 2, 'user04'),
(19, 'nguyenvanthusasas.ptp@gmail.com', '123', NULL, 2, 'user05'),
(20, 'nguyenvanthasu.ptp@gmail.com', '123', NULL, 2, 'user06'),
(21, 'nguyenvaasnthsasasu.ptp@gmail.com', '123', NULL, 2, 'user08'),
(22, 'nguyenvanth2222u.ptp@gmail.com', '123', NULL, 2, 'nguyenthu01');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `cartitem`
--
ALTER TABLE `cartitem`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cate_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `cate_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
