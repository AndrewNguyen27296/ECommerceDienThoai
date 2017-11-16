/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DacTien
 */
@Entity
@Table(name = "san_pham")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SanPham.findAll", query = "SELECT s FROM SanPham s")
    , @NamedQuery(name = "SanPham.findById", query = "SELECT s FROM SanPham s WHERE s.id = :id")
    , @NamedQuery(name = "SanPham.findByTenMay", query = "SELECT s FROM SanPham s WHERE s.tenMay = :tenMay")
    , @NamedQuery(name = "SanPham.findByHinhAnh", query = "SELECT s FROM SanPham s WHERE s.hinhAnh = :hinhAnh")
    , @NamedQuery(name = "SanPham.findByGiaBan", query = "SELECT s FROM SanPham s WHERE s.giaBan = :giaBan")
    , @NamedQuery(name = "SanPham.findByGhiChu", query = "SELECT s FROM SanPham s WHERE s.ghiChu = :ghiChu")
    , @NamedQuery(name = "SanPham.findByMoTa", query = "SELECT s FROM SanPham s WHERE s.moTa = :moTa")
    , @NamedQuery(name = "SanPham.findByTonKho", query = "SELECT s FROM SanPham s WHERE s.tonKho = :tonKho")
    , @NamedQuery(name = "SanPham.findByNgayDang", query = "SELECT s FROM SanPham s WHERE s.ngayDang = :ngayDang")
    , @NamedQuery(name = "SanPham.findBySoLanXem", query = "SELECT s FROM SanPham s WHERE s.soLanXem = :soLanXem")
    , @NamedQuery(name = "SanPham.findBySoLanMua", query = "SELECT s FROM SanPham s WHERE s.soLanMua = :soLanMua")
    , @NamedQuery(name = "SanPham.findByBiDanh", query = "SELECT s FROM SanPham s WHERE s.biDanh = :biDanh")
    , @NamedQuery(name = "SanPham.findByTrangThai", query = "SELECT s FROM SanPham s WHERE s.trangThai = :trangThai")
    , @NamedQuery(name = "SanPham.findByAnHien", query = "SELECT s FROM SanPham s WHERE s.anHien = :anHien")})
public class SanPham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ten_may")
    private String tenMay;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "hinh_anh")
    private String hinhAnh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia_ban")
    private float giaBan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ghi_chu")
    private String ghiChu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "mo_ta")
    private String moTa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ton_kho")
    private int tonKho;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_dang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_lan_xem")
    private int soLanXem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_lan_mua")
    private int soLanMua;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "bi_danh")
    private String biDanh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trang_thai")
    private boolean trangThai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "an_hien")
    private boolean anHien;
    @JoinColumn(name = "id_hang_san_xuat", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HangSanXuat idHangSanXuat;
    @JoinColumn(name = "id_nguoi_ban", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NguoiBan idNguoiBan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSanPham", fetch = FetchType.LAZY)
    private List<CtPhieuMuaHang> ctPhieuMuaHangList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSanPham", fetch = FetchType.LAZY)
    private List<ThongSoKyThuat> thongSoKyThuatList;

    public SanPham() {
    }

    public SanPham(Integer id) {
        this.id = id;
    }

    public SanPham(Integer id, String tenMay, String hinhAnh, float giaBan, String ghiChu, String moTa, int tonKho, Date ngayDang, int soLanXem, int soLanMua, String biDanh, boolean trangThai, boolean anHien) {
        this.id = id;
        this.tenMay = tenMay;
        this.hinhAnh = hinhAnh;
        this.giaBan = giaBan;
        this.ghiChu = ghiChu;
        this.moTa = moTa;
        this.tonKho = tonKho;
        this.ngayDang = ngayDang;
        this.soLanXem = soLanXem;
        this.soLanMua = soLanMua;
        this.biDanh = biDanh;
        this.trangThai = trangThai;
        this.anHien = anHien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenMay() {
        return tenMay;
    }

    public void setTenMay(String tenMay) {
        this.tenMay = tenMay;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTonKho() {
        return tonKho;
    }

    public void setTonKho(int tonKho) {
        this.tonKho = tonKho;
    }

    public Date getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }

    public int getSoLanXem() {
        return soLanXem;
    }

    public void setSoLanXem(int soLanXem) {
        this.soLanXem = soLanXem;
    }

    public int getSoLanMua() {
        return soLanMua;
    }

    public void setSoLanMua(int soLanMua) {
        this.soLanMua = soLanMua;
    }

    public String getBiDanh() {
        return biDanh;
    }

    public void setBiDanh(String biDanh) {
        this.biDanh = biDanh;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public boolean getAnHien() {
        return anHien;
    }

    public void setAnHien(boolean anHien) {
        this.anHien = anHien;
    }

    public HangSanXuat getIdHangSanXuat() {
        return idHangSanXuat;
    }

    public void setIdHangSanXuat(HangSanXuat idHangSanXuat) {
        this.idHangSanXuat = idHangSanXuat;
    }

    public NguoiBan getIdNguoiBan() {
        return idNguoiBan;
    }

    public void setIdNguoiBan(NguoiBan idNguoiBan) {
        this.idNguoiBan = idNguoiBan;
    }

    @XmlTransient
    public List<CtPhieuMuaHang> getCtPhieuMuaHangList() {
        return ctPhieuMuaHangList;
    }

    public void setCtPhieuMuaHangList(List<CtPhieuMuaHang> ctPhieuMuaHangList) {
        this.ctPhieuMuaHangList = ctPhieuMuaHangList;
    }

    @XmlTransient
    public List<ThongSoKyThuat> getThongSoKyThuatList() {
        return thongSoKyThuatList;
    }

    public void setThongSoKyThuatList(List<ThongSoKyThuat> thongSoKyThuatList) {
        this.thongSoKyThuatList = thongSoKyThuatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SanPham)) {
            return false;
        }
        SanPham other = (SanPham) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.SanPham[ id=" + id + " ]";
    }
    
}
