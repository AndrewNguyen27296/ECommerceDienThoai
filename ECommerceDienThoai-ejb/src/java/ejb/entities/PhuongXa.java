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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "phuong_xa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhuongXa.findAll", query = "SELECT p FROM PhuongXa p"),
    @NamedQuery(name = "PhuongXa.findById", query = "SELECT p FROM PhuongXa p WHERE p.id = :id"),
    @NamedQuery(name = "PhuongXa.findByTenPhuongXa", query = "SELECT p FROM PhuongXa p WHERE p.tenPhuongXa = :tenPhuongXa"),
    @NamedQuery(name = "PhuongXa.findByLoai", query = "SELECT p FROM PhuongXa p WHERE p.loai = :loai")})
public class PhuongXa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ten_phuong_xa")
    private String tenPhuongXa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "loai")
    private String loai;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPhuongXa", fetch = FetchType.LAZY)
    private List<PhieuMuaHang> phieuMuaHangList;
    @JoinColumn(name = "id_quan_huyen", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private QuanHuyen idQuanHuyen;

    public PhuongXa() {
    }

    public PhuongXa(Integer id) {
        this.id = id;
    }

    public PhuongXa(Integer id, String tenPhuongXa, String loai) {
        this.id = id;
        this.tenPhuongXa = tenPhuongXa;
        this.loai = loai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenPhuongXa() {
        return tenPhuongXa;
    }

    public void setTenPhuongXa(String tenPhuongXa) {
        this.tenPhuongXa = tenPhuongXa;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @XmlTransient
    public List<PhieuMuaHang> getPhieuMuaHangList() {
        return phieuMuaHangList;
    }

    public void setPhieuMuaHangList(List<PhieuMuaHang> phieuMuaHangList) {
        this.phieuMuaHangList = phieuMuaHangList;
    }

    public QuanHuyen getIdQuanHuyen() {
        return idQuanHuyen;
    }

    public void setIdQuanHuyen(QuanHuyen idQuanHuyen) {
        this.idQuanHuyen = idQuanHuyen;
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
        if (!(object instanceof PhuongXa)) {
            return false;
        }
        PhuongXa other = (PhuongXa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.PhuongXa[ id=" + id + " ]";
    }
    
}
