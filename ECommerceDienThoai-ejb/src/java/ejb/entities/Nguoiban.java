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
@Table(name = "nguoiban")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nguoiban.findAll", query = "SELECT n FROM Nguoiban n"),
    @NamedQuery(name = "Nguoiban.findByMaNguoiBan", query = "SELECT n FROM Nguoiban n WHERE n.maNguoiBan = :maNguoiBan"),
    @NamedQuery(name = "Nguoiban.findByTen", query = "SELECT n FROM Nguoiban n WHERE n.ten = :ten"),
    @NamedQuery(name = "Nguoiban.findByEmail", query = "SELECT n FROM Nguoiban n WHERE n.email = :email"),
    @NamedQuery(name = "Nguoiban.findByMatKhau", query = "SELECT n FROM Nguoiban n WHERE n.matKhau = :matKhau"),
    @NamedQuery(name = "Nguoiban.findByCmnd", query = "SELECT n FROM Nguoiban n WHERE n.cmnd = :cmnd"),
    @NamedQuery(name = "Nguoiban.findBySoDT", query = "SELECT n FROM Nguoiban n WHERE n.soDT = :soDT"),
    @NamedQuery(name = "Nguoiban.findByDiaChi", query = "SELECT n FROM Nguoiban n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "Nguoiban.findByNgayDK", query = "SELECT n FROM Nguoiban n WHERE n.ngayDK = :ngayDK"),
    @NamedQuery(name = "Nguoiban.findByKichHoat", query = "SELECT n FROM Nguoiban n WHERE n.kichHoat = :kichHoat"),
    @NamedQuery(name = "Nguoiban.findByTrangThai", query = "SELECT n FROM Nguoiban n WHERE n.trangThai = :trangThai")})
public class Nguoiban implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaNguoiBan")
    private Integer maNguoiBan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Ten")
    private String ten;
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
    @Column(name = "CMND")
    private int cmnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoDT")
    private int soDT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DiaChi")
    private String diaChi;
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

    public Nguoiban() {
    }

    public Nguoiban(Integer maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public Nguoiban(Integer maNguoiBan, String ten, String email, String matKhau, int cmnd, int soDT, String diaChi, Date ngayDK, boolean kichHoat, boolean trangThai) {
        this.maNguoiBan = maNguoiBan;
        this.ten = ten;
        this.email = email;
        this.matKhau = matKhau;
        this.cmnd = cmnd;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.ngayDK = ngayDK;
        this.kichHoat = kichHoat;
        this.trangThai = trangThai;
    }

    public Integer getMaNguoiBan() {
        return maNguoiBan;
    }

    public void setMaNguoiBan(Integer maNguoiBan) {
        this.maNguoiBan = maNguoiBan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
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

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public int getSoDT() {
        return soDT;
    }

    public void setSoDT(int soDT) {
        this.soDT = soDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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
        hash += (maNguoiBan != null ? maNguoiBan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nguoiban)) {
            return false;
        }
        Nguoiban other = (Nguoiban) object;
        if ((this.maNguoiBan == null && other.maNguoiBan != null) || (this.maNguoiBan != null && !this.maNguoiBan.equals(other.maNguoiBan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Nguoiban[ maNguoiBan=" + maNguoiBan + " ]";
    }
    
}
