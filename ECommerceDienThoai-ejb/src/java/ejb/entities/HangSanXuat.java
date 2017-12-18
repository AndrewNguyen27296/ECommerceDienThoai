/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "hang_san_xuat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HangSanXuat.findAll", query = "SELECT h FROM HangSanXuat h")
    , @NamedQuery(name = "HangSanXuat.findById", query = "SELECT h FROM HangSanXuat h WHERE h.id = :id")
    , @NamedQuery(name = "HangSanXuat.findByTenHang", query = "SELECT h FROM HangSanXuat h WHERE h.tenHang = :tenHang")
    , @NamedQuery(name = "HangSanXuat.findByLogoHang", query = "SELECT h FROM HangSanXuat h WHERE h.logoHang = :logoHang")
    , @NamedQuery(name = "HangSanXuat.findByAnHien", query = "SELECT h FROM HangSanXuat h WHERE h.anHien = :anHien")})
public class HangSanXuat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ten_hang")
    private String tenHang;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "logo_hang")
    private String logoHang;
    @Basic(optional = false)
    @NotNull
    @Column(name = "an_hien")
    private boolean anHien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHangSanXuat")
    private List<SanPham> sanPhamList;

    public HangSanXuat() {
    }

    public HangSanXuat(Integer id) {
        this.id = id;
    }

    public HangSanXuat(Integer id, String tenHang, String logoHang, boolean anHien) {
        this.id = id;
        this.tenHang = tenHang;
        this.logoHang = logoHang;
        this.anHien = anHien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean getAnHien() {
        return anHien;
    }

    public void setAnHien(boolean anHien) {
        this.anHien = anHien;
    }

    @XmlTransient
    public List<SanPham> getSanPhamList() {
        return sanPhamList;
    }

    public void setSanPhamList(List<SanPham> sanPhamList) {
        this.sanPhamList = sanPhamList;
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
        if (!(object instanceof HangSanXuat)) {
            return false;
        }
        HangSanXuat other = (HangSanXuat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.HangSanXuat[ id=" + id + " ]";
    }
    
}
