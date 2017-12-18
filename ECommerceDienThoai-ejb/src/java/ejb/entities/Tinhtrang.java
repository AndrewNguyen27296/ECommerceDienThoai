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
@Table(name = "tinh_trang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TinhTrang.findAll", query = "SELECT t FROM TinhTrang t")
    , @NamedQuery(name = "TinhTrang.findById", query = "SELECT t FROM TinhTrang t WHERE t.id = :id")
    , @NamedQuery(name = "TinhTrang.findByTenMoTa", query = "SELECT t FROM TinhTrang t WHERE t.tenMoTa = :tenMoTa")})
public class TinhTrang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ten_mo_ta")
    private String tenMoTa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTinhTrang")
    private List<CtPhieuMuaHang> ctPhieuMuaHangList;

    public TinhTrang() {
    }

    public TinhTrang(String id) {
        this.id = id;
    }

    public TinhTrang(String id, String tenMoTa) {
        this.id = id;
        this.tenMoTa = tenMoTa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenMoTa() {
        return tenMoTa;
    }

    public void setTenMoTa(String tenMoTa) {
        this.tenMoTa = tenMoTa;
    }

    @XmlTransient
    public List<CtPhieuMuaHang> getCtPhieuMuaHangList() {
        return ctPhieuMuaHangList;
    }

    public void setCtPhieuMuaHangList(List<CtPhieuMuaHang> ctPhieuMuaHangList) {
        this.ctPhieuMuaHangList = ctPhieuMuaHangList;
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
        if (!(object instanceof TinhTrang)) {
            return false;
        }
        TinhTrang other = (TinhTrang) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.TinhTrang[ id=" + id + " ]";
    }
    
}
