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
 * @author HOME
 */
@Entity
@Table(name = "nguoi_mua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NguoiMua.findAll", query = "SELECT n FROM NguoiMua n")
    , @NamedQuery(name = "NguoiMua.findById", query = "SELECT n FROM NguoiMua n WHERE n.id = :id")
    , @NamedQuery(name = "NguoiMua.findByEmail", query = "SELECT n FROM NguoiMua n WHERE n.email = :email")
    , @NamedQuery(name = "NguoiMua.findByMatKhau", query = "SELECT n FROM NguoiMua n WHERE n.matKhau = :matKhau")
    , @NamedQuery(name = "NguoiMua.findByHoTen", query = "SELECT n FROM NguoiMua n WHERE n.hoTen = :hoTen")
    , @NamedQuery(name = "NguoiMua.findBySoDienThoai", query = "SELECT n FROM NguoiMua n WHERE n.soDienThoai = :soDienThoai")
    , @NamedQuery(name = "NguoiMua.findByDiaChi", query = "SELECT n FROM NguoiMua n WHERE n.diaChi = :diaChi")
    , @NamedQuery(name = "NguoiMua.findByNgayDangKy", query = "SELECT n FROM NguoiMua n WHERE n.ngayDangKy = :ngayDangKy")
    , @NamedQuery(name = "NguoiMua.findByKichHoat", query = "SELECT n FROM NguoiMua n WHERE n.kichHoat = :kichHoat")
    , @NamedQuery(name = "NguoiMua.findByTrangThai", query = "SELECT n FROM NguoiMua n WHERE n.trangThai = :trangThai")})
public class NguoiMua implements Serializable {

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
    @Column(name = "kich_hoat")
    private boolean kichHoat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trang_thai")
    private boolean trangThai;
    @JoinColumn(name = "id_quan_huyen", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private QuanHuyen idQuanHuyen;
    @JoinColumn(name = "id_thanh_pho", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ThanhPho idThanhPho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiMua")
    private List<PhieuMuaHang> phieuMuaHangList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNguoiMua")
    private List<DanhGia> danhGiaList;

    public NguoiMua() {
    }

    public NguoiMua(Integer id) {
        this.id = id;
    }

    public NguoiMua(Integer id, String email, String matKhau, String hoTen, String soDienThoai, String diaChi, Date ngayDangKy, boolean kichHoat, boolean trangThai) {
        this.id = id;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngayDangKy = ngayDangKy;
        this.kichHoat = kichHoat;
        this.trangThai = trangThai;
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

    public boolean getKichHoat() {
        return kichHoat;
    }

    public void setKichHoat(boolean kichHoat) {
        this.kichHoat = kichHoat;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public QuanHuyen getIdQuanHuyen() {
        return idQuanHuyen;
    }

    public void setIdQuanHuyen(QuanHuyen idQuanHuyen) {
        this.idQuanHuyen = idQuanHuyen;
    }

    public ThanhPho getIdThanhPho() {
        return idThanhPho;
    }

    public void setIdThanhPho(ThanhPho idThanhPho) {
        this.idThanhPho = idThanhPho;
    }

    @XmlTransient
    public List<PhieuMuaHang> getPhieuMuaHangList() {
        return phieuMuaHangList;
    }

    public void setPhieuMuaHangList(List<PhieuMuaHang> phieuMuaHangList) {
        this.phieuMuaHangList = phieuMuaHangList;
    }

    @XmlTransient
    public List<DanhGia> getDanhGiaList() {
        return danhGiaList;
    }

    public void setDanhGiaList(List<DanhGia> danhGiaList) {
        this.danhGiaList = danhGiaList;
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
        if (!(object instanceof NguoiMua)) {
            return false;
        }
        NguoiMua other = (NguoiMua) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.NguoiMua[ id=" + id + " ]";
    }
    
}
