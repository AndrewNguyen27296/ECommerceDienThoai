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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XinKaChu
 */
@Entity
@Table(name = "hang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hang.findAll", query = "SELECT h FROM Hang h"),
    @NamedQuery(name = "Hang.findByMaHang", query = "SELECT h FROM Hang h WHERE h.maHang = :maHang"),
    @NamedQuery(name = "Hang.findByTenHang", query = "SELECT h FROM Hang h WHERE h.tenHang = :tenHang"),
    @NamedQuery(name = "Hang.findByLogoHang", query = "SELECT h FROM Hang h WHERE h.logoHang = :logoHang"),
    @NamedQuery(name = "Hang.findByTinhTrang", query = "SELECT h FROM Hang h WHERE h.tinhTrang = :tinhTrang")})
public class Hang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MaHang")
    private String maHang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TenHang")
    private String tenHang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "LogoHang")
    private String logoHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TinhTrang")
    private boolean tinhTrang;

    public Hang() {
    }

    public Hang(String maHang) {
        this.maHang = maHang;
    }

    public Hang(String maHang, String tenHang, String logoHang, boolean tinhTrang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.logoHang = logoHang;
        this.tinhTrang = tinhTrang;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public String getLogoHang() {
        return logoHang;
    }

    public void setLogoHang(String logoHang) {
        this.logoHang = logoHang;
    }

    public boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHang != null ? maHang.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hang)) {
            return false;
        }
        Hang other = (Hang) object;
        if ((this.maHang == null && other.maHang != null) || (this.maHang != null && !this.maHang.equals(other.maHang))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Hang[ maHang=" + maHang + " ]";
    }
    
}
