-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 08, 2020 lúc 04:38 PM
-- Phiên bản máy phục vụ: 10.1.39-MariaDB
-- Phiên bản PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bookstore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danh_muc_san_pham`
--

CREATE TABLE `danh_muc_san_pham` (
  `id_danh_mucsp` bigint(20) NOT NULL,
  `link_danh_muc` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ten_danh_muc` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `danh_muc_san_pham`
--

INSERT INTO `danh_muc_san_pham` (`id_danh_mucsp`, `link_danh_muc`, `ten_danh_muc`) VALUES
(1, 'khoaHoc', 'Khoa Hoc'),
(2, 'tieuThuyet', 'Tiểu Thuyết');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `don_hang`
--

CREATE TABLE `don_hang` (
  `id_don_hang` bigint(20) NOT NULL,
  `id_nguoi_giao_dich` bigint(20) DEFAULT NULL,
  `id_san_pham` bigint(20) DEFAULT NULL,
  `la_nguoi_dung` bit(1) DEFAULT NULL,
  `ngay_tao` date DEFAULT NULL,
  `nguoi_tao` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `tien` double DEFAULT NULL,
  `trang_thai` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `don_hang`
--

INSERT INTO `don_hang` (`id_don_hang`, `id_nguoi_giao_dich`, `id_san_pham`, `la_nguoi_dung`, `ngay_tao`, `nguoi_tao`, `so_luong`, `tien`, `trang_thai`) VALUES
(21, 5, 1, b'0', '2020-11-08', NULL, 12, 0, '0'),
(22, 5, 2, b'0', '2020-11-08', NULL, 3, 0, '0'),
(23, 1, 1, b'0', '2020-11-08', NULL, 5, 0, '0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giam_gia`
--

CREATE TABLE `giam_gia` (
  `id_giam_gia` bigint(20) NOT NULL,
  `mo_ta` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `nguoi_tao` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `nguoi_thay_doi` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `phan_tram_giam` int(11) DEFAULT NULL,
  `ten_giam_gia` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `trang_thai` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ngay_tao` date DEFAULT NULL,
  `ngay_thay_doi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `giam_gia`
--

INSERT INTO `giam_gia` (`id_giam_gia`, `mo_ta`, `ngay_bat_dau`, `ngay_ket_thuc`, `nguoi_tao`, `nguoi_thay_doi`, `phan_tram_giam`, `ten_giam_gia`, `trang_thai`, `ngay_tao`, `ngay_thay_doi`) VALUES
(1, 'Giảm Giá nhân 10/10', '2020-10-03', '2020-10-31', 'MThien', NULL, 20, 'Giảm Giá nhân 10/10', NULL, '0000-00-00', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giao_dich`
--

CREATE TABLE `giao_dich` (
  `id_giao_dich` bigint(20) NOT NULL,
  `dia_chi_giao_hang` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ghi_chu` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `id_khach_hang` bigint(20) DEFAULT NULL,
  `ngay_tao` date DEFAULT NULL,
  `so_dien_thoai` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `so_tien` double DEFAULT NULL,
  `ten_khach_hang` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_german2_ci NOT NULL,
  `trang_thai` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `giao_dich`
--

INSERT INTO `giao_dich` (`id_giao_dich`, `dia_chi_giao_hang`, `ghi_chu`, `id_khach_hang`, `ngay_tao`, `so_dien_thoai`, `so_tien`, `ten_khach_hang`, `email`, `trang_thai`) VALUES
(1, '59/6Y ấp chánh 1, Xã Tân Xuân', '', 1, '2020-11-08', '0348868611', 395000, 'Thien', 'minhthiennguyen1997@gmail.com', '0');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hinh_anh`
--

CREATE TABLE `hinh_anh` (
  `id_hinh_anh` bigint(20) NOT NULL,
  `id_san_pham` bigint(20) DEFAULT NULL,
  `link` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `sap_xep` int(11) DEFAULT NULL,
  `ten_hinh` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `hinh_anh`
--

INSERT INTO `hinh_anh` (`id_hinh_anh`, `id_san_pham`, `link`, `sap_xep`, `ten_hinh`) VALUES
(1, 1, 'NGK.jpg', 1, 'Nhà Giả kiêm'),
(2, 1, 'NGK_01.jpg', 2, 'NGK_01'),
(3, 1, 'NGK_02.jpg', 3, 'NGK_02'),
(4, 2, 'DNT_01.jpg', 2, 'DNT_01'),
(5, 2, 'DNT_02.jpg', 3, 'DNT_02'),
(6, 2, 'DNT.jpg', 1, 'DNT');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoi_dung`
--

CREATE TABLE `nguoi_dung` (
  `id_nguoi_dung` bigint(20) NOT NULL,
  `dia_chi` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `la_quan_ly` bit(1) DEFAULT NULL,
  `mat_khau` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ngay_tao` date DEFAULT NULL,
  `so_dien_thoai` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ten_nguoi_dung` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoi_dung`
--

INSERT INTO `nguoi_dung` (`id_nguoi_dung`, `dia_chi`, `email`, `la_quan_ly`, `mat_khau`, `ngay_tao`, `so_dien_thoai`, `ten_nguoi_dung`) VALUES
(1, '59/6Y ấp chánh 1, Xã Tân Xuân', 'minhthiennguyen1997@gmail.com', b'0', '111', '2020-10-24', '0348868611', 'Thien'),
(3, '1', 'thu@gmail.com', b'0', '1', '2020-10-24', '111', 'Thu'),
(4, '11', 'viphan@gmail.com', b'0', '1', '2020-11-07', '111', 'Phan Vi'),
(5, '11', 'thanh@gmail.com', b'0', '1', '2020-11-07', '111', 'Thanh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `san_pham`
--

CREATE TABLE `san_pham` (
  `id_san_pham` bigint(20) NOT NULL,
  `gia` double DEFAULT NULL,
  `id_danh_mucsp` int(11) DEFAULT NULL,
  `id_giam_gia` int(11) DEFAULT NULL,
  `luot_thich` int(11) DEFAULT NULL,
  `luot_xem` int(11) DEFAULT NULL,
  `mo_ta` text COLLATE utf8mb4_german2_ci,
  `tac_gia` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `nha_xuat_ban` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ngay_tao` date DEFAULT NULL,
  `ngay_thay_doi` date DEFAULT NULL,
  `nguoi_tao` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `nguoi_thay_doi` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `so_luong` int(11) DEFAULT NULL,
  `ten_san_pham` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `trang_thai` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Đang đổ dữ liệu cho bảng `san_pham`
--

INSERT INTO `san_pham` (`id_san_pham`, `gia`, `id_danh_mucsp`, `id_giam_gia`, `luot_thich`, `luot_xem`, `mo_ta`, `tac_gia`, `nha_xuat_ban`, `ngay_tao`, `ngay_thay_doi`, `nguoi_tao`, `nguoi_thay_doi`, `so_luong`, `ten_san_pham`, `trang_thai`) VALUES
(1, 79000, 1, 1, 1, 1, 'Tất cả những trải nghiệm trong chuyến phiêu du theo đuổi vận mệnh của mình đã giúp Santiago thấu hiểu được ý nghĩa sâu xa nhất của hạnh phúc, hòa hợp với vũ trụ và con người.', '', '', '2020-10-04', NULL, 'MThien', NULL, 100, 'Nhà Giả Kim', NULL),
(2, 76000, 1, 0, 1, 1, 'Đắc nhân tâm của Dale Carnegie là quyển sách của mọi thời đại và một hiện tượng đáng kinh ngạc trong ngành xuất bản Hoa Kỳ.', '', '', '2020-10-04', NULL, 'MThien', NULL, 100, 'Đắc Nhân Tâm', NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `slide`
--

CREATE TABLE `slide` (
  `id` bigint(20) NOT NULL,
  `chi_tiet` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `hinh` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `link` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `ngay_tao` date DEFAULT NULL,
  `ngay_thay_doi` date DEFAULT NULL,
  `nguoi_tao` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `nguoi_thay_doi` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL,
  `thu_tu_hien_thi` int(11) DEFAULT NULL,
  `tieu_de` varchar(255) COLLATE utf8mb4_german2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_german2_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `danh_muc_san_pham`
--
ALTER TABLE `danh_muc_san_pham`
  ADD PRIMARY KEY (`id_danh_mucsp`);

--
-- Chỉ mục cho bảng `don_hang`
--
ALTER TABLE `don_hang`
  ADD PRIMARY KEY (`id_don_hang`);

--
-- Chỉ mục cho bảng `giam_gia`
--
ALTER TABLE `giam_gia`
  ADD PRIMARY KEY (`id_giam_gia`);

--
-- Chỉ mục cho bảng `giao_dich`
--
ALTER TABLE `giao_dich`
  ADD PRIMARY KEY (`id_giao_dich`);

--
-- Chỉ mục cho bảng `hinh_anh`
--
ALTER TABLE `hinh_anh`
  ADD PRIMARY KEY (`id_hinh_anh`);

--
-- Chỉ mục cho bảng `nguoi_dung`
--
ALTER TABLE `nguoi_dung`
  ADD PRIMARY KEY (`id_nguoi_dung`);

--
-- Chỉ mục cho bảng `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`id_san_pham`);

--
-- Chỉ mục cho bảng `slide`
--
ALTER TABLE `slide`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `danh_muc_san_pham`
--
ALTER TABLE `danh_muc_san_pham`
  MODIFY `id_danh_mucsp` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `don_hang`
--
ALTER TABLE `don_hang`
  MODIFY `id_don_hang` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `giam_gia`
--
ALTER TABLE `giam_gia`
  MODIFY `id_giam_gia` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `giao_dich`
--
ALTER TABLE `giao_dich`
  MODIFY `id_giao_dich` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `hinh_anh`
--
ALTER TABLE `hinh_anh`
  MODIFY `id_hinh_anh` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `nguoi_dung`
--
ALTER TABLE `nguoi_dung`
  MODIFY `id_nguoi_dung` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `san_pham`
--
ALTER TABLE `san_pham`
  MODIFY `id_san_pham` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `slide`
--
ALTER TABLE `slide`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
