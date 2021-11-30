-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 30, 2021 lúc 08:04 AM
-- Phiên bản máy phục vụ: 10.4.11-MariaDB
-- Phiên bản PHP: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `spring_clean`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking`
--

CREATE TABLE `booking` (
  `id` int(11) NOT NULL,
  `amount` float DEFAULT NULL,
  `created` varchar(255) DEFAULT NULL,
  `ct_items_id` int(11) DEFAULT NULL,
  `shift_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `booking`
--

INSERT INTO `booking` (`id`, `amount`, `created`, `ct_items_id`, `shift_id`, `user_id`, `address`, `email`, `full_name`, `phone_number`, `message`, `start_date`, `status`) VALUES
(1, 450000, '2021-11-29', 7, 3, 1, 'Hà Nội', 'minhnha2308@gmail.com', 'Nguyễn Minh Nhã', '0379572434', 'Tới sớm giúp mình', '2021-11-30', 1),
(2, 400000, '2021-11-29', 7, 1, 1, 'Hà Nội', 'minhnha2308@gmail.com', 'Nguyễn Minh Nhã', '0379572434', 'ok', '2021-11-29', 0),
(3, 450000, '2021-11-29', 7, 1, 3, 'Hà Nội', 'minhhuy@gmail.com', 'Minh Huy', '0394073456', 'Khi nào tới hãy liên lạc qua sdt cho tôi', '2021-11-30', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `booking_items`
--

CREATE TABLE `booking_items` (
  `id` int(11) NOT NULL,
  `booking_id` int(11) DEFAULT NULL,
  `items_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `booking_items`
--

INSERT INTO `booking_items` (`id`, `booking_id`, `items_id`) VALUES
(1, 1, 10),
(2, 2, 10),
(3, 3, 10),
(4, 3, 12);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category_items`
--

CREATE TABLE `category_items` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category_items`
--

INSERT INTO `category_items` (`id`, `description`, `name`, `price`, `image`) VALUES
(7, '<p>Dịch vụ vệ sinh Mr Guru cung cấp các dịch vụ vệ sinh linh hoạt, giá cả phải chăng và đáng tin cậy để đáp ứng nhu cầu của bạn. Báo giá tại chỗ miễn phí nghĩa vụ được cung cấp để bạn biết chính xác những gì bạn sẽ trả cho.</p>', 'Dọn nhà thường xuyên', 100000, '1638254120031.jpg'),
(2, '<p>Chúng tôi cung cấp các dịch vụ vệ sinh đáng tin cậy và giá cả phải chăng cho văn phòng hoặc cửa hàng của bạn. Cộng với đảm bảo hài lòng đáng kinh ngạc!</p>', 'Làm sạch thương mại', 3000000, '1638254192804.jpg'),
(3, '<p>Dọn dẹp hoàn hảo để đưa ngôi nhà của bạn trở lại tình trạng sáng bóng.</p><p>Dịch vụ dọn dẹp này rất được khuyến khích trước khi bán tài sản của bạn.</p>', 'Làm sạch sau mùa xuân', 1000000, '1638254286179.jpg'),
(4, '<p>Được trang bị máy móc tiên tiến và mạnh mẽ nhất trên thị trường cùng sự chú ý đến từng chi tiết, chúng tôi tự tin khẳng định mình là nhà sản xuất máy giặt thảm hơi nước hàng đầu tại Canberra.</p>', 'Làm sạch thảm bằng hơi nước', 1500000, '1638254203477.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `items`
--

INSERT INTO `items` (`id`, `name`, `price`, `category_id`) VALUES
(10, 'Phun khử khuẩn', 100000, 7),
(11, 'Xông hơi không khí', 150000, 2),
(12, 'Dọn nhà bếp', 100000, 7),
(13, 'Hơi nước tinh dầu thơm', 100000, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `review`
--

CREATE TABLE `review` (
  `id` int(11) NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `ct_items_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `created` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `review`
--

INSERT INTO `review` (`id`, `comment`, `ct_items_id`, `user_id`, `created`) VALUES
(1, 'Dịch vụ chất lượng, dọn dẹp rất sạch sẽ', 7, 1, NULL),
(2, 'Nhân viên nhiệt tình, vệ sinh ok và sạch', 2, 2, NULL),
(3, 'dịch vụ rất ok', 7, 1, '2021-11-29'),
(4, 'Dịch vụ oke, sạch sẽ', 7, 3, '2021-11-29');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `shift`
--

CREATE TABLE `shift` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `shift`
--

INSERT INTO `shift` (`id`, `name`, `price`) VALUES
(1, 'Buổi Sáng', 150000),
(2, 'Buổi Trưa', 200000),
(3, 'Buổi chiều', 250000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(128) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `address`, `email`, `full_name`, `password`, `phone_number`, `status`, `user_name`) VALUES
(1, 'ádasd', 'minhnha2308@gmail.com', 'Nguyễn Minh Nhã', '25f9e794323b453885f5181f1b624d0b', '0379572434', 0, 'use'),
(2, NULL, 'nguoidung@gmail.com', 'Người Dùng', 'a916938188dc916c35fba826dd78633b', NULL, 0, 'nguoidung'),
(3, 'Hà Nội', 'minhhuy@gmail.com', 'Minh Huy', 'a95271e4a0bb9d05889d674834cc732f', '0394073512', 0, 'minhhuy');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhqwrv53d9q2ijay3ccw2wu3as` (`ct_items_id`),
  ADD KEY `FKo68uipbvb50hoffcx4mrkmjwg` (`shift_id`),
  ADD KEY `FKkgseyy7t56x7lkjgu3wah5s3t` (`user_id`);

--
-- Chỉ mục cho bảng `booking_items`
--
ALTER TABLE `booking_items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj89vr9gn43bvwg4qd0h7p5lym` (`booking_id`),
  ADD KEY `FK40lalb20wg5o71chlfsbia0df` (`items_id`);

--
-- Chỉ mục cho bảng `category_items`
--
ALTER TABLE `category_items`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkkclv9lmg7rvobko2u6lbvt03` (`category_id`);

--
-- Chỉ mục cho bảng `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6xcm2xkxhtpgenglfmaowtcc6` (`ct_items_id`),
  ADD KEY `FKiyf57dy48lyiftdrf7y87rnxi` (`user_id`);

--
-- Chỉ mục cho bảng `shift`
--
ALTER TABLE `shift`
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
-- AUTO_INCREMENT cho bảng `booking`
--
ALTER TABLE `booking`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `booking_items`
--
ALTER TABLE `booking_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `category_items`
--
ALTER TABLE `category_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT cho bảng `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `review`
--
ALTER TABLE `review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `shift`
--
ALTER TABLE `shift`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
