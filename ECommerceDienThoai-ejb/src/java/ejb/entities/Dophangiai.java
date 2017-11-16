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
 * @author XinKaChu
 */
@Entity
@Table(name = "do_phan_giai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DoPhanGiai.findAll", query = "SELECT d FROM DoPhanGiai d"),
    @NamedQuery(name = "DoPhanGiai.findById", query = "SELECT d FROM DoPhanGiai d WHERE d.id = :id"),
    @NamedQuery(name = "DoPhanGiai.findByTenDoPhanGiai", query = "SELECT d FROM DoPhanGiai d WHERE d.tenDoPhanGiai = :tenDoPhanGiai"),
    @NamedQuery(name = "DoPhanGiai.findByChieuRong", query = "SELECT d FROM DoPhanGiai d WHERE d.chieuRong = :chieuRong"),
    @NamedQuery(name = "DoPhanGiai.findByChieuDai", query = "SELECT d FROM DoPhanGiai d WHERE d.chieuDai = :chieuDai")})
public class DoPhanGiai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ten_do_phan_giai")
    private String tenDoPhanGiai;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chieu_rong")
    private int chieuRong;
    @Basic(optional = false)
    @NotNull
    @Column(name = "chieu_dai")
    private int chieuDai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDoPhanGiai", fetch = FetchType.LAZY)
    private List<ThongSoKyThuat> thongSoKyThuatList;

    public DoPhanGiai() {
    }

    public DoPhanGiai(Integer id) {
        this.id = id;
    }

    public DoPhanGiai(Integer id, String tenDoPhanGiai, int chieuRong, int chieuDai) {
        this.id = id;
        this.tenDoPhanGiai = tenDoPhanGiai;
        this.chieuRong = chieuRong;
        this.chieuDai = chieuDai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenDoPhanGiai() {
        return tenDoPhanGiai;
    }

    public void setTenDoPhanGiai(String tenDoPhanGiai) {
        this.tenDoPhanGiai = tenDoPhanGiai;
    }

    public int getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(int chieuRong) {
        this.chieuRong = chieuRong;
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
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
        if (!(object instanceof DoPhanGiai)) {
            return false;
        }
        DoPhanGiai other = (DoPhanGiai) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.DoPhanGiai[ id=" + id + " ]";
    }
    
}
