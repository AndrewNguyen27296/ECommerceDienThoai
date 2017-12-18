-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2017 at 05:27 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `banmobilec2c`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(250) NOT NULL,
  `mat_khau` varchar(250) NOT NULL,
  `ho_ten` varchar(250) NOT NULL,
  `so_dien_thoai` varchar(11) NOT NULL,
  `so_tai_khoan` varchar(12) NOT NULL,
  `dia_chi` varchar(250) NOT NULL,
  `trang_thai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `email`, `mat_khau`, `ho_ten`, `so_dien_thoai`, `so_tai_khoan`, `dia_chi`, `trang_thai`) VALUES
(1, 'dactien020796@gmail.com', '1', 'Le Dac Tien', '01234020796', '111111111111', '85/24 Phạm Văn Hai, P.3, Q.Tân Bình', b'1'),
(2, 'nguyenhuuthien27296_webmaster@gmail.com', '123456789', 'nguyen huu thien', '0903506796', '012345678', '237 thoai ngoc hau', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `bien_ban_khoa`
--

CREATE TABLE `bien_ban_khoa` (
  `id` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `ngay_khoa` datetime NOT NULL,
  `ly_do` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bien_ban_khoa`
--

INSERT INTO `bien_ban_khoa` (`id`, `id_nguoi_ban`, `ngay_khoa`, `ly_do`) VALUES
(1, 1, '2017-12-17 01:37:48', '3 lần bị đánh giá 1 sao');

-- --------------------------------------------------------

--
-- Table structure for table `bien_ban_khoa_vinh_vien`
--

