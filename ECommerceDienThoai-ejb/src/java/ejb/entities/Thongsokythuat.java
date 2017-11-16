/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XinKaChu
 */
@Entity
@Table(name = "thongsokythuat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Thongsokythuat.findAll", query = "SELECT t FROM Thongsokythuat t"),
    @NamedQuery(name = "Thongsokythuat.findByMaThongSoKyThuat", query = "SELECT t FROM Thongsokythuat t WHERE t.maThongSoKyThuat = :maThongSoKyThuat"),
    @NamedQuery(name = "Thongsokythuat.findByMaSP", query = "SELECT t FROM Thongsokythuat t WHERE t.maSP = :maSP"),
    @NamedQuery(name = "Thongsokythuat.findByMaMau", query = "SELECT t FROM Thongsokythuat t WHERE t.maMau = :maMau"),
    @NamedQuery(name = "Thongsokythuat.findByMaManHinh", query = "SELECT t FROM Thongsokythuat t WHERE t.maManHinh = :maManHinh"),
    @NamedQuery(name = "Thongsokythuat.findByMaDungLuong", query = "SELECT t FROM Thongsokythuat t WHERE t.maDungLuong = :maDungLuong"),
    @NamedQuery(name = "Thongsokythuat.findByMaRam", query = "SELECT t FROM Thongsokythuat t WHERE t.maRam = :maRam"),
    @NamedQuery(name = "Thongsokythuat.findByMaChip", query = "SELECT t FROM Thongsokythuat t WHERE t.maChip = :maChip"),
    @NamedQuery(name = "Thongsokythuat.findByMaHDH", query = "SELECT t FROM Thongsokythuat t WHERE t.maHDH = :maHDH"),
    @NamedQuery(name = "Thongsokythuat.findByMaDoPhanGiai", query = "SELECT t FROM Thongsokythuat t WHERE t.maDoPhanGiai = :maDoPhanGiai"),
    @NamedQuery(name = "Thongsokythuat.findByMaChipDoHoa", query = "SELECT t FROM Thongsokythuat t WHERE t.maChipDoHoa = :maChipDoHoa")})
public class Thongsokythuat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaThongSoKyThuat")
    private Integer maThongSoKyThuat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaSP")
    private int maSP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaMau")
    private int maMau;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaManHinh")
    private int maManHinh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaDungLuong")
    private int maDungLuong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaRam")
    private int maRam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaChip")
    private int maChip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaHDH")
    private int maHDH;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaDoPhanGiai")
    private int maDoPhanGiai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MaChipDoHoa")
    private int maChipDoHoa;

    public Thongsokythuat() {
    }

    public Thongsokythuat(Integer maThongSoKyThuat) {
        this.maThongSoKyThuat = maThongSoKyThuat;
    }

    public Thongsokythuat(Integer maThongSoKyThuat, int maSP, int maMau, int maManHinh, int maDungLuong, int maRam, int maChip, int maHDH, int maDoPhanGiai, int maChipDoHoa) {
        this.maThongSoKyThuat = maThongSoKyThuat;
        this.maSP = maSP;
        this.maMau = maMau;
        this.maManHinh = maManHinh;
        this.maDungLuong = maDungLuong;
        this.maRam = maRam;
        this.maChip = maChip;
        this.maHDH = maHDH;
        this.maDoPhanGiai = maDoPhanGiai;
        this.maChipDoHoa = maChipDoHoa;
    }

    public Integer getMaThongSoKyThuat() {
        return maThongSoKyThuat;
    }

    public void setMaThongSoKyThuat(Integer maThongSoKyThuat) {
        this.maThongSoKyThuat = maThongSoKyThuat;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public int getMaManHinh() {
        return maManHinh;
    }

    public void setMaManHinh(int maManHinh) {
        this.maManHinh = maManHinh;
    }

    public int getMaDungLuong() {
        return maDungLuong;
    }

    public void setMaDungLuong(int maDungLuong) {
        this.maDungLuong = maDungLuong;
    }

    public int getMaRam() {
        return maRam;
    }

    public void setMaRam(int maRam) {
        this.maRam = maRam;
    }

    public int getMaChip() {
        return maChip;
    }

    public void setMaChip(int maChip) {
        this.maChip = maChip;
    }

    public int getMaHDH() {
        return maHDH;
    }

    public void setMaHDH(int maHDH) {
        this.maHDH = maHDH;
    }

    public int getMaDoPhanGiai() {
        return maDoPhanGiai;
    }

    public void setMaDoPhanGiai(int maDoPhanGiai) {
        this.maDoPhanGiai = maDoPhanGiai;
    }

    public int getMaChipDoHoa() {
        return maChipDoHoa;
    }

    public void setMaChipDoHoa(int maChipDoHoa) {
        this.maChipDoHoa = maChipDoHoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maThongSoKyThuat != null ? maThongSoKyThuat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thongsokythuat)) {
            return false;
        }
        Thongsokythuat other = (Thongsokythuat) object;
        if ((this.maThongSoKyThuat == null && other.maThongSoKyThuat != null) || (this.maThongSoKyThuat != null && !this.maThongSoKyThuat.equals(other.maThongSoKyThuat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Thongsokythuat[ maThongSoKyThuat=" + maThongSoKyThuat + " ]";
    }
    
}
