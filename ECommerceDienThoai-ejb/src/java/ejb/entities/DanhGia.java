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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author myly
 */
@Entity
@Table(name = "danh_gia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DanhGia.findAll", query = "SELECT d FROM DanhGia d")
    , @NamedQuery(name = "DanhGia.findById", query = "SELECT d FROM DanhGia d WHERE d.id = :id")
    , @NamedQuery(name = "DanhGia.findBySoDiem", query = "SELECT d FROM DanhGia d WHERE d.soDiem = :soDiem")
    , @NamedQuery(name = "DanhGia.findBySuDung", query = "SELECT d FROM DanhGia d WHERE d.suDung = :suDung")})
public class DanhGia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_diem")
    private int soDiem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "su_dung")
    private boolean suDung;
    @JoinColumn(name = "id_nguoi_ban", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NguoiBan idNguoiBan;
    @JoinColumn(name = "id_nguoi_mua", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NguoiMua idNguoiMua;

    public DanhGia() {
    }

    public DanhGia(Integer id) {
        this.id = id;
    }

    public DanhGia(Integer id, int soDiem, boolean suDung) {
        this.id = id;
        this.soDiem = soDiem;
        this.suDung = suDung;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(int soDiem) {
        this.soDiem = soDiem;
    }

    public boolean getSuDung() {
        return suDung;
    }

    public void setSuDung(boolean suDung) {
        this.suDung = suDung;
    }

    public NguoiBan getIdNguoiBan() {
        return idNguoiBan;
    }

    public void setIdNguoiBan(NguoiBan idNguoiBan) {
        this.idNguoiBan = idNguoiBan;
    }

    public NguoiMua getIdNguoiMua() {
        return idNguoiMua;
    }

    public void setIdNguoiMua(NguoiMua idNguoiMua) {
        this.idNguoiMua = idNguoiMua;
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
        if (!(object instanceof DanhGia)) {
            return false;
        }
        DanhGia other = (DanhGia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.DanhGia[ id=" + id + " ]";
    }
    
}