CREATE TABLE `bien_ban_khoa_vinh_vien` (
  `id` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `ngay_khoa_vinh_vien` datetime NOT NULL,
  `ly_do` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `cau_hinh`
--

CREATE TABLE `cau_hinh` (
  `id` int(11) NOT NULL,
  `so_lan_block` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cau_hinh`
--

INSERT INTO `cau_hinh` (`id`, `so_lan_block`) VALUES
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `ct_phieu_mua_hang`
--

CREATE TABLE `ct_phieu_mua_hang` (
  `id` int(11) NOT NULL,
  `id_phieu_mua_hang` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `id_san_pham` int(11) NOT NULL,
  `gia_ban` decimal(10,0) NOT NULL,
  `so_luong_mua` int(11) NOT NULL,
  `thanh_tien` decimal(10,0) NOT NULL,
  `ngay_giao_hang` datetime DEFAULT NULL,
  `id_tinh_trang` char(2) NOT NULL,
  `danh_gia` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ct_phieu_mua_hang`
--

INSERT INTO `ct_phieu_mua_hang` (`id`, `id_phieu_mua_hang`, `id_nguoi_ban`, `id_san_pham`, `gia_ban`, `so_luong_mua`, `thanh_tien`, `ngay_giao_hang`, `id_tinh_trang`, `danh_gia`) VALUES
(1, 1, 1, 2, '5499000', 1, '5499000', '2017-12-18 00:00:00', 'TC', 0),
(2, 2, 2, 1, '14500000', 1, '14500000', NULL, 'DG', 0),
(3, 3, 2, 1, '14500000', 1, '14500000', NULL, 'DG', 0),
(4, 4, 1, 2, '5499000', 1, '5499000', NULL, 'DH', 0),
(5, 5, 2, 1, '14500000', 1, '14500000', NULL, 'XL', 0),
(6, 6, 1, 2, '5499000', 1, '5499000', '2017-12-18 00:00:00', 'TC', 1),
(7, 7, 2, 1, '14500000', 1, '14500000', NULL, 'XL', 0),
(8, 8, 2, 1, '14500000', 1, '14500000', '2017-12-16 00:00:00', 'TC', 1),
(9, 8, 1, 2, '5499000', 1, '5499000', NULL, 'DH', 1),
(10, 9, 2, 1, '14500000', 1, '14500000', NULL, 'XL', 0),
(11, 10, 1, 3, '6990000', 1, '6990000', '2017-12-18 21:33:04', 'TC', 0);

-- --------------------------------------------------------

--
-- Table structure for table `danh_gia`
--

CREATE TABLE `danh_gia` (
  `id` int(11) NOT NULL,
  `id_nguoi_mua` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `so_diem` int(11) NOT NULL,
  `su_dung` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `danh_gia`
--

INSERT INTO `danh_gia` (`id`, `id_nguoi_mua`, `id_nguoi_ban`, `so_diem`, `su_dung`) VALUES
(1, 4, 1, 4, b'1'),
(2, 4, 2, 1, b'1'),
(3, 4, 1, 1, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `goi_tin`
--

CREATE TABLE `goi_tin` (
  `id` int(11) NOT NULL,
  `ten_goi_tin` varchar(250) NOT NULL,
  `so_tin` int(11) NOT NULL,
  `gia_ban` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `goi_tin`
--

INSERT INTO `goi_tin` (`id`, `ten_goi_tin`, `so_tin`, `gia_ban`) VALUES
(1, 'Gói tiêu chuẩn', 5, '100000'),
(2, 'Gói bạc', 10, '200000'),
(3, 'Gói vàng', 15, '300000');

-- --------------------------------------------------------

--
-- Table structure for table `hang_san_xuat`
--

CREATE TABLE `hang_san_xuat` (
  `id` int(11) NOT NULL,
  `ten_hang` varchar(250) NOT NULL,
  `logo_hang` varchar(250) NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hang_san_xuat`
--

INSERT INTO `hang_san_xuat` (`id`, `ten_hang`, `logo_hang`, `an_hien`) VALUES
(1, 'Apple', '', b'1'),
(2, 'Samsung', '', b'1'),
(3, 'Oppo', '', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `khu_vuc`
--

CREATE TABLE `khu_vuc` (
  `id` int(11) NOT NULL,
  `ten_khu_vuc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `nguoi_ban`
--

CREATE TABLE `nguoi_ban` (
  `id` int(11) NOT NULL,
  `email` varchar(250) NOT NULL,
  `mat_khau` varchar(250) NOT NULL,
  `ho_ten` varchar(250) NOT NULL,
  `cmnd` varchar(12) NOT NULL,
  `so_dien_thoai` varchar(11) NOT NULL,
  `dia_chi` varchar(250) NOT NULL,
  `ngay_dang_ky` datetime NOT NULL,
  `so_lan_canh_cao` int(11) NOT NULL,
  `so_lan_bi_block` int(11) NOT NULL,
  `kich_hoat` bit(1) NOT NULL,
  `bi_khoa` bit(1) NOT NULL,
  `bi_block` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nguoi_ban`
--

INSERT INTO `nguoi_ban` (`id`, `email`, `mat_khau`, `ho_ten`, `cmnd`, `so_dien_thoai`, `dia_chi`, `ngay_dang_ky`, `so_lan_canh_cao`, `so_lan_bi_block`, `kich_hoat`, `bi_khoa`, `bi_block`) VALUES
(1, 'dactien020796@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Le Dac Tiến heo', '025489056', '01234020796', '85/24 Phạm Văn Hai, P.3, Q.Tân Bình', '2017-11-21 00:00:00', 0, 1, b'1', b'0', b'0'),
(2, 'huuthien27296@gmail.com', '1', 'Nguyễn Hữu Thiện', '012345678', '01234020796', '24 An Dương Vương', '2017-11-27 00:00:00', 1, 0, b'0', b'0', b'0');

-- --------------------------------------------------------

--
-- Table structure for table `nguoi_mua`
--

CREATE TABLE `nguoi_mua` (
  `id` int(11) NOT NULL,
  `id_thanh_pho` int(11) NOT NULL,
  `id_quan_huyen` int(11) NOT NULL,
  `email` varchar(250) NOT NULL,
  `mat_khau` varchar(250) NOT NULL,
  `ho_ten` varchar(250) NOT NULL,
  `so_dien_thoai` varchar(11) NOT NULL,
  `dia_chi` varchar(250) NOT NULL,
  `ngay_dang_ky` datetime NOT NULL,
  `kich_hoat` bit(1) NOT NULL,
  `trang_thai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nguoi_mua`
--

INSERT INTO `nguoi_mua` (`id`, `id_thanh_pho`, `id_quan_huyen`, `email`, `mat_khau`, `ho_ten`, `so_dien_thoai`, `dia_chi`, `ngay_dang_ky`, `kich_hoat`, `trang_thai`) VALUES
(4, 1, 1, 'dactien020796@gmail.com', 'e10adc3949ba59abbe56e057f20f883e', 'Lê Đắc Tiến', '01234020796', '85/21 pham van hai, p.3', '2017-12-14 22:41:25', b'0', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `phieu_mua_hang`
--

CREATE TABLE `phieu_mua_hang` (
  `id` int(11) NOT NULL,
  `id_nguoi_mua` int(11) NOT NULL,
  `email` varchar(250) NOT NULL,
  `so_dien_thoai` varchar(11) NOT NULL,
  `ten_nguoi_nhan` varchar(250) NOT NULL,
  `dia_chi_giao` varchar(250) NOT NULL,
  `id_phuong_xa` int(11) NOT NULL,
  `id_quan_huyen` int(11) NOT NULL,
  `id_thanh_pho` int(11) NOT NULL,
  `ghi_chu` varchar(250) DEFAULT NULL,
  `ngay_dat_hang` datetime NOT NULL,
  `tong_tien` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `phieu_mua_hang`
--

INSERT INTO `phieu_mua_hang` (`id`, `id_nguoi_mua`, `email`, `so_dien_thoai`, `ten_nguoi_nhan`, `dia_chi_giao`, `id_phuong_xa`, `id_quan_huyen`, `id_thanh_pho`, `ghi_chu`, `ngay_dat_hang`, `tong_tien`) VALUES
(1, 4, 'dactien020796@gmail.com', '01234020796', 'Lê Đắc Tiến', '85/21 pham van hai, p.3', 0, 1, 1, '', '2017-12-15 12:28:52', '5499000'),
(2, 4, 'dactien020796@gmail.com', '01234020796', 'Nguyễn Thị Mỹ Ly', 'nguyen canh chan', 0, 1, 1, '', '2017-12-15 12:37:46', '14500000'),
(3, 4, 'dactien020796@gmail.com', '01234020796', 'Lê Đắc Tiến', '85/21 pham van hai, p.3', 0, 1, 1, '', '2017-12-15 12:44:21', '14500000'),
(4, 4, 'dactien020796@gmail.com', '01234020796', 'Lê Đắc Tiến', '85/21 pham van hai, p.3', 0, 1, 1, '', '2017-12-15 13:09:32', '5499000'),
(5, 4, 'dactien020796@gmail.com', '01234020796', 'Lê Đắc Tiến', '85/21 pham van hai, p.3', 0, 1, 1, '', '2017-12-15 13:34:32', '14500000'),
(6, 4, 'dactien020796@gmail.com', '01234020796', 'Lê Đắc Tiến', '85/21 pham van hai, p.3', 0, 1, 1, '', '2017-12-15 13:41:08', '5499000'),
(7, 4, 'dactien020796@gmail.com', '01234020796', 'Lê Đắc Tiến', '85/21 pham van hai, p.3', 0, 1, 1, '', '2017-12-15 14:26:01', '14500000'),
(8, 4, 'dactien020796@gmail.com', '01234020796', 'Lê Đắc Tiến', '85/21 pham van hai, p.3', 0, 1, 1, '', '2017-12-15 14:41:29', '19999000'),
(9, 4, 'dactien020796@gmail.com', '0982823016', 'Nguyễn Thị Mỹ Ly', 'nguyen canh chan', 0, 1, 1, '', '2017-12-15 14:51:52', '14500000'),
(10, 4, 'dactien020796@gmail.com', '01234270296', 'Nguyễn Hữu Thiện', '85/21 pham van hai', 0, 2, 1, '', '2017-12-18 21:26:26', '6990000');

-- --------------------------------------------------------

--
-- Table structure for table `phieu_mua_tin`
--

CREATE TABLE `phieu_mua_tin` (
  `id` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `id_goi_tin` int(11) NOT NULL,
  `gia_ban` decimal(10,0) NOT NULL,
  `ngay_mua` datetime NOT NULL,
  `phuong_thuc_thanh_toan` int(11) NOT NULL,
  `trang_thai` bit(1) NOT NULL,
  `payment_id` varchar(200) NOT NULL,
  `payer_id` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `phieu_mua_tin_offline`
--

CREATE TABLE `phieu_mua_tin_offline` (
  `id` int(11) NOT NULL,
  `id_admin` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `id_goi_tin` int(11) NOT NULL,
  `gia_ban` decimal(10,0) NOT NULL,
  `ngay_mua` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `phieu_mua_tin_offline`
--

INSERT INTO `phieu_mua_tin_offline` (`id`, `id_admin`, `id_nguoi_ban`, `id_goi_tin`, `gia_ban`, `ngay_mua`) VALUES
(1, 1, 1, 2, '200000', '2017-12-17 16:58:46'),
(2, 1, 1, 3, '300000', '2017-12-18 23:01:13'),
(3, 1, 1, 1, '100000', '2017-12-18 23:02:01'),
(4, 1, 1, 1, '100000', '2017-12-18 23:03:33');

-- --------------------------------------------------------

--
-- Table structure for table `phieu_nop_phat`
--

CREATE TABLE `phieu_nop_phat` (
  `id` int(11) NOT NULL,
  `id_admin` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `ngay_nop_phat` datetime NOT NULL,
  `so_tien` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `phieu_nop_phat`
--

INSERT INTO `phieu_nop_phat` (`id`, `id_admin`, `id_nguoi_ban`, `ngay_nop_phat`, `so_tien`) VALUES
(1, 1, 1, '2017-12-17 11:14:05', '200000');

-- --------------------------------------------------------

--
-- Table structure for table `quan_huyen`
--

CREATE TABLE `quan_huyen` (
  `id` int(11) NOT NULL,
  `id_thanh_pho` int(11) NOT NULL,
  `ten_quan_huyen` varchar(250) NOT NULL,
  `loai` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `quan_huyen`
--

INSERT INTO `quan_huyen` (`id`, `id_thanh_pho`, `ten_quan_huyen`, `loai`) VALUES
(1, 1, 'Quận 1', ''),
(2, 1, 'Quận 2', '');

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE `san_pham` (
  `id` int(11) NOT NULL,
  `ten_may` varchar(500) NOT NULL,
  `hinh_anh` varchar(250) NOT NULL,
  `gia_ban` decimal(10,0) NOT NULL,
  `so_luong` int(11) NOT NULL,
  `id_hang_san_xuat` int(11) NOT NULL,
  `mo_ta` varchar(500) NOT NULL,
  `kich_thuoc_man_hinh` varchar(250) NOT NULL,
  `cpu` varchar(250) NOT NULL,
  `toc_do_cpu` varchar(250) NOT NULL,
  `ram` varchar(250) NOT NULL,
  `bo_nho_trong` varchar(250) NOT NULL,
  `he_dieu_hanh` varchar(250) NOT NULL,
  `camera_truoc` varchar(250) NOT NULL,
  `camera_sau` varchar(250) NOT NULL,
  `dung_luong_pin` varchar(250) NOT NULL,
  `the_nho_ngoai` bit(1) NOT NULL,
  `khang_nuoc` bit(1) NOT NULL,
  `bao_hanh` varchar(250) NOT NULL,
  `ton_kho` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `ngay_dang` datetime NOT NULL,
  `so_lan_xem` int(11) NOT NULL,
  `so_lan_mua` int(11) NOT NULL,
  `bi_danh` varchar(500) NOT NULL,
  `trang_thai` bit(1) NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `san_pham`
--

INSERT INTO `san_pham` (`id`, `ten_may`, `hinh_anh`, `gia_ban`, `so_luong`, `id_hang_san_xuat`, `mo_ta`, `kich_thuoc_man_hinh`, `cpu`, `toc_do_cpu`, `ram`, `bo_nho_trong`, `he_dieu_hanh`, `camera_truoc`, `camera_sau`, `dung_luong_pin`, `the_nho_ngoai`, `khang_nuoc`, `bao_hanh`, `ton_kho`, `id_nguoi_ban`, `ngay_dang`, `so_lan_xem`, `so_lan_mua`, `bi_danh`, `trang_thai`, `an_hien`) VALUES
(1, 'Iphone 6 Plus lock 16GB', '1001.png', '14500000', 2, 1, 'Máy mới đẹp 99%. Phụ kiện zin đầy đủ. Bảo hành 12 tháng', '5 - 6 inch', 'Apple', '1.4 GHz', '1 - 2 GB', '16 GB', 'iOS', '1.2 MP', '8 MP', '2915 mAh', b'0', b'0', '12 tháng', 10, 2, '2017-11-28 00:00:00', 0, 0, '', b'1', b'1'),
(2, 'Samsung Galaxy J7 Pro Fullbox Hàng chính hãng Samsung', 'samsung-galaxy-j7-pro-2323-400x460.png', '5499000', 4, 2, 'Samsung Galaxy J7 Pro là một chiếc smartphone phù hợp với những người yêu thích một sản phẩm pin tốt, thích hệ điều hành mới cùng những tính năng đi kèm độc quyền của Samsung.', '5.5 inch', 'Exynos', '1.6 GHz', '3 GB', '32 GB', 'Android', '13 MP', '13 MP', '3600 mAh', b'1', b'0', '6 tháng', 3, 1, '2017-12-01 00:00:00', 0, 0, '', b'1', b'1'),
(3, 'Oppo F5 99% like new', 'oppo-f5-h1-400x460.png', '6990000', 4, 3, 'Oppo f5 like new nhé mọi người ơi', '5,99 inch', 'Mediatek', '2.2 GHz', '6 GB', '64 GB', 'Android', '20 MP', '16 MP', '3200 mAh', b'1', b'1', '6 tháng', 5, 1, '2017-12-18 00:00:00', 0, 0, '', b'1', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `so_tin_ton`
--

CREATE TABLE `so_tin_ton` (
  `id` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `so_tin_ton` int(11) NOT NULL,
  `so_tin_da_dung` int(11) NOT NULL,
  `ngay_cap_nhat` datetime NOT NULL,
  `tang_giam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `so_tin_ton`
--

INSERT INTO `so_tin_ton` (`id`, `id_nguoi_ban`, `so_tin_ton`, `so_tin_da_dung`, `ngay_cap_nhat`, `tang_giam`) VALUES
(1, 1, 15, 0, '2017-12-18 23:01:14', 15),
(2, 1, 20, 0, '2017-12-18 23:02:01', 5),
(3, 1, 25, 0, '2017-12-18 23:03:33', 5);

-- --------------------------------------------------------

--
-- Table structure for table `thanh_pho`
--

CREATE TABLE `thanh_pho` (
  `id` int(11) NOT NULL,
  `ten_thanh_pho` varchar(250) NOT NULL,
  `loai` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `thanh_pho`
--

INSERT INTO `thanh_pho` (`id`, `ten_thanh_pho`, `loai`) VALUES
(1, 'Hồ Chí Minh', ''),
(2, 'Hà Nội', '');

-- --------------------------------------------------------

--
-- Table structure for table `tinh_trang`
--

CREATE TABLE `tinh_trang` (
  `id` char(2) NOT NULL,
  `ten_mo_ta` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tinh_trang`
--

INSERT INTO `tinh_trang` (`id`, `ten_mo_ta`) VALUES
('DG', 'Đang giao'),
('DH', 'Đã hủy'),
('TC', 'Thành công'),
('XL', 'Đang xử lý');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bien_ban_khoa`
--
ALTER TABLE `bien_ban_khoa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bienban_nguoiban` (`id_nguoi_ban`);

--
-- Indexes for table `bien_ban_khoa_vinh_vien`
--
ALTER TABLE `bien_ban_khoa_vinh_vien`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bienbankhoavinhvien_nguoiban` (`id_nguoi_ban`);

--
-- Indexes for table `cau_hinh`
--
ALTER TABLE `cau_hinh`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ct_phieu_mua_hang`
--
ALTER TABLE `ct_phieu_mua_hang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ctphieumuahang_nguoiban` (`id_nguoi_ban`),
  ADD KEY `fk_phieumuahang_sanpham` (`id_san_pham`),
  ADD KEY `fk_phieumuahang_tinhtrrang` (`id_tinh_trang`),
  ADD KEY `fk_phieumuahang_phieumuahang` (`id_phieu_mua_hang`);

--
-- Indexes for table `danh_gia`
--
ALTER TABLE `danh_gia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_danhgia_nguoiban` (`id_nguoi_ban`),
  ADD KEY `fk_danhgia_nguoimua` (`id_nguoi_mua`);

--
-- Indexes for table `goi_tin`
--
ALTER TABLE `goi_tin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hang_san_xuat`
--
ALTER TABLE `hang_san_xuat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `khu_vuc`
--
ALTER TABLE `khu_vuc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nguoi_ban`
--
ALTER TABLE `nguoi_ban`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `nguoi_mua`
--
ALTER TABLE `nguoi_mua`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_nguoimua_thanhpho` (`id_thanh_pho`),
  ADD KEY `fk_nguoimua_quanhuyen` (`id_quan_huyen`);

--
-- Indexes for table `phieu_mua_hang`
--
ALTER TABLE `phieu_mua_hang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_phieumuahang_phuongxa` (`id_phuong_xa`),
  ADD KEY `fk_phieumuahang_quanhuyen` (`id_quan_huyen`),
  ADD KEY `fk_phieumuahang_thanhpho` (`id_thanh_pho`),
  ADD KEY `fk_phieumuahang_nguoimua` (`id_nguoi_mua`);

--
-- Indexes for table `phieu_mua_tin`
--
ALTER TABLE `phieu_mua_tin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_phieumuatin_goitin` (`id_goi_tin`),
  ADD KEY `fk_phieumuatin_nguoiban` (`id_nguoi_ban`);

--
-- Indexes for table `phieu_mua_tin_offline`
--
ALTER TABLE `phieu_mua_tin_offline`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_phieumuatin_admin` (`id_admin`),
  ADD KEY `fk_phieumuatinoff_nguoiban` (`id_nguoi_ban`),
  ADD KEY `fk_phieumuatinoff_goitin` (`id_goi_tin`);

--
-- Indexes for table `phieu_nop_phat`
--
ALTER TABLE `phieu_nop_phat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_nopphat_admin` (`id_admin`),
  ADD KEY `fk_nopphat_nguoiban` (`id_nguoi_ban`);

--
-- Indexes for table `quan_huyen`
--
ALTER TABLE `quan_huyen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_thanhpho_quanhuyen` (`id_thanh_pho`);

--
-- Indexes for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_sanpham_hsx` (`id_hang_san_xuat`),
  ADD KEY `fk_sanpham_nguoiban` (`id_nguoi_ban`);

--
-- Indexes for table `so_tin_ton`
--
ALTER TABLE `so_tin_ton`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_tinton_nguoiban` (`id_nguoi_ban`);

--
-- Indexes for table `thanh_pho`
--
ALTER TABLE `thanh_pho`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tinh_trang`
--
ALTER TABLE `tinh_trang`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `bien_ban_khoa`
--
ALTER TABLE `bien_ban_khoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `bien_ban_khoa_vinh_vien`
--
ALTER TABLE `bien_ban_khoa_vinh_vien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cau_hinh`
--
ALTER TABLE `cau_hinh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `ct_phieu_mua_hang`
--
ALTER TABLE `ct_phieu_mua_hang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `danh_gia`
--
ALTER TABLE `danh_gia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `goi_tin`
--
ALTER TABLE `goi_tin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `hang_san_xuat`
--
ALTER TABLE `hang_san_xuat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `khu_vuc`
--
ALTER TABLE `khu_vuc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `nguoi_ban`
--
ALTER TABLE `nguoi_ban`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `nguoi_mua`
--
ALTER TABLE `nguoi_mua`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `phieu_mua_hang`
--
ALTER TABLE `phieu_mua_hang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `phieu_mua_tin`
--
ALTER TABLE `phieu_mua_tin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `phieu_mua_tin_offline`
--
ALTER TABLE `phieu_mua_tin_offline`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `phieu_nop_phat`
--
ALTER TABLE `phieu_nop_phat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `quan_huyen`
--
ALTER TABLE `quan_huyen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `san_pham`
--
ALTER TABLE `san_pham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `so_tin_ton`
--
ALTER TABLE `so_tin_ton`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `thanh_pho`
--
ALTER TABLE `thanh_pho`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bien_ban_khoa`
--
ALTER TABLE `bien_ban_khoa`
  ADD CONSTRAINT `fk_bienban_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`);

--
-- Constraints for table `bien_ban_khoa_vinh_vien`
--
ALTER TABLE `bien_ban_khoa_vinh_vien`
  ADD CONSTRAINT `fk_bienbankhoavinhvien_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`);

--
-- Constraints for table `ct_phieu_mua_hang`
--
ALTER TABLE `ct_phieu_mua_hang`
  ADD CONSTRAINT `fk_ctphieumuahang_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_phieumuahang` FOREIGN KEY (`id_phieu_mua_hang`) REFERENCES `phieu_mua_hang` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_sanpham` FOREIGN KEY (`id_san_pham`) REFERENCES `san_pham` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_tinhtrrang` FOREIGN KEY (`id_tinh_trang`) REFERENCES `tinh_trang` (`id`);

--
-- Constraints for table `danh_gia`
--
ALTER TABLE `danh_gia`
  ADD CONSTRAINT `fk_danhgia_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`),
  ADD CONSTRAINT `fk_danhgia_nguoimua` FOREIGN KEY (`id_nguoi_mua`) REFERENCES `nguoi_mua` (`id`);

--
-- Constraints for table `nguoi_mua`
--
ALTER TABLE `nguoi_mua`
  ADD CONSTRAINT `fk_nguoimua_quanhuyen` FOREIGN KEY (`id_quan_huyen`) REFERENCES `quan_huyen` (`id`),
  ADD CONSTRAINT `fk_nguoimua_thanhpho` FOREIGN KEY (`id_thanh_pho`) REFERENCES `thanh_pho` (`id`);

--
-- Constraints for table `phieu_mua_hang`
--
ALTER TABLE `phieu_mua_hang`
  ADD CONSTRAINT `fk_phieumuahang_nguoimua` FOREIGN KEY (`id_nguoi_mua`) REFERENCES `nguoi_mua` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_quanhuyen` FOREIGN KEY (`id_quan_huyen`) REFERENCES `quan_huyen` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_thanhpho` FOREIGN KEY (`id_thanh_pho`) REFERENCES `thanh_pho` (`id`);

--
-- Constraints for table `phieu_mua_tin`
--
ALTER TABLE `phieu_mua_tin`
  ADD CONSTRAINT `fk_phieumuatin_goitin` FOREIGN KEY (`id_goi_tin`) REFERENCES `goi_tin` (`id`),
  ADD CONSTRAINT `fk_phieumuatin_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`);

--
-- Constraints for table `phieu_mua_tin_offline`
--
ALTER TABLE `phieu_mua_tin_offline`
  ADD CONSTRAINT `fk_phieumuatin_admin` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id`),
  ADD CONSTRAINT `fk_phieumuatinoff_goitin` FOREIGN KEY (`id_goi_tin`) REFERENCES `goi_tin` (`id`),
  ADD CONSTRAINT `fk_phieumuatinoff_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`);

--
-- Constraints for table `phieu_nop_phat`
--
ALTER TABLE `phieu_nop_phat`
  ADD CONSTRAINT `fk_nopphat_admin` FOREIGN KEY (`id_admin`) REFERENCES `admin` (`id`),
  ADD CONSTRAINT `fk_nopphat_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`);

--
-- Constraints for table `quan_huyen`
--
ALTER TABLE `quan_huyen`
  ADD CONSTRAINT `fk_thanhpho_quanhuyen` FOREIGN KEY (`id_thanh_pho`) REFERENCES `thanh_pho` (`id`);

--
-- Constraints for table `san_pham`
--
ALTER TABLE `san_pham`
  ADD CONSTRAINT `fk_sanpham_hsx` FOREIGN KEY (`id_hang_san_xuat`) REFERENCES `hang_san_xuat` (`id`),
  ADD CONSTRAINT `fk_sanpham_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`);

--
-- Constraints for table `so_tin_ton`
--
ALTER TABLE `so_tin_ton`
  ADD CONSTRAINT `fk_tinton_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
