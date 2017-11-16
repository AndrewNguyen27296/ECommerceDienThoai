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
import javax.persistence.FetchType;
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
 * @author DacTien
 */
@Entity
@Table(name = "he_dieu_hanh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HeDieuHanh.findAll", query = "SELECT h FROM HeDieuHanh h")
    , @NamedQuery(name = "HeDieuHanh.findById", query = "SELECT h FROM HeDieuHanh h WHERE h.id = :id")
    , @NamedQuery(name = "HeDieuHanh.findByTenLoai", query = "SELECT h FROM HeDieuHanh h WHERE h.tenLoai = :tenLoai")
    , @NamedQuery(name = "HeDieuHanh.findByAnHien", query = "SELECT h FROM HeDieuHanh h WHERE h.anHien = :anHien")})
public class HeDieuHanh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ten_loai")
    private String tenLoai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "an_hien")
    private boolean anHien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHeDieuHanh", fetch = FetchType.LAZY)
    private List<ThongSoKyThuat> thongSoKyThuatList;

    public HeDieuHanh() {
    }

    public HeDieuHanh(Integer id) {
        this.id = id;
    }

    public HeDieuHanh(Integer id, String tenLoai, boolean anHien) {
        this.id = id;
        this.tenLoai = tenLoai;
        this.anHien = anHien;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public boolean getAnHien() {
        return anHien;
    }

    public void setAnHien(boolean anHien) {
        this.anHien = anHien;
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
        if (!(object instanceof HeDieuHanh)) {
            return false;
        }
        HeDieuHanh other = (HeDieuHanh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.HeDieuHanh[ id=" + id + " ]";
    }
    
}
