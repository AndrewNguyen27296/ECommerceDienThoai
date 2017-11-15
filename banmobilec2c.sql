-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2017 at 01:30 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

-- --------------------------------------------------------

--
-- Table structure for table `bo_nho_trong`
--

CREATE TABLE `bo_nho_trong` (
  `id` int(11) NOT NULL,
  `dung_luong` varchar(250) NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `chip_do_hoa`
--

CREATE TABLE `chip_do_hoa` (
  `id` int(11) NOT NULL,
  `ten_chip` varchar(250) NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `cpu`
--

CREATE TABLE `cpu` (
  `id` int(11) NOT NULL,
  `ten_cpu` varchar(250) NOT NULL,
  `so_nhan` int(11) NOT NULL,
  `toc_do` float NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `ct_phieu_mua_hang`
--

CREATE TABLE `ct_phieu_mua_hang` (
  `id` int(11) NOT NULL,
  `id_phieu_mua_hang` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `id_san_pham` int(11) NOT NULL,
  `gia_ban` float NOT NULL,
  `so_luong_ban` int(11) NOT NULL,
  `id_tinh_trang` char(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `danh_gia`
--

CREATE TABLE `danh_gia` (
  `id` int(11) NOT NULL,
  `id_don_hang` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `so_diem` int(11) NOT NULL,
  `su_dung` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `do_phan_giai`
--

CREATE TABLE `do_phan_giai` (
  `id` int(11) NOT NULL,
  `ten_do_phan_giai` varchar(250) NOT NULL,
  `chieu_rong` int(11) NOT NULL,
  `chieu_dai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `goi_tin`
--

CREATE TABLE `goi_tin` (
  `id` int(11) NOT NULL,
  `ten_goi_tin` varchar(250) NOT NULL,
  `so_tin` int(11) NOT NULL,
  `gia_ban` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

-- --------------------------------------------------------

--
-- Table structure for table `he_dieu_hanh`
--

CREATE TABLE `he_dieu_hanh` (
  `id` int(11) NOT NULL,
  `ten_loai` varchar(250) NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `khu_vuc`
--

CREATE TABLE `khu_vuc` (
  `id` int(11) NOT NULL,
  `ten_khu_vuc` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `kich_thuoc_man_hinh`
--

CREATE TABLE `kich_thuoc_man_hinh` (
  `id` int(11) NOT NULL,
  `loai_kich_thuoc` varchar(11) NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `loai_man_hinh`
--

CREATE TABLE `loai_man_hinh` (
  `id` int(11) NOT NULL,
  `ten_loai` varchar(250) NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `loai_man_hinh`
--

INSERT INTO `loai_man_hinh` (`id`, `ten_loai`, `an_hien`) VALUES
(1, 'AMOLED', b'1'),
(2, 'IPS', b'1'),
(3, 'Retina', b'1');

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
  `kich_hoat` bit(1) NOT NULL,
  `trang_thai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `nguoi_mua`
--

CREATE TABLE `nguoi_mua` (
  `id` int(11) NOT NULL,
  `email` varchar(250) NOT NULL,
  `mat_khau` varchar(250) NOT NULL,
  `ho_ten` varchar(250) NOT NULL,
  `ngay_sinh` date NOT NULL,
  `so_dien_thoai` varchar(11) NOT NULL,
  `dia_chi` varchar(250) NOT NULL,
  `ngay_dang_ky` datetime NOT NULL,
  `kich_hoat` bit(1) NOT NULL,
  `trang_thai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `ghi_chu` varchar(250) NOT NULL,
  `ngay_dat_hang` datetime NOT NULL,
  `ngay_giao_hang` datetime NOT NULL,
  `trang_thai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `phieu_mua_tin`
--

CREATE TABLE `phieu_mua_tin` (
  `id` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `id_goi_tin` int(11) NOT NULL,
  `gia_ban` float NOT NULL,
  `ngay_mua` datetime NOT NULL,
  `phuong_thuc_thanh_toan` int(11) NOT NULL,
  `trang_thai` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `phuong_xa`
--

CREATE TABLE `phuong_xa` (
  `id` int(11) NOT NULL,
  `id_quan_huyen` int(11) NOT NULL,
  `ten_phuong_xa` varchar(250) NOT NULL,
  `loai` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

-- --------------------------------------------------------

--
-- Table structure for table `ram`
--

CREATE TABLE `ram` (
  `id` int(11) NOT NULL,
  `dung_luong` varchar(250) NOT NULL,
  `don_vi` char(2) NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ram`
--

INSERT INTO `ram` (`id`, `dung_luong`, `don_vi`, `an_hien`) VALUES
(1, '512', 'MB', b'1'),
(2, '1', 'GB', b'1'),
(3, '2', 'GB', b'1'),
(4, '3', 'GB', b'1'),
(5, '4', 'GB', b'1'),
(6, '6', 'GB', b'1'),
(7, '> 6', 'GB', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `san_pham`
--

CREATE TABLE `san_pham` (
  `id` int(11) NOT NULL,
  `ten_may` varchar(500) NOT NULL,
  `hinh_anh` varchar(250) NOT NULL,
  `gia_ban` float NOT NULL,
  `id_hang_san_xuat` int(11) NOT NULL,
  `ghi_chu` varchar(250) NOT NULL,
  `mo_ta` varchar(500) NOT NULL,
  `ton_kho` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `ngay_dang` datetime NOT NULL,
  `so_lan_xem` int(11) NOT NULL,
  `so_lan_mua` int(11) NOT NULL,
  `bi_danh` varchar(500) NOT NULL,
  `trang_thai` bit(1) NOT NULL,
  `an_hien` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `so_tin_ton`
--

CREATE TABLE `so_tin_ton` (
  `id` int(11) NOT NULL,
  `id_nguoi_ban` int(11) NOT NULL,
  `so_tin_ton` int(11) NOT NULL,
  `so_tin_da_dung` int(11) NOT NULL,
  `ngay_cap_nhat` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `thanh_pho`
--

CREATE TABLE `thanh_pho` (
  `id` int(11) NOT NULL,
  `ten_thanh_pho` varchar(250) NOT NULL,
  `loai` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `thong_so_ky_thuat`
--

CREATE TABLE `thong_so_ky_thuat` (
  `id` int(11) NOT NULL,
  `id_san_pham` int(11) NOT NULL,
  `id_kich_thuoc_man_hinh` int(11) NOT NULL,
  `id_loai_man_hinh` int(11) NOT NULL,
  `id_do_phan_giai` int(11) NOT NULL,
  `id_cpu` int(11) NOT NULL,
  `id_chip_do_hoa` int(11) NOT NULL,
  `id_ram` int(11) NOT NULL,
  `id_bo_nho_trong` int(11) NOT NULL,
  `id_he_dieu_hanh` int(11) NOT NULL,
  `camera_truoc` varchar(250) NOT NULL,
  `camera_sau` varchar(250) NOT NULL,
  `dung_luong_pin` varchar(250) NOT NULL,
  `the_nho` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tinh_trang`
--

CREATE TABLE `tinh_trang` (
  `id` char(2) NOT NULL,
  `ten_mo_ta` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bo_nho_trong`
--
ALTER TABLE `bo_nho_trong`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chip_do_hoa`
--
ALTER TABLE `chip_do_hoa`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cpu`
--
ALTER TABLE `cpu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ct_phieu_mua_hang`
--
ALTER TABLE `ct_phieu_mua_hang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ctphieumuahang_nguoiban` (`id_nguoi_ban`),
  ADD KEY `fk_phieumuahang_phieumuahang` (`id_phieu_mua_hang`),
  ADD KEY `fk_phieumuahang_sanpham` (`id_san_pham`);

--
-- Indexes for table `danh_gia`
--
ALTER TABLE `danh_gia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_danhgia_nguoiban` (`id_nguoi_ban`),
  ADD KEY `fk_danhgia_phieumuahang` (`id_don_hang`);

--
-- Indexes for table `do_phan_giai`
--
ALTER TABLE `do_phan_giai`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `he_dieu_hanh`
--
ALTER TABLE `he_dieu_hanh`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `khu_vuc`
--
ALTER TABLE `khu_vuc`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `kich_thuoc_man_hinh`
--
ALTER TABLE `kich_thuoc_man_hinh`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loai_man_hinh`
--
ALTER TABLE `loai_man_hinh`
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
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `phieu_mua_hang`
--
ALTER TABLE `phieu_mua_hang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_phieumuahang_nguoimua` (`id_nguoi_mua`),
  ADD KEY `fk_phieumuahang_phuongxa` (`id_phuong_xa`),
  ADD KEY `fk_phieumuahang_quanhuyen` (`id_quan_huyen`),
  ADD KEY `fk_phieumuahang_thanhpho` (`id_thanh_pho`);

--
-- Indexes for table `phieu_mua_tin`
--
ALTER TABLE `phieu_mua_tin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_phieumuatin_goitin` (`id_goi_tin`),
  ADD KEY `fk_phieumuatin_nguoiban` (`id_nguoi_ban`);

--
-- Indexes for table `phuong_xa`
--
ALTER TABLE `phuong_xa`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_quanhuyen_phuongxa` (`id_quan_huyen`);

--
-- Indexes for table `quan_huyen`
--
ALTER TABLE `quan_huyen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_thanhpho_quanhuyen` (`id_thanh_pho`);

--
-- Indexes for table `ram`
--
ALTER TABLE `ram`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `thong_so_ky_thuat`
--
ALTER TABLE `thong_so_ky_thuat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_thongso_bonhotrong` (`id_bo_nho_trong`),
  ADD KEY `fk_thongso_chipdohoa` (`id_chip_do_hoa`),
  ADD KEY `fk_thongso_cpu` (`id_cpu`),
  ADD KEY `fk_thongso_dophangiai` (`id_do_phan_giai`),
  ADD KEY `fk_thongso_hedieuhanh` (`id_he_dieu_hanh`),
  ADD KEY `fk_thongso_kichthuocmanhinh` (`id_kich_thuoc_man_hinh`),
  ADD KEY `fk_thongso_loaimanhinh` (`id_loai_man_hinh`),
  ADD KEY `fk_thongso_ram` (`id_ram`),
  ADD KEY `fk_thongso_sanpham` (`id_san_pham`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `bo_nho_trong`
--
ALTER TABLE `bo_nho_trong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `chip_do_hoa`
--
ALTER TABLE `chip_do_hoa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `cpu`
--
ALTER TABLE `cpu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ct_phieu_mua_hang`
--
ALTER TABLE `ct_phieu_mua_hang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `danh_gia`
--
ALTER TABLE `danh_gia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `do_phan_giai`
--
ALTER TABLE `do_phan_giai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `goi_tin`
--
ALTER TABLE `goi_tin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `hang_san_xuat`
--
ALTER TABLE `hang_san_xuat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `he_dieu_hanh`
--
ALTER TABLE `he_dieu_hanh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `khu_vuc`
--
ALTER TABLE `khu_vuc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `kich_thuoc_man_hinh`
--
ALTER TABLE `kich_thuoc_man_hinh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `loai_man_hinh`
--
ALTER TABLE `loai_man_hinh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `nguoi_ban`
--
ALTER TABLE `nguoi_ban`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `nguoi_mua`
--
ALTER TABLE `nguoi_mua`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `phieu_mua_hang`
--
ALTER TABLE `phieu_mua_hang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `phieu_mua_tin`
--
ALTER TABLE `phieu_mua_tin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `phuong_xa`
--
ALTER TABLE `phuong_xa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `quan_huyen`
--
ALTER TABLE `quan_huyen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `ram`
--
ALTER TABLE `ram`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `san_pham`
--
ALTER TABLE `san_pham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `so_tin_ton`
--
ALTER TABLE `so_tin_ton`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `thanh_pho`
--
ALTER TABLE `thanh_pho`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `thong_so_ky_thuat`
--
ALTER TABLE `thong_so_ky_thuat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `ct_phieu_mua_hang`
--
ALTER TABLE `ct_phieu_mua_hang`
  ADD CONSTRAINT `fk_ctphieumuahang_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_phieumuahang` FOREIGN KEY (`id_phieu_mua_hang`) REFERENCES `phieu_mua_hang` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_sanpham` FOREIGN KEY (`id_san_pham`) REFERENCES `san_pham` (`id`);

--
-- Constraints for table `danh_gia`
--
ALTER TABLE `danh_gia`
  ADD CONSTRAINT `fk_danhgia_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`),
  ADD CONSTRAINT `fk_danhgia_phieumuahang` FOREIGN KEY (`id_don_hang`) REFERENCES `phieu_mua_hang` (`id`);

--
-- Constraints for table `phieu_mua_hang`
--
ALTER TABLE `phieu_mua_hang`
  ADD CONSTRAINT `fk_phieumuahang_nguoimua` FOREIGN KEY (`id_nguoi_mua`) REFERENCES `nguoi_mua` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_phuongxa` FOREIGN KEY (`id_phuong_xa`) REFERENCES `phuong_xa` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_quanhuyen` FOREIGN KEY (`id_quan_huyen`) REFERENCES `quan_huyen` (`id`),
  ADD CONSTRAINT `fk_phieumuahang_thanhpho` FOREIGN KEY (`id_thanh_pho`) REFERENCES `thanh_pho` (`id`);

--
-- Constraints for table `phieu_mua_tin`
--
ALTER TABLE `phieu_mua_tin`
  ADD CONSTRAINT `fk_phieumuatin_goitin` FOREIGN KEY (`id_goi_tin`) REFERENCES `goi_tin` (`id`),
  ADD CONSTRAINT `fk_phieumuatin_nguoiban` FOREIGN KEY (`id_nguoi_ban`) REFERENCES `nguoi_ban` (`id`);

--
-- Constraints for table `phuong_xa`
--
ALTER TABLE `phuong_xa`
  ADD CONSTRAINT `fk_quanhuyen_phuongxa` FOREIGN KEY (`id_quan_huyen`) REFERENCES `quan_huyen` (`id`);

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

--
-- Constraints for table `thong_so_ky_thuat`
--
ALTER TABLE `thong_so_ky_thuat`
  ADD CONSTRAINT `fk_thongso_bonhotrong` FOREIGN KEY (`id_bo_nho_trong`) REFERENCES `bo_nho_trong` (`id`),
  ADD CONSTRAINT `fk_thongso_chipdohoa` FOREIGN KEY (`id_chip_do_hoa`) REFERENCES `chip_do_hoa` (`id`),
  ADD CONSTRAINT `fk_thongso_cpu` FOREIGN KEY (`id_cpu`) REFERENCES `cpu` (`id`),
  ADD CONSTRAINT `fk_thongso_dophangiai` FOREIGN KEY (`id_do_phan_giai`) REFERENCES `do_phan_giai` (`id`),
  ADD CONSTRAINT `fk_thongso_hedieuhanh` FOREIGN KEY (`id_he_dieu_hanh`) REFERENCES `he_dieu_hanh` (`id`),
  ADD CONSTRAINT `fk_thongso_kichthuocmanhinh` FOREIGN KEY (`id_kich_thuoc_man_hinh`) REFERENCES `kich_thuoc_man_hinh` (`id`),
  ADD CONSTRAINT `fk_thongso_loaimanhinh` FOREIGN KEY (`id_loai_man_hinh`) REFERENCES `loai_man_hinh` (`id`),
  ADD CONSTRAINT `fk_thongso_ram` FOREIGN KEY (`id_ram`) REFERENCES `ram` (`id`),
  ADD CONSTRAINT `fk_thongso_sanpham` FOREIGN KEY (`id_san_pham`) REFERENCES `san_pham` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
