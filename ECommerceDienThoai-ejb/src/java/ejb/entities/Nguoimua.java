/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XinKaChu
 */
@Entity
@Table(name = "nguoimua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoimua.findAll", query = "SELECT n FROM Nguoimua n"),
    @NamedQuery(name = "Nguoimua.findByMaNguoiMua", query = "SELECT n FROM Nguoimua n WHERE n.maNguoiMua = :maNguoiMua"),
    @NamedQuery(name = "Nguoimua.findByEmail", query = "SELECT n FROM Nguoimua n WHERE n.email = :email"),
    @NamedQuery(name = "Nguoimua.findByMatKhau", query = "SELECT n FROM Nguoimua n WHERE n.matKhau = :matKhau"),
    @NamedQuery(name = "Nguoimua.findByHoTen", query = "SELECT n FROM Nguoimua n WHERE n.hoTen = :hoTen"),
    @NamedQuery(name = "Nguoimua.findByNgaySinh", query = "SELECT n FROM Nguoimua n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Nguoimua.findByDiaChi", query = "SELECT n FROM Nguoimua n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "Nguoimua.findBySoDT", query = "SELECT n FROM Nguoimua n WHERE n.soDT = :soDT"),
    @NamedQuery(name = "Nguoimua.findByNgayDK", query = "SELECT n FROM Nguoimua n WHERE n.ngayDK = :ngayDK"),
    @NamedQuery(name = "Nguoimua.findByKichHoat", query = "SELECT n FROM Nguoimua n WHERE n.kichHoat = :kichHoat"),
    @NamedQuery(name = "Nguoimua.findByTrangThai", query = "SELECT n FROM Nguoimua n WHERE n.trangThai = :trangThai")})
public class Nguoimua implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaNguoiMua")
    private Integer maNguoiMua;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "MatKhau")
    private String matKhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "HoTen")
    private String hoTen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DiaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoDT")
    private int soDT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NgayDK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KichHoat")
    private boolean kichHoat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TrangThai")
    private boolean trangThai;

    public Nguoimua() {
    }

    public Nguoimua(Integer maNguoiMua) {
        this.maNguoiMua = maNguoiMua;
    }

    public Nguoimua(Integer maNguoiMua, String email, String matKhau, String hoTen, Date ngaySinh, String diaChi, int soDT, Date ngayDK, boolean kichHoat, boolean trangThai) {
        this.maNguoiMua = maNguoiMua;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.ngayDK = ngayDK;
        this.kichHoat = kichHoat;
        this.trangThai = trangThai;
    }

    public Integer getMaNguoiMua() {
        return maNguoiMua;
    }

    public void setMaNguoiMua(Integer maNguoiMua) {
        this.maNguoiMua = maNguoiMua;
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public Date getNgayDK() {
        return ngayDK;
    }

    public void setNgayDK(Date ngayDK) {
        this.ngayDK = ngayDK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNguoiMua != null ? maNguoiMua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nguoimua)) {
            return false;
        }
        Nguoimua other = (Nguoimua) object;
        if ((this.maNguoiMua == null && other.maNguoiMua != null) || (this.maNguoiMua != null && !this.maNguoiMua.equals(other.maNguoiMua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Nguoimua[ maNguoiMua=" + maNguoiMua + " ]";
    }
    
}
