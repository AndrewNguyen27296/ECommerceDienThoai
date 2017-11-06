USE [ECommerceDienThoai]
GO
/****** Object:  Table [dbo].[GOITIN]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GOITIN](
	[MaGoi] [int] NOT NULL,
	[TenGoi] [nvarchar](50) NULL,
	[SoLuongTin] [int] NULL,
 CONSTRAINT [PK_GOITIN] PRIMARY KEY CLUSTERED 
(
	[MaGoi] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_HOADON]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_HOADON](
	[MaCTHD] [int] NOT NULL,
	[MaHD] [int] NULL,
	[MaNguoiBan] [int] NULL,
	[MaSP] [int] NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[ThanhTien] [float] NULL,
	[TinhTrangDonHang] [int] NULL,
 CONSTRAINT [PK_CT_HOADON] PRIMARY KEY CLUSTERED 
(
	[MaCTHD] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NGUOIMUA]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NGUOIMUA](
	[MaNguoiMua] [int] NOT NULL,
	[MatKhau] [nvarchar](50) NULL,
	[HoTen] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SoDT] [int] NULL,
	[Email] [nvarchar](50) NULL,
 CONSTRAINT [PK_NguoiMua] PRIMARY KEY CLUSTERED 
(
	[MaNguoiMua] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SANPHAM]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SANPHAM](
	[MaSP] [int] NOT NULL,
	[MaHang] [int] NULL,
	[TenSP] [nvarchar](50) NULL,
	[Gia] [float] NULL,
	[ManHinh] [nvarchar](50) NULL,
	[DungLuong] [int] NULL,
	[Ram] [int] NULL,
	[Chip] [nvarchar](50) NULL,
	[CameraTruoc] [int] NULL,
	[CameraSau] [int] NULL,
	[Pin] [int] NULL,
	[TrongLuong] [float] NULL,
	[HDH] [nvarchar](50) NULL,
	[DoPhanGiai] [nvarchar](50) NULL,
	[TocDoCPU] [nvarchar](50) NULL,
	[ChipDoHoa] [nvarchar](50) NULL,
	[TheNhoNgoai] [int] NULL,
	[TrangThai] [bit] NULL,
	[SoLuongTon] [int] NULL,
 CONSTRAINT [PK_SANPHAM] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOADON]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOADON](
	[MaHD] [int] NOT NULL,
	[MaNguoiMua] [int] NULL,
	[TongTien] [float] NULL,
	[Ngay] [datetime] NULL,
 CONSTRAINT [PK_HOADON] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NGUOIBAN]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NGUOIBAN](
	[MaNguoiBan] [int] NOT NULL,
	[Ten] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[CMND] [int] NULL,
	[SoDT] [int] NULL,
	[Diachi] [nvarchar](50) NULL,
	[SoTin] [int] NULL,
	[TrangThai] [bit] NOT NULL,
 CONSTRAINT [PK_NGUOIBAN] PRIMARY KEY CLUSTERED 
(
	[MaNguoiBan] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHIEUTHU]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHIEUTHU](
	[MaPhieuThu] [int] NOT NULL,
	[MaNguoiBan] [int] NULL,
	[MaGoi] [int] NULL,
	[NgayThu] [datetime] NULL,
 CONSTRAINT [PK_PHIEUTHU] PRIMARY KEY CLUSTERED 
(
	[MaPhieuThu] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BIENBAN]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BIENBAN](
	[MaBienBan] [int] NOT NULL,
	[MaNguoiBan] [int] NULL,
	[Ngay] [datetime] NULL,
	[LyDo] [nvarchar](50) NULL,
 CONSTRAINT [PK_BIENBAN] PRIMARY KEY CLUSTERED 
(
	[MaBienBan] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HANG]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HANG](
	[MaHang] [int] NOT NULL,
	[TenHang] [nvarchar](50) NULL,
	[TinhTrang] [bit] NULL,
 CONSTRAINT [PK_HANG] PRIMARY KEY CLUSTERED 
(
	[MaHang] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DANHGIA]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DANHGIA](
	[MaDanhGia] [int] NOT NULL,
	[MaNguoiMua] [int] NULL,
	[MaNguoiBan] [int] NULL,
	[Rating] [int] NULL,
 CONSTRAINT [PK_DANHGIA] PRIMARY KEY CLUSTERED 
(
	[MaDanhGia] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MAUSAC]    Script Date: 11/06/2017 12:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MAUSAC](
	[MaMau] [int] NOT NULL,
	[MaSP] [int] NULL,
	[Mau] [nvarchar](50) NULL,
	[Gia] [float] NULL,
 CONSTRAINT [PK_MauSac] PRIMARY KEY CLUSTERED 
(
	[MaMau] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
