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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "nguoi_ban")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NguoiBan.findAll", query = "SELECT n FROM NguoiBan n")
    , @NamedQuery(name = "NguoiBan.findById", query = "SELECT n FROM NguoiBan n WHERE n.id = :id")
    , @NamedQuery(name = "NguoiBan.findByEmail", query = "SELECT n FROM NguoiBan n WHERE n.email = :email")
    , @NamedQuery(name = "NguoiBan.findByMatKhau", query = "SELECT n FROM NguoiBan n WHERE n.matKhau = :matKhau")
    , @NamedQuery(name = "NguoiBan.findByHoTen", query = "SELECT n FROM NguoiBan n WHERE n.hoTen = :hoTen")
    , @NamedQuery(name = "NguoiBan.findByCmnd", query = "SELECT n FROM NguoiBan n WHERE n.cmnd = :cmnd")
    , @NamedQuery(name = "NguoiBan.findBySoDienThoai", query = "SELECT n FROM NguoiBan n WHERE n.soDienThoai = :soDienThoai")
    , @NamedQuery(name = "NguoiBan.findByDiaChi", query = "SELECT n FROM NguoiBan n WHERE n.diaChi = :diaChi")
    , @NamedQuery(name = "NguoiBan.findByNgayDangKy", query = "SELECT n FROM NguoiBan n WHERE n.ngayDangKy = :ngayDangKy")
    , @NamedQuery(name = "NguoiBan.findBySoLanCanhCao", query = "SELECT n FROM NguoiBan n WHERE n.soLanCanhCao = :soLanCanhCao")
    , @NamedQuery(name = "NguoiBan.findBySoLanBiBlock", query = "SELECT n FROM NguoiBan n WHERE n.soLanBiBlock = :soLanBiBlock")
    , @NamedQuery(name = "NguoiBan.findByKichHoat", query = "SELECT n FROM NguoiBan n WHERE n.kichHoat = :kichHoat")
    , @NamedQuery(name = "NguoiBan.findByBiKhoa", query = "SELECT n FROM NguoiBan n WHERE n.biKhoa = :biKhoa")
    , @NamedQuery(name = "NguoiBan.findByBiBlock", query = "SELECT n FROM NguoiBan n WHERE n.biBlock = :biBlock")})
public class NguoiBan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mat_khau")
    private String matKhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ho_ten")
    private String hoTen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "cmnd")
    private String cmnd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "so_dien_thoai")
    private String soDienThoai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "dia_chi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_dang_ky")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDangKy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_lan_canh_cao")
    private int soLanCanhCao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_lan_bi_block")
    private int soLanBiBlock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kich_hoat")
    private boolean kichHoat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bi_khoa")
    private boolean biKhoa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bi_block")
    private boolean biBlock;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiBan")
    private List<BienBanKhoaVinhVien> bienBanKhoaVinhVienList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiBan")
    private List<SanPham> sanPhamList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiBan")
    private List<BienBanKhoa> bienBanKhoaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiBan")
    private List<CtPhieuMuaHang> ctPhieuMuaHangList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiBan")
    private List<PhieuMuaTin> phieuMuaTinList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiBan")
    private List<DanhGia> danhGiaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiBan")
    private List<SoTinTon> soTinTonList;

    public NguoiBan() {
    }

    public NguoiBan(Integer id) {
        this.id = id;
    }

    public NguoiBan(Integer id, String email, String matKhau, String hoTen, String cmnd, String soDienThoai, String diaChi, Date ngayDangKy, int soLanCanhCao, int soLanBiBlock, boolean kichHoat, boolean biKhoa, boolean biBlock) {
        this.id = id;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.cmnd = cmnd;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngayDangKy = ngayDangKy;
        this.soLanCanhCao = soLanCanhCao;
        this.soLanBiBlock = soLanBiBlock;
        this.kichHoat = kichHoat;
        this.biKhoa = biKhoa;
        this.biBlock = biBlock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public int getSoLanCanhCao() {
        return soLanCanhCao;
    }

    public void setSoLanCanhCao(int soLanCanhCao) {
        this.soLanCanhCao = soLanCanhCao;
    }

    public int getSoLanBiBlock() {
        return soLanBiBlock;
    }

    public void setSoLanBiBlock(int soLanBiBlock) {
        this.soLanBiBlock = soLanBiBlock;
    }

    public boolean getKichHoat() {
        return kichHoat;
    }

    public void setKichHoat(boolean kichHoat) {
        this.kichHoat = kichHoat;
    }

    public boolean getBiKhoa() {
        return biKhoa;
    }

    public void setBiKhoa(boolean biKhoa) {
        this.biKhoa = biKhoa;
    }

    public boolean getBiBlock() {
        return biBlock;
    }

    public void setBiBlock(boolean biBlock) {
        this.biBlock = biBlock;
    }

    @XmlTransient
    public List<BienBanKhoaVinhVien> getBienBanKhoaVinhVienList() {
        return bienBanKhoaVinhVienList;
    }

    public void setBienBanKhoaVinhVienList(List<BienBanKhoaVinhVien> bienBanKhoaVinhVienList) {
        this.bienBanKhoaVinhVienList = bienBanKhoaVinhVienList;
    }

    @XmlTransient
    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
    }

    @XmlTransient
    public List<BienBanKhoa> getBienBanKhoaList() {
        return bienBanKhoaList;
    }

    public void setBienBanKhoaList(List<BienBanKhoa> bienBanKhoaList) {
        this.bienBanKhoaList = bienBanKhoaList;
    }

    @XmlTransient
    public List<CtPhieuMuaHang> getCtPhieuMuaHangList() {
        return ctPhieuMuaHangList;
    }

    public void setCtPhieuMuaHangList(List<CtPhieuMuaHang> ctPhieuMuaHangList) {
        this.ctPhieuMuaHangList = ctPhieuMuaHangList;
    }

    @XmlTransient
    public List<PhieuMuaTin> getPhieuMuaTinList() {
        return phieuMuaTinList;
    }

    public void setPhieuMuaTinList(List<PhieuMuaTin> phieuMuaTinList) {
        this.phieuMuaTinList = phieuMuaTinList;
    }

    @XmlTransient
    public List<DanhGia> getDanhGiaList() {
        return danhGiaList;
    }

    public void setDanhGiaList(List<DanhGia> danhGiaList) {
        this.danhGiaList = danhGiaList;
    }

    @XmlTransient
    public List<SoTinTon> getSoTinTonList() {
        return soTinTonList;
    }

    public void setSoTinTonList(List<SoTinTon> soTinTonList) {
        this.soTinTonList = soTinTonList;
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
        if (!(object instanceof NguoiBan)) {
            return false;
        }
        NguoiBan other = (NguoiBan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.NguoiBan[ id=" + id + " ]";
    }
    
}
