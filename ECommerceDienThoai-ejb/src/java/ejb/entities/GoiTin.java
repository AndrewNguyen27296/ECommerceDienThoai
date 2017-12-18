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
 * @author myly
 */
@Entity
@Table(name = "goi_tin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoiTin.findAll", query = "SELECT g FROM GoiTin g")
    , @NamedQuery(name = "GoiTin.findById", query = "SELECT g FROM GoiTin g WHERE g.id = :id")
    , @NamedQuery(name = "GoiTin.findByTenGoiTin", query = "SELECT g FROM GoiTin g WHERE g.tenGoiTin = :tenGoiTin")
    , @NamedQuery(name = "GoiTin.findBySoTin", query = "SELECT g FROM GoiTin g WHERE g.soTin = :soTin")
    , @NamedQuery(name = "GoiTin.findByGiaBan", query = "SELECT g FROM GoiTin g WHERE g.giaBan = :giaBan")})
public class GoiTin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ten_goi_tin")
    private String tenGoiTin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_tin")
    private int soTin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gia_ban")
    private long giaBan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGoiTin")
    private List<PhieuMuaTin> phieuMuaTinList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGoiTin")
    private List<PhieuMuaTinOffline> phieuMuaTinOfflineList;

    public GoiTin() {
    }

    public GoiTin(Integer id) {
        this.id = id;
    }

    public GoiTin(Integer id, String tenGoiTin, int soTin, long giaBan) {
        this.id = id;
        this.tenGoiTin = tenGoiTin;
        this.soTin = soTin;
        this.giaBan = giaBan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenGoiTin() {
        return tenGoiTin;
    }

    public void setTenGoiTin(String tenGoiTin) {
        this.tenGoiTin = tenGoiTin;
    }

    public int getSoTin() {
        return soTin;
    }

    public void setSoTin(int soTin) {
        this.soTin = soTin;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    @XmlTransient
    public List<PhieuMuaTin> getPhieuMuaTinList() {
        return phieuMuaTinList;
    }

    public void setPhieuMuaTinList(List<PhieuMuaTin> phieuMuaTinList) {
        this.phieuMuaTinList = phieuMuaTinList;
    }

    @XmlTransient
    public List<PhieuMuaTinOffline> getPhieuMuaTinOfflineList() {
        return phieuMuaTinOfflineList;
    }

    public void setPhieuMuaTinOfflineList(List<PhieuMuaTinOffline> phieuMuaTinOfflineList) {
        this.phieuMuaTinOfflineList = phieuMuaTinOfflineList;
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
        if (!(object instanceof GoiTin)) {
            return false;
        }
        GoiTin other = (GoiTin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.GoiTin[ id=" + id + " ]";
    }
    
}
